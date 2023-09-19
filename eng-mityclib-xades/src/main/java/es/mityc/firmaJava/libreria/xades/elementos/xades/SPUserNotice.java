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
import es.mityc.javasign.xml.xades.policy.PolicyException;

/**
 * @author dsantose
 *
 */
public class SPUserNotice extends SPUserNoticeType implements IPolicyQualifier {

    /**
     * @param schema
     */
    public SPUserNotice(XAdESSchemas schema) {
        super(schema);
    }

    @Override
    public void load(Element element) throws InvalidInfoNodeException {
        checkElementName(element, schema.getSchemaUri(), ConstantesXADES.XADES_TAG_SP_USER_NOTICE);
        super.load(element);
    }

    @Override
    public boolean isThisNode(Node node) {
        return isElementName(nodeToElement(node), schema.getSchemaUri(), ConstantesXADES.XADES_TAG_SP_USER_NOTICE);
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
                namespaceXAdES + ":" + ConstantesXADES.XADES_TAG_SP_USER_NOTICE);
        super.addContent(res, namespaceXAdES);
        return res;
    }

    public Node createPolicyQualifierContent(Document doc) throws PolicyException {
        Element el = null;
        try {
            if (getNamespaceXAdES() != null)
                el = createElement(doc, namespaceXAdES);
            else
                throw new PolicyException("No se ha indicado qualifier para nodo SPUserNotice");
        } catch (InvalidInfoNodeException ex) {
            throw new PolicyException(ex);
        }
        return el;
    }

    public void loadPolicyQualifierContent(Element element) throws PolicyException {
        try {
            load(element);
        } catch (InvalidInfoNodeException ex) {
            throw new PolicyException(ex);
        }
    }

}
