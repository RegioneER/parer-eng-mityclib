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

import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.firmaJava.libreria.xades.elementos.xmldsig.Transforms;
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class SignaturePolicyIdType extends AbstractXADESElement {

    private SigPolicyId sigPolicyId;
    private Transforms transforms;
    private SigPolicyHash sigPolicyHash;
    private SigPolicyQualifiers sigPolicyQualifiers;

    /**
     * @param schema
     */
    public SignaturePolicyIdType(XAdESSchemas schema) {
        super(schema);
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
        if ((sigPolicyId == null) || (sigPolicyHash == null))
            throw new InvalidInfoNodeException("Informacion insuficiente para escribir nodo SignaturePolicyIdType");

        element.appendChild(sigPolicyId.createElement(element.getOwnerDocument(), namespaceXAdES));

        if (transforms != null) {
            element.appendChild(transforms.createElement(element.getOwnerDocument(), namespaceXDsig));
        }

        element.appendChild(sigPolicyHash.createElement(element.getOwnerDocument(), namespaceXDsig, namespaceXAdES));

        if (sigPolicyQualifiers != null) {
            element.appendChild(sigPolicyQualifiers.createElement(element.getOwnerDocument(), namespaceXAdES));
        }
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SignaturePolicyIdType) {
            SignaturePolicyIdType spit = (SignaturePolicyIdType) obj;
            if ((sigPolicyId == null) || (spit.sigPolicyId == null) || (sigPolicyHash == null)
                    || (spit.sigPolicyHash == null))
                return false;
            if (((transforms == null) && (spit.transforms != null))
                    || (transforms != null) && (spit.transforms == null))
                return false;
            if (((sigPolicyQualifiers == null) && (spit.sigPolicyQualifiers != null))
                    || (sigPolicyQualifiers != null) && (spit.sigPolicyQualifiers == null))
                return false;
            if ((transforms != null) && (spit.transforms != null) && (!transforms.equals(spit.transforms)))
                return false;
            if (!sigPolicyId.equals(spit.sigPolicyId))
                return false;
            if (!sigPolicyHash.equals(spit.sigPolicyHash))
                return false;
            if ((sigPolicyQualifiers != null) && (spit.sigPolicyQualifiers != null)
                    && (!sigPolicyQualifiers.equals(spit.sigPolicyQualifiers)))
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
        // Nodo SigPolicyId
        Node node = getFirstNonvoidNode(element);

        SigPolicyId sigPolicyId = new SigPolicyId(schema);
        if (!sigPolicyId.isThisNode(node))
            throw new InvalidInfoNodeException("Nodo SignaturePolicyIdType no tiene hijo SigPolicyId");
        sigPolicyId.load((Element) node);

        // Comprueba si el siguiente nodo es de transformadas
        node = getNextNonvoidNode(node);
        Transforms transforms = new Transforms();
        if (transforms.isThisNode(node))
            transforms.load((Element) node);
        else
            transforms = null;

        // Nodo SigPolicyHash
        if (node == null)
            throw new InvalidInfoNodeException("Nodo SignaturePolicyIdType no tiene hijo SigPolicyId");
        if (transforms != null)
            node = getNextNonvoidNode(node);
        SigPolicyHash sigPolicyHash = new SigPolicyHash(schema);
        if (!sigPolicyHash.isThisNode(node))
            throw new InvalidInfoNodeException("Nodo SignaturePolicyIdType no tiene hijo SigPolicyHash");
        sigPolicyHash.load((Element) node);
        node = getNextNonvoidNode(node);

        // nodo SigPolicyQualifiers
        SigPolicyQualifiers sigPolicyQualifiers = null;
        if (node != null) {
            sigPolicyQualifiers = new SigPolicyQualifiers(schema);
            if (!sigPolicyQualifiers.isThisNode(node))
                throw new InvalidInfoNodeException(
                        "Nodo SigPolicyQualifiers esperado como hijo de SignaturePolicyIdType");
            sigPolicyQualifiers.load((Element) node);
        }

        this.sigPolicyId = sigPolicyId;
        this.transforms = transforms;
        this.sigPolicyHash = sigPolicyHash;
        this.sigPolicyQualifiers = sigPolicyQualifiers;
    }

    /**
     * @return the sigPolicyId
     */
    public SigPolicyId getSigPolicyId() {
        return sigPolicyId;
    }

    /**
     * @param sigPolicyId
     *            the sigPolicyId to set
     */
    public void setSigPolicyId(SigPolicyId sigPolicyId) {
        this.sigPolicyId = sigPolicyId;
    }

    /**
     * @return the transforms
     */
    public Transforms getTransforms() {
        return transforms;
    }

    /**
     * @param transforms
     *            the transforms to set
     */
    public void setTransforms(Transforms transforms) {
        this.transforms = transforms;
    }

    /**
     * @return the sigPolicyHash
     */
    public SigPolicyHash getSigPolicyHash() {
        return sigPolicyHash;
    }

    /**
     * @param sigPolicyHash
     *            the sigPolicyHash to set
     */
    public void setSigPolicyHash(SigPolicyHash sigPolicyHash) {
        this.sigPolicyHash = sigPolicyHash;
    }

    public SigPolicyQualifiers getSigPolicyQualifiers() {
        return sigPolicyQualifiers;
    }

    public void setSigPolicyQualifiers(SigPolicyQualifiers sigPolicyQualifiers) {
        this.sigPolicyQualifiers = sigPolicyQualifiers;
    }

}
