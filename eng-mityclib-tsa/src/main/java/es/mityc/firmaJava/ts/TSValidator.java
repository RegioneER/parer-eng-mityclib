/*
 * Engineering Ingegneria Informatica S.p.A.
 *
 * Copyright (C) 2023 Regione Emilia-Romagna
 * <p/>
 * This program is free software: you can redistribute it and/or modify it under the terms of
 * the GNU Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU Affero General Public License along with this program.
 * If not, see <https://www.gnu.org/licenses/>.
 */

package es.mityc.firmaJava.ts;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.tsp.GenTimeAccuracy;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.TimeStampResponse;
import org.bouncycastle.tsp.TimeStampToken;
import org.bouncycastle.tsp.TimeStampTokenInfo;

/**
 * <p>
 * Clase encargada de validar sellos de tiempo.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class TSValidator {

    /**
     * <p>
     * Este método valida el Sello de Tiempo.
     * </p>
     * 
     * @param binarioaSellar
     *            fichero binario a validar
     * @param sellodeTiempo
     *            El Sello de Tiempo se ingresa en formato binario
     * 
     * @return TSValidacion Valores TSA
     * 
     * @throws NoSuchAlgorithmException
     * @throws TSPException
     * @throws IOException
     * @throws NoSuchProviderException
     * @throws CertStoreException
     * @throws TSClienteError
     */
    public static TSValidacion validarSelloTiempo(final byte[] binarioaSellar, final byte[] sellodeTiempo)
            throws NoSuchAlgorithmException, TSPException, IOException, NoSuchProviderException, CertStoreException,
            TSClienteError {

        // Set permitidos = new HashSet(Arrays.asList(TSPAlgoritmos.getValoresPermitidos()));
        // si el algoritmo pasado no es permitido o es nulo se usa el algortimo por defecto

        TimeStampToken tst = null;
        TSValidacion tsv = new TSValidacion();

        try {
            tst = new TimeStampToken(new CMSSignedData(sellodeTiempo));
        } catch (CMSException e) {
            // Intenta obtenerlo como una timestamResp
            try {
                TimeStampResponse tsr = new TimeStampResponse(sellodeTiempo);
                tst = tsr.getTimeStampToken();
                if (tst == null) {
                    throw new TSClienteError(I18n.getResource(ConstantesTSA.LIBRERIA_TSA_ERROR_2));
                }
            } catch (TSPException ex) {
                throw new TSClienteError(I18n.getResource(ConstantesTSA.LIBRERIA_TSA_ERROR_2));
            } catch (IOException ex) {
                throw new TSClienteError(I18n.getResource(ConstantesTSA.LIBRERIA_TSA_ERROR_2));
            }
        }

        tsv.setTst(tst);
        TimeStampTokenInfo tokenInfo = tst.getTimeStampInfo();

        MessageDigest resumen = TSPAlgoritmos.getDigest(tokenInfo.getMessageImprintAlgOID());
        if (resumen == null) {
            tsv.setRespuesta(false);
            return tsv;
        }

        resumen.update(binarioaSellar);
        if (MessageDigest.isEqual(resumen.digest(), tst.getTimeStampInfo().getMessageImprintDigest())) {
            // TimeStampTokenInfo tokenInfo = tst.getTimeStampInfo();
            SimpleDateFormat formato = new SimpleDateFormat(ConstantesTSA.FORMATO_FECHA);
            tsv.setFecha(formato.format(tokenInfo.getGenTime()));
            tsv.setFechaDate(tokenInfo.getGenTime());

            GenTimeAccuracy precision = tokenInfo.getGenTimeAccuracy();
            tsv.setPrecision(precision);

            long accuLong = 0;
            if (precision != null) {
                accuLong = (precision.getMicros() * 1L) + (precision.getMillis() * 1000L)
                        + (precision.getSeconds() * 1000000L);
            }
            tsv.setPrecisionLong(accuLong);

            tsv.setSello(tokenInfo.getSerialNumber());
            tsv.setFirmaDigest(new String(Base64Coder.encode(tokenInfo.getMessageImprintDigest())));
            tsv.setRespuesta(true);
            tsv.setSelloAlg(tokenInfo.getMessageImprintAlgOID());

            // Obtiene el nombre del firmante del sello

            // Intenta extraer informacion de los certificados firmantes contenidos en el token
            X500Principal signer = null;
            GeneralName gn = tokenInfo.getTsa();
            if (gn != null) {
                // Si es del tipo X500 lo transforma
                if (gn.getTagNo() == 4) {
                    signer = new X500Principal(X509Name.getInstance(gn.getName()).getEncoded());
                }
            }
            // si el token no indica el nombre del firmante, intenta extraerlo por el certificado
            if (signer == null) {
                try {
                    CertStore cs = tst.getCertificatesAndCRLs("Collection", null);
                    Collection<? extends Certificate> certs = cs.getCertificates(null);
                    if (certs.size() > 0) {
                        Certificate cert = certs.iterator().next();
                        if (cert instanceof X509Certificate) {
                            signer = ((X509Certificate) cert).getSubjectX500Principal();
                        }
                    }
                } catch (NoSuchAlgorithmException ex) {
                } catch (NoSuchProviderException ex) {
                } catch (CMSException ex) {
                } catch (CertStoreException ex) {
                }
            }
            tsv.setEmisor(signer);

        } else {
            tsv.setRespuesta(false);
        }
        return tsv;
    }

}
