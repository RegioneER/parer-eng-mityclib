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

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * <p>
 * Guarda informacion sobre una transformada que se va a aplicar a un objeto a firmar.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class Transform {

    /** Algoritmo de la transformada. */
    private String algorithm;
    /** Generador de la informacion extra de la transformada. */
    private ITransformData data;

    /**
     * <p>
     * Construye una transformada general con el algoritmo indicado.
     * </p>
     * 
     * @param alg
     *            Algoritmo de la transformada
     * @param extraData
     *            Generador de los nodos de informacion extra, <code>null</code> si no hay informacion extra para la
     *            transformada
     */
    public Transform(String alg, ITransformData extraData) {
        this.algorithm = alg;
        this.data = extraData;
    }

    /**
     * <p>
     * Establece el generador de los nodos de informacion extra.
     * </p>
     * 
     * @param extraData
     */
    protected void setTransformData(ITransformData extraData) {
        this.data = extraData;
    }

    /**
     * <p>
     * Devuelve el algoritmo de la transformada.
     * </p>
     * 
     * @return the algorithm
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * <p>
     * Devuelve el listado de nodos de informacion extra que necesita la transformada.
     * </p>
     * 
     * @param doc
     *            Documento en el que ira la transformada
     * 
     * @return listado de nodos
     */
    public NodeList getExtraData(Document doc) {
        NodeList nl = null;
        if (data != null) {
            nl = data.getExtraData(doc);
        }
        return nl;
    }

}
