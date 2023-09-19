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

package es.mityc.javasign.xml.transform;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.mityc.javasign.ConstantsXAdES;
import es.mityc.javasign.i18n.I18nFactory;
import es.mityc.javasign.i18n.II18nManager;
import es.mityc.javasign.xml.xades.TransformProxy;

/**
 * <p>
 * Transformada que aplica transformaciones XSLT.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class TransformXSLT extends Transform implements ITransformData {

    /** Internacionalizador. */
    private static final II18nManager I18N = I18nFactory.getI18nManager(ConstantsXAdES.LIB_NAME);

    /** Elemento raíz de la hoja de estilo. */
    private Element stylesheet;

    /**
     * <p>
     * Constructor.
     * </p>
     */
    public TransformXSLT() {
        super(TransformProxy.TRANSFORM_XSLT, null);
        setTransformData(this);
    }

    /**
     * @see es.mityc.javasign.xml.transform.Transform#getExtraData(org.w3c.dom.Document)
     */
    @Override
    public NodeList getExtraData(Document doc) {
        SimpleNodeList nl = null;
        if ((stylesheet != null)) {
            try {
                Node node = doc.importNode(stylesheet, true);
                nl = new SimpleNodeList();
                nl.addNode(node);
            } catch (DOMException ex) {
            }
        }
        return nl;
    }

    /**
     * <p>
     * Establece la hoja de estilo de esta transformada.
     * </p>
     * 
     * @param stylesheet
     *            Hoja de estilo
     * 
     * @throws IllegalArgumentException
     *             si el elemento no se corresponde con una hoja de estilo
     */
    public void setStyleSheet(Element stylesheet) throws IllegalArgumentException {
        if (!"http://www.w3.org/1999/XSL/Transform".equals(stylesheet.getNamespaceURI())) {
            throw new IllegalArgumentException(
                    I18N.getLocalMessage(ConstantsXAdES.I18N_SIGN_8, stylesheet.getNamespaceURI()));
        }
        if (!"stylesheet".equals(stylesheet.getLocalName())) {
            throw new IllegalArgumentException(
                    I18N.getLocalMessage(ConstantsXAdES.I18N_SIGN_9, stylesheet.getLocalName()));
        }
        this.stylesheet = stylesheet;
    }

}
