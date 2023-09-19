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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.MessageDigest;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.TimeStampRequest;
import org.bouncycastle.tsp.TimeStampRequestGenerator;
import org.bouncycastle.tsp.TimeStampResponse;

import es.mityc.javasign.ssl.ISSLManager;

/**
 * <p>
 * Clase encargada de generar sellos de tiempo.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class TSCliente {

    /** Servidor que da el servicio de sellado de tiempo. */
    private String servidorTSA = null;
    /** Algoritmo hash del sello de tiempo. */
    private String algoritmoHash = null;
    /** Cliente Http para las comunicaciones. */
    private static final HttpClient CLIENTE = new HttpClient();
    /** Valor 5000 para timeouts. */
    private static final Integer INT5000 = new Integer(5000);
    /** Looger. */
    static Log log = LogFactory.getLog(TSCliente.class.getName());

    /**
     * <p>
     * Crea una nueva instancia de TSCliente.
     * </p>
     * 
     * @param nombreServidor
     *            Nombre del servidor
     * @param algoritmoHash
     *            Algoritmo del hash del Sello de Tiempo
     */
    public TSCliente(final String nombreServidor, final String algoritmoHash) {
        super();
        this.servidorTSA = nombreServidor;

        // Algoritmo para digest aceptado por defecto
        this.algoritmoHash = ConstantesTSA.SHA1;

        // Comprueba que el algoritmo configurado en propiedades es aceptado. Si no lo es deja el algoritmo por defecto.
        // Los algoritmos aceptados se pueden ver en la clase TSPAlgorithms (excepto MD5)
        if (algoritmoHash != null) {
            String temp = algoritmoHash.trim().toUpperCase();
            if (TSPAlgoritmos.getPermitidos().contains(algoritmoHash)) {
                this.algoritmoHash = temp;
            } else {
                log.warn(ConstantesTSA.MENSAJE_NO_ALGORITMO_HASH);
            }
        }
    }

    /**
     * <p>
     * Establece un gestionador de las conexiones SSL para el cliente.
     * </p>
     * 
     * @param sslmanager
     *            Gestionador de las conexiones SSL
     */
    public static void setSSLManager(ISSLManager sslmanager) {
        Protocol authhttps = new Protocol("https", new OwnSSLProtocolSocketFactory(sslmanager), 443);
        Protocol.registerProtocol("https", authhttps);
    }

    /**
     * <p>
     * Este mÃ©todo genera el Sello de Tiempo.
     * </p>
     * 
     * @param binarioaSellar
     *            fichero binario que se va a sellar
     * 
     * @return TimeStampToken en formato binario
     * 
     * @throws TSClienteError
     *             En caso de error
     */
    public byte[] generarSelloTiempo(final byte[] binarioaSellar) throws TSClienteError {
        if (binarioaSellar == null) {
            log.error(ConstantesTSA.MENSAJE_NO_DATOS_SELLO_TIEMPO);
            throw new TSClienteError(I18n.getResource(ConstantesTSA.LIBRERIA_TSA_ERROR_1));
        } else {
            log.info(ConstantesTSA.MENSAJE_GENERANDO_SELLO_TIEMPO);
            TimeStampRequestGenerator generadorPeticion = new TimeStampRequestGenerator();
            generadorPeticion.setCertReq(true);
            TimeStampRequest peticion = null;
            TimeStampResponse respuesta = null;

            try {
                MessageDigest resumen = MessageDigest.getInstance(algoritmoHash);
                resumen.update(binarioaSellar);
                peticion = generadorPeticion.generate(TSPAlgoritmos.getOID(algoritmoHash), resumen.digest());
                log.info(ConstantesTSA.MENSAJE_PETICION_TSA_GENERADA);
            } catch (final Exception e) {
                log.error(ConstantesTSA.MENSAJE_ERROR_PETICION_TSA);
                throw new TSClienteError(I18n.getResource(ConstantesTSA.LIBRERIA_TSA_ERROR_10));
            }

            CLIENTE.getParams().setParameter(HttpClientParams.SO_TIMEOUT, INT5000);

            String servidorProxy = System.getProperty("http.proxyHost");
            if (servidorProxy != null) {
                int puertoProxy = 80;
                try {
                    puertoProxy = Integer.parseInt(System.getProperty("http.proxyPort"));
                } catch (NumberFormatException ex) {
                }
                CLIENTE.getHostConfiguration().setProxy(servidorProxy, puertoProxy);

                Credentials defaultcreds = new AuthenticatorProxyCredentials(servidorProxy, ConstantesTSA.CADENA_VACIA);
                CLIENTE.getState().setProxyCredentials(AuthScope.ANY, defaultcreds);
            }

            PostMethod metodo = new PostMethod(servidorTSA);
            metodo.addRequestHeader(ConstantesTSA.CONTENT_TYPE, ConstantesTSA.APPLICATION_TIMESTAMP_QUERY);
            ByteArrayInputStream datos = null;
            try {
                datos = new ByteArrayInputStream(peticion.getEncoded());
            } catch (IOException e) {
                log.error(ConstantesTSA.MENSAJE_ERROR_PETICION + e.getMessage());
                throw new TSClienteError(I18n.getResource(ConstantesTSA.LIBRERIA_TSA_ERROR_11)
                        + ConstantesTSA.DOS_PUNTOS_ESPACIO + e.getMessage());
            }

            InputStreamRequestEntity rq = new InputStreamRequestEntity(datos);
            metodo.setRequestEntity(rq);

            metodo.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                    new DefaultHttpMethodRetryHandler(3, false));

            byte[] cuerpoRespuesta = null;
            try {
                int estadoCodigo = CLIENTE.executeMethod(metodo);
                log.info(ConstantesTSA.MENSAJE_PETICION_TSA_ENVIADA);

                if (estadoCodigo != HttpStatus.SC_OK) {
                    log.error(ConstantesTSA.MENSAJE_FALLO_EJECUCION_METODO + metodo.getStatusLine());
                    throw new TSClienteError(I18n.getResource(ConstantesTSA.LIBRERIA_TSA_ERROR_12)
                            + ConstantesTSA.DOS_PUNTOS_ESPACIO + metodo.getStatusLine());
                }

                cuerpoRespuesta = metodo.getResponseBody();
                log.info(ConstantesTSA.MENSAJE_RESPUESTA_TSA_OBTENIDA);

                try {
                    respuesta = new TimeStampResponse(cuerpoRespuesta);
                    try {

                        // Se valida que la respuesta sea la peticiÃ³n enviada
                        respuesta.validate(peticion);

                        log.info(ConstantesTSA.MENSAJE_RESPUESTA_TSA_VALIDADA_OK);
                        // Para solucionar bug en libreria bouncycastle
                        // return respuesta.getTimeStampToken().getEncoded();
                        // AppPerfect: Falso positivo
                        ASN1InputStream is = new ASN1InputStream(cuerpoRespuesta);
                        ASN1Sequence seq = ASN1Sequence.getInstance(is.readObject());
                        DEREncodable enc = seq.getObjectAt(1);
                        if (enc == null) {
                            return null;
                        }
                        return enc.getDERObject().getEncoded();
                        // Fin Para solucionar bug en libreria bouncycastle
                    } catch (TSPException e) {
                        log.error(ConstantesTSA.MENSAJE_RESPUESTA_NO_VALIDA + e.getMessage());
                        throw new TSClienteError(I18n.getResource(ConstantesTSA.LIBRERIA_TSA_ERROR_9)
                                + ConstantesTSA.DOS_PUNTOS_ESPACIO + e.getMessage());
                    }
                } catch (TSPException e) {
                    log.error(ConstantesTSA.MENSAJE_RESPUESTA_MAL_FORMADA + e.getMessage());
                    throw new TSClienteError(I18n.getResource(ConstantesTSA.LIBRERIA_TSA_ERROR_8)
                            + ConstantesTSA.DOS_PUNTOS_ESPACIO + e.getMessage());
                } catch (IOException e) {

                    log.error(ConstantesTSA.MENSAJE_SECUENCIA_BYTES_MAL_CODIFICADA + e.getMessage());
                    throw new TSClienteError(I18n.getResource(ConstantesTSA.LIBRERIA_TSA_ERROR_7)
                            + ConstantesTSA.DOS_PUNTOS_ESPACIO + e.getMessage());
                }
            } catch (HttpException e) {
                log.error(ConstantesTSA.MENSAJE_VIOLACION_PROTOCOLO_HTTP + e.getMessage());
                throw new TSClienteError(I18n.getResource(ConstantesTSA.LIBRERIA_TSA_ERROR_6)
                        + ConstantesTSA.DOS_PUNTOS_ESPACIO + e.getMessage());
            } catch (IOException e) {
                String mensajeError = I18n.getResource(ConstantesTSA.LIBRERIA_TSA_ERROR_4)
                        + ConstantesTSA.DOS_PUNTOS_ESPACIO + servidorTSA;
                log.error(ConstantesTSA.MENSAJE_ERROR_CONEXION_SERVIDOR_OCSP + e.getMessage());

                throw new TSClienteError(mensajeError);
            } finally {
                // Termina la conexiÃ³n
                metodo.releaseConnection();
            }
        }
    }

    /**
     * <p>
     * Ejemplo de validacion del sello de tiempo.
     * </p>
     * 
     * @param args
     *            No se admiten argumentos
     */
    public static void main(final String[] args) {
        // TSCliente cliente = new TSCliente("http://minister-6vp1kq.mityc.age:9207","SHA-1", null, 0);
        // byte[] firma = Base64.decode(("X1MlQzZRNqBeJR2hjunePlD+ywlkdgaBAo3QDRhItXGhb1k4FffA6V2w5KZoSjPCaDhMgwcTXxz3"+
        // "UThBmRlOxfZaPCpne63jRlkp63g2IclrmBRKFgsb+Wzb0/pNh/ITffiARrRpYqtO7M92V1+GZbph"+
        // "m8swQHEJlCtiOyJvwPsFkq5LyB8Zm9pBhUo12oVWnU2sCi9EMl1wIGpr71o7rm0XeudCnFS+45pb"+
        // "1uQNOILSYizSEnFZpa81/nSgjlW93q0xcE5wrzBsHvUPvhRHydXyYzITXYiSKSFFBuM/N/dcrn57"+
        // "HoaCGoJP6zQ/Wd00c7AopMxM4qFcLSuljIRSag==")) ;
        // byte[] tiempoSello =
        // Base64.decode(("MIAGCSqGSIb3DQEHAqCAMIICdgIBAzELMAkGBSsOAwIaBQAwgZwGCyqGSIb3DQEJEAEEoIGMBIGJMIGGAgEBBgUqAwQFBjAhMAkGBSsOAwIaBQAEFLLvwLC3nEd02gNUWVajJdZXzgCuAhDYJoYNZgUCsQnl459uAPTjGA8yMDA3MDQxODE1MjIyM1qgNKQyMDAxCzAJBgNVBAYTAkVTMQ0wCwYDVQQLEwRERU1PMRIwEAYDVQQDEwlNSVRZQyBUU1AxggHDMIIBvwIBATBEMDAxCzAJBgNVBAYTAkVTMQ0wCwYDVQQLEwRERU1PMRIwEAYDVQQDEwlNSVRZQyBUU1ACEACk/CLM7Wk3DZLGU0wsw+4wCQYFKw4DAhoFAKCB1jAaBgkqhkiG9w0BCQMxDQYLKoZIhvcNAQkQAQQwHAYJKoZIhvcNAQkFMQ8XDTA3MDQxODE1MjIyM1owIwYJKoZIhvcNAQkEMRYEFEF7oHc9iR2uGAGjO+rta/Qqy5OpMHUGCyqGSIb3DQEJEAIMMWYwZDBiMGAEFCzqcQksWEIV1+dMt+JE/PEKjp1zMEgwNKQyMDAxCzAJBgNVBAYTAkVTMQ0wCwYDVQQLEwRERU1PMRIwEAYDVQQDEwlNSVRZQyBUU1ACEACk/CLM7Wk3DZLGU0wsw+4wDQYJKoZIhvcNAQEBBQAEgYCMr1HUe8xtsJ+a4cwQoV1DeTarNP4BLpSDM0qQky/ZKJgmsldaIUIG9j246njLAMGBURU1rbi+HhOKbIVImjWk7G/hzn/sUQsgrIqdffoGW5PSnVR5hKBPsTDUvdnZ8LvHLCLbir44TDVhF2ewzjp9lYXjM9/cMNU8cS3vePmftgAAAAA="))
        // ;
        // TSValidacion tsv = null;
        // try {
        // tsv = cliente.validarSelloTiempo(firma, tiempoSello);
        //
        // } catch (Exception ex) {
        // ex.printStackTrace();
        // }
        //
        // log.info("------------------------------------------");
        // if (tsv != null){
        // log.info(tsv.getFecha());
        // }
    }
}
