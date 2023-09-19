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

package es.mityc.firmaJava.libreria.xades.elementos;

import java.math.BigInteger;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

public class XMLDataIntegerType extends AbstractXMLElement {

    protected BigInteger value;

    public XMLDataIntegerType(BigInteger value) {
        this.value = value;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#addContent(org.w3c.dom.Element)
     */
    @Override
    public void addContent(Element element) throws InvalidInfoNodeException {
        if (value == null)
            throw new InvalidInfoNodeException("Informacion insuficiente para escribir nodo XMLDataStringType");
        element.setTextContent(value.toString());
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof XMLDataIntegerType) {
            XMLDataIntegerType xdst = (XMLDataIntegerType) obj;
            if (value.equals(xdst))
                return true;
        } else if (obj instanceof String) {
            String data = (String) obj;
            if (value.equals(data))
                return true;
        }
        return false;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#load(org.w3c.dom.Element)
     */
    @Override
    public void load(Element element) throws InvalidInfoNodeException {
        Node node = getFirstNonvoidNode(element);
        if (node.getNodeType() != Node.TEXT_NODE)
            throw new InvalidInfoNodeException("Nodo xsd:string no contiene CDATA como primer valor");

        try {
            String strvalue = node.getNodeValue();
            if (strvalue == null)
                throw new InvalidInfoNodeException("Contenido de valor de xsd.string vacío");
            this.value = new BigInteger(strvalue);
        } catch (NumberFormatException ex) {
            throw new InvalidInfoNodeException("Contenido de valor de xsd.integer no numérico");
        }

    }

    /**
     * @return the value
     */
    public BigInteger getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(BigInteger value) {
        this.value = value;
    }

}
