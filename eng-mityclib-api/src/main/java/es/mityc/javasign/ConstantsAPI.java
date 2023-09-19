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

package es.mityc.javasign;

/**
 * <p>
 * Clase de constantes de la librería base.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public final class ConstantsAPI {

    /**
     * Constructor.
     */
    private ConstantsAPI() {
    }

    /** Nombre de la librería. */
    public static final String LIB_NAME = "MITyCLibAPI";

    /** Propiedad de sistema del directorio de usuario. */
    public static final String SYSTEM_PROPERTY_USER_HOME = "user.home";
    /** Propiedad de sistema del directorio temporal. */
    public static final String SYSTEM_PROPERTY_TMP_DIR = "java.io.tmpdir";
    /** Propiedad de sistema del path de librerías. */
    public static final String SYSTEM_PROPERTY_LIBRARY_PATH = "java.library.path";

    // Contantes de internacionalizacion

    // Tools
    /** Fichero de propiedades indicado ({0}) no se encuentra debido a {1}. */
    public static final String I18N_TOOLS_CP_1 = "i18n.mityc.api.tools.cp.1";
    /** Sistema operativo no reconocido. */
    public static final String I18N_TOOLS_CP_2 = "i18n.mityc.api.tools.cp.2";
    /** Error estableciendo path de librerías nativas de java. */
    public static final String I18N_TOOLS_CP_3 = "i18n.mityc.api.tools.cp.3";
    /** No se encuentra la clave {0}. */
    public static final String I18N_TOOLS_CP_4 = "i18n.mityc.api.tools.cp.4";
    /** CRC Adler32 no tiene formato numérico. */
    public static final String I18N_TOOLS_CP_5 = "i18n.mityc.api.tools.cp.5";
    /** No hay informacion disponible sobre los ficheros a copiar. */
    public static final String I18N_TOOLS_CP_6 = "i18n.mityc.api.tools.cp.6";
    /** No se ha encontrado el fichero indicado. */
    public static final String I18N_TOOLS_CP_7 = "i18n.mityc.api.tools.cp.7";
    /** Error copiando fichero {0} en ruta {1}. */
    public static final String I18N_TOOLS_CP_8 = "i18n.mityc.api.tools.cp.8";
    /** No se dispone de ningún criterio de integridad. */
    public static final String I18N_TOOLS_CP_9 = "i18n.mityc.api.tools.cp.9";
    /** Copiando ficheros de {0} en {1}. */
    public static final String I18N_TOOLS_CP_10 = "i18n.mityc.api.tools.cp.10";
    /** Fichero no existe o alterado. Copiando fichero en ruta {0}. */
    public static final String I18N_TOOLS_CP_11 = "i18n.mityc.api.tools.cp.11";
    /** Comprobado integridad de fichero {0}. */
    public static final String I18N_TOOLS_CP_12 = "i18n.mityc.api.tools.cp.12";
    /** CRC obtenido: {0} CRC íntegro: {1}. */
    public static final String I18N_TOOLS_CP_13 = "i18n.mityc.api.tools.cp.13";
    /** Copiando ficheros a SO {0}. */
    public static final String I18N_TOOLS_CP_14 = "i18n.mityc.api.tools.cp.14";
    /** Copiando los recursos etiquetados como {0}. */
    public static final String I18N_TOOLS_CP_15 = "i18n.mityc.api.tools.cp.15";
    /** Actualizando variable LibraryPath con el directorio {0}. */
    public static final String I18N_TOOLS_CP_16 = "i18n.mityc.api.tools.cp.16";
    /** Hay disponibles {0} recursos con el nombre {1}. */
    public static final String I18N_TOOLS_CP_17 = "i18n.mityc.api.tools.cp.17";
    /** Length of Base64 encoded input string is not a multiple of 4. */
    public static final String I18N_TOOLS_CP_18 = "i18n.mityc.api.tools.cp.18";
    /** Illegal character in Base64 encoded data. */
    public static final String I18N_TOOLS_CP_19 = "i18n.mityc.api.tools.cp.19";
    /** Base64 input not properly padded. */
    public static final String I18N_TOOLS_CP_20 = "i18n.mityc.api.tools.cp.20";
    /** El directorio {0} no existe. Se creara nuevo. */
    public static final String I18N_TOOLS_CP_21 = "i18n.mityc.api.tools.cp.21";

    // Trust
    /** Error cargando ficheros de configuracion de managers de confianza: {0}. */
    public static final String I18N_TRUST_1 = "i18n.mityc.api.trust.1";
    /** La clase asociada no se puede instanciar ({0}, {1}). */
    public static final String I18N_TRUST_2 = "i18n.mityc.api.trust.2";
    /** No hay permisos para instanciar el validador ({0}, {1}). */
    public static final String I18N_TRUST_3 = "i18n.mityc.api.trust.3";
    /** La clase asociada al valor no se encuentra disponible ({0}, {1}). */
    public static final String I18N_TRUST_4 = "i18n.mityc.api.trust.4";
    /** La clase asociada no es del tipo validador de confianza esperado ({0}, {1}). */
    public static final String I18N_TRUST_5 = "i18n.mityc.api.trust.5";
    /** No hay validador de confianza asociado a esa clave: {0}. */
    public static final String I18N_TRUST_6 = "i18n.mityc.api.trust.6";
    /** El validador de confianza indicado no tiene instanciador ({0}, {1}). */
    public static final String I18N_TRUST_7 = "i18n.mityc.api.trust.7";
    /** Error intentando instanciar la factoría de validadores de confianza: {0}. */
    public static final String I18N_TRUST_8 = "i18n.mityc.api.trust.8";
    /** No se cargo fichero de propiedades {0} debido a error {1}. */
    public static final String I18N_TRUST_9 = "i18n.mityc.api.trust.9";

    // Bridge
    /** No hay configuracion disponible para instanciar facades de firma. */
    public static final String I18N_BRIDGE_1 = "i18n.mityc.api.bridge.1";
    /** Facade no es una clase instanciable. */
    public static final String I18N_BRIDGE_2 = "i18n.mityc.api.bridge.2";
    /** Clase facade no es accesible en el nivel de seguridad actual. */
    public static final String I18N_BRIDGE_3 = "i18n.mityc.api.bridge.3";
    /** Clase facade {0} indicada no se encuentra. */
    public static final String I18N_BRIDGE_4 = "i18n.mityc.api.bridge.4";
    /** Clase facade indicada no es el tipo esperado. */
    public static final String I18N_BRIDGE_5 = "i18n.mityc.api.bridge.5";
    /** No hay propiedad para indicar clase de facade de servicios de firma. */
    public static final String I18N_BRIDGE_6 = "i18n.mityc.api.bridge.6";

    // Certificates
    /** Contraseña de almacén de certificados. */
    public static final String I18N_CERT_SMR_CARD_TITLE = "i18n.mityc.api.cert.smartcards.GUI.title";
    /** Aceptar. */
    public static final String I18N_CERT_SMR_CARD_ACCEPT = "i18n.mityc.api.cert.smartcards.GUI.accept";
    /** Cancelar. */
    public static final String I18N_CERT_SMR_CARD_CANCEL = "i18n.mityc.api.cert.smartcards.GUI.cancel";
    /** Introduzca la contraseña. */
    public static final String I18N_CERT_SMR_CARD_PIN = "i18n.mityc.api.cert.smartcards.GUI.pin";
    /** Tipo identificador: {0}. */
    public static final String I18N_CERT_1 = "i18n.mityc.api.cert.1";
    /** Nombre X500. */
    public static final String I18N_CERT_2 = "i18n.mityc.api.cert.2";
    /** Hash PublicKey. */
    public static final String I18N_CERT_3 = "i18n.mityc.api.cert.3";
    /** Desconocido. */
    public static final String I18N_CERT_4 = "i18n.mityc.api.cert.4";
    /** (Valor: {0}). */
    public static final String I18N_CERT_5 = "i18n.mityc.api.cert.5";

}
