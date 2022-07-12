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
package es.mityc.javasign.xml.resolvers;

import es.mityc.javasign.xml.XmlException;

/**
 * Esta excepcion se lanza cuando se produce algún error al intentar calcular el digest de informacion privada
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class ResourceDataException extends XmlException {

    /**
     * 
     */
    public ResourceDataException() {
        super();
    }

    /**
     * @param message
     */
    public ResourceDataException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public ResourceDataException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public ResourceDataException(String message, Throwable cause) {
        super(message, cause);
    }

}
