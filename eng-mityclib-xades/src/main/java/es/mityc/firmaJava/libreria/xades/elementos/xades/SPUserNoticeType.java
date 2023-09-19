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

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * @author dsantose
 *
 */
public class SPUserNoticeType extends AbstractXADESElement {

    private NoticeRef noticeRef;
    private ExplicitText explicitText;

    /**
     * @param schema
     */
    public SPUserNoticeType(XAdESSchemas schema) {
        super(schema);
    }

    public NoticeRef getNoticeRef() {
        return noticeRef;
    }

    public void setNoticeRef(NoticeRef noticeRef) {
        this.noticeRef = noticeRef;
    }

    public void setNoticeRef(String organization, int[] numbers) {
        this.noticeRef = new NoticeRef(schema, organization, numbers);
    }

    public String getExplicitText() {
        if (explicitText != null)
            return explicitText.getValue();
        else
            return null;
    }

    public void setExplicitText(String explicitText) {
        this.explicitText = new ExplicitText(schema, explicitText);
    }

    @Override
    public void addContent(Element element, String namespaceXAdES) throws InvalidInfoNodeException {
        super.addContent(element, namespaceXAdES);
    }

    @Override
    protected void addContent(Element element) throws InvalidInfoNodeException {
        if (noticeRef != null)
            element.appendChild(noticeRef.createElement(element.getOwnerDocument(), namespaceXAdES));
        if (explicitText != null)
            element.appendChild(explicitText.createElement(element.getOwnerDocument(), namespaceXAdES));
    }

    /*
     * (non-Javadoc)
     * 
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SPUserNoticeType) {
            SPUserNoticeType sppt = (SPUserNoticeType) obj;
            if (noticeRef == null) {
                if (sppt.noticeRef != null)
                    return false;
            } else if (!noticeRef.equals(sppt.noticeRef))
                return false;
            if (explicitText == null) {
                if (sppt.explicitText != null)
                    return false;
            } else if (!explicitText.equals(sppt.explicitText))
                return false;

            return true;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#load(org.w3c.dom.Element)
     */
    @Override
    public void load(Element element) throws InvalidInfoNodeException {
        Node node = getFirstNonvoidNode(element);

        // busca la noticeref
        if (node == null)
            return;
        else if (node.getNodeType() != Node.ELEMENT_NODE)
            throw new InvalidInfoNodeException("Se esperaba elemento como hijo de SPUserNoticeType");
        Element child = (Element) node;
        NoticeRef noticeTemp = new NoticeRef(schema);
        if (noticeTemp.isThisNode(child)) {
            noticeTemp.load(child);
            noticeRef = noticeTemp;
            node = getNextNonvoidNode(node);
        } else
            noticeRef = null;

        // busca el explicittext
        if (node == null)
            return;
        else if (node.getNodeType() != Node.ELEMENT_NODE)
            throw new InvalidInfoNodeException("Se esperaba elemento como hijo de SPUserNoticeType");
        child = (Element) node;
        ExplicitText explicitTemp = new ExplicitText(schema);
        if (explicitTemp.isThisNode(child)) {
            explicitTemp.load(child);
            explicitText = explicitTemp;
            node = getNextNonvoidNode(node);
        } else
            explicitText = null;

        if (node != null)
            throw new InvalidInfoNodeException("No se esperaba este elemento como hijo de SPUserNoticeType");
    }

}
