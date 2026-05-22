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

import org.apache.xml.security.signature.XMLSignatureByteInput;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.resolver.ResourceResolverContext;
import org.apache.xml.security.utils.resolver.ResourceResolverException;

/**
 * Este ResourceResolverSpi permite acceder a informaciÃ³n privada obtiendo su digest para poder
 * realizar una firma XML.
 *
 * @author Ministerio de Industria, Turismo y Comercio
 *
 * @version 1.0
 */
public class ResolverPrivateData extends MITyCResourceResolver {

    private IPrivateData internalResolver;

    public ResolverPrivateData(IPrivateData internalResolver) {
        super();
        this.internalResolver = internalResolver;
    }

    /**
     * @see org.apache.xml.security.utils.resolver.ResourceResolverSpi#engineIsPrivateData()
     */

    public boolean engineIsPrivateData() {
        return true;
    }

    @Override
    public XMLSignatureInput engineResolveURI(ResourceResolverContext context)
            throws ResourceResolverException {
        if (internalResolver == null || context.attr == null) {
            throw new ResourceResolverException("", context.attr.getBaseURI(), context.baseUri);
        }
        String algName = context.getProperties() != null
                ? (String) context.getProperties().get("digest.algorithm")
                : null;
        if (algName == null) {
            throw new ResourceResolverException("", context.attr.getBaseURI(), context.baseUri);
        }
        try {
            String uriValue = context.attr.getValue();
            String baseURI = context.baseUri;
            byte[] data = internalResolver.getDigest(uriValue, baseURI, algName);
            return new XMLSignatureByteInput(data);
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
        return internalResolver.canDigest(uriValue, baseURI);
    }
}
