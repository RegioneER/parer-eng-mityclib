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

import java.math.BigInteger;

import javax.security.auth.x500.X500Principal;

/**
 * Clase encargada de almacenar informacion referida a los certificados X509Certificate
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 0.9 beta
 */

public class DatosX509 {

    private String algMethod = null;
    private String digestValue = null;
    private BigInteger serial = null;
    private X500Principal issuer = null;

    public DatosX509() {
    }

    /**
     * @param algMethod
     *            Método de calculo de digest
     * @param digestvalue
     *            Es el valor de digest del certificado utilizando el algoritmo referido
     * @param serial
     *            Es el número de serie del certificado
     * @param issuer
     *            Es el nombre del emisor del certificado
     */
    public DatosX509(String algMethod, String digestValue, BigInteger serial, X500Principal issuer) {
        this.algMethod = algMethod;
        this.digestValue = digestValue;
        this.serial = serial;
        this.issuer = issuer;
    }

    /**
     * @return algMethod
     */
    public String getAlgMethod() {
        return algMethod;
    }

    /**
     * @param algMethod
     */
    public void setAlgMethod(String algMethod) {
        this.algMethod = algMethod;
    }

    /**
     * @return digestValue
     */
    public String getDigestValue() {
        return digestValue;
    }

    /**
     * @param digestValue
     */
    public void setDigestValue(String digestValue) {
        this.digestValue = digestValue;
    }

    /**
     * @return issuer
     */
    public X500Principal getIssuer() {
        return issuer;
    }

    /**
     * @param issuer
     */
    public void setIssuer(X500Principal issuer) {
        this.issuer = issuer;
    }

    /**
     * @return serial
     */
    public BigInteger getSerial() {
        return serial;
    }

    /**
     * @param serial
     */
    public void setSerial(BigInteger serial) {
        this.serial = serial;
    }
}
