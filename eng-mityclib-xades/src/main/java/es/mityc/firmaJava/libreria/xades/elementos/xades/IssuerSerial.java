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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.mityc.firmaJava.libreria.ConstantesXADES;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.firmaJava.libreria.xades.elementos.xmldsig.X509IssuerSerialType;
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class IssuerSerial extends X509IssuerSerialType {

    protected XAdESSchemas schema;
    protected String namespaceXAdES;

    public IssuerSerial(XAdESSchemas schema) {
        super();
        this.schema = schema;
    }

    public IssuerSerial(XAdESSchemas schema, String issuerName, BigInteger serialNumber) {
        super(issuerName, serialNumber);
        this.schema = schema;
    }

    /**
     * @return the schema
     */
    public XAdESSchemas getSchema() {
        return schema;
    }

    /**
     * @param schema
     *            the schema to set
     */
    public void setSchema(XAdESSchemas schema) {
        this.schema = schema;
    }

    /**
     * Este elemento lo pueden hacer público los elementos
     * 
     * @see es.mityc.firmaJava.libreria.xades.elementos.xmldsig.AbstractXDsigElement#createElement(org.w3c.dom.Document,
     *      java.lang.String)
     */
    protected Element createElement(Document doc, String namespaceXAdES) throws InvalidInfoNodeException {
        setNamespaceXAdES(namespaceXAdES);
        return createElement(doc);
    }

    /**
     * Este elemento lo pueden hacer público los elementos
     * 
     * @param doc
     * @param namespaceXDsig
     * @param namespaceXAdES
     * 
     * @return
     * 
     * @throws InvalidInfoNodeException
     */
    public Element createElement(Document doc, String namespaceXDsig, String namespaceXAdES)
            throws InvalidInfoNodeException {
        setNamespaceXAdES(namespaceXAdES);
        return super.createElement(doc, namespaceXDsig);
    }

    /**
     * @return the namespaceXAdES
     */
    public String getNamespaceXAdES() {
        return namespaceXAdES;
    }

    /**
     * @param namespaceXAdES
     *            the namespaceXAdES to set
     */
    public void setNamespaceXAdES(String namespaceXAdES) {
        this.namespaceXAdES = namespaceXAdES;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xades.DigestAlgAndValueType#load(org.w3c.dom.Element)
     */
    @Override
    public void load(Element element) throws InvalidInfoNodeException {
        checkElementName(element, schema.getSchemaUri(), ConstantesXADES.ISSUER_SERIAL);
        super.load(element);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xades.DigestAlgAndValueType#isThisNode(org.w3c.dom.Node)
     */
    @Override
    public boolean isThisNode(Node node) {
        return isElementName(nodeToElement(node), schema.getSchemaUri(), ConstantesXADES.ISSUER_SERIAL);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xades.DigestAlgAndValueType#createElement(org.w3c.dom.Document)
     */
    @Override
    protected Element createElement(Document doc) throws InvalidInfoNodeException {
        Element res = doc.createElementNS(schema.getSchemaUri(), namespaceXAdES + ":" + ConstantesXADES.ISSUER_SERIAL);
        addContent(res, namespaceXAdES, namespaceXDsig);
        return res;
    }

    /**
     * 
     * @param element
     * @param namespaceXAdES
     * @param namespaceXDsig
     * 
     * @throws InvalidInfoNodeException
     */
    public void addContent(Element element, String namespaceXAdES, String namespaceXDsig)
            throws InvalidInfoNodeException {
        setNamespaceXAdES(namespaceXAdES);
        super.addContent(element, namespaceXDsig);
    }

}
