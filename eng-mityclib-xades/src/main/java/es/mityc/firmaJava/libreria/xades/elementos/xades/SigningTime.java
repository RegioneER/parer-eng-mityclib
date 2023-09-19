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

import java.util.Date;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.mityc.firmaJava.libreria.ConstantesXADES;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.firmaJava.libreria.xades.elementos.XMLDataDateTimeType;
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class SigningTime extends AbstractXADESElement {

    private XMLDataDateTimeType data;

    /**
     * @param schema
     */
    public SigningTime(XAdESSchemas schema) {
        super(schema);
    }

    public SigningTime(XAdESSchemas schema, Date date) {
        super(schema);
        this.data = new XMLDataDateTimeType(date);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SigningTime) {
            SigningTime time = (SigningTime) obj;
            if (data.equals(time.data))
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
        checkElementName(element, schema.getSchemaUri(), ConstantesXADES.SIGNING_TIME);
        data = new XMLDataDateTimeType(null);
        data.load(element);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#createElement(org.w3c.dom.Document)
     */
    @Override
    protected Element createElement(Document doc) throws InvalidInfoNodeException {
        if (data == null)
            throw new InvalidInfoNodeException("Informacion insuficiente para escribir elemento SigningTime");
        Element res = doc.createElementNS(schema.getSchemaUri(), namespaceXAdES + ":" + ConstantesXADES.SIGNING_TIME);
        data.addContent(res);
        return res;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#isThisNode(org.w3c.dom.Node)
     */
    @Override
    public boolean isThisNode(Node node) {
        return isElementName(nodeToElement(node), schema.getSchemaUri(), ConstantesXADES.SIGNING_TIME);
    }

    public void setValue(Date value) {
        if (data == null)
            data = new XMLDataDateTimeType(value);
        else
            data.setValue(value);
    }

    public Date getValue() {
        if (data != null)
            return data.getValue();
        return null;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xades.AbstractXADESElement#createElement(org.w3c.dom.Document,
     *      java.lang.String)
     */
    @Override
    public Element createElement(Document doc, String namespaceXAdES) throws InvalidInfoNodeException {
        return super.createElement(doc, namespaceXAdES);
    }
}
