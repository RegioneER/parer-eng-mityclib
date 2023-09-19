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

package es.mityc.javasign.xml.refs;

import java.util.ArrayList;
import java.util.List;

import org.apache.xml.security.signature.ObjectContainer;
import org.apache.xml.security.transforms.Transforms;
import org.w3c.dom.Document;

import es.mityc.javasign.xml.resolvers.MITyCResourceResolver;
import es.mityc.javasign.xml.transform.Transform;

/**
 * Interfaz para señalar las clases que representan objetos a ser firmados
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public abstract class AbstractObjectToSign {

    /** Transformadas. */
    private ArrayList<Transform> transforms = new ArrayList<Transform>();

    /**
     * <p>
     * Incluye la transformada indicada para que se aplique en el objeto a firmar.
     * </p>
     * 
     * @param t
     *            transformada
     */
    public void addTransform(Transform t) {
        // evita que se añada una transformada que ya esta incluida que no aporte nada nuevo
        if (t != null) {
            boolean mustadd = true;
            String alg = t.getAlgorithm();
            if ((alg != null) && (Transforms.TRANSFORM_ENVELOPED_SIGNATURE.equals(alg))) {
                for (Transform trans : transforms) {
                    if (alg.equals(trans.getAlgorithm())) {
                        mustadd = false;
                        break;
                    }
                }
            }
            if (mustadd) {
                transforms.add(t);
            }
        }
    }

    /**
     * <p>
     * Devuelve el listado de transformadas que se quieren aplicar al objeto.
     * </p>
     * 
     * @return lista de transformadas
     */
    @SuppressWarnings("unchecked")
    public List<Transform> getTransforms() {
        return (List<Transform>) transforms.clone();
    }

    /**
     * <p>
     * Devuelve una URI que sirve para indicar donde se encuentra el objeto a ser firmado.
     * </p>
     * 
     * @return URI de referencia
     */
    public abstract String getReferenceURI();

    /**
     * <p>
     * Devuelve el tipo de referencia que tendra el objeto a firmar.
     * </p>
     * <p>
     * Este método debera ser sobreescrito por las clases hijas que quieran devolver un tipo específico.
     * </p>
     * 
     * @return devuelve <code>null</code>
     */
    public String getType() {
        return null;
    }

    /**
     * <p>
     * Devuelve un conjunto de contenedores de objetos que se añadiran a la firma.
     * </p>
     * <p>
     * Este método debera ser sobreescrito por las clases hijas que quieran incluir nuevos objetos de firma.
     * </p>
     * 
     * @param doc
     *            Document en el que iran los objetos
     * 
     * @return devuelve una lista vacía
     */
    public List<ObjectContainer> getObjects(Document doc) {
        return new ArrayList<ObjectContainer>();
    }

    /**
     * <p>
     * Devuelve un Resolver extra para tratar este objeto a ser firmado.
     * </p>
     * <p>
     * Este método debera ser sobreescrito por las clases hijas que quieran incluir Resolver extra.
     * </p>
     * 
     * @return devuelve <code>null</code>
     */
    public MITyCResourceResolver getResolver() {
        return null;
    }

}
