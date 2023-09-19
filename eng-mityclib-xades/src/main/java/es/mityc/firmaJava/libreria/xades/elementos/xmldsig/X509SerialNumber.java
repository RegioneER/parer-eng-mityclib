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

import java.math.BigInteger;

import es.mityc.firmaJava.libreria.ConstantesXADES;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class X509SerialNumber extends AbstractXDsigIntegerElement {

    /**
     * @param data
     */
    public X509SerialNumber(BigInteger data) {
        super(ConstantesXADES.X_509_SERIAL_NUMBER, data);
    }

    public X509SerialNumber() {
        super(ConstantesXADES.X_509_SERIAL_NUMBER);
    }

}
