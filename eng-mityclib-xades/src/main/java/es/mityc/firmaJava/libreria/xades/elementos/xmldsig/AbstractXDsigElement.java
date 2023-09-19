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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement;
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * Interfaz que ha de cumplir una implementacion de un elemento del esquema XDsig
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public abstract class AbstractXDsigElement extends AbstractXMLElement {

    protected String namespaceXDsig;

    protected AbstractXDsigElement() {
        super();
    }

    /**
     * Este método pueden hacerlo público los elementos finales.
     * 
     * @param doc
     * @param namespace
     * 
     * @return
     * 
     * @throws InvalidInfoNodeException
     */
    protected Element createElement(Document doc, String namespaceXDsig) throws InvalidInfoNodeException {
        setNamespaceXDsig(namespaceXDsig);
        return createElement(doc);
    }

    /**
     * Este método pueden hacerlo público los tipos.
     * 
     * @param doc
     * @param element
     * @param namespace
     * 
     * @throws InvalidInfoNodeException
     */
    protected void addContent(Element element, String namespaceXDsig) throws InvalidInfoNodeException {
        setNamespaceXDsig(namespaceXDsig);
        addContent(element);
    }

    /**
     * @return the namespaceXDsig
     */
    public String getNamespaceXDsig() {
        return namespaceXDsig;
    }

    /**
     * @param namespaceXDsig
     *            the namespaceXDsig to set
     */
    public void setNamespaceXDsig(String namespaceXDsig) {
        this.namespaceXDsig = namespaceXDsig;
    }

}
