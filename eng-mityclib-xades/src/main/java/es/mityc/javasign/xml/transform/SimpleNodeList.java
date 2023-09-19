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

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * <p>
 * Lista de nodos.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class SimpleNodeList implements NodeList {

    /** Listado de nodos. */
    private List<Node> list = new ArrayList<Node>();

    public void addNode(Node node) {
        list.add(node);
    }

    /**
     * @see org.w3c.dom.NodeList#getLength()
     */
    public int getLength() {
        return list.size();
    }

    /**
     * @see org.w3c.dom.NodeList#item(int)
     */
    public Node item(int index) {
        return list.get(index);
    }

}
