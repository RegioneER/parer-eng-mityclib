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
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 * 
 *          TODO: incluir metodo para devolver y aceptar el resultado en binario (codificar/decodificar base64)
 */
public class DigestValue extends AbstractXDsigElement {

    private String value;

    public DigestValue() {
        super();
    }

    /**
     * @param namespaceXDSig
     */
    public DigestValue(String value) {
        super();
        setValue(value);
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(String value) {
        this.value = value;
        if (this.value != null)
            this.value = this.value.replace(" ", "").replace("\n", "").replace("\r", "");
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#createElement(org.w3c.dom.Document)
     */
    @Override
    protected Element createElement(Document doc) throws InvalidInfoNodeException {
        if (value == null)
            throw new InvalidInfoNodeException("Informacion insuficiente para escribir elemento DigestValue");
        Element res = doc.createElementNS(ConstantesXADES.SCHEMA_DSIG,
                namespaceXDsig + ":" + ConstantesXADES.DIGEST_VALUE);
        res.setTextContent(value);
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
     * @see es.mityc.firmaJava.libreria.xades.elementos.xmldsig.AbstractXDsigElement#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DigestValue) {
            DigestValue huella = (DigestValue) obj;
            if (value.equals(huella.value))
                return true;
        }
        return false;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xmldsig.AbstractXDsigElement#load(org.w3c.dom.Element)
     */
    @Override
    public void load(Element element) throws InvalidInfoNodeException {
        checkElementName(element, ConstantesXADES.SCHEMA_DSIG, ConstantesXADES.LIBRERIAXADES_DIGESTVALUE);

        Node node = getFirstNonvoidNode(element);
        if ((node == null) || (node.getNodeType() != Node.TEXT_NODE))
            throw new InvalidInfoNodeException("Nodo DigestValue no contiene CDATA como primer valor");

        this.value = node.getNodeValue();
        if (this.value == null)
            throw new InvalidInfoNodeException("Contenido de valor de digest vacío");
        this.value = this.value.replace(" ", "").replace("\n", "").replace("\r", "");
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#isThisNode(org.w3c.dom.Node)
     */
    @Override
    public boolean isThisNode(Node node) {
        return isElementName(nodeToElement(node), ConstantesXADES.SCHEMA_DSIG,
                ConstantesXADES.LIBRERIAXADES_DIGESTVALUE);
    }

}
