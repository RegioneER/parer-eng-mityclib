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
 * Interfaz que han de implementar los managers de internacionalizacion.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface II18nManager {

    /**
     * Inicializa el manager con el diccionario indicado.
     * 
     * @param dictionary
     *            diccionario que debera gestionar el manager
     * @param locale
     *            Locale establecido (<code>null</code> si no se especifica ninguno)
     * 
     * @throws DictionaryUnknownException
     *             cuando se desconoce el diccionario indicado
     */
    void init(String dictionary, Locale locale) throws DictionaryUnknownException;

    /**
     * <p>
     * Devuelve el mensaje identificado por la clave proporcionada según el diccionario gestionado por el manager.
     * </p>
     * 
     * @param message
     *            clave que identifica el mensaje
     * 
     * @return mensaje recuperado
     */
    String getLocalMessage(String message);

    /**
     * <p>
     * Devuelve el mensaje compuesto identificado por la clave proporcionada según el diccionario gestionado por el
     * manager.
     * </p>
     * 
     * @param message
     *            clave que identifica el mensaje
     * @param varargs
     *            variables que se deben insertar en el mensaje compuesto
     * 
     * @return mensaje recuperado con las variables indicadas incrustadas
     */
    String getLocalMessage(String message, Object... varargs);

}
