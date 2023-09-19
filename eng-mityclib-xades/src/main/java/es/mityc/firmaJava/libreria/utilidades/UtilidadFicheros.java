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

package es.mityc.firmaJava.libreria.utilidades;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author dsantose
 *
 */
public class UtilidadFicheros {

    public static byte[] readFile(File file) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            int length = (int) file.length();
            ByteArrayOutputStream baos = new ByteArrayOutputStream(length);
            byte[] buffer = new byte[4096];
            int i = 0;
            while (i < length) {
                int j = fis.read(buffer);
                baos.write(buffer, 0, j);
                i += j;
            }
            return baos.toByteArray();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                }
            }
        }
        return null;
    }

    /**
     * <p>
     * Devuelve la ruta a un fichero relativa a la base indicada.
     * </p>
     * 
     * @param baseUri
     *            Base sobre la que se relativiza la ruta
     * @param file
     *            Fichero del que se calcula la ruta
     * 
     * @return ruta relativizada
     */
    public static String relativizeRute(String baseUri, File file) {
        String strFile = null;
        try {
            URI relative = new URI(URIEncoder.encode(baseUri, "UTF-8"));
            URI uri = file.toURI();// new URI("file:///" + URIEncoder.encode(file.getAbsolutePath().replace("\\", "/"),
                                   // "UTF-8"));
            strFile = URIEncoder.relativize(relative.toString(), uri.toString());
        } catch (UnsupportedEncodingException e) {
            // try {
            strFile = file.toURI().toString();// "file:///" + URIEncoder.encode(file.getAbsolutePath().replace("\\",
                                              // "/"), "UTF-8");
            // } catch (UnsupportedEncodingException ex) {
            // // TODO: lanzar aviso
            // }
        } catch (URISyntaxException e) {
            // try {
            strFile = file.toURI().toString();// "file:///" + URIEncoder.encode(file.getAbsolutePath().replace("\\",
                                              // "/"), "UTF-8");
            // strFile = "file:///" + URIEncoder.encode(file.getAbsolutePath().replace("\\", "/"), "UTF-8");
            // } catch (UnsupportedEncodingException ex) {
            // // TODO: lanzar aviso
            // }
        }

        return strFile;
    }

}
