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
package es.mityc.javasign.trust;

import es.mityc.javasign.exception.SignMITyCException;

/**
 * <p>
 * Base de las excepciones lanzadas cuando hay problemas de confianza.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class TrustException extends SignMITyCException {

    /** SerialVersionUID. */
    static final long serialVersionUID = 1L;

    /**
     * <p>
     * Constructor.
     * </p>
     */
    public TrustException() {
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
    public TrustException(final String message) {
        super(message);
    }

    /**
     * <p>
     * Constructor.
     * </p>
     * 
     * @param cause
     *            Excepcion que causa esta otra excepcion
     */
    public TrustException(final Throwable cause) {
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
     *            Excepcion que causa esta otra excepcion
     */
    public TrustException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
