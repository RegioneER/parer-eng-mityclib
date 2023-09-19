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

/**
 * Convierte Array de bytes a Hexadecimal
 *
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 0.9 beta
 */

public class ByteArrayAHex {

    final private static char[] NIBBLE = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
            'f', };

    /**
     * Devuelve la cadena en Hexadecimal
     * 
     * @param buf
     * @param i
     * @param longitud
     * 
     * @return
     */
    public static final String hexString(byte[] buf, int i, int longitud) {
        StringBuffer sb = new StringBuffer();
        for (int j = i; j < i + longitud; j++) {
            sb.append(NIBBLE[(buf[j] >>> 4) & 15]);
            sb.append(NIBBLE[buf[j] & 15]);
        }
        return String.valueOf(sb);
    }

    /**
     * Devuelve la cadena en hexadecimal
     * 
     * @param buf
     * 
     * @return
     */
    public static final String hexString(byte[] buf) {
        return hexString(buf, 0, buf.length);
    }

    /**
     * 
     * @param n
     * 
     * @return
     */
    public static byte fromHexNibble(char n) {
        if (n <= '9')
            return (byte) (n - '0');
        if (n <= 'G')
            return (byte) (n - ('A' - 10));
        return (byte) (n - ('a' - 10));
    }

    /**
     * Convierte una cadena de digitos hexadecimales a un array de bytes
     * 
     * @param hex
     */
    public static byte[] fromHexString(String hex) {
        int l = (hex.length() + 1) >>> 1;
        byte[] r = new byte[l];
        int i = 0;
        int j = 0;
        if (hex.length() % 2 != 0) {
            // Número impar de caracteres: debe manejar medio byte primero.
            r[0] = fromHexNibble(hex.charAt(0));
            i = j = 1;
        }
        while (i < l)
            r[i++] = (byte) ((fromHexNibble(hex.charAt(j++)) << 4) | fromHexNibble(hex.charAt(j++)));
        return r;
    }

    /**
     * Concatena 2 arrays de bytes
     */
    public static byte[] concatByteArrays(byte[] array1, byte[] array2) {

        if (array1.length == 0)
            return array2;
        else if (array2.length == 0)
            return array1;
        else {
            int logitudFinal = array1.length + array2.length;
            byte[] arrayCombinado = new byte[logitudFinal];
            // añadir primer array
            // for(int i=0; i<array1.length; i++)
            // {
            // System.arraycopy(arrayCombinado, 0, array1, 0, array1.length);
            System.arraycopy(array1, 0, arrayCombinado, 0, array1.length);
            // arrayCombinado[i] = array1[i];
            // }
            // añadir segundo array
            // int b = 0;
            // for(int i=array1.length; i<logitudFinal; i++)
            // {
            // arrayCombinado[i] = array2[b];
            // b++;
            // }
            // System.arraycopy(arrayCombinado, array1.length, array2, 0, logitudFinal);
            System.arraycopy(array2, 0, arrayCombinado, array1.length, array2.length);

            return arrayCombinado;
        }
    }
}
