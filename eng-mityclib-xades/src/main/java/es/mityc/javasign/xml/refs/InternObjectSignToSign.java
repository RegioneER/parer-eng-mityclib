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

package es.mityc.javasign.xml.refs;

import java.util.List;

import org.apache.xml.security.signature.ObjectContainer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import es.mityc.firmaJava.libreria.ConstantesXADES;
import es.mityc.firmaJava.libreria.utilidades.UtilidadTratarNodo;

/**
 * Representa un objeto que se quiere añadir como un objeto (ds:object) de la firma.
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class InternObjectSignToSign extends AbstractObjectToSign {

    private String encoding;
    private String mimeType;
    private Element data;
    /** Identidad del objeto interno a firmar. */
    private String id = null;

    public InternObjectSignToSign() {
    }

    public InternObjectSignToSign(String encoding, String mimeType) {
        this.encoding = encoding;
        this.mimeType = mimeType;
    }

    public void setData(Element data) {
        this.data = data;
    }

    public Element getData() {
        return data;
    }

    /**
     * @return the encoding
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * @return the mimeType
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * @see es.mityc.javasign.xml.refs.AbstractObjectToSign#getReferenceURI()
     */
    @Override
    public String getReferenceURI() {
        return id;
    }

    /**
     * @see es.mityc.javasign.xml.refs.AbstractObjectToSign#getObjects(org.w3c.dom.Document)
     */
    @Override
    public List<ObjectContainer> getObjects(Document doc) {
        List<ObjectContainer> list = super.getObjects(doc);

        ObjectContainer container = new ObjectContainer(doc);
        // Es muy importante añadir el nodo antes de generar el nuevo Id para evitar colisiones (ids repetidos)
        container.appendChild(doc.adoptNode(getData().cloneNode(true)));

        id = UtilidadTratarNodo.newID(doc, "Object-ID-");
        container.setId(id);
        if (getEncoding() != null) {
            container.setEncoding(getEncoding());
        }
        if (getMimeType() != null) {
            container.setMimeType(getMimeType());
        }
        id = ConstantesXADES.ALMOHADILLA + id;

        list.add(container);
        return list;
    }

}
