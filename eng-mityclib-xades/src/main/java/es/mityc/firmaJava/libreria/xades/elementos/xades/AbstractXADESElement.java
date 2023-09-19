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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.firmaJava.libreria.xades.elementos.xmldsig.AbstractXDsigElement;
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * Interfaz que ha de cumplir una implementacion de un elemento del esquema xades
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public abstract class AbstractXADESElement extends AbstractXDsigElement {

    protected XAdESSchemas schema;
    protected String namespaceXAdES;

    protected AbstractXADESElement(XAdESSchemas schema) {
        super();
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
    protected Element createElement(Document doc, String namespaceXDsig, String namespaceXAdES)
            throws InvalidInfoNodeException {
        setNamespaceXAdES(namespaceXAdES);
        return super.createElement(doc, namespaceXDsig);
    }

    /**
     * Este metodo lo puede hacer público los tipos
     * 
     * @see es.mityc.firmaJava.libreria.xades.elementos.xmldsig.AbstractXDsigElement#addContent(org.w3c.dom.Document,
     *      org.w3c.dom.Element, java.lang.String)
     */
    protected void addContent(Element element, String namespaceXAdES) throws InvalidInfoNodeException {
        setNamespaceXAdES(namespaceXAdES);
        addContent(element);
    }

    /**
     * Este metodo lo puede hacer público los tipos.
     * 
     * @param doc
     * @param element
     * @param namespaceXAdES
     * @param namespaceXDsig
     * 
     * @throws InvalidInfoNodeException
     */
    protected void addContent(Element element, String namespaceXAdES, String namespaceXDsig)
            throws InvalidInfoNodeException {
        setNamespaceXAdES(namespaceXAdES);
        super.addContent(element, namespaceXDsig);
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

}
