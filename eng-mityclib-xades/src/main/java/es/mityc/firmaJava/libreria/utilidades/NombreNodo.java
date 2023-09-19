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

package es.mityc.firmaJava.libreria.utilidades;

import org.w3c.dom.Element;

/**
 * Clase para indicar nombres de elementos
 *
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 0.9 beta
 */
public class NombreNodo {
    private String namespace;
    private String localname;

    public NombreNodo(String namespace, String localname) {
        this.namespace = namespace;
        this.localname = localname;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof NombreNodo) {
                NombreNodo nodo = (NombreNodo) obj;
                if (namespace == null) {
                    if (nodo.namespace != null)
                        return false;
                } else if (!namespace.equals(nodo.namespace))
                    return false;
                if (localname.equals(nodo.localname))
                    return true;
            } else if (obj instanceof Element) {
                Element el = (Element) obj;
                if ((namespace == el.getNamespaceURI()) && (localname == el.getLocalName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getLocalname() {
        return localname;
    }
}
