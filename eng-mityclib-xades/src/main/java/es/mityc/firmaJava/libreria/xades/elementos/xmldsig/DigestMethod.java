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
 * Elemento DigestMethod (rfc 3275 4.3.3.5).
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class DigestMethod extends AbstractXDsigElement {

    // TODO: tratarlo como URI y no como String
    private String algorithm;

    /**
     * @param namespaceXDSig
     */
    public DigestMethod(String algorithm) {
        super();
        this.algorithm = algorithm;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#createElement(org.w3c.dom.Document)
     */
    @Override
    protected Element createElement(Document doc) throws InvalidInfoNodeException {
        if (algorithm == null)
            throw new InvalidInfoNodeException("Informacion insuficiente para escribir elemento DigestMethod");
        Element res = doc.createElementNS(ConstantesXADES.SCHEMA_DSIG,
                namespaceXDsig + ":" + ConstantesXADES.DIGEST_METHOD);
        res.setAttributeNS(null, ConstantesXADES.ALGORITHM, algorithm);
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
        if (obj instanceof DigestMethod) {
            DigestMethod method = (DigestMethod) obj;
            if (algorithm.equals(method.algorithm))
                return true;
        }
        return false;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xmldsig.AbstractXDsigElement#load(org.w3c.dom.Element)
     */
    @Override
    public void load(Element element) throws InvalidInfoNodeException {
        checkElementName(element, ConstantesXADES.SCHEMA_DSIG, ConstantesXADES.LIBRERIAXADES_DIGEST_METHOD);
        if (!element.hasAttribute(ConstantesXADES.ALGORITHM))
            throw new InvalidInfoNodeException("Atributo requerido no presente" + ConstantesXADES.ALGORITHM);
        this.algorithm = element.getAttribute(ConstantesXADES.ALGORITHM);
    }

    /**
     * @return the algorithm
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * @param algorithm
     *            the algorithm to set
     */
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#isThisNode(org.w3c.dom.Node)
     */
    @Override
    public boolean isThisNode(Node node) {
        return isElementName(nodeToElement(node), ConstantesXADES.SCHEMA_DSIG,
                ConstantesXADES.LIBRERIAXADES_DIGEST_METHOD);
    }

}
