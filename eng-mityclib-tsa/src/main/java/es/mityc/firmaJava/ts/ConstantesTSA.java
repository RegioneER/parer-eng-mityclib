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

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */

public interface ConstantesTSA {

    static final String LIBRERIA_TSA_ERROR_1 = "libreriatsa.error1";
    static final String LIBRERIA_TSA_ERROR_10 = "libreriatsa.error10";
    static final String LIBRERIA_TSA_ERROR_11 = "libreriatsa.error11";
    static final String LIBRERIA_TSA_ERROR_12 = "libreriatsa.error12";
    static final String LIBRERIA_TSA_ERROR_9 = "libreriatsa.error9";
    static final String LIBRERIA_TSA_ERROR_8 = "libreriatsa.error8";
    static final String LIBRERIA_TSA_ERROR_7 = "libreriatsa.error7";
    static final String LIBRERIA_TSA_ERROR_6 = "libreriatsa.error6";
    static final String LIBRERIA_TSA_ERROR_4 = "libreriatsa.error4";
    static final String LIBRERIA_TSA_ERROR_5 = "libreriatsa.error5";
    static final String LIBRERIA_TSA_ERROR_2 = "libreriatsa.error2";

    static final String FORMATO_FECHA = "dd/MM/yyyy H:mm:ss.SSS";

    static final String MENSAJE_NO_ALGORITMO_HASH = "No se ha encontrado un algoritmo hash valido para el Sello de Tiempo. Se va a utilizar el algoritmo SHA1 por defecto";
    static final String MENSAJE_NO_DATOS_SELLO_TIEMPO = "No se han especificado los datos sobre los que generar el sello de tiempo";
    static final String MENSAJE_GENERANDO_SELLO_TIEMPO = "Se va a generar el sello de tiempo ...";
    static final String MENSAJE_PETICION_TSA_GENERADA = "Peticion TSA generada";
    static final String MENSAJE_ERROR_PETICION_TSA = "Ha ocurrido un error al generar la peticion TSA";
    static final String CONTENT_TYPE = "Content-Type";
    static final String APPLICATION_TIMESTAMP_QUERY = "application/timestamp-query";
    static final String MENSAJE_ERROR_PETICION = "Error al leer la peticion: ";
    static final String MENSAJE_PETICION_TSA_ENVIADA = "Peticion TSA enviada.";
    static final String MENSAJE_FALLO_EJECUCION_METODO = "Fallo la ejecucion del método: ";
    static final String MENSAJE_RESPUESTA_TSA_OBTENIDA = "Respuesta TSA obtenida.";
    static final String MENSAJE_RESPUESTA_TSA_VALIDADA_OK = "Respuesta TSA validada OK";
    static final String MENSAJE_RESPUESTA_NO_VALIDA = "La respuesta no es valida para la peticion enviada: ";
    static final String MENSAJE_RESPUESTA_MAL_FORMADA = "La respuesta esta mal formada: ";
    static final String MENSAJE_SECUENCIA_BYTES_MAL_CODIFICADA = "La secuencia de bytes de respuesta no esta codificada en ASN.1: ";
    static final String MENSAJE_VIOLACION_PROTOCOLO_HTTP = "Violacion del protocolo HTTP: ";
    static final String MENSAJE_ERROR_CONEXION_SERVIDOR_OCSP = "Error en la conexion con el servidor OCSP: ";
    static final String MENSAJE_SE_UTILIZA_PROXY = "Se utiliza un servidor Proxy: ";

    static final String DOS_PUNTOS_ESPACIO = ": ";

    static final String ES_MINUSCULA = "es";
    static final String ES_MAYUSCULA = "ES";
    static final String NOMBRE_LIBRERIA = "i18n_libreriaTSA";
    static final String LOCALE = "locale";

    static final String NUEVA_LINEA = "\n";
    static final String DOS_PUNTOS = ":";

    /**
     * Tipo de algoritmo SHA1
     */
    static final String SHA1 = "SHA-1";
    /**
     * Tipo de algoritmo SHA2
     */
    static final String SHA2 = "SHA-2";
    /**
     * Tipo de algoritmo SHA224
     */
    static final String SHA224 = "SHA-224";
    /**
     * Tipo de algoritmo SHA256
     */
    static final String SHA256 = "SHA-256";
    /**
     * Tipo de algoritmo SHA384
     */
    static final String SHA384 = "SHA-384";
    /**
     * Tipo de algoritmo SHA512
     */
    static final String SHA512 = "SHA-512";

    static final String MD5 = "MD5";

    /** No options specified. Value is zero. */
    public final static int NO_OPTIONS = 0;

    /** Specify encoding. */
    public final static int ENCODE = 1;

    /** Specify decoding. */
    public final static int DECODE = 0;

    /** Specify that data should be gzip-compressed. */
    public final static int GZIP = 2;

    /** Don't break lines when encoding (violates strict Base64 specification) */
    public final static int DONT_BREAK_LINES = 8;

    /**
     * Encode using Base64-like encoding that is URL- and Filename-safe as described in Section 4 of RFC3548:
     * <a href="http://www.faqs.org/rfcs/rfc3548.html">http://www.faqs.org/rfcs/rfc3548.html</a>. It is important to
     * note that data encoded this way is <em>not</em> officially valid Base64, or at the very least should not be
     * called Base64 without also specifying that is was encoded using the URL- and Filename-safe dialect.
     */
    public final static int URL_SAFE = 16;

    /**
     * Encode using the special "ordered" dialect of Base64 described here:
     * <a href="http://www.faqs.org/qa/rfcc-1940.html">http://www.faqs.org/qa/rfcc-1940.html</a>.
     */
    public final static int ORDERED = 32;

    static final String STR_USAGE_JAVA_BASE_64 = "Usage: java Base64 -e|-d inputfile outputfile";
    static final String STR_BAD_BASE_64 = "Bad Base64 input character at ";
    static final String STR_DECIMAL = "(decimal)";
    static final String STR_FILE_TOO_BIG = "File is too big for this convenience method (";
    static final String STR_BYTES = " bytes).";
    static final String STR_ERROR_DECODING = "Error decoding from file ";
    static final String STR_ERROR_ENCODING = "Error encoding from file ";
    static final String STR_US_ASCII = "US-ASCII";
    static final String STR_ERROR_IN_BASE_64 = "Error in Base64 code reading stream.";
    static final String STR_INVALID_CHARACTER = "Invalid character in Base64 data.";
    static final String STR_INPUT_NOT_PROPERLY_PADDED = "Base64 input not properly padded.";

    static final String STR_IMPROPERLY_PADDED = "Improperly padded Base64 input.";

    static final String STR_LENGTH_OF_BASE_64 = "Length of Base64 encoded input string is not a multiple of 4.";
    static final String STR_ILLEGAL_CHARACTER_IN_BASE_64 = "Illegal character in Base64 encoded data.";

    static final String CADENA_VACIA = "";

}
