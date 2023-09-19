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

import java.net.URI;
import java.net.URISyntaxException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.mityc.firmaJava.libreria.ConstantesXADES;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public abstract class IdentifierType extends AbstractXADESElement {

    private URI uri;
    private QualifierEnum qualifier = null;

    /**
     * @param namespaceXAdES
     * @param namespaceXDSig
     * @param schema
     */
    public IdentifierType(XAdESSchemas schema) {
        super(schema);
    }

    public IdentifierType(XAdESSchemas schema, URI uri, QualifierEnum qualifier) {
        super(schema);
        this.uri = uri;
        this.qualifier = qualifier;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xmldsig.AbstractXDsigElement#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IdentifierType) {
            IdentifierType it = (IdentifierType) obj;
            if (uri.equals(it.uri))
                return true;
        }
        return false;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xmldsig.AbstractXDsigElement#load(org.w3c.dom.Element)
     */
    @Override
    public void load(Element element) throws InvalidInfoNodeException {
        Node node = getFirstNonvoidNode(element);
        if (node.getNodeType() != Node.TEXT_NODE) {
            throw new InvalidInfoNodeException("Nodo IdentifierType no contiene CDATA como primer valor");
        }

        // Obtiene el qualifier si existe
        qualifier = QualifierEnum.getQualifierEnum(element.getAttribute(ConstantesXADES.QUALIFIER));

        String data = node.getNodeValue();
        if (data == null)
            throw new InvalidInfoNodeException("No hay URI en nodo IdentifierType");
        try {
            // FIX: Cambia los espacios por %20 para evitar problemas con la clase URI
            data = data.replace(" ", "%20");
            uri = new URI(data);
        } catch (URISyntaxException ex) {
            throw new InvalidInfoNodeException("URI malformada en nodo IdentifierType", ex);
        }
    }

    protected void addContent(Element element) throws InvalidInfoNodeException {
        if (uri == null)
            throw new InvalidInfoNodeException("No hay informacion de URI para nodo IdentifierType");
        element.setTextContent(uri.toString());

        if (qualifier != null)
            element.setAttributeNS(null, ConstantesXADES.QUALIFIER, qualifier.toString());
    }

    /**
     * @return the uri
     */
    public URI getUri() {
        return uri;
    }

    /**
     * @param uri
     *            the uri to set
     */
    public void setUri(URI uri) {
        this.uri = uri;
    }

    /**
     * @return the qualifier
     */
    public QualifierEnum getQualifier() {
        return qualifier;
    }

    /**
     * @param qualifier
     *            the qualifier to set
     */
    public void setQualifier(QualifierEnum qualifier) {
        this.qualifier = qualifier;
    }

}
