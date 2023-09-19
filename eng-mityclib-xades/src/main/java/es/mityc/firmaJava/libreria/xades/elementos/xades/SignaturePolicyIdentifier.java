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

package es.mityc.firmaJava.libreria.xades.elementos.xades;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.mityc.firmaJava.libreria.ConstantesXADES;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class SignaturePolicyIdentifier extends SignaturePolicyIdentifierType {

    /**
     * @param schema
     */
    public SignaturePolicyIdentifier(XAdESSchemas schema) {
        super(schema);
    }

    public SignaturePolicyIdentifier(XAdESSchemas schema, boolean isImplied) {
        super(schema, isImplied);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xades.SignaturePolicyIdentifierType#isThisNode(org.w3c.dom.Node)
     */
    @Override
    public boolean isThisNode(Node node) {
        return isElementName(nodeToElement(node), schema.getSchemaUri(), ConstantesXADES.SIGNATURE_POLICY_IDENTIFIER);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xades.SignaturePolicyIdentifierType#load(org.w3c.dom.Element)
     */
    @Override
    public void load(Element element) throws InvalidInfoNodeException {
        checkElementName(element, schema.getSchemaUri(), ConstantesXADES.SIGNATURE_POLICY_IDENTIFIER);
        super.load(element);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xades.AbstractXADESElement#createElement(org.w3c.dom.Document,
     *      java.lang.String, java.lang.String)
     */
    @Override
    public Element createElement(Document doc, String namespaceXDsig, String namespaceXAdES)
            throws InvalidInfoNodeException {
        return super.createElement(doc, namespaceXDsig, namespaceXAdES);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#createElement(org.w3c.dom.Document)
     */
    @Override
    protected Element createElement(Document doc) throws InvalidInfoNodeException {
        Element res = doc.createElementNS(schema.getSchemaUri(),
                namespaceXAdES + ":" + ConstantesXADES.SIGNATURE_POLICY_IDENTIFIER);
        super.addContent(res, namespaceXAdES, namespaceXDsig);
        return res;
    }

}
