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
import java.util.Date;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.mityc.firmaJava.libreria.ConstantesXADES;
import es.mityc.firmaJava.libreria.utilidades.UtilidadTratarNodo;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * @author dsantose
 *
 */
public class CRLIdentifierType extends AbstractXADESElement {

    private Issuer issuer;
    private IssueTime issueTime;
    private Number number;
    private String uri;

    /**
     * @param schema
     */
    public CRLIdentifierType(XAdESSchemas schema, String issuer, Date issueTime, BigInteger number, String URI) {
        super(schema);
        if (issuer != null)
            this.issuer = new Issuer(schema, issuer);
        if (issueTime != null)
            this.issueTime = new IssueTime(schema, issueTime);
        if (number != null)
            this.number = new Number(schema, number);
        if (URI != null)
            this.uri = URI;
    }

    public CRLIdentifierType(XAdESSchemas schema) {
        super(schema);
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public IssueTime getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(IssueTime issueTime) {
        this.issueTime = issueTime;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    @Override
    public void addContent(Element element, String namespaceXAdES) throws InvalidInfoNodeException {
        super.addContent(element, namespaceXAdES);
    }

    @Override
    protected void addContent(Element element) throws InvalidInfoNodeException {
        if ((issuer == null) || (issueTime == null))
            throw new InvalidInfoNodeException("Informacion insuficiente para escribir nodo CRLIdentifierType");

        element.appendChild(issuer.createElement(element.getOwnerDocument(), namespaceXAdES));
        element.appendChild(issueTime.createElement(element.getOwnerDocument(), namespaceXAdES));

        if (number != null)
            element.appendChild(number.createElement(element.getOwnerDocument(), namespaceXAdES));

        if (uri != null)
            element.setAttributeNS(null, ConstantesXADES.URI_MAYUS, uri);

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CRLIdentifierType) {
            CRLIdentifierType crl = (CRLIdentifierType) obj;
            if ((issuer == null) || (issueTime == null))
                return false;
            if (!issuer.equals(crl.getIssuer()))
                return false;
            if (issueTime.equals(crl.getIssueTime()))
                return false;
            // TODO: completar
        }
        return false;
    }

    @Override
    public void load(Element element) throws InvalidInfoNodeException {
        // Recupera los atributos
        if (element.hasAttribute(ConstantesXADES.URI_MAYUS))
            this.uri = element.getAttribute(ConstantesXADES.URI_MAYUS);

        // El siguiente elemento es un nodo Issuer
        Node node = UtilidadTratarNodo.getFirstElementChild(element, true);
        if ((node == null) || (node.getNodeType() != Node.ELEMENT_NODE))
            throw new InvalidInfoNodeException("Se esperaba elemento como hijo de CRLIdentifierType");
        Element child = (Element) node;
        issuer = new Issuer(schema);
        issuer.load(child);

        // El siguiente elemento es un nodo IssueTime
        node = UtilidadTratarNodo.getNextElementSibling(child, true);
        if ((node == null) || (node.getNodeType() != Node.ELEMENT_NODE))
            throw new InvalidInfoNodeException("Se esperaba elemento como hijo de CRLIdentifierType");
        child = (Element) node;
        issueTime = new IssueTime(schema);
        issueTime.load(child);

        // El siguiente elemento puede ser un nodo IssueTime
        node = UtilidadTratarNodo.getNextElementSibling(child, true);
        if (node != null) {
            if (node.getNodeType() != Node.ELEMENT_NODE)
                throw new InvalidInfoNodeException("Se esperaba elemento como hijo de CRLIdentifierType");
            child = (Element) node;
            number = new Number(schema);
            number.load(child);
        }
    }

}
