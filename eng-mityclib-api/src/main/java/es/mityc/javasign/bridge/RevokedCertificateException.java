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
package es.mityc.javasign.bridge;

/**
 * <p>
 * Excepcion lanzada cuando un certificado cuyo estado se ha consultado se encuentra revocado.
 * </p>
 * <p>
 * El texto de la excepcion es la causa de la revocacion (si se puede obtener).
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class RevokedCertificateException extends InvalidCertificateException {

    /**
     * <p>
     * Constructor.
     * </p>
     */
    public RevokedCertificateException() {
        super();
    }

    /**
     * <p>
     * Constructor.
     * </p>
     * 
     * @param message
     *            Mensaje de error
     */
    public RevokedCertificateException(final String message) {
        super(message);
    }

    /**
     * <p>
     * Constructor.
     * </p>
     * 
     * @param cause
     *            Causa de la excepcion
     */
    public RevokedCertificateException(final Throwable cause) {
        super(cause);
    }

    /**
     * <p>
     * Constructor.
     * </p>
     * 
     * @param message
     *            Mensaje de error
     * @param cause
     *            Causa de la excepcion
     */
    public RevokedCertificateException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
