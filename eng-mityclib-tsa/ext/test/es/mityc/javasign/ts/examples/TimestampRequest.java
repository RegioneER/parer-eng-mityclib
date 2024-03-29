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

/*
 * 
 */
package es.mityc.javasign.ts.examples;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;

import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.TimeStampToken;

import es.mityc.firmaJava.ts.Base64;
import es.mityc.firmaJava.ts.TSCliente;
import es.mityc.firmaJava.ts.TSClienteError;
import es.mityc.javasign.ssl.SimpleSSLManager;
import es.mityc.javasign.ts.AllTrustedManager;

/**
 * <p>
 * Ejemplo que muestra como pedir un sello de tiempo de unos datos determinados.
 * </p>
 * <p>
 * Para simplificar el codigo del programa se usan una serie constantes para su
 * configuracion. Las constantes usadas, y que pueden ser modificadas según las
 * necesidades específicas, son las siguientes:
 * </p>
 * <ul>
 * <li><code>TSA_URL</code></li>
 * <li><code>ALGORITHM</code></li>
 * <li><code>DATA</code></li>
 * <li><code>SSL_AUTHENTICATION</code></li>
 * <li><code>PKCS12_RESOURCE</code></li>
 * <li><code>PKCS12_PASSWORD</code></li>
 * <li><code>USE_PROXY</code></li>
 * <li><code>IS_PROXY_AUTH</code></li>
 * <li><code>PROXY_USER</code></li>
 * <li><code>PROXY_PASSWORD</code></li>
 * <li><code>PROXY_SERVER</code></li>
 * <li><code>PROXY_PORT</code></li>
 * </ul>
 * <p>
 * El ejemplo, tal y como se distribuye, realiza una peticion de sellado de
 * tiempo de los datos <code>DATA</code> a la TSA <code>TSA_URL</code>
 * utilizando el algoritmo <code>ALGORITHM</code>. No se usa ni proxy ni SSL.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * @version 1.0
 */
public class TimestampRequest {

    /**
     * <p>
     * URL donde escucha la TSA a la que se quiere realizar la peticion.
     * </p>
     */
    public static final String TSA_URL = "";

    /**
     * <p>
     * Algoritmo del hash del sello de tiempo.
     * </p>
     */
    public static final String ALGORITHM = "SHA-1";

    /**
     * <p>
     * Datos de los que se quiere generar el sello de tiempo.
     * </p>
     */
    public static final byte[] DATA = new byte[512];

    /**
     * <p>
     * Si se necesita autenticacion SSL basada en certificados para conectar con
     * la TSA
     * </p>
     */
    public static final Boolean SSL_AUTHENTICATION = false;

    /**
     * <p>
     * Recurso PKCS12 que contiene el certificado de identificacion del usuario.
     * </p>
     */
    public final static String PKCS12_RESOURCE = "";
    
    /**
     * <p>Constraseña de acceso a la clave privada del usuario</p>
     */
    public final static String PKCS12_PASSWORD = "";
    
    /**
     * <p>Si se necesita o no usar proxy para ejecutar el ejemplo</p>
     */
    public final static Boolean USE_PROXY = false;

    /**
     * <p>Si el proxy es o no autenticado</p>
     */
    public final static Boolean IS_PROXY_AUTH = false;

    /**
     * <p>Usuario del proxy, para el caso de proxy autenticado</p>
     */
    public final static String PROXY_USER = "";

    /**
     * <p>Usuario del proxy, para el caso de proxy autenticado</p>
     */
    public final static String PROXY_PASSWORD = "";

    /**
     * <p>Host correspondiente al proxy, en el caso de que exista</p>
     */
    public final static String PROXY_SERVER ="";

    /**
     * <p>Puerto correspondiente al proxy, en el caso de que exista</p>
     */
    public final static Integer PROXY_PORT = null;

    /**
     * <p>
     * Punto de entrada al programa.
     * </p>
     * 
     * @param args
     *            Argumentos del programa.
     */
    public static void main(String[] args) {
        TimestampRequest timestampRequest = new TimestampRequest();
        timestampRequest.execute();
    }

