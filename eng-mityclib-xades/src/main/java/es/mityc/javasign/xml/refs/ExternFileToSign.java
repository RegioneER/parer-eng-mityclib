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

import java.io.File;

import es.mityc.firmaJava.libreria.utilidades.UtilidadFicheros;

/**
 * Representa un objeto externo (en forma de fichero) al XML que debe ser firmado.
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class ExternFileToSign extends AbstractObjectToSign {

    private File file;
    /** BaseUri de la firma donde ira este objeto. */
    private String base;

    public ExternFileToSign(File file, String baseUri) {
        this.file = file;
        this.base = baseUri;
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file
     *            the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * @see es.mityc.javasign.xml.refs.AbstractObjectToSign#getReferenceURI()
     */
    @Override
    public String getReferenceURI() {
        return UtilidadFicheros.relativizeRute(base, file);
    }
}
