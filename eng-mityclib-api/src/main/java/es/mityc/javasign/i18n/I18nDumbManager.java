/**
 * LICENCIA LGPL:
 * 
 * Esta librería es Software Libre; Usted puede redistribuirlo y/o modificarlo
 * bajo los términos de la GNU Lesser General Public License (LGPL)
 * tal y como ha sido publicada por la Free Software Foundation; o
 * bien la version 2.1 de la Licencia, o (a su eleccion) cualquier version posterior.
 * 
 * Esta librería se distribuye con la esperanza de que sea útil, pero SIN NINGUNA
 * GARANTÍA; tampoco las implícitas garantías de MERCANTILIDAD o ADECUACIoN A UN
 * PROPoSITO PARTICULAR. Consulte la GNU Lesser General Public License (LGPL) para mas
 * detalles
 * 
 * Usted debe recibir una copia de la GNU Lesser General Public License (LGPL)
 * junto con esta librería; si no es así, escriba a la Free Software Foundation Inc.
 * 51 Franklin Street, 5º Piso, Boston, MA 02110-1301, USA.
 * 
 */
package es.mityc.javasign.i18n;

import java.util.Locale;

/**
 * <p>
 * Manager devuelto cuando no se dispone de un diccionario asociado.
 * </p>
 * 
 * <p>
 * Esta clase evita que se produzcan errores en ejecucion si no se controlan errores al instanciar el manager.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class I18nDumbManager implements II18nManager {

    /** Espacio en blanco. */
    private static final String SPACE = " ";
    /** Cabecera fija del mensaje del internacionalizador. */
    private static final String DUMB_MESSAGE = "I18nDumbManager: no dictionary avalaible: ";

    /** Respuesta enviada como cabecera de todas las consultas a este internacionalizador. */
    private String response;

    /**
     * <p>
     * Construye una instancia de un manager no disponible.
     * </p>
     */
    public I18nDumbManager() {
    }

    /**
     * <p>
     * Inicializa el diccionario con el nombre del diccionario que se ha pedido.
     * </p>
     * 
     * @param dictionary
     *            Nombre del diccionario que no se ha encontrado
     * @param locale
     *            Localizador con el que se inicializa el manager
     * 
     * @throws DictionaryUnknownException
     *             No se lanza nunca
     */
    public void init(final String dictionary, final Locale locale) throws DictionaryUnknownException {
        response = DUMB_MESSAGE + dictionary;
        if (locale != null) {
            response = response + SPACE + locale;
        }
    }

    /**
     * <p>
     * Devuelve un mensaje de aviso de que el diccionario no se encuentra disponible.
     * </p>
     * 
     * @param message
     *            Clave del mensaje que se quiere internacionalizar
     * 
     * @return mensaje de aviso del error
     * 
     * @see es.mityc.javasign.i18n.II18nManager#getLocalMessage(java.lang.String)
     */
    public String getLocalMessage(final String message) {
        return response + SPACE + message;
    }

    /**
     * <p>
     * Devuelve un mensaje de aviso de que el diccionario no se encuentra disponible.
     * </p>
     * 
     * @param message
     *            Clave del mensaje que se quiere internacionalizar
     * @param varargs
     *            variables que se quieren introducir en el mensaje
     * 
     * @return mensaje de aviso del error
     * 
     * @see es.mityc.javasign.i18n.II18nManager#getLocalMessage(java.lang.String, java.lang.Object[])
     */
    public String getLocalMessage(final String message, final Object... varargs) {
        return response + SPACE + message;
    }

}
