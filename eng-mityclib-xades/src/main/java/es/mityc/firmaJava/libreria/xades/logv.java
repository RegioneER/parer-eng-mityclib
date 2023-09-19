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

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import es.mityc.firmaJava.libreria.ConstantesXADES;

/**
 * Esquemas de firma XAdES
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0 beta
 */
public class logv {

    private static BufferedOutputStream f = null;
    private static boolean tieneError = false;
    private static StringBuffer logsstart = null;
    private static StringBuffer logsend = null;
    private static StringBuffer logsb = null;

    // nombreFile: xml a validar
    static void createFile(String nombreFile) {

        return;

        // String nombreFirma = (nombreFile.substring(nombreFile.lastIndexOf("\\"))).substring(1);
        // String rutaFirma = nombreFile.substring(0, nombreFile.lastIndexOf("\\"));
        // String nombreParticipante = "MIG";//(rutaFirma.substring(rutaFirma.lastIndexOf("\\"))).substring(1);
        // String nombreFichero = "./Verification_of_" + nombreParticipante + "_" + nombreFirma;
        //
        // tieneError = false;
        //
        // try {
        // f = new BufferedOutputStream(new FileOutputStream(nombreFichero));
        // logsb = new StringBuffer("");
        // logsstart = new StringBuffer("");
        // logsend = new StringBuffer("");
        //
        // } catch (FileNotFoundException e) {
        // System.out.println("No se puede guardar el fichero" + ConstantesXADES.ESPACIO + e.getMessage());
        // }
    }

    static void cierraLog() {

        return;

        // String rootnode = (tieneError)?"Failed":"Verified";
        //
        // logsstart.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        // logsstart.append("<" + rootnode + ">");
        // logsend.append("\n</" + rootnode + ">");
        //
        // try {
        //
        // f.write(logsstart.toString().getBytes());
        // f.write(logsb.toString().getBytes());
        // f.write(logsend.toString().getBytes());
        //
        // } catch (IOException e) {
        // System.out.println("Error al escribir el fichero de verificacion " + e.getMessage());
        // } finally {
        // try {
        // f.flush();
        // f.close();
        // } catch (IOException e) {
        // System.out.println(e.getMessage());
        // }
        // }
    }

    static void error(String error) {
        return;
        // tieneError = true;
        // logsb.append("\n\t<Failed>\n" + "\t\t" + error + "\n\t</Failed>");
    }

    static void info(String info) {
        return;
        // logsb.append("\n\t<Verified>\n" + "\t\t" + info + "\n\t</Verified>");
    }

    static void error(String error, int tabs) {
        return;
        // tieneError = true;
        // if (tabs == 0 || tabs == 1)
        // logsb.append("\n\t<Failed>\n" + "\t\t" + error + "\n\t</Failed>");
        // else if (tabs == 2)
        // logsb.append("\n\t\t" + error);
        // else if (tabs == 3)
        // logsb.append("\n\t\t\t" + error);
        // else {
        // System.out.println("Error.- El numero de tabulaciones va de 0 a 3");
        // logsb.append("\n\t<Failed>\n" + "\t\t" + error + "\n\t</Failed>");
        // }
    }

    static void info(String info, int tabs) {
        return;
        // if (tabs == 0 || tabs == 1)
        // logsb.append("\n\t<Verified>\n" + "\t\t" + info + "\n\t</Verified>");
        // else if (tabs == 2)
        // logsb.append("\n\t\t" + info);
        // else if (tabs == 3)
        // logsb.append("\n\t\t\t" + info);
        // else {
        // System.out.println("Error.- El numero de tabulaciones va de 0 a 3");
        // logsb.append("\n\t<Verified>\n" + "\t\t" + info + "\n\t</Verified>");
        // }
    }

    static void abreTag(boolean resultado) {
        return;
        // if (resultado)
        // logsb.append("\n\t<Verified>");
        // else
        // logsb.append("\n\t<Failed>");
    }

    static void cierraTag(boolean resultado) {
        return;
        // if (resultado)
        // logsb.append("\n\t</Verified>");
        // else
        // logsb.append("\n\t</Failed>");
    }
}
