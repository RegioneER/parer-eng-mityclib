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

/**
 * <p>
 * Guarda informacion extra sobre codificacion y MIME de un objeto.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class ExtraObjectData {

    /** Tipo mime del objeto. */
    private String mimeType = null;
    /** Tipon de encoding en el que se encuentra el objeto. */
    private URI encoding = null;

    /**
     * <p>
     * Constructor.
     * </p>
     * 
     * @param mimeType
     *            Tipo mime del objeto
     * @param encoding
     *            Encoding del objeto (en formato URI)
     */
    public ExtraObjectData(String mimeType, URI encoding) {
        super();
        this.mimeType = mimeType;
        this.encoding = encoding;
    }

    /**
     * @return the mimeType
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * @return the encoding
     */
    public URI getEncoding() {
        return encoding;
    }
}
