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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * Implementa un {@link InputStream} equivalente a {@link ByteArrayInputStream} pero que permite escribir en el array
 * del que se alimenta durante su uso.
 * </p>
 * 
 * <p>
 * Permite asociar un escritor general para ir llenando el array interno. El escritor general ha de implementar el
 * interfaz {@link IWriter}.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class ByteArrayWrittableInputStream extends InputStream {

    /** Buffer interno de lectura. */
    private ByteArrayInputStream bais = null;
    /** Escritor para rellenar el buffer interno. */
    private IWriter writer = null;

    /**
     * <p>
     * Constructor.
     * </p>
     * 
     * @param wrt
     *            Escritor que se utilizara para rellenar el buffer
     */
    public ByteArrayWrittableInputStream(final IWriter wrt) {
        bais = new ByteArrayInputStream(new byte[0]);
        this.writer = wrt;
    }

    /**
     * <p>
     * Lee del buffer de lectura. Si se vacía lo cambia al buffer de escritura y éste lo resetea.
     * </p>
     * 
     * @return byte leido del buffer
     * 
     * @throws IOException
     *             lanzada cuando se produce un error al leer del buffer
     * 
     * @see java.io.InputStream#read()
     */
    @Override
    public int read() throws IOException {
        int data = bais.read();
        if (data == -1) {
            updateBuffer();
            data = bais.read();
        }
        return data;
    }

    /**
     * <p>
     * Actualiza los buffers de escritura y lectura con los últimos bytes escritos por el {@link IWriter} asociado.
     * </p>
     * 
     * @throws IOException
     *             Lanzada si se produce un error al actualizar el buffer
     */
    private void updateBuffer() throws IOException {
        flush();
        bais = new ByteArrayInputStream(writer.toByteArray());
        writer.reset();
    }

    /**
     * <p>
     * Vacía el contenido del {@link IWriter} asociado en el array interno.
     * </p>
     * 
     * @throws IOException
     *             Lanzada si se produce un error al asegurar el contenido interno
     */
    public void flush() throws IOException {
        writer.flush();
    }

    /**
     * <p>
     * Indica si se pueden recuperar mas bytes del buffer interno.
     * </p>
     * 
     * <p>
     * Comprueba en primer lugar si todavía quedan disponibles bytes en el buffer interno, y si no es el caso, consulta
     * al {@link IWriter} asociado a ver si ya se han producido mas datos.
     * </p>
     * 
     * @return Númer de bytes disponibles en el buffer intermedio
     * 
     * @throws IOException
     *             Lanzada si se produce un error al acceder al contenido interno
     * 
     * @see java.io.InputStream#available()
     */
    @Override
    public int available() throws IOException {
        int i = bais.available();
        if (i == 0) {
            i = writer.size();
        }
        return i;
    }

}
