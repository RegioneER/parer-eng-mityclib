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

package es.mityc.firmaJava.libreria.xades.elementos.xades;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public enum QualifierEnum {

    OIDAsURI("OIDAsURI"), OIDAsURN("OIDAsURN");

    private String value;

    private QualifierEnum(String value) {
        this.value = value;
    }

    /**
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return new String(value);
    }

    public static QualifierEnum getQualifierEnum(String value) {
        if (value == null)
            return null;
        if (OIDAsURI.toString().equals(value))
            return OIDAsURI;
        else if (OIDAsURN.toString().equals(value))
            return OIDAsURN;
        return null;
    }

}
