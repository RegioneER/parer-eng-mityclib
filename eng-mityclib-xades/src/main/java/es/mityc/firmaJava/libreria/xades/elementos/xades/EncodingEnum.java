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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public enum EncodingEnum {

    DER_ENCODED("http://uri.etsi.org/01903/v1.2.2#DER"), BER_ENCODED("http://uri.etsi.org/01903/v1.2.2#BER"),
    CER_ENCODED("http://uri.etsi.org/01903/v1.2.2#CER"), PER_ENCODED("http://uri.etsi.org/01903/v1.2.2#PER"),
    XER_ENCODED("http://uri.etsi.org/01903/v1.2.2#XER"),

    /*
     * Aggiunto
     */
    DER131_ENCODED("http://uri.etsi.org/01903/v1.3.1#DER");

    private final static Log logger = LogFactory.getLog(EncodingEnum.class);

    private URI uri;

    private EncodingEnum(String uri) {
        try {
            this.uri = new URI(uri);
        } catch (URISyntaxException ex) {
            Log logger = LogFactory.getLog(EncodingEnum.class);
            logger.error("Error creando enumerado de encoding", ex);
        }
    }

    public URI getEncodingUri() {
        return uri;
    }

    public static EncodingEnum getEncoding(String uri) {
        try {
            if ((uri == null) || ("".equals(uri.trim())))
                return DER_ENCODED;
            URI temp = new URI(uri);
            if (temp.equals(DER_ENCODED.uri))
                return DER_ENCODED;
            else if (temp.equals(BER_ENCODED.uri))
                return BER_ENCODED;
            else if (temp.equals(CER_ENCODED.uri))
                return CER_ENCODED;
            else if (temp.equals(PER_ENCODED.uri))
                return PER_ENCODED;
            else if (temp.equals(DER131_ENCODED.uri))
                return DER131_ENCODED;
            else if (temp.equals(XER_ENCODED.uri))
                return XER_ENCODED;
        } catch (URISyntaxException ex) {
            if (logger.isDebugEnabled())
                logger.debug("Encoding indicado no es una URI", ex);
            return null;
        }
        return null;
    }

}
