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
 * @author dsantose
 *
 */
public class SignatureProductionPlace extends SignatureProductionPlaceType {

    /**
     * @param schema
     */
    public SignatureProductionPlace(XAdESSchemas schema) {
        super(schema);
    }

    public SignatureProductionPlace(XAdESSchemas schema, String city, String state, String postalCode, String country) {
        super(schema, city, state, postalCode, country);
    }

    @Override
    public void load(Element element) throws InvalidInfoNodeException {
        checkElementName(element, schema.getSchemaUri(), ConstantesXADES.XADES_TAG_SIGNATURE_PRODUCTION_PLACE);
        super.load(element);
    }

    @Override
    public boolean isThisNode(Node node) {
        return isElementName(nodeToElement(node), schema.getSchemaUri(),
                ConstantesXADES.XADES_TAG_SIGNATURE_PRODUCTION_PLACE);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xades.AbstractXADESElement#createElement(org.w3c.dom.Document,
     *      java.lang.String, java.lang.String)
     */
    @Override
    public Element createElement(Document doc, String namespaceXAdES) throws InvalidInfoNodeException {
        return super.createElement(doc, namespaceXAdES);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xades.SignaturePolicyIdType#createElement(org.w3c.dom.Document)
     */
    @Override
    protected Element createElement(Document doc) throws InvalidInfoNodeException {
        Element res = doc.createElementNS(schema.getSchemaUri(),
                namespaceXAdES + ":" + ConstantesXADES.XADES_TAG_SIGNATURE_PRODUCTION_PLACE);
        super.addContent(res, namespaceXAdES);
        return res;
    }

}
