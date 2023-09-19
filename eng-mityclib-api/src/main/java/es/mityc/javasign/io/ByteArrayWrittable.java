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
