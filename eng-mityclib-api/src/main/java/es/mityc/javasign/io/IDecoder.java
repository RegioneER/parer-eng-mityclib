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
