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

import java.security.cert.X509Certificate;

/**
 * <p>
 * Interfaz para comunicar de errores encontrados en la verificacion de la conexion SSL.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface ISSLErrorManager {

    /**
     * <p>
     * Indica que se ha producido un error al comprobar la identidad del servidor.
     * </p>
     * <p>
     * El certificado del servidor y el nombre del host no coinciden.
     * </p>
     * 
     * @param actualHost
     *            Nombre resuelto del peer
     * @param certServer
     *            Certificado obtenido del servidor
     * 
     * @return <code>true</code> si se debe continuar, <code>false</code> si se debe parar el establecimiento del SSL
     */
    boolean continueErrorPeer(String actualHost, X509Certificate certServer);

}
