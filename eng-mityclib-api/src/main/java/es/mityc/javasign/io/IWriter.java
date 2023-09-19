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
