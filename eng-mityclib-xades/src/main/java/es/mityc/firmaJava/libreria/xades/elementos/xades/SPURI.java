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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.mityc.firmaJava.libreria.ConstantesXADES;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;
import es.mityc.javasign.xml.xades.policy.PolicyException;

/**
 * @author dsantose
 *
 */
public class SPURI extends AbstractXadesURIElement implements IPolicyQualifier {

    /**
     * @param schema
     * @param nameElement
     * @param data
     */
    public SPURI(XAdESSchemas schema, URI data) {
        super(schema, ConstantesXADES.XADES_TAG_SP_URI, data);
    }

    /**
     * @param schema
     * @param nameElement
     */
    public SPURI(XAdESSchemas schema) {
        super(schema, ConstantesXADES.XADES_TAG_SP_URI);
    }

    public Node createPolicyQualifierContent(Document doc) throws PolicyException {
        Element el = null;
        try {
            if (getNamespaceXAdES() != null)
                el = createElement(doc, namespaceXAdES);
            else
                throw new PolicyException("No se ha indicado qualifier para nodo SPURI");
        } catch (InvalidInfoNodeException ex) {
            throw new PolicyException(ex);
        }
        return el;
    }

    public void loadPolicyQualifierContent(Element element) throws PolicyException {
        try {
            load(element);
        } catch (InvalidInfoNodeException ex) {
            throw new PolicyException(ex);
        }
    }

}
