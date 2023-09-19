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

import java.net.URI;

import es.mityc.firmaJava.libreria.xades.elementos.xades.ObjectIdentifier;

/**
 * Contiene un objeto que se firmara e informacion de apoyo.
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class ObjectToSign {

    private AbstractObjectToSign objectToSign;
    private String id;

    // Informacion adicional
    private String description = null;
    private ObjectIdentifier objectIdentifier = null;
    private ExtraObjectData extraData = null;

    /**
     * Permite pasar un objeto a firmar, junto con la informacion sobre dicho objeto a firmar.
     * 
     * @param objectToSign
     *            .- Objeto a firmar
     * @param desc
     *            .- Descripcion del objeto a firmar
     * @param id
     *            .- Objecto identificador del objeto descrito
     * @param mimeType
     *            .- Tipo MIME del objeto descrito
     * @param encoding
     *            .- Codificacion en la firma del objeto descrito
     */
    public ObjectToSign(AbstractObjectToSign objectToSign, String desc, ObjectIdentifier id, String mimeType,
            URI encoding) {
        this.objectToSign = objectToSign;
        this.description = desc;
        this.objectIdentifier = id;
        this.extraData = new ExtraObjectData(mimeType, encoding);
    }

    public void setObjectToSign(AbstractObjectToSign objectToSign) {
        this.objectToSign = objectToSign;
    }

    public AbstractObjectToSign getObjectToSign() {
        return this.objectToSign;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descripcion) {
        this.description = descripcion;
    }

    public ObjectIdentifier getObjectIdentifier() {
        return objectIdentifier;
    }

    public void setObjectIdentifier(ObjectIdentifier identificador) {
        this.objectIdentifier = identificador;
    }

    public String getMimeType() {
        return extraData.getMimeType();
    }

    public URI getEncoding() {
        return extraData.getEncoding();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
