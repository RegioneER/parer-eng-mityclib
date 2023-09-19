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

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.mityc.firmaJava.libreria.utilidades.UtilidadTratarNodo;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class SignaturePolicyIdentifierType extends AbstractXADESElement {

    private SignaturePolicyImplied signaturePolicyImplied;
    private SignaturePolicyId signaturePolicyId;

    /**
     * @param schema
     */
    public SignaturePolicyIdentifierType(XAdESSchemas schema) {
        super(schema);
    }

    public SignaturePolicyIdentifierType(XAdESSchemas schema, boolean isImplied) {
        super(schema);
        if (isImplied)
            signaturePolicyImplied = new SignaturePolicyImplied(schema);
        else
            signaturePolicyId = new SignaturePolicyId(schema);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xades.AbstractXADESElement#addContent(org.w3c.dom.Element,
     *      java.lang.String, java.lang.String)
     */
    @Override
    public void addContent(Element element, String namespaceXAdES, String namespaceXDsig)
            throws InvalidInfoNodeException {
        super.addContent(element, namespaceXAdES, namespaceXDsig);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#addContent(org.w3c.dom.Element)
     */
    @Override
    protected void addContent(Element element) throws InvalidInfoNodeException {
        if (isImplied()) {
            element.appendChild(signaturePolicyImplied.createElement(element.getOwnerDocument(), namespaceXAdES));
        } else {
            if (signaturePolicyId == null)
                throw new InvalidInfoNodeException("Informacion insuficiente para escribir nodo SignaturePolicyId");
            element.appendChild(
                    signaturePolicyId.createElement(element.getOwnerDocument(), namespaceXDsig, namespaceXAdES));
        }
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SignaturePolicyIdentifierType) {
            SignaturePolicyIdentifierType spit = (SignaturePolicyIdentifierType) obj;
            if (isImplied()) {
                if (spit.isImplied())
                    return true;
            } else {
                if ((signaturePolicyId == null) || (spit.isImplied()))
                    return false;
                else if (signaturePolicyId.equals(spit.signaturePolicyId))
                    return true;
            }
        }
        return false;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#load(org.w3c.dom.Element)
     */
    @Override
    public void load(Element element) throws InvalidInfoNodeException {
        // Nodo SignaturePolicyImplied o SignaturePolicyId
        Node node = getFirstNonvoidNode(element);
        SignaturePolicyImplied spi = new SignaturePolicyImplied(schema);
        if (spi.isThisNode(node)) {
            spi.load((Element) node);
            signaturePolicyImplied = spi;
        } else {
            SignaturePolicyId spid = new SignaturePolicyId(schema);
            spid.load((Element) node);
            signaturePolicyId = spid;
        }
        if (UtilidadTratarNodo.getNextElementSibling(node, true) != null)
            throw new InvalidInfoNodeException("Nodo SignaturePolicyIdentifierType debe tener un único hijo");
    }

    /**
     * @return the signaturePolicyImplied
     */
    public SignaturePolicyImplied getSignaturePolicyImplied() {
        return signaturePolicyImplied;
    }

    /**
     * @param signaturePolicyImplied
     *            the signaturePolicyImplied to set
     */
    public void setSignaturePolicyImplied() {
        this.signaturePolicyImplied = new SignaturePolicyImplied(schema);
        this.signaturePolicyId = null;
    }

    /**
     * @return the signaturePolicyId
     */
    public SignaturePolicyId getSignaturePolicyId() {
        return signaturePolicyId;
    }

    /**
     * @param signaturePolicyId
     *            the signaturePolicyId to set
     */
    public void setSignaturePolicyId(SignaturePolicyId signaturePolicyId) {
        this.signaturePolicyId = signaturePolicyId;
        this.signaturePolicyId = null;
    }

    public boolean isImplied() {
        if (signaturePolicyImplied != null)
            return true;
        return false;
    }
}
