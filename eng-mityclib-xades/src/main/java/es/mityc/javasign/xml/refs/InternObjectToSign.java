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

import es.mityc.firmaJava.libreria.ConstantesXADES;

/**
 * Representa un objeto interior al XML pero exterior a la firma (ds:signature) que se quiere firmar.
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class InternObjectToSign extends AbstractObjectToSign {

    private String id;

    /**
     * <p>
     * Constructor.
     * </p>
     * 
     * @param id
     *            Identidad del nodo a firmar
     */
    public InternObjectToSign(String id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @see es.mityc.javasign.xml.refs.AbstractObjectToSign#getReferenceURI()
     */
    @Override
    public String getReferenceURI() {
        return ConstantesXADES.ALMOHADILLA + getId();
    }

}
