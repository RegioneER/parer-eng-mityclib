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

package es.mityc.firmaJava.libreria.xades.elementos.xmldsig;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.mityc.firmaJava.libreria.ConstantesXADES;
import es.mityc.firmaJava.libreria.xades.elementos.XMLDataStringType;
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class AbstractXDSigStringElement extends AbstractXDsigElement {

    private XMLDataStringType data;
    private String nameElement;

    public AbstractXDSigStringElement(String nameElement, String data) {
        super();
        this.nameElement = nameElement;
        this.data = new XMLDataStringType(data);
    }

    /**
     * @param namespaceXDSig
     * @param schema
     */
    public AbstractXDSigStringElement(String nameElement) {
        super();
        this.nameElement = nameElement;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#createElement(org.w3c.dom.Document)
     */
    @Override
    protected Element createElement(Document doc) throws InvalidInfoNodeException {
        if (data == null) {
            throw new InvalidInfoNodeException("Informacion insuficiente para escribir elemento " + nameElement);
        }
        Element res = doc.createElementNS(ConstantesXADES.SCHEMA_DSIG, namespaceXDsig + ":" + nameElement);
        data.addContent(res);
        return res;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xmldsig.AbstractXDsigElement#createElement(org.w3c.dom.Document,
     *      java.lang.String)
     */
    @Override
    public Element createElement(Document doc, String namespaceXDsig) throws InvalidInfoNodeException {
        return super.createElement(doc, namespaceXDsig);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractXDSigStringElement) {
            AbstractXDSigStringElement desc = (AbstractXDSigStringElement) obj;
            if ((nameElement.equals(desc.nameElement)) && (data.equals(desc.data))) {
                return true;
            }
        } else {
            return data.equals(obj);
        }
        return false;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xmldsig.AbstractXDsigElement#load(org.w3c.dom.Element)
     */
    @Override
    public void load(Element element) throws InvalidInfoNodeException {
        checkElementName(element, ConstantesXADES.SCHEMA_DSIG, nameElement);
        data = new XMLDataStringType(null);
        data.load(element);
    }

    public void setValue(String value) {
        if (data == null) {
            data = new XMLDataStringType(value);
        } else {
            data.setValue(value);
        }
    }

    public String getValue() {
        if (data != null) {
            return data.getValue();
        }
        return null;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#isThisNode(org.w3c.dom.Node)
     */
    @Override
    public boolean isThisNode(Node node) {
        return isElementName(nodeToElement(node), ConstantesXADES.SCHEMA_DSIG, nameElement);
    }

}
