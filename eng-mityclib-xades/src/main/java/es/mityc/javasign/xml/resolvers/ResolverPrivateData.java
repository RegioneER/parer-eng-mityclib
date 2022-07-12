/**
 * LICENCIA LGPL:
 * 
 * Esta librerÃ­a es Software Libre; Usted puede redistribuirlo y/o modificarlo
 * bajo los tÃ©rminos de la GNU Lesser General Public License (LGPL)
 * tal y como ha sido publicada por la Free Software Foundation; o
 * bien la versiÃ³n 2.1 de la Licencia, o (a su elecciÃ³n) cualquier versiÃ³n posterior.
 * 
 * Esta librerÃ­a se distribuye con la esperanza de que sea Ãºtil, pero SIN NINGUNA
 * GARANTÃ�A; tampoco las implÃ­citas garantÃ­as de MERCANTILIDAD o ADECUACIÃ“N A UN
 * PROPÃ“SITO PARTICULAR. Consulte la GNU Lesser General Public License (LGPL) para mÃ¡s
 * detalles
 * 
 * Usted debe recibir una copia de la GNU Lesser General Public License (LGPL)
 * junto con esta librerÃ­a; si no es asÃ­, escriba a la Free Software Foundation Inc.
 * 51 Franklin Street, 5Âº Piso, Boston, MA 02110-1301, USA.
 * 
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

    /**
     * 
     */
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
