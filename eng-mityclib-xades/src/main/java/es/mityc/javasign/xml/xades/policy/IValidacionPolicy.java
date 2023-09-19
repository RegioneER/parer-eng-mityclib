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

package es.mityc.javasign.xml.xades.policy;

import org.w3c.dom.Element;

import es.mityc.firmaJava.libreria.xades.ResultadoValidacion;

/**
 * Interfaz que han de implementar los validadores de policies que gestiona el manager de policies.
 * 
 * Ademas los validadores de policies deben tener un constructor por defecto sin parametros.
 *
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface IValidacionPolicy {

    /**
     * Este método debera encargarse de validar que la firma cumple la policy implementada.
     * 
     * @param nodoFirma
     *            nodo raíz (de firma) de la firma que se esta validando
     * @param resultadoValidacion
     *            resultado de la validacion de una firma
     * 
     * @return devuelve el resultado de la validacion de la policy
     */
    public PolicyResult validaPolicy(Element nodoFirma, final ResultadoValidacion resultadoValidacion);

    /**
     * Devuelve una cadena que sirve para identificar la policy
     * 
     * @return identificacion de la policy
     */
    public String getIdentidadPolicy();

}
