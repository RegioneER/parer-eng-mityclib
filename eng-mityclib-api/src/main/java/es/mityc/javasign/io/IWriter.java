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
package es.mityc.javasign.io;

import java.io.IOException;

/**
 * <p>
 * Interfaz que debe implementar la clase que inyecte datos en un {@link ByteArrayWrittableInputStream}.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface IWriter {

    /**
     * <p>
     * Vacía los buffers intermedios.
     * </p>
     * 
     * @throws IOException
     *             si hay algún problema en el vaciado
     */
    void flush() throws IOException;

    /**
     * <p>
     * Devuelve un array de bytes con el contenido escrito.
     * </p>
     * 
     * @return byte[] con el contenido escrito
     */
    byte[] toByteArray();

    /**
     * <p>
     * Inicializa el escritor marcandolo como vacío.
     * </p>
     */
    void reset();

    /**
     * <p>
     * Devuelve el tamaño actual del contenido escrito.
     * </p>
     * 
     * @return tamaño en bytes del contenido actual
     */
    int size();

}
