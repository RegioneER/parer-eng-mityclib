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
package es.mityc.javasign.ssl;

import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;

/**
 * <p>
 * Gestion de la pasarela SSL de comunicacion del cliente TS.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class SimpleSSLManager implements ISSLManager {

    /** Gestionador de la confianza para el otro punto de conexion. */
    private TrustManager truster;
    /** Gestionador de las claves para la autenticacion de este punto. */
    private KeyManager keyer;
    /** Gestionador de los errores del establecimiento de la sesion SSL. */
    private ISSLErrorManager errorManager;

    /**
     * <p>
     * Constructor.
     * </p>
     * 
     * @param trustManager
     *            gestionador de la confianza
     * @param keyManager
     *            gestionador de la autenticacion
     */
    public SimpleSSLManager(TrustManager trustManager, KeyManager keyManager) {
        this.truster = trustManager;
        this.keyer = keyManager;
    }

    /**
     * <p>
     * Establece el gestionador de errores en las comunicaciones SSL.
     * </p>
     * 
     * @param errorMng
     *            Manager de errores
     */
    public void setSSLErrorManager(final ISSLErrorManager errorMng) {
        this.errorManager = errorMng;
    }

    /**
     * <p>
     * Devuelve el manager de errores establecido.
     * </p>
     * 
     * @return manager de errores
     * 
     * @see es.mityc.javasign.ssl.ISSLManager#getSSLErrorManager()
     */
    public ISSLErrorManager getSSLErrorManager() {
        return errorManager;
    }

    /**
     * <p>
     * Devuelve el gestionador de autenticacion de este punto.
     * </p>
     * 
     * @return gestionador de autenticacion
     * 
     * @see es.mityc.javasign.ssl.ISSLManager#getKeyManager()
     */
    public KeyManager getKeyManager() {
        return keyer;
    }

    /**
     * <p>
     * Devuelve el gestionador de confianza del otro punto.
     * </p>
     * 
     * @return gestionador de confianza
     * 
     * @see es.mityc.javasign.ssl.ISSLManager#getTrustManager()
     */
    public TrustManager getTrustManager() {
        return truster;
    }

}
