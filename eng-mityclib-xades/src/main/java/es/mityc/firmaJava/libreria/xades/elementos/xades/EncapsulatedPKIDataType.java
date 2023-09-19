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

import es.mityc.firmaJava.libreria.ConstantesXADES;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 * 
 *          TODO: incluir el tratamiento de la informacion en base6binary
 */
public class EncapsulatedPKIDataType extends AbstractXADESElement {

    private String id;
    private EncodingEnum encoding;
    private String value;

    /**
     * @param schema
     */
    public EncapsulatedPKIDataType(XAdESSchemas schema) {
        super(schema);
    }

    public EncapsulatedPKIDataType(XAdESSchemas schema, String id) {
        super(schema);
        this.id = id;
    }

    public EncapsulatedPKIDataType(XAdESSchemas schema, String id, EncodingEnum encoding) {
        this(schema, id);
        this.encoding = encoding;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the encoding
     */
    public EncodingEnum getEncoding() {
        if (!schema.equals(XAdESSchemas.XAdES_111))
            return encoding;
        return null;
    }

    /**
     * @param encoding
     *            the encoding to set
     */
    public void setEncoding(EncodingEnum encoding) {
        this.encoding = encoding;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EncapsulatedPKIDataType) {
            EncapsulatedPKIDataType epdt = (EncapsulatedPKIDataType) obj;
            // TODO: comprobar que se indica el mismo encoding
            if (value.equals(epdt.value))
                return true;
        }
        return false;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xades.AbstractXADESElement#addContent(org.w3c.dom.Element,
     *      java.lang.String, java.lang.String)
     */
    @Override
    public void addContent(Element element, String namespaceXAdES) throws InvalidInfoNodeException {
        super.addContent(element, namespaceXAdES);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#load(org.w3c.dom.Element)
     */
    @Override
    public void load(Element element) throws InvalidInfoNodeException {
        // Recupera los atributos
        if (element.hasAttribute(ConstantesXADES.ID))
            this.id = element.getAttribute(ConstantesXADES.ID);
        if (element.hasAttribute(ConstantesXADES.XADES_TAG_ENCODING)) {
            if (schema.equals(XAdESSchemas.XAdES_111))
                throw new InvalidInfoNodeException(
                        "Atributo invalido para nodo EncapsulatedPKIDataType en esquema XAdES: "
                                + schema.getSchemaUri());
            this.encoding = EncodingEnum.getEncoding(element.getAttribute(ConstantesXADES.XADES_TAG_ENCODING));
            if (this.encoding == null)
                throw new InvalidInfoNodeException("Encoding de nodo EncapsulatedPKIDataType desconocido: "
                        + element.getAttribute(ConstantesXADES.XADES_TAG_ENCODING));
        }

        // Recupera la informacion del nodo
        Node node = element.getFirstChild();
        if (node.getNodeType() != Node.TEXT_NODE)
            throw new InvalidInfoNodeException("Nodo EncapsulatedPKIDataType no contiene CDATA como primer valor");

        this.value = node.getNodeValue();
        if (this.value == null)
            throw new InvalidInfoNodeException("Contenido de valor de EncapsulatedPKIDataType vacío");
        // TODO: chequear que es un contenido del tipo base64binary (en el encoding adecuado si viene indicado).
        // TODO: obtener realmente el contenido binario y no la cadena en base64
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#addContent(org.w3c.dom.Element)
     */
    @Override
    protected void addContent(Element element) throws InvalidInfoNodeException {
        if (value == null)
            throw new InvalidInfoNodeException("Informacion insuficiente para escribir nodo EncapsulatedPKIDataType");
        if (id != null)
            element.setAttributeNS(null, ConstantesXADES.ID, id);
        EncodingEnum encoding = getEncoding();
        if ((!schema.equals(XAdESSchemas.XAdES_111)) && (encoding != null))
            element.setAttributeNS(null, ConstantesXADES.XADES_TAG_ENCODING, encoding.getEncodingUri().toString());

        element.setTextContent(value);
    }

}
