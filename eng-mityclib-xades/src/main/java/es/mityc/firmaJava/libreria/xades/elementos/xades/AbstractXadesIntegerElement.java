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

import java.math.BigInteger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.firmaJava.libreria.xades.elementos.XMLDataIntegerType;
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

public abstract class AbstractXadesIntegerElement extends AbstractXADESElement {

    private XMLDataIntegerType data;
    private String nameElement;

    public AbstractXadesIntegerElement(XAdESSchemas schema, String nameElement, BigInteger data) {
        super(schema);
        this.nameElement = nameElement;
        this.data = new XMLDataIntegerType(data);
    }

    /**
     * @param namespaceXAdES
     * @param namespaceXDSig
     * @param schema
     */
    public AbstractXadesIntegerElement(XAdESSchemas schema, String nameElement) {
        super(schema);
        this.nameElement = nameElement;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#createElement(org.w3c.dom.Document)
     */
    @Override
    protected Element createElement(Document doc) throws InvalidInfoNodeException {
        if (data == null)
            throw new InvalidInfoNodeException("Informacion insuficiente para escribir elemento " + nameElement);
        Element res = doc.createElementNS(schema.getSchemaUri(), namespaceXAdES + ":" + nameElement);
        data.addContent(res);
        return res;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xades.AbstractXADESElement#createElement(org.w3c.dom.Document,
     *      java.lang.String)
     */
    @Override
    public Element createElement(Document doc, String namespaceXAdES) throws InvalidInfoNodeException {
        return super.createElement(doc, namespaceXAdES);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractXadesIntegerElement) {
            AbstractXadesIntegerElement desc = (AbstractXadesIntegerElement) obj;
            if ((nameElement.equals(desc.nameElement)) && (data.equals(desc.data)))
                return true;
        } else
            return data.equals(obj);
        return false;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#load(org.w3c.dom.Element)
     */
    @Override
    public void load(Element element) throws InvalidInfoNodeException {
        checkElementName(element, schema.getSchemaUri(), nameElement);
        data = new XMLDataIntegerType(null);
        data.load(element);
    }

    public void setValue(BigInteger value) {
        if (data == null)
            data = new XMLDataIntegerType(value);
        else
            data.setValue(value);
    }

    public BigInteger getValue() {
        if (data != null)
            return data.getValue();
        return null;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#isThisNode(org.w3c.dom.Node)
     */
    @Override
    public boolean isThisNode(Node node) {
        return isElementName(nodeToElement(node), schema.getSchemaUri(), nameElement);
    }
}
