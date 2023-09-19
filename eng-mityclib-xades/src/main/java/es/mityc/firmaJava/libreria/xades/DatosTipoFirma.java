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
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class DatosTipoFirma {

    private EnumFormatoFirma tipoXAdES = null;
    private boolean esXAdES_EPES = false;
    private boolean esXAdES_A = false;

    public DatosTipoFirma() {
    }

    /**
     * Almacena informacion referente al tipo de firma XAdES obtenido
     * 
     * @param tipoFirma
     *            .- Indica el nivel de firma (XAdES-BES, XAdES-T, etc...)
     * @param esXAdES_EPES
     *            .- Modificador que indica que la firma incluye políticas
     * @param esXAdES_A
     *            .- Modificador que indica que la firma incluye un sello de tiempo del tipo A
     */
    public DatosTipoFirma(EnumFormatoFirma tipoXAdES, boolean esXAdES_EPES, boolean esXAdES_A) {

        this.tipoXAdES = tipoXAdES;
        this.esXAdES_EPES = esXAdES_EPES;
        this.esXAdES_A = esXAdES_A;
    }

    public EnumFormatoFirma getTipoXAdES() {
        return tipoXAdES;
    }

    public void setTipoXAdES(EnumFormatoFirma tipoXAdES) {
        this.tipoXAdES = tipoXAdES;
    }

    public boolean esXAdES_EPES() {
        return esXAdES_EPES;
    }

    public void setEsXAdES_EPES(boolean esXAdES_EPES) {
        this.esXAdES_EPES = esXAdES_EPES;
    }

    public boolean esXAdES_A() {
        return esXAdES_A;
    }

    public void setEsXAdES_A(boolean esXAdES_A) {
        this.esXAdES_A = esXAdES_A;
    }
}
