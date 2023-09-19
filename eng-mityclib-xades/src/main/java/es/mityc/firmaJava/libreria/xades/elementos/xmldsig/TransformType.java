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

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import es.mityc.firmaJava.libreria.ConstantesXADES;
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public abstract class TransformType extends AbstractXDsigElement {

    // TODO: tratarlo como URI
    private String algorithm;
    private NodeList extraNodes;

    /**
     * @param namespaceXDSig
     */
    public TransformType(String algorithm) {
        super();
        this.algorithm = algorithm;
    }

    public TransformType() {
        super();
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xmldsig.AbstractXDsigElement#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TransformType) {
            TransformType method = (TransformType) obj;
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
        if (!element.hasAttribute(ConstantesXADES.ALGORITHM))
            throw new InvalidInfoNodeException("Atributo requerido no presente" + ConstantesXADES.ALGORITHM);
        this.algorithm = element.getAttribute(ConstantesXADES.ALGORITHM);

        // carga los hijos
        extraNodes = element.getChildNodes();
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

    public NodeList getExtraNodes() {
        return extraNodes;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#addContent(org.w3c.dom.Element)
     */
    @Override
    protected void addContent(Element element) throws InvalidInfoNodeException {
        if (algorithm == null)
            throw new InvalidInfoNodeException("Informacion insuficiente para escribir nodo TransformType");
        element.setAttributeNS(null, ConstantesXADES.ALGORITHM, algorithm);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xmldsig.AbstractXDsigElement#addContent(org.w3c.dom.Element,
     *      java.lang.String)
     */
    @Override
    public void addContent(Element element, String namespaceXDsig) throws InvalidInfoNodeException {
        super.addContent(element, namespaceXDsig);
    }

}
