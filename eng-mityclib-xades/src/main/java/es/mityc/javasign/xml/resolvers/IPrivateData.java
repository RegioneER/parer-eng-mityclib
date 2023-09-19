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

package es.mityc.javasign.xml.resolvers;

/**
 * Este interfaz permite la obtencion del hash de informacion para ser firmada que permanece privada a la librería de
 * firma.
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface IPrivateData {

    /**
     * Obtiene el digest del elemento utilizando el algoritmo de hashing indicado.
     * 
     * @param name
     *            Nombre del elemento del que se quiere calcular el hashing
     * @param baseURI
     *            Ruta base del elemento
     * @param algName
     *            Nombre del algoritmo de hashing
     * 
     * @return Digest calculado de la informacion privada
     * 
     * @throws ResourceDataException
     *             lanzada cuando no se puede acceder a la informacion por alguna razon
     */
    public byte[] getDigest(String name, String baseURI, String algName) throws ResourceDataException;

    /**
     * Indica si esta implementacion puede acceder a la informacion indicada para calcular su digest
     * 
     * @param name
     *            Nombre del elemento
     * @param baseURI
     *            Ruta base del elemento
     * 
     * @return <code>true<code> si puede calcular su digest, <code>false</code> en otro caso
     */
    public boolean canDigest(String name, String baseURI);

}
