/*
 * Engineering Ingegneria Informatica S.p.A.
 *
 * Copyright (C) 2023 Regione Emilia-Romagna <p/> This program is free software: you can
 * redistribute it and/or modify it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. <p/> This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Affero General Public License for more details. <p/> You should
 * have received a copy of the GNU Affero General Public License along with this program. If not,
 * see <https://www.gnu.org/licenses/>.
 */

package es.mityc.javasign.xml.resolvers;

import java.io.InputStream;

import org.apache.xml.security.signature.XMLSignatureByteInput;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.signature.XMLSignatureStreamInput;
import org.apache.xml.security.utils.resolver.ResourceResolverContext;
import org.apache.xml.security.utils.resolver.ResourceResolverException;

/**
 * Este ResourceResolverSpi permite acceder a informacion de un elemento a través de un interfaz
 * propio para poder realizar una firma XML.
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

    @Override
    public XMLSignatureInput engineResolveURI(ResourceResolverContext context)
            throws ResourceResolverException {
        if (internalResolver == null || context.attr == null) {
            throw new ResourceResolverException("", context.attr.getBaseURI(), context.baseUri);
        }
        try {
            String uriValue = context.attr.getValue();
            String baseURI = context.baseUri;
            Object dataAccess = internalResolver.getAccess(uriValue, baseURI);
            XMLSignatureInput xsi;
            if (dataAccess instanceof InputStream) {
                xsi = new XMLSignatureStreamInput((InputStream) dataAccess);
            } else if (dataAccess instanceof byte[]) {
                xsi = new XMLSignatureByteInput((byte[]) dataAccess);
            } else {
                throw new ResourceResolverException("", context.attr.getBaseURI(), context.baseUri);
            }
            return xsi;
        } catch (ResourceDataException ex) {
            throw new ResourceResolverException("", context.attr.getBaseURI(), context.baseUri);
        }
    }

    @Override
    public boolean engineCanResolveURI(ResourceResolverContext context) {
        if (internalResolver == null || context.attr == null) {
            return false;
        }
        String uriValue = context.attr.getValue();
        String baseURI = context.baseUri;
        return internalResolver.canAccess(uriValue, baseURI);
    }

}
