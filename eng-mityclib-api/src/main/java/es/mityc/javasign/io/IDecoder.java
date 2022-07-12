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

/**
 * Interfaz que deben cumplir los decodificadores utilizados en {@link DecoderInputStream} para poder decodificar una
 * entrada al aire (directamente desde el <i>stream</i> de entrada, en pequeños bloques, sin tener que cargar todo el
 * contenido del <i>stream</i>).
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface IDecoder {

    /**
     * <p>
     * Indica que para poder continuar decoficando se ha de incluir mas datos en el buffer.
     * </p>
     * 
     * @return <code>true</code> si necesita mas datos, <code>false</code> en otro caso
     */
    boolean needsInput();

    /**
     * <p>
     * Indica quedan bytes en el buffer sin decodificar.
     * </p>
     * 
     * @return <code>true</code> si quedan bytes sin haber sido decoficados en el buffer, <code>false</code> en otro
     *         caso
     */
    boolean isIncomplete();

    /**
     * <p>
     * Añade nuevos datos en el buffer de decodificacion.
     * </p>
     * 
     * @param data
     *            array con los nuevos datos
     * @param off
     *            posicion del array desde la que se incluyen los datos
     * @param len
     *            cantidad de bytes que hay que añadir
     */
    void addInput(byte[] data, int off, int len);

    /**
     * <p>
     * Decodifica en el array de bytes indicado la informacion contenida en el buffer.
     * </p>
     * 
     * @param data
     *            Array en el que escribir los datos
     * @param off
     *            Posicion a partir de la cual escribir
     * @param len
     *            Cantidad de bytes maximo que se puede escribir
     * 
     * @return Cantidad de bytes que se han decodificado
     * 
     * @throws DecodingException
     *             lanzada cuando se produce un error decodificando (los datos no se ajustan al codec o hay
     *             desincronismos en el buffer)
     */
    int decode(byte[] data, int off, int len) throws DecodingException;

}
