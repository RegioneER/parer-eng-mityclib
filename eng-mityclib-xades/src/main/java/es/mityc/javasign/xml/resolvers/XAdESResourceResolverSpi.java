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

import java.io.InputStream;

import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.resolver.ResourceResolverException;
import org.w3c.dom.Attr;

/**
 * Este ResourceResolverSpi permite acceder a informacion de un elemento a través de un interfaz propio para poder
 * realizar una firma XML.
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class XAdESResourceResolverSpi extends MITyCResourceResolver {

    private IResourceData internalResolver;

    public XAdESResourceResolverSpi(IResourceData internalResolver) {
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
        return internalResolver.canAccess(uri.getValue(), BaseURI);
    }

    /**
     * @see org.apache.xml.security.utils.resolver.ResourceResolverSpi#engineResolve(org.w3c.dom.Attr, java.lang.String)
     */
    @Override
    public XMLSignatureInput engineResolve(Attr uri, String BaseURI) throws ResourceResolverException {
        if (internalResolver == null) {
            throw new ResourceResolverException("", uri, BaseURI);
        }
        try {
            Object dataAccess = internalResolver.getAccess(uri.getValue(), BaseURI);
            XMLSignatureInput xsi = null;
            if (dataAccess instanceof InputStream) {
                xsi = new XMLSignatureInput((InputStream) dataAccess);
            } else if (dataAccess instanceof byte[]) {
                xsi = new XMLSignatureInput((byte[]) dataAccess);
            } else {
                throw new ResourceResolverException("", uri, BaseURI);
            }
            return xsi;
        } catch (ResourceDataException ex) {
            throw new ResourceResolverException("", uri, BaseURI);
        }
    }

}