    /**
     * <p>
     * Ejecucion del ejemplo.
     * </p>
     */
    private void execute() {
        
        // Se configura la conexion
        configureConnection();
        
        // En el caso que sea necesario se prepara el cliente para SSL
        if (SSL_AUTHENTICATION) {
            prepareSSL();
        }

        // Instanciacion del cliente
        TSCliente cliente = new TSCliente(TSA_URL, ALGORITHM);

        // Obtencion del resultado como array de bytes
        byte[] result;
        try {
            result = cliente.generarSelloTiempo(DATA);
        } catch (TSClienteError e) {
            System.err.println("Error al generar el sello de tiempo");
            e.printStackTrace();
            return;
        }

        // Parseo del resultado como un TimeStampToken
        TimeStampToken timeStampToken;
        try {
            timeStampToken = new TimeStampToken(new CMSSignedData(result));
        } catch (TSPException e) {
            System.err.println("Error al parsear la respuseta");
            e.printStackTrace();
            return;
        } catch (IOException e) {
            System.err.println("Error al parsear la respuseta");
            e.printStackTrace();
            return;
        } catch (CMSException e) {
            System.err.println("Error al parsear la respuseta");
            e.printStackTrace();
            return;
        }

        // Impresion de resultados por salida estandar
        System.out.println("--------------------------------");
        System.out.println("-- TOKEN DE SELLADO DE TIEMPO --");
        System.out.println("--------------------------------");
        System.out.println("Número de serie del token: "
                + timeStampToken.getTimeStampInfo().getSerialNumber());
        System.out.println("Fecha generacion del token: "
                + timeStampToken.getTimeStampInfo().getGenTime());
        System.out.println("OID política del token: "
                + timeStampToken.getTimeStampInfo().getPolicy());
        System.out.println("OID algoritmo de hash: "
                + timeStampToken.getTimeStampInfo().getMessageImprintAlgOID());
        System.out.println("");
        System.out.println("---------------------");
        System.out.println("-- TOKEN EN BASE64 --");
        System.out.println("---------------------");
        System.out.println(Base64.encodeBytes(result));
    }

    /**
     * Prepara el cliente de la TSA para poder establecer una conexion por SSL
     * con autenticacion mediante certificados X509.
     */
    private void prepareSSL() {
        KeyStore ks = null;
        try {
            ks = KeyStore.getInstance("PKCS12");
            ks.load(this.getClass().getResourceAsStream(PKCS12_RESOURCE), PKCS12_PASSWORD.toCharArray());
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ks, PKCS12_PASSWORD.toCharArray());
            TSCliente.setSSLManager(new SimpleSSLManager(new AllTrustedManager(), kmf.getKeyManagers()[0]));
        } catch (CertificateException e) {
            System.out.println("Error al establecer la configuracion de seguridad de la comunicacion con la TSA.");
            e.printStackTrace();
            System.exit(-1);
        } catch (KeyStoreException e) {
            System.out.println("Error al establecer la configuracion de seguridad de la comunicacion con la TSA.");
            e.printStackTrace();
            System.exit(-1);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error al establecer la configuracion de seguridad de la comunicacion con la TSA.");
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Error al establecer la configuracion de seguridad de la comunicacion con la TSA.");
            e.printStackTrace();
            System.exit(-1);
        } catch (UnrecoverableKeyException e) {
            System.out.println("Error al establecer la configuracion de seguridad de la comunicacion con la TSA.");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * <p>
     * Método para configurar la conexion a utilizar según el valor de las
     * constantes declaradas en la clase
     * </p>
     * <p>
     * Las posibles configuraciones son las siguientes:
     * </p>
     * <ul>
     * <li>Proxy</li>
     * <li>Proxy autenticado</li>
     * <li>Conexion directa</li>
     * </ul>
     */
    private void configureConnection() {
        if(USE_PROXY) {
            System.setProperty("http.proxyHost", PROXY_SERVER);
            System.setProperty("http.proxyPort", Integer.toString(PROXY_PORT));
            if (IS_PROXY_AUTH) {
                Authenticator.setDefault(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(PROXY_USER, PROXY_PASSWORD.toCharArray());
                    }
                });
            } else {
                Authenticator.setDefault(null);
            }
        }
    }

}
