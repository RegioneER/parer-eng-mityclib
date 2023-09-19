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

import es.mityc.firmaJava.libreria.ConstantesXADES;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;

/**
 * @author dsantose
 *
 */
public class ExplicitText extends AbstractXadesStringElement {

    public ExplicitText(XAdESSchemas schema, String data) {
        super(schema, ConstantesXADES.XADES_TAG_EXPLICIT_TEXT, data);
    }

    /**
     * @param namespaceXAdES
     * @param namespaceXDSig
     * @param schema
     */
    public ExplicitText(XAdESSchemas schema) {
        super(schema, ConstantesXADES.XADES_TAG_EXPLICIT_TEXT);
    }

}
