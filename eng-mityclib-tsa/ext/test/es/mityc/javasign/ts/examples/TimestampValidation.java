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
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertStoreException;

import org.bouncycastle.tsp.TSPException;

import es.mityc.firmaJava.ts.Base64;
import es.mityc.firmaJava.ts.TSClienteError;
import es.mityc.firmaJava.ts.TSValidacion;
import es.mityc.firmaJava.ts.TSValidator;

/**
 * <p>
 * Ejemplo que muestra como realizar validaciones de sellos de tiempo a partir
 * de los datos originales y los tokens.
 * </p>
 * <p>
 * Para simplificar el codigo del programa se usan una serie constantes para su
 * configuracion. Las constantes usadas, y que pueden ser modificadas según las
 * necesidades específicas, son las siguientes:
 * </p>
 * <ul>
 * <li><code>DATA1</code></li>
 * <li><code>TOKEN_DATA1</code></li>
 * <li><code>DATA2</code></li>
 * <li><code>TOKEN_DATA2</code></li>
 * </ul>
 * <p>
 * El ejemplo, tal y como se distribuye, realiza una validacion cruzada de los
 * conjuntos de datos con los tokens de sellado de tiempo, de tal forma que se
 * realizan 4 validaciones:
 * </p>
 * <ul>
 * <li><code>DATA1</code> con <code>TOKEN_DATA1</code>, esperando un resultado
 * correcto</li>
 * <li><code>DATA1</code> con <code>TOKEN_DATA2</code>, esperando un resultado
 * erroneo</li>
 * <li><code>DATA2</code> con <code>TOKEN_DATA1</code>, esperando un resultado
 * erroneo</li>
 * <li><code>DATA2</code> con <code>TOKEN_DATA2</code>, esperando un resultado
 * correcto</li>
 * </ul>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * @version 1.0
 */
public class TimestampValidation {

    /**
     * <p>
     * Conjunto 1 de datos codificados en base64.
     * </p>
     */
    public static final String DATA1 =
        "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
        "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
        "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
        "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
        "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
        "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
        "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
        "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
        "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=";

    /**
     * <p>
     * Token de sellado de tiempo codificado en base64 asociado a los datos del
     * conjunto 1.
     * </p>
     */
    public static final String TOKEN_DATA1 = 
        "MIICPAYJKoZIhvcNAQcCoIICLTCCAikCAQMxDzANBglghkgBZQMEAgEFADBSBgsqhkiG9w0BCRAB" +
        "BKBDBEEwPwIBAQYDKgMEMCEwCQYFKw4DAhoFAAQUXD64AGZCAAK8Pcx8pKtu+tftSuUCAQEYDzIw" +
        "MDkwODMxMTIxOTI1WjGCAb0wggG5AgEBMHgwcjELMAkGA1UEBhMCRVMxDzANBgNVBAgTBk1hZHJp" +
        "ZDEPMA0GA1UEBxMGTWFkcmlkMQ4wDAYDVQQKEwVNSVR5QzEbMBkGA1UECxMSTUlUeUMgRE5JZSBQ" +
        "cnVlYmFzMRQwEgYDVQQDEwtDQSB1c3VhcmlvcwICAIIwDQYJYIZIAWUDBAIBBQCggZgwGgYJKoZI" +
        "hvcNAQkDMQ0GCyqGSIb3DQEJEAEEMBwGCSqGSIb3DQEJBTEPFw0wOTA4MzExMjE5MjVaMCsGCyqG" +
        "SIb3DQEJEAIMMRwwGjAYMBYEFAVR2zDjKjiz5ZYDhbBU4ZB27TaHMC8GCSqGSIb3DQEJBDEiBCB5" +
        "AUYy9sAkQ1w2Yx5ynrMis974lMPKpcxCqqkVfF4EtjANBgkqhkiG9w0BAQEFAASBgIvaA7UD2EO1" +
        "Pw401/Q/QkIvDPL4aIpd0KxNNkQzZRZfe17x4pPf7P+j9uaKd5fnPy8sXTBxBumo6oJ7GfeSdgjc" +
        "Zec2fcVv1fJkVYyQ2W2789jiZ1ltG6mNKiod+vBCgWfzhf7tHXgihiUYvXSDTMigQkAY4IAAQgCO" +
        "vCvR2PdH";

    /**
     * <p>
     * Conjunto 2 de datos codificados en base64.
     * </p>
     */
    public static final String DATA2 = 
        "AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB" +
        "AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB" +
        "AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB" +
        "AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB" +
        "AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB" +
        "AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB" +
        "AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB" +
        "AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB" +
        "AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQE=";

