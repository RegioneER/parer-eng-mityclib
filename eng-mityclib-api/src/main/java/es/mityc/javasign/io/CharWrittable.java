/*
 * Engineering Ingegneria Informatica S.p.A.
 *
 * Copyright (C) 2023 Regione Emilia-Romagna
 * <p/>
 * This program is free software: you can redistribute it and/or modify it under the terms of
 * the GNU Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU Affero General Public License along with this program.
 * If not, see <https://www.gnu.org/licenses/>.
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
