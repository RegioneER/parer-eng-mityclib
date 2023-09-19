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

import java.util.Date;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.mityc.firmaJava.libreria.utilidades.UtilidadFechas;
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class XMLDataDateTimeType extends AbstractXMLElement {

    protected Date value;

    public XMLDataDateTimeType(Date value) {
        this.value = value;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#addContent(org.w3c.dom.Element)
     */
    @Override
    public void addContent(Element element) throws InvalidInfoNodeException {
        if (value == null)
            throw new InvalidInfoNodeException("Informacion insuficiente para escribir nodo DateTimeType");

        element.setTextContent(UtilidadFechas.formatFechaXML(value));
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof XMLDataDateTimeType) {
            if (value.equals(((XMLDataDateTimeType) obj).value))
                return true;
        } else if (obj instanceof Date) {
            if (value.equals(obj))
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
        if ((node == null) || (node.getNodeType() != Node.TEXT_NODE))
            throw new InvalidInfoNodeException("Nodo xsd:string no contiene CDATA como primer valor");

        String value = node.getNodeValue();
        if (value != null)
            this.value = UtilidadFechas.parseaFechaXML(value);

        if (this.value == null)
            throw new InvalidInfoNodeException("Contenido de valor de xsd.string vacío");
    }

    /**
     * @return the value
     */
    public Date getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(Date value) {
        this.value = value;
    }

}