    /**
     * <p>
     * Token de sellado de tiempo codificado en base64 asociado a los datos del
     * conjunto 1.
     * </p>
     */
    public static final String TOKEN_DATA2 = 
        "MIICPAYJKoZIhvcNAQcCoIICLTCCAikCAQMxDzANBglghkgBZQMEAgEFADBSBgsqhkiG9w0BCRAB" +
        "BKBDBEEwPwIBAQYDKgMEMCEwCQYFKw4DAhoFAAQUPvigjskOJE/iqJSLcB6vzB0GVxICAQEYDzIw" +
        "MDkwODMxMTIyODA0WjGCAb0wggG5AgEBMHgwcjELMAkGA1UEBhMCRVMxDzANBgNVBAgTBk1hZHJp" +
        "ZDEPMA0GA1UEBxMGTWFkcmlkMQ4wDAYDVQQKEwVNSVR5QzEbMBkGA1UECxMSTUlUeUMgRE5JZSBQ" +
        "cnVlYmFzMRQwEgYDVQQDEwtDQSB1c3VhcmlvcwICAIIwDQYJYIZIAWUDBAIBBQCggZgwGgYJKoZI" +
        "hvcNAQkDMQ0GCyqGSIb3DQEJEAEEMBwGCSqGSIb3DQEJBTEPFw0wOTA4MzExMjI4MDRaMCsGCyqG" +
        "SIb3DQEJEAIMMRwwGjAYMBYEFAVR2zDjKjiz5ZYDhbBU4ZB27TaHMC8GCSqGSIb3DQEJBDEiBCAG" +
        "NjoAL/bpSEmZ+cjoEGdL/1i6Do3EIqTuBqOAz7YGZjANBgkqhkiG9w0BAQEFAASBgHjDCqrivTq7" +
        "EHlnsr5g8FrE+gk8Ju/qOBFZ0xA4ES+WjMjgxxfIM1H18wGHfbf7g3KqJ3dYNBmVhVOL7gN1PMwf" +
        "YE7T/qSmMzFDot7uLy/5FqBVhEdYnJNz3JydB48i6wTvC4aYlGSMe7Y40JDzjX7l4SgX1dNfW1px" +
        "7rpjAqB1";

    /**
     * <p>Punto de entrada al programa</p>
     * @param args Argumentos del programa
     */
    public static void main(String[] args) {
        TimestampValidation timestampValidation = new TimestampValidation();
        timestampValidation.execute();
    }

    /**
     * <p>Ejecucion del ejemplo</p>
     */
    private void execute() {
        TSValidacion result;
        try {
            result = TSValidator.validarSelloTiempo(Base64.decode(DATA1), Base64.decode(TOKEN_DATA1));
            System.out.println("-------------------------------------");
            System.out.println("-- Resultado DATA1 con TOKEN_DATA1 --");
            System.out.println("-------------------------------------");
            System.out.println("Resultado: "+result.isRespuesta());
            System.out.println("Fecha token: "+result.getFecha());
            System.out.println("");

            result = TSValidator.validarSelloTiempo(Base64.decode(DATA2), Base64.decode(TOKEN_DATA2));
            System.out.println("-------------------------------------");
            System.out.println("-- Resultado DATA2 con TOKEN_DATA2 --");
            System.out.println("-------------------------------------");
            System.out.println("Resultado: "+result.isRespuesta());
            System.out.println("Fecha token: "+result.getFecha());
            System.out.println("");

            result = TSValidator.validarSelloTiempo(Base64.decode(DATA1), Base64.decode(TOKEN_DATA2));
            System.out.println("-------------------------------------");
            System.out.println("-- Resultado DATA1 con TOKEN_DATA2 --");
            System.out.println("-------------------------------------");
            System.out.println("Resultado: "+result.isRespuesta());
            System.out.println("Fecha token: "+result.getFecha());
            System.out.println("");

            result = TSValidator.validarSelloTiempo(Base64.decode(DATA2), Base64.decode(TOKEN_DATA1));
            System.out.println("-------------------------------------");
            System.out.println("-- Resultado DATA2 con TOKEN_DATA1 --");
            System.out.println("-------------------------------------");
            System.out.println("Resultado: "+result.isRespuesta());
            System.out.println("Fecha token: "+result.getFecha());
            System.out.println("");

        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error al validar el sello de tiempo");
            e.printStackTrace();
            return;
        } catch (NoSuchProviderException e) {
            System.err.println("Error al validar el sello de tiempo");
            e.printStackTrace();
            return;
        } catch (CertStoreException e) {
            System.err.println("Error al validar el sello de tiempo");
            e.printStackTrace();
            return;
        } catch (TSPException e) {
            System.err.println("Error al validar el sello de tiempo");
            e.printStackTrace();
            return;
        } catch (IOException e) {
            System.err.println("Error al validar el sello de tiempo");
            e.printStackTrace();
            return;
        } catch (TSClienteError e) {
            System.err.println("Error al validar el sello de tiempo");
            e.printStackTrace();
            return;
        }
		
    }
}
