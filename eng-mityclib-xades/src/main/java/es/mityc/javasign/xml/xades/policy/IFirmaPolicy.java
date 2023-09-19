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

import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.firmaJava.libreria.xades.errores.PolicyException;

/**
 * Interfaz que han de implementar las clases que añadan policies que gestiona el manager de policies.
 * 
 * Ademas los escritores de policies deben tener un constructor por defecto sin parametros.
 *
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface IFirmaPolicy {

    /**
     * Este método debera encargarse escribir la policy.
     * 
     * @param signNode
     *            nodo raíz (de firma) de la firma en la que se quiere escribir la política
     * @param namespaceDS
     *            Namespace de xmlDSig
     * @param namespaceXAdES
     *            namespace de XAdES
     * @param schema
     *            esquema de XAdEs
     * 
     * @throws lanza
     *             una excepcion si no puede escribir la policy.
     */
    public void writePolicyNode(Element signNode, String namespaceDS, String namespaceXAdES, XAdESSchemas schema)
            throws PolicyException;

}
