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

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.signature.Reference;
import org.apache.xml.security.signature.XMLSignatureException;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.InvalidTransformException;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.transforms.Transforms;
import org.w3c.dom.Element;

/**
 * <p>
 * Clase proxy para trabajar con un elemento Reference de XMLSec.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class ReferenceProxy {

    /** Guarda la referencia a la instancia Reference. */
    private Reference reference;

    /**
     * <p>
     * Construye una instancia proxy a un Reference.
     * </p>
     * 
     * @param ref
     *            referencia
     */
    public ReferenceProxy(Reference ref) {
        this.reference = ref;
    }

    /**
     * <p>
     * Devuelve la Id del nodo Reference.
     * </p>
     * 
     * @return id
     */
    public String getID() {
        return reference.getId();
    }

    /**
     * <p>
     * Devuelve la URI señalada por la Reference.
     * </p>
     * 
     * @return URI
     */
    public String getURI() {
        return reference.getURI();
    }

    /**
     * <p>
     * Devuelve un listado de las transformadas aplicadas al nodo.
     * </p>
     * 
     * @return
     */
    public List<TransformProxy> getTransforms() {
        ArrayList<TransformProxy> proxys = new ArrayList<TransformProxy>();
        Transforms trans = null;
        try {
            trans = reference.getTransforms();
        } catch (XMLSignatureException ex) {
        } catch (InvalidTransformException ex) {
        } catch (TransformationException ex) {
        } catch (XMLSecurityException ex) {
        }
        if (trans != null) {
            for (int i = 0; i < trans.getLength(); i++) {
                try {
                    proxys.add(new TransformProxy(trans.item(i)));
                } catch (TransformationException ex) {
                }
            }
        }
        return proxys;
    }

    /**
     * <p>
     * Devuelve la informacion en binario del contenido indicado en la referencia.
     * </p>
     * 
     * @return byte[] con los datos, <code>null</code> si se produce un error en el acceso
     */
    public byte[] getBytes() {
        byte[] data = null;
        try {
            XMLSignatureInput si = reference.getContentsAfterTransformation();
            data = si.getBytes();
        } catch (XMLSignatureException ex) {
        } catch (CanonicalizationException ex) {
        } catch (IOException ex) {
        }
        return data;
    }

    /**
     * <p>
     * Escribe el contenido del nodo referenciado en un stream de salida.
     * </p>
     * 
     * @param os
     *            Stream de salida
     */
    public void writeToStream(OutputStream os) throws IOException {
        try {
            XMLSignatureInput si = reference.getContentsAfterTransformation();
            si.updateOutputStream(os);
        } catch (XMLSignatureException ex) {
        } catch (CanonicalizationException ex) {
        }
    }

    /**
     * <p>
     * Devuelve el Element que representa al Reference.
     * </p>
     * 
     * @return Element
     */
    public Element getElement() {
        return reference.getElement();
    }

}
