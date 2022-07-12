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

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * Manager por defecto para la internacionalizacion.
 * </p>
 * 
 * <p>
 * Obtiene el diccionario buscando un fichero de propiedades con el mismo nombre que el diccionario la ruta de recursos
 * <code>/i18n/dictionaries</code> y con el tipo de Locale indicado. No se recarga si hay un cambio de Locale.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class I18nDefaultManager implements II18nManager {

    /** SerialVersionUID. */
    static final long serialVersionUID = 1L;
    /** Logger. */
    private static final Log LOG = LogFactory.getLog(I18nDefaultManager.class);

    /** Ruta donde se buscan los diccionarios. */
    protected static final String BASE_PATH = "i18n/dictionaries/";
    /** Clave malformada: {0}. */
    private static final String ILLFORMED_KEY = "Clave malformada: {0}";
    /** No existe clave {0}. */
    private static final String NOT_AVALAIBLE_KEY = "No existe clave {0}";

    /** Recursos de internacionalizacion asociados a este manager. */
    protected ResourceBundle rb = null;
    /** Locale por defecto. */
    protected Locale locale = null;

    /**
     * <p>
     * Constructor por defecto.
     * </p>
     */
    public I18nDefaultManager() {
        // Constructor por defecto
    }

    /**
     * <p>
     * Busca el diccionario indicado en la ruta <code>i18n/dictionaries</code> siguiendo el nombre del diccionario
     * provisto como un recurso dependiente del locale (@see {@link ResourceBundle}).
     * </p>
     * 
     * @param dictionary
     *            Nombre del diccionario que se asocia al manager
     * @param specificLocale
     *            locale específico en el que se quiere el diccionario
     * 
     * @throws DictionaryUnknownException
     *             Lanzada cuando no se encuentra el diccionario indicado
     * 
     * @see es.mityc.javasign.i18n.II18nManager#init(java.lang.String, java.util.Locale)
     */
    public void init(final String dictionary, final Locale specificLocale) throws DictionaryUnknownException {
        // busca el fichero de recursos de idioma en la carpeta i18n/dictionaries
        try {
            if (specificLocale == null) {
                this.locale = Locale.getDefault();
            } else {
                this.locale = (Locale) specificLocale.clone();
            }
            rb = ResourceBundle.getBundle(BASE_PATH + dictionary, this.locale);
        } catch (MissingResourceException ex) {
            throw new DictionaryUnknownException(ex);
        }
    }

    /**
     * <p>
     * Devuelve el mensaje con la clave indicada disponible en el diccionario actual.
     * </p>
     * 
     * @param message
     *            clave del mensaje que se quiere recuperar
     * 
     * @return Mensaje recuperado del diccionario, <code>null</code> si no hay mensaje asociado a la clave o no hay
     *         diccionario
     * 
     * @see es.mityc.javasign.i18n.II18nManager#getLocalMessage(java.lang.String)
     */
    public String getLocalMessage(final String message) {
        try {
            return findMessage(message);
        } catch (MissingResourceException ex) {
            LOG.warn(getFormatedMessage(NOT_AVALAIBLE_KEY, message));
        }
        return null;
    }

    /**
     * <p>
     * Devuelve el mensaje asociado a la clave indicada.
     * </p>
     * <p>
     * Busca el mensaje en el diccionario actual disponible.
     * </p>
     * 
     * @param key
     *            clave del mensaje
     * 
     * @return Mensaje recuperado
     */
    protected String findMessage(final String key) {
        if (rb != null) {
            return rb.getString(key);
        }
        return null;
    }

    /**
     * <p>
     * Formatea un mensaje con los datos provistos.
     * </p>
     * 
     * @param message
     *            mensaje que sigue el formato indicado en {@link MessageFormat}
     * @param varargs
     *            objetos que hay que insertar en el mensaje
     * 
     * @return Mensaje con los objetos insertados
     */
    private static String getFormatedMessage(final String message, final Object... varargs) {
        MessageFormat mf = new MessageFormat(message);
        return mf.format(varargs, new StringBuffer(), null).toString();
    }

    /**
     * <p>
     * Devuelve el mensaje con la clave indicada disponible en el diccionario actual.
     * </p>
     * 
     * @param message
     *            clave del mensaje que se quiere recuperar
     * @param varargs
     *            objetos que hay que insertar en el mensaje
     * 
     * @return Mensaje recuperado del diccionario, <code>null</code> si no hay mensaje asociado a la clave o no hay
     *         diccionario
     * 
     * @see es.mityc.javasign.i18n.II18nManager#getLocalMessage(java.lang.String, java.lang.Object[])
     */
    public String getLocalMessage(final String message, final Object... varargs) {
        try {
            String res = findMessage(message);
            if (res != null) {
                MessageFormat mf = new MessageFormat(res, locale);
                return mf.format(varargs, new StringBuffer(), null).toString();
            }
        } catch (MissingResourceException ex) {
            LOG.warn(getFormatedMessage(NOT_AVALAIBLE_KEY, message));
        } catch (IllegalArgumentException ex) {
            LOG.warn(getFormatedMessage(ILLFORMED_KEY, message));
        }
        return null;
    }

}
