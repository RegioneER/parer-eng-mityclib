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
 * Interfaz que ha de implementar una factoría de managers de internacionalizacion.
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface II18nFactory {

    /**
     * Devuelve una instancia de un manager de internacionalizacion.
     * 
     * @param dictionary
     *            Clave que identifica el diccionario
     * @param locale
     *            Localizacion de la que se quiere el diccionario
     * 
     * @return Instancia del manager de internacionalizacion
     */
    II18nManager getI18nManager(String dictionary, Locale locale);

}
