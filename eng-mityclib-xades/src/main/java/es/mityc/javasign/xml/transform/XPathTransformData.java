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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import es.mityc.firmaJava.libreria.ConstantesXADES;

/**
 * <p>
 * Indica un conjunto de transformadas XPath.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class XPathTransformData implements ITransformData {

    private List<String> paths = new ArrayList<String>();

    /**
     * <p>
     * Incluye el path indicado para la transformada.
     * </p>
     * 
     * @param path
     */
    public void addPath(String path) {
        paths.add(path);
    }

    /**
     * @see es.mityc.javasign.xml.transform.ITransformData#getExtraData(org.w3c.dom.Document))
     */
    public NodeList getExtraData(Document doc) {
        SimpleNodeList nl = null;
        if (paths.size() > 0) {
            nl = new SimpleNodeList();
            for (String path : paths) {
                Element pathElement = doc.createElementNS(ConstantesXADES.SCHEMA_DSIG, "ds:XPath");
                pathElement.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:ds", ConstantesXADES.SCHEMA_DSIG);
                pathElement.setTextContent(path);
                nl.addNode(pathElement);
            }
        }
        return nl;
    }
}
