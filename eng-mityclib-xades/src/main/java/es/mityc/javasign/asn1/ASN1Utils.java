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

package es.mityc.javasign.asn1;

import java.io.IOException;

import javax.security.auth.x500.X500Principal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ocsp.ResponderID;
import org.bouncycastle.asn1.x509.X509Name;

import es.mityc.javasign.ConstantsXAdES;
import es.mityc.javasign.certificate.OCSPResponderID;
import es.mityc.javasign.i18n.I18nFactory;
import es.mityc.javasign.i18n.II18nManager;

/**
 * <p>
 * Conjunto de utilidades para el tratamiento de campos ASN.1.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class ASN1Utils {

    /** Logger. */
    private static Log LOG = LogFactory.getLog(ASN1Utils.class);
    /** Internacionalizador. */
    private static II18nManager I18N = I18nFactory.getI18nManager(ConstantsXAdES.LIB_NAME);

    /**
     * <p>
     * Constructor vacío.
     * </p>
     */
    private ASN1Utils() {
    }

    /**
     * <p>
     * Obtiene la informacion sobre la identidad de un responder de OCSP mediante una estructura ASN.1.
     * </p>
     * 
     * @param responder
     *            Bloque ASN.1 que contiene la informacion del responder
     * 
     * @return objeto con los datos del responder, <code>null</code> si no se ha podido formar
     */
    public static OCSPResponderID getResponderID(ResponderID responder) {
        OCSPResponderID result = null;
        ASN1TaggedObject tagged = (ASN1TaggedObject) responder.toASN1Object();
        switch (tagged.getTagNo()) {
        case 1:
            try {
                X509Name name = X509Name.getInstance(tagged.getObject());
                result = OCSPResponderID.getOCSPResponderID(new X500Principal(name.getEncoded()));
            } catch (IllegalArgumentException ex) {
                LOG.error(I18N.getLocalMessage(ConstantsXAdES.I18N_UTILS_1, ex.getMessage()));
                if (LOG.isDebugEnabled()) {
                    LOG.debug("", ex);
                }
            } catch (IOException ex) {
                LOG.error(I18N.getLocalMessage(ConstantsXAdES.I18N_UTILS_1, ex.getMessage()));
                if (LOG.isDebugEnabled()) {
                    LOG.debug("", ex);
                }
            }
            break;
        case 2:
            ASN1OctetString octect = (ASN1OctetString) tagged.getObject();
            result = OCSPResponderID.getOCSPResponderID(octect.getOctets());
            break;
        }
        return result;
    }

}
