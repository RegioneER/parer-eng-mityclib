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

package es.mityc.firmaJava.libreria.xades.elementos.xmldsig;

import java.util.ArrayList;
import java.util.Iterator;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class TransformsType extends AbstractXDsigElement {

    private ArrayList<Transform> list;

    public TransformsType() {
        super();
    }

    public TransformsType(ArrayList<Transform> list) {
        super();
        this.list = list;
    }

    public void addTransform(Transform transform) {
        if (list == null)
            list = new ArrayList<Transform>();
        list.add(transform);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.xmldsig.AbstractXDsigElement#addContent(org.w3c.dom.Element,
     *      java.lang.String)
     */
    @Override
    public void addContent(Element element, String namespaceXDsig) throws InvalidInfoNodeException {
        super.addContent(element, namespaceXDsig);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#addContent(org.w3c.dom.Element)
     */
    @Override
    protected void addContent(Element element) throws InvalidInfoNodeException {
        if ((list == null) || (list.size() < 1))
            throw new InvalidInfoNodeException("Informacion insuficiente para escribir nodo TransformsType");
        Iterator<Transform> it = list.iterator();
        while (it.hasNext()) {
            element.appendChild(it.next().createElement(element.getOwnerDocument(), namespaceXDsig));
        }
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TransformType) {
            TransformsType tt = (TransformsType) obj;
            ArrayList<Transform> comp = tt.list;
            if (((list == null) || (list.isEmpty())) && ((comp == null) || (comp.isEmpty())))
                return true;
            if (((list != null) && (comp != null)) && (list.size() == comp.size())) {
                Iterator<Transform> itThis = list.iterator();
                Iterator<Transform> itComp = comp.iterator();
                while (itThis.hasNext()) {
                    if (!itThis.next().equals(itComp.next()))
                        return false;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#load(org.w3c.dom.Element)
     */
    @Override
    public void load(Element element) throws InvalidInfoNodeException {
        NodeList nodos = element.getChildNodes();

        ArrayList<Transform> temp = new ArrayList<Transform>(nodos.getLength());
        for (int i = 0; i < nodos.getLength(); i++) {
            Node nodo = nodos.item(i);
            if (isDecorationNode(nodo))
                continue;

            if (nodo.getNodeType() != Node.ELEMENT_NODE)
                throw new InvalidInfoNodeException("Hijo de Transforms no es un elemento");

            Transform transform = new Transform();
            transform.load((Element) nodo);
            temp.add(transform);
        }
        if (temp.size() == 0)
            throw new InvalidInfoNodeException("Un nodo Trasforms debe tener al menos un hijo Transform");

        list = temp;
    }

    /**
     * @return the list
     */
    public ArrayList<Transform> getList() {
        return list;
    }

    /**
     * @param list
     *            the list to set
     */
    public void setList(ArrayList<Transform> list) {
        this.list = list;
    }

}
