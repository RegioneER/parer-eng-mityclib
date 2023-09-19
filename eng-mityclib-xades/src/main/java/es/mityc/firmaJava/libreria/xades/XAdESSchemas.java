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

package es.mityc.firmaJava.libreria.xades;

/**
 * Esquemas de firma XAdES
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0 beta
 */

public enum XAdESSchemas implements Comparable<XAdESSchemas> {

    XAdES_111("1.1.1", "http://uri.etsi.org/01903/v1.1.1#"), XAdES_122("1.2.2", "http://uri.etsi.org/01903/v1.2.2#"),
    XAdES_131("1.3.1", "http://uri.etsi.org/01903/v1.3.1#"), XAdES_132("1.3.2", "http://uri.etsi.org/01903/v1.3.2#"),
    XAdES_141("1.4.1", "http://uri.etsi.org/01903/v1.4.1#");

    private String name;
    private String uri;

    private XAdESSchemas(String name, String uri) {
        this.name = name;
        this.uri = uri;
    }

    public String getSchemaVersion() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getSchemaUri() {
        return uri;
    }

    public static XAdESSchemas getXAdESSchema(String esquemaUri) {
        XAdESSchemas resultado = null;
        if (esquemaUri != null) {
            if (XAdES_111.uri.equals(esquemaUri)) {
                resultado = XAdES_111;
            } else if (XAdES_122.uri.equals(esquemaUri)) {
                resultado = XAdES_122;
            } else if (XAdES_131.uri.equals(esquemaUri)) {
                resultado = XAdES_131;
            } else if (XAdES_132.uri.equals(esquemaUri)) {
                resultado = XAdES_132;
            } else if (XAdES_141.uri.equals(esquemaUri)) {
                resultado = XAdES_141;
            }
        }
        return resultado;
    }
}
