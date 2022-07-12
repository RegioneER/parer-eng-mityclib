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
 * Interfaz que han de cumplir los gestionadores de las conexiones SSL del cliente.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface ISSLManager {

    /**
     * <p>
     * Devuelve el gestionador de confianza del otro peer de la conexion.
     * </p>
     * 
     * @return gestor de confianza
     */
    TrustManager getTrustManager();

    /**
     * <p>
     * Devuelve el gestionador de la autenticacion por parte de este peer de la conexion.
     * </p>
     * 
     * @return gestionador de las claves
     */
    KeyManager getKeyManager();

    /**
     * <p>
     * Devuelve el gestionador ante errores en el establecimiento del SSL.
     * </p>
     * 
     * @return gestionador de errores, <code>null</code> si no se desea ninguno
     */
    ISSLErrorManager getSSLErrorManager();

}
