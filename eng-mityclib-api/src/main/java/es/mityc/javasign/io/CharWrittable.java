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

import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * <p>
 * Implementa el interfaz {@link IWriter} sobre una cadena de caracteres.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class CharWrittable implements IWriter {

    /** Escritor interno de caracteres. */
    private CharArrayWriter caw;

    /**
     * <p>
     * Constructor.
     * </p>
     */
    public CharWrittable() {
        caw = new CharArrayWriter();
    }

    /**
     * <p>
     * Escribe nuevos datos en el buffer de escritura.
     * </p>
     * 
     * @param c
     *            array de caracteres a escribir
     * @param off
     *            Offset sobre el array de caracteres
     * @param len
     *            cantidad de bytes a escribir
     */
    public void write(final char[] c, final int off, final int len) {
        caw.write(c, off, len);
    }

    /**
     * <p>
     * Asegura el contenido del buffer interno.
     * </p>
     * 
     * @throws IOException
     *             Lanzada cuando se produce un error al asegurar el buffer interno
     * 
     * @see es.mityc.javasign.io.IWriter#flush()
     */
    public void flush() throws IOException {
        caw.flush();
    }

    /**
     * <p>
     * Inicializa el objeto vaciando los buffers internos.
     * </p>
     * 
     * @see es.mityc.javasign.io.IWriter#reset()
     */
    public void reset() {
        caw.reset();
    }

    /**
     * <p>
     * Devuelve la cantidad de datos disponibles en el buffer interno.
     * </p>
     * 
     * @return número de bytes disponibles
     * 
     * @see es.mityc.javasign.io.IWriter#size()
     */
    public int size() {
        return caw.size();
    }

    /**
     * <p>
     * Devuelve un array con los datos disponibles en el buffer interno.
     * </p>
     * 
     * @return array con los datos disponibles
     * 
     * @see es.mityc.javasign.io.IWriter#toByteArray()
     */
    public byte[] toByteArray() {
        return caw.toString().getBytes();
    }
}
