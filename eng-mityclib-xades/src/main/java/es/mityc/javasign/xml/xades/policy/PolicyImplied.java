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
import es.mityc.firmaJava.libreria.xades.elementos.xades.SignaturePolicyIdentifier;
import es.mityc.firmaJava.libreria.xades.errores.PolicyException;

/**
 * Escribe la política implícita en el nodo de firma indicado, sustituyendo la política previa indicada (si la hay).
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class PolicyImplied implements IFirmaPolicy {

    public PolicyImplied() {

    }

    /**
     * 
     * @see es.mityc.javasign.xml.xades.policy.IFirmaPolicy#writePolicyNode(org.w3c.dom.Element, java.lang.String,
     *      java.lang.String, es.mityc.firmaJava.libreria.xades.XAdESSchemas)
     */
    public void writePolicyNode(Element nodoFirma, String namespaceDS, String namespaceXAdES, XAdESSchemas schema)
            throws PolicyException {
        SignaturePolicyIdentifier spi = new SignaturePolicyIdentifier(schema, true);
        PoliciesTool.insertPolicyNode(nodoFirma, namespaceDS, namespaceXAdES, schema, spi);
    }

}
