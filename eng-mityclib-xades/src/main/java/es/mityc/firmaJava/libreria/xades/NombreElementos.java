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
 * @version 0.9 beta
 */

public class NombreElementos {
    private String nameFileOCSPResp = null;
    private String nameFileCRLResp = null;
    private String nameFileX509Cert = null;

    public NombreElementos() {
        // No hace nada
    }

    public String getNameFileOCSPResp() {
        return nameFileOCSPResp;
    }

    public String getNameFileX509Cert() {
        return nameFileX509Cert;
    }

    public void setNameFileOCSPResp(String name) {
        this.nameFileOCSPResp = name;
    }

    public void setNameFileX509Cert(String name) {
        this.nameFileX509Cert = name;
    }

    public String getNameFileCRLResp() {
        return nameFileCRLResp;
    }

    public void setNameFileCRLResp(String nameFileCRLResp) {
        this.nameFileCRLResp = nameFileCRLResp;
    }

}
