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
 * Este interfaz permite la obtencion de informacion referente a recursos de la firma (disponible en nodos Reference).
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface IResourceData {

    /**
     * Obtiene acceso a la informacion del elemento indicado.
     * 
     * @param name
     *            Nombre del elemento del que se quiere obtener acceso
     * @param baseURI
     *            Ruta base del elemento
     * 
     * @return Objeto del tipo InputStream o byte[] que da acceso a los datos del elemento
     * 
     * @throws ResourceDataException
     *             lanzada cuando no se puede acceder a la informacion por alguna razon
     */
    public Object getAccess(String name, String baseURI) throws ResourceDataException;

    /**
     * Indica si esta implementacion puede acceder a la informacion indicada
     * 
     * @param name
     *            Nombre del elemento
     * @param baseURI
     *            Ruta base del elemento
     * 
     * @return <code>true<code> si puede acceder, <code>false</code> en otro caso
     */
    public boolean canAccess(String name, String baseURI);

}
