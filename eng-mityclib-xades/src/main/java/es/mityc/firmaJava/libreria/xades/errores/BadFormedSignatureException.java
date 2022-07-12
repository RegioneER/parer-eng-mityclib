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
 * 51 Franklin Street, 5º Piso, Boston, MA 02110-1301, USA o consulte
 * <http://www.gnu.org/licenses/>.
 *
 * Copyright 2008 Ministerio de Industria, Turismo y Comercio
 * 
 */

package es.mityc.firmaJava.libreria.xades.errores;

/**
 * Excepcion en la implementacion de un esquema XAdES
 *
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 0.9 beta
 */

public class BadFormedSignatureException extends XMLError {
    /**
     * Crea una nueva instancia de XMLError sin el detalle mensaje
     */
    public BadFormedSignatureException() {
    }

    /**
     * Crea una instancia de BadFormedSignatureException con el detalle de mensaje especificado
     * 
     * @param msg
     *            El detalle mensaje
     */
    public BadFormedSignatureException(String msg) {
        super(msg);
    }

    public BadFormedSignatureException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadFormedSignatureException(Throwable cause) {
        super(cause);
    }
}
