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

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * <p>
 * Implementa el interfaz {@link IWriter} sobre un array de bytes.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class ByteArrayWrittable implements IWriter {

    /** Buffer privado para acceder a un array de bytes. */
    private ByteArrayOutputStream baos;

    /**
     * <p>
     * Constructor.
     * </p>
     */
    public ByteArrayWrittable() {
        baos = new ByteArrayOutputStream();
    }

    /**
     * <p>
     * Escribe nuevos datos en el buffer de escritura.
     * </p>
     * 
     * @param b
     *            array de bytes que contiene los datos que hay que escribir
     * @param off
     *            Offset en el array de bytes
     * @param len
     *            Número de bytes a escribir
     */
    public void write(final byte[] b, final int off, final int len) {
        baos.write(b, off, len);
    }

    /**
     * <p>
     * Asegura que los datos que estan en bufferes temporales se guarden.
     * </p>
     * 
     * @throws IOException
     *             Lanzada cuando no se han podido asegurar los datos
     * 
     * @see es.mityc.javasign.io.IWriter#flush()
     */
    public void flush() throws IOException {
        baos.flush();
    }

    /**
     * <p>
     * Limpia el buffer vaciandolo.
     * </p>
     * 
     * @see es.mityc.javasign.io.IWriter#reset()
     */
    public void reset() {
        baos.reset();
    }

    /**
     * <p>
     * Devuelve el número de bytes disponibles en el buffer.
     * </p>
     * 
     * @return número de bytes disponibles en el buffer interno
     * 
     * @see es.mityc.javasign.io.IWriter#size()
     */
    public int size() {
        return baos.size();
    }

    /**
     * <p>
     * Devuelve en un array de bytes los datos acumulados.
     * </p>
     * 
     * @return array de bytes disponible en el buffer
     * 
     * @see es.mityc.javasign.io.IWriter#toByteArray()
     */
    public byte[] toByteArray() {
        return baos.toByteArray();
    }
}
