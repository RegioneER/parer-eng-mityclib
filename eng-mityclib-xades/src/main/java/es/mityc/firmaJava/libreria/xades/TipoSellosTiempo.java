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

import es.mityc.firmaJava.libreria.ConstantesXADES;

/**
 * Esquemas de firma XAdES
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0 beta
 */

public enum TipoSellosTiempo {

    CLASE_T(ConstantesXADES.LITERAL_CLASE_T), CLASE_X_TIPO_1(ConstantesXADES.LITERAL_CLASE_X_TIPO_1),
    CLASE_X_TIPO_2(ConstantesXADES.LITERAL_CLASE_X_TIPO_2), CLASE_A(ConstantesXADES.LITERAL_CLASE_A);

    private String name;

    private TipoSellosTiempo(String name) {
        this.name = name;
    }

    public String getTipoSello() {
        return name;
    }
}
