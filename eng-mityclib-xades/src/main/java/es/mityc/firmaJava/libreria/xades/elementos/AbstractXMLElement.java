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

package es.mityc.firmaJava.libreria.xades.elementos;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.mityc.firmaJava.libreria.ConstantesXADES;
import es.mityc.firmaJava.libreria.utilidades.NombreNodo;
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public abstract class AbstractXMLElement {

    protected AbstractXMLElement() {

    }

    /**
     * Incluye la informacion de este nodo al elemento indicado. Implementado por los tipos.
     * 
     * @param doc
     * 
     * @return
     * 
     * @throws InvalidInfoNodeException
     */
    protected void addContent(Element element) throws InvalidInfoNodeException {
        throw new UnsupportedOperationException("invalid operation");
    }

    /**
     * Devuelve el arbol de nodos que representa este elemento. Implementado por los elementos finales.
     * 
     * @param doc
     *            Documento donde se agregara el elemento
     */
    protected Element createElement(Document doc) throws InvalidInfoNodeException {
        throw new UnsupportedOperationException("invalid operation");
    }

    /**
     * Lee la informacion del nodo
     * 
     * @param element
     *            elemento del que cuelga la informacion
     * 
     * @throws InvalidInfoNodeException
     *             lanzada cuando la estructura de nodos leída es invalida
     */
    public abstract void load(Element element) throws InvalidInfoNodeException;

    /**
     * Compara otro objeto similar a ver si contienen la misma informacion
     * 
     * @param obj
     *            Objeto que ha de ser de la misma clase
     * 
     * @return <code>true</code> si contienen la misma informacion, <code>false</code> en cualquier otro caso
     */
    public abstract boolean equals(Object obj);

    /**
     * Comprueba que el elemento indicado tiene el namespaceURI y el nombre esperados
     * 
     * @param element
     *            Elemento que chequear
     * @param namespaceURI
     *            NamespaceURI esperado
     * @param name
     *            Nombre esperado
     * 
     * @throws InvalidInfoNodeException
     *             Se lanza cuando no se cumple lo esperado
     */
    protected void checkElementName(Element element, String namespaceURI, String name) throws InvalidInfoNodeException {
        if (!isElementName(element, namespaceURI, name))
            throw new InvalidInfoNodeException(
                    "Elemento esperado (".concat(namespaceURI).concat(":").concat(name).concat(" Elemento obtenido ")
                            + element.getNamespaceURI() + ":".concat(element.getLocalName()));
    }

    /**
     * Comprueba si el elemento indicado tiene el nombre esperado
     * 
     * @param element
     *            Elemento que chequear
     * @param namespaceURI
     *            NamespaceURI esperado
     * @param name
     *            Nombre esperado
     * 
     * @return
     */
    protected boolean isElementName(Element element, String namespaceURI, String name) {
        if ((element != null) && (new NombreNodo(namespaceURI, name)
                .equals(new NombreNodo(element.getNamespaceURI(), element.getLocalName()))))
            return true;
        return false;
    }

    /**
     * Indica si el nodo pasado es o no del tipo al que se le hace la consulta
     * 
     * @param node
     * 
     * @return
     */
    protected boolean isThisNode(Node node) {
        throw new UnsupportedOperationException("invalid operation");
    }

    /**
     * Convierte el nodo indicado a un elemento
     * 
     * @param node
     * 
     * @return <code>null<code> si el nodo indicado no es un Element
     */
    protected Element nodeToElement(Node node) {
        Element element = null;
        if (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE)
                element = (Element) node;
        }
        return element;
    }

    protected static boolean isDecorationNode(Node node) {
        if (node != null) {
            switch (node.getNodeType()) {
            case Node.TEXT_NODE:
                String text = node.getNodeValue().trim();
                text = text.replaceAll("/n", ConstantesXADES.CADENA_VACIA);
                text = text.replaceAll("/r", ConstantesXADES.CADENA_VACIA);
                text = text.replaceAll(ConstantesXADES.ESPACIO, ConstantesXADES.CADENA_VACIA);
                if (text.equals(ConstantesXADES.CADENA_VACIA))
                    return true;
                else
                    return false;
            case Node.COMMENT_NODE:
                return true;
            case Node.ELEMENT_NODE:
            default:
                return false;
            }
        }
        return true;
    }

    protected static Node getFirstNonvoidNode(Node node) {
        Node child = node.getFirstChild();

        while ((child != null) && (isDecorationNode(child))) {
            child = child.getNextSibling();
        }
        return child;
    }

    protected static Node getNextNonvoidNode(Node node) {
        Node child = node.getNextSibling();

        while ((child != null) && (isDecorationNode(child))) {
            child = child.getNextSibling();
        }
        return child;
    }

    protected static boolean compare(Object obj1, Object obj2) {
        if ((obj1 == null) && (obj2 == null))
            return true;
        if (obj1 != null)
            return (obj1.equals(obj2));
        return false;
    }
}
