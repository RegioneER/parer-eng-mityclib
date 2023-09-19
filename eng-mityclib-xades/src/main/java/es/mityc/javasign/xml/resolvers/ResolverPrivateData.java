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

package es.mityc.javasign.xml.resolvers;

import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.Constants;
import org.apache.xml.security.utils.resolver.ResourceResolverException;
import org.w3c.dom.Attr;

/**
 * Este ResourceResolverSpi permite acceder a informaciÃ³n privada obtiendo su digest para poder realizar una firma XML.
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class ResolverPrivateData extends MITyCResourceResolver {

    private final static String[] keys = { "digest.algorithm" };

    private IPrivateData internalResolver;

    public ResolverPrivateData(IPrivateData internalResolver) {
        super();
        this.internalResolver = internalResolver;
    }

    /**
     * @see org.apache.xml.security.utils.resolver.ResourceResolverSpi#engineCanResolve(org.w3c.dom.Attr,
     *      java.lang.String)
     */
    @Override
    public boolean engineCanResolve(Attr uri, String BaseURI) {
        if (internalResolver == null) {
            return false;
        }
        return internalResolver.canDigest(uri.getValue(), BaseURI);
    }

    /**
     * @see org.apache.xml.security.utils.resolver.ResourceResolverSpi#engineResolve(org.w3c.dom.Attr, java.lang.String)
     */
    @Override
    public XMLSignatureInput engineResolve(Attr uri, String BaseURI) throws ResourceResolverException {
        if (internalResolver == null) {
            throw new ResourceResolverException("", uri, BaseURI);
        }
        String algName = engineGetProperty("digest.algorithm");
        if (algName == null) {
            throw new ResourceResolverException("", uri, BaseURI);
        }
        try {
            byte[] data = internalResolver.getDigest(uri.getValue(), BaseURI, algName);
            XMLSignatureInput xsi = new XMLSignatureInput(data);
            return xsi;
        } catch (ResourceDataException ex) {
            throw new ResourceResolverException("", uri, BaseURI);
        }
    }

    /**
     * @see org.apache.xml.security.utils.resolver.ResourceResolverSpi#engineIsPrivateData()
     */

    public boolean engineIsPrivateData() {
        return true;
    }

    /**
     * @see org.apache.xml.security.utils.resolver.ResourceResolverSpi#engineGetPropertyKeys()
     */
    @Override
    public String[] engineGetPropertyKeys() {
        return keys;
    }
}
