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
 * Soporte de internacionalizador cacheado.
 * </p>
 * <p>
 * Permite optimizar el acceso a internacionalizadores cacheando un manager de un diccionario con el locale relativo.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
class ManagerCached {
    /** Manager de internacionalizacion. */
    private II18nManager managerCached;
    /** Locale del internacionalizador. */
    private Locale localeCached;

    /**
     * <p>
     * Constructor.
     * </p>
     * 
     * @param manager
     *            Manager de internacionalizacion
     * @param i18nLocale
     *            Locale del manager
     */
    public ManagerCached(final II18nManager manager, final Locale i18nLocale) {
        this.managerCached = manager;
        this.localeCached = i18nLocale;
    }

    /**
     * <p>
     * Devuelve si el locale indicado es el mismo que el del manager cacheado.
     * </p>
     * 
     * @param otherLocale
     *            Localizador a comparar
     * 
     * @return <code>true</code> si es el mismo locale, <code>false</code> en otro caso
     */
    public boolean isSameLocale(final Locale otherLocale) {
        if (otherLocale == null) {
            if (this.localeCached == null) {
                return true;
            }
            return false;
        }
        return otherLocale.equals(this.localeCached);
    }

    /**
     * <p>
     * Devuelve el manager asociado a esta caché.
     * </p>
     * 
     * @return internacionalizador
     */
    public II18nManager getI18nCached() {
        return managerCached;
    }
}
