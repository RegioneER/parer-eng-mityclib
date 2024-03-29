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

package es.mityc.firmaJava.libreria.utilidades;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.jce.PrincipalUtil;
import org.bouncycastle.jce.X509Principal;

import es.mityc.firmaJava.libreria.ConstantesXADES;

/**
 * Clase de utilidades para el DNIe
 *
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 0.9 beta
 */
public class UtilidadDNIe { // implements ConstantesXADES

    static Log log = LogFactory.getLog(UtilidadDNIe.class);

    public enum SUBJECT_OR_ISSUER {
        SUBJECT, ISSUER
    };

    /**
     * Constructor por defecto de la clase
     */
    public UtilidadDNIe() {
    }

    /**
     * Obtiene el nombre común
     * 
     * @param cert
     *            X509Certificate Certificado del cual se obtiene el nombre
     * @param tipo
     *            Tipo de certificado
     * 
     * @return String CN obtenido
     */
    public static String getCN(X509Certificate cert, SUBJECT_OR_ISSUER tipo) {

        String retorno = ConstantesXADES.CADENA_VACIA;
        X509Principal nombre = null;

        // Se discrimina que tipo de certificado es requerido
        try {
            if (tipo == SUBJECT_OR_ISSUER.ISSUER)
                nombre = PrincipalUtil.getIssuerX509Principal(cert);
            else
                nombre = PrincipalUtil.getSubjectX509Principal(cert);

        } catch (CertificateEncodingException e) {
            log.error(e.getMessage(), e);
            return retorno;
        }

        // Se obtienen sus valores asociados
        Vector<?> commonNameOIDs = nombre.getOIDs();
        Vector<?> commonName = nombre.getValues();
        int longitudValues = commonName.size();

        if (longitudValues != 0) {
            // Se busca el valor "CN"
            int indexCN = commonNameOIDs.indexOf(X509Name.CN);
            if (indexCN != -1) {
                Object elemento = commonName.get(indexCN);
                if (elemento instanceof String)
                    retorno = (String) elemento;
                else
                    log.error(ConstantesXADES.ERR_CN_NO_TIPO_STRING);
            }

            // Si no se obtuvo resultado, se busca el valor "OU"
            if (retorno == ConstantesXADES.CADENA_VACIA) {
                int indexOU = commonNameOIDs.indexOf(X509Name.OU);
                if (indexOU != -1) {
                    Object elemento = commonName.get(indexOU);
                    if (elemento instanceof String)
                        retorno = (String) elemento;
                    else
                        log.error(ConstantesXADES.ERR_CN_NO_TIPO_STRING);
                }
            }

            // Si no se obtuvo resultado, se busca el valor "O"
            if (retorno == ConstantesXADES.CADENA_VACIA || retorno == null) {
                int indexO = commonNameOIDs.indexOf(X509Name.O);
                if (indexO != -1) {
                    Object elemento = commonName.get(indexO);
                    if (elemento instanceof String)
                        retorno = (String) elemento;
                    else
                        log.error(ConstantesXADES.ERR_CN_NO_TIPO_STRING);
                }
            }
        } else
            log.error(ConstantesXADES.ERR_CERT_NO_VALUES);

        return retorno;
    }

    /**
     * Convierte un java.util.Date a DateFormat.SHORT,new Locale("ES","es")
     * 
     * @param date
     *            Fecha a convertir
     * 
     * @return String en formato DateFormat.SHORT,new Locale("ES","es")
     */
    public static String convertDate(Date date) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat(ConstantesXADES.FORMATO_SOLO_FECHA);
        String fecha = formatoFecha.format(date);

        return fecha.replace(ConstantesXADES.SLASH, ConstantesXADES.GUION);
    }

    /**
     * Obtiene el numero de DNI del Subject del certificado
     * 
     * @param subjectDN
     *            Subject del certificado
     * 
     * @return Numero del DNI
     */
    public static final String giveMeDNINumber(String subjectDN) {
        if (subjectDN == null) {
            return null;
        }
        String[] tokens = subjectDN.split(ConstantesXADES.COMA);

        for (int a = 0; a < tokens.length; a++) {
            String[] nDNI = null;

            if (tokens[a].trim().startsWith(ConstantesXADES.NUMERO_DE_SERIE)) {
                nDNI = tokens[a].trim().split(ConstantesXADES.IGUAL);
                return nDNI[1].trim();
            } else if (tokens[a].trim().startsWith(ConstantesXADES.OID_2_5_4_5)) {
                nDNI = tokens[a].trim().split(ConstantesXADES.IGUAL);
                return nDNI[1].trim();
            } else if (tokens[a].trim().startsWith(ConstantesXADES.SERIAL_NUMBER)) {
                nDNI = tokens[a].trim().split(ConstantesXADES.IGUAL);
                return nDNI[1].trim();
            }
        }
        return null;
    }

    /**
     * Comprueba si es un certificado de DNIe
     * 
     * @param emisorDN
     *            Emisor del certificado
     * 
     * @return Verdadero si lo es, Falso en caso contrario
     */
    public static final boolean isCertDNIe(String emisorDN) {
        return emisorDN.indexOf(ConstantesXADES.OU_DNIE) >= 0
                && emisorDN.indexOf(ConstantesXADES.O_DIRECCION_GENERAL_DE_LA_POLICIA) >= 0;
    }

}
