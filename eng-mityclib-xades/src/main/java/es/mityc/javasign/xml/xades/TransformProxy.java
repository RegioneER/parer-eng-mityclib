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

package es.mityc.javasign.xml.xades;

import org.apache.xml.security.transforms.Transform;

/**
 * <p>
 * Sirve de wrapper para las Transform asociadas a un Reference.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class TransformProxy {

    public static final String TRANSFORM_C14N_OMIT_COMMENTS = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";
    public static final String TRANSFORM_C14N_WITH_COMMENTS = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315#WithComments";
    public static final String TRANSFORM_C14N11_OMIT_COMMENTS = "http://www.w3.org/2006/12/xml-c14n11";
    public static final String TRANSFORM_C14N11_WITH_COMMENTS = "http://www.w3.org/2006/12/xml-c14n11#WithComments";
    public static final String TRANSFORM_C14N_EXCL_OMIT_COMMENTS = "http://www.w3.org/2001/10/xml-exc-c14n#";
    public static final String TRANSFORM_C14N_EXCL_WITH_COMMENTS = "http://www.w3.org/2001/10/xml-exc-c14n#WithComments";
    public static final String TRANSFORM_XSLT = "http://www.w3.org/TR/1999/REC-xslt-19991116";
    public static final String TRANSFORM_BASE64_DECODE = "http://www.w3.org/2000/09/xmldsig#base64";
    public static final String TRANSFORM_XPATH = "http://www.w3.org/TR/1999/REC-xpath-19991116";
    public static final String TRANSFORM_ENVELOPED_SIGNATURE = "http://www.w3.org/2000/09/xmldsig#enveloped-signature";
    public static final String TRANSFORM_XPOINTER = "http://www.w3.org/TR/2001/WD-xptr-20010108";
    public static final String TRANSFORM_XPATH2FILTER04 = "http://www.w3.org/2002/04/xmldsig-filter2";
    public static final String TRANSFORM_XPATH2FILTER = "http://www.w3.org/2002/06/xmldsig-filter2";
    public static final String TRANSFORM_XPATHFILTERCHGP = "http://www.nue.et-inf.uni-siegen.de/~geuer-pollmann/#xpathFilter";

    /** Referencia a la transformada. */
    private Transform transform;

    /**
     * <p>
     * Construye un wrapper con la transformada indicada
     * 
     * @param ref
     *            Referencia
     */
    public TransformProxy(Transform ref) {
        this.transform = ref;
    }

    /**
     * <p>
     * Devuelve la representacion URI de la transformada.
     * </p>
     * 
     * @return URI de la transformada
     */
    public String getURI() {
        return transform.getURI();
    }

    /**
     * <p>
     * Indica si la transformada es de canonicalizacion.
     * </p>
     * 
     * @param trans
     *            Transformada
     * 
     * @return true si es una canonicalizacion
     */
    public static boolean isCanonicalization(TransformProxy trans) {
        String uri = trans.getURI();
        if ((uri.equals(TRANSFORM_C14N_OMIT_COMMENTS)) || (uri.equals(TRANSFORM_C14N_WITH_COMMENTS))
                || (uri.equals(TRANSFORM_C14N11_OMIT_COMMENTS)) || (uri.equals(TRANSFORM_C14N11_WITH_COMMENTS))
                || (uri.equals(TRANSFORM_C14N_EXCL_OMIT_COMMENTS)) || (uri.equals(TRANSFORM_C14N_EXCL_WITH_COMMENTS))) {
            return true;
        }
        return false;
    }

}
