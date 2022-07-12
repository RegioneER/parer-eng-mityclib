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
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * <p>
 * Manager para la internacionalizacion que permite sobreescritura de frases.
 * </p>
 * 
 * <p>
 * Obtiene el diccionario buscando un fichero de propiedades con el mismo nombre que el diccionario la ruta de recursos
 * <code>/i18n/dictionaries</code> y con el tipo de Locale indicado. No se recarga si hay un cambio de Locale.
 * </p>
 * <p>
 * También busca un diccionario con el mismo nombre pero añadiéndole el sufijo <code>_add</code>. En caso de existir
 * buscara las claves en ese fichero antes que en el fichero base.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class I18nAddendumManager extends I18nDefaultManager {

    /** Ruta donde se buscan los diccionarios. */
    protected static final String ADDENDUM_SUFIX = "_add";

    /** Recursos de internacionalizacion addendum asociados a este manager. */
    private ResourceBundle rbAdd = null;

    /**
     * <p>
     * Busca el diccionario indicado en la ruta <code>i18n/dictionaries</code> siguiendo el nombre del diccionario
     * provisto como un recurso dependiente del locale (@see {@link ResourceBundle}) y añadiéndole el sufijo
     * <code>add</code>.
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
    @Override
    public void init(final String dictionary, final Locale specificLocale) throws DictionaryUnknownException {
        super.init(dictionary, specificLocale);
        // busca el fichero extra de recursos de idioma en la carpeta i18n/dictionaries
        try {
            rbAdd = ResourceBundle.getBundle(BASE_PATH + dictionary + ADDENDUM_SUFIX, this.locale);
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * <p>
     * Devuelve el mensaje asociado a la clave indicada.
     * </p>
     * <p>
     * Busca el mensaje en el addenudum en primer lugar. Si no lo encuentra lo busca en el diccionario base.
     * </p>
     * 
     * @param key
     *            clave del mensaje
     * 
     * @return Mensaje recuperado
     */
    @Override
    protected String findMessage(final String key) {
        if (rbAdd != null) {
            try {
                return rbAdd.getString(key);
            } catch (MissingResourceException ex) {
            }
        }
        return super.findMessage(key);
    }
}
