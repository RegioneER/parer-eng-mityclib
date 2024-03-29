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

import java.math.BigInteger;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class X509IssuerSerialType extends AbstractXDsigElement {

    private X509IssuerName issuerName;
    private X509SerialNumber serialNumber;

    public X509IssuerSerialType() {
        super();
    }

    public X509IssuerSerialType(String issuerName, BigInteger serialNumber) {
        super();
        this.issuerName = new X509IssuerName(issuerName);
        this.serialNumber = new X509SerialNumber(serialNumber);
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = new X509IssuerName(issuerName);
    }

    public void setSerialNumber(BigInteger serialNumber) {
        this.serialNumber = new X509SerialNumber(serialNumber);
    }

    public String getIssuerName() {
        return (issuerName != null) ? issuerName.getValue() : null;
    }

    public BigInteger getSerialNumber() {
        return (serialNumber != null) ? serialNumber.getValue() : null;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xmldsig.AbstractXDsigElement#addContent(org.w3c.dom.Element,
     *      java.lang.String)
     */
    @Override
    public void addContent(Element element, String namespaceXDsig) throws InvalidInfoNodeException {
        super.addContent(element, namespaceXDsig);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#addContent(org.w3c.dom.Element)
     */
    @Override
    protected void addContent(Element element) throws InvalidInfoNodeException {
        if ((issuerName == null) || (serialNumber == null)) {
            throw new InvalidInfoNodeException("Informacion insuficiente para escribir nodo X509IssuerSerialType");
        }
        element.appendChild(issuerName.createElement(element.getOwnerDocument(), namespaceXDsig));
        element.appendChild(serialNumber.createElement(element.getOwnerDocument(), namespaceXDsig));
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof X509IssuerSerialType) {
            X509IssuerSerialType ist = (X509IssuerSerialType) obj;
            if ((serialNumber == null) || (issuerName == null))
                return false;
            if (!issuerName.equals(ist.issuerName))
                return false;
            if (!serialNumber.equals(ist.serialNumber))
                return false;
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

        X509IssuerName name = new X509IssuerName();
        if (!name.isThisNode(node)) {
            throw new InvalidInfoNodeException("Se esperaba nodo X509IssuerName en X509IssuerSerialType");
        }
        name.load((Element) node);

        node = getNextNonvoidNode(node);
        X509SerialNumber serial = new X509SerialNumber(null);
        if (!serial.isThisNode(node)) {
            throw new InvalidInfoNodeException("Se esperaba nodo X509SerialNumber en X509IssuerSerialType");
        }
        serial.load((Element) node);

        this.issuerName = name;
        this.serialNumber = serial;
    }

}
