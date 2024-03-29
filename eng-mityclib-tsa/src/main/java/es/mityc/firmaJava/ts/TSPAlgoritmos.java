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

package es.mityc.firmaJava.ts;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bouncycastle.tsp.TSPAlgorithms;

/**
 * <p>
 * Clase con los algortimos de codificacion permitidos para el sellado de tiempo.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class TSPAlgoritmos {

    /**
     * <p>
     * Devuelve una lista de algoritmos de sellado de tiempo aceptados.
     * </p>
     * 
     * @return Lista de algoritmos
     */
    public static Set<String> getPermitidos() {
        Set<String> permitidos = new HashSet<String>(Arrays.asList(getValoresPermitidos()));

        return permitidos;
    }

    /**
     * <p>
     * Resuelve el nombre del algortimo de digest a partir del OID.
     * </p>
     * 
     * @param oid
     *            OID del algortimo buscado
     * 
     * @return Nopmbre del algoritmo, o el OID proveído en caso de no poder ser resuelto
     */
    public static String getAlgName(final String oid) {
        if (TSPAlgorithms.SHA1.equals(oid)) {
            return ConstantesTSA.SHA1;
        } else if (TSPAlgorithms.SHA256.equals(oid)) {
            return ConstantesTSA.SHA2;
        } else if (TSPAlgorithms.SHA224.equals(oid)) {
            return ConstantesTSA.SHA224;
        } else if (TSPAlgorithms.SHA256.equals(oid)) {
            return ConstantesTSA.SHA256;
        } else if (TSPAlgorithms.SHA384.equals(oid)) {
            return ConstantesTSA.SHA384;
        } else if (TSPAlgorithms.SHA512.equals(oid)) {
            return ConstantesTSA.SHA512;
        }

        return oid;
    }

    /**
     * <p>
     * Resuelve el OID del algoritmo de Digest a partir del nombre.
     * </p>
     * 
     * @param algoritmo
     *            Nombre del algoritmo buscado
     * 
     * @return El OID del algoritmo, o <code>null</code> si no pudo resolverse
     */
    public static String getOID(final String algoritmo) {
        Set<String> permitidos = new HashSet<String>(Arrays.asList(getValoresPermitidos()));

        if (permitidos.contains(algoritmo)) {
            if (ConstantesTSA.SHA1.equals(algoritmo)) {
                return TSPAlgorithms.SHA1;
            } else if (ConstantesTSA.SHA2.equals(algoritmo)) {
                return TSPAlgorithms.SHA256;
            } else if (ConstantesTSA.SHA224.equals(algoritmo)) {
                return TSPAlgorithms.SHA224;
            } else if (ConstantesTSA.SHA256.equals(algoritmo)) {
                return TSPAlgorithms.SHA256;
            } else if (ConstantesTSA.SHA384.equals(algoritmo)) {
                return TSPAlgorithms.SHA384;
            } else if (ConstantesTSA.SHA512.equals(algoritmo)) {
                return TSPAlgorithms.SHA512;
            }
        }

        return null;
    }

    /**
     * <p>
     * Correspondencia entre nombre de algoritmo y OID.
     * </p>
     */
    private static HashMap<String, String> algoritmosVSoids = null;
    static {
        algoritmosVSoids = new HashMap<String, String>();

        algoritmosVSoids.put(TSPAlgorithms.SHA1, ConstantesTSA.SHA1);
        algoritmosVSoids.put(TSPAlgorithms.SHA224, ConstantesTSA.SHA224);
        algoritmosVSoids.put(TSPAlgorithms.SHA256, ConstantesTSA.SHA256);
        algoritmosVSoids.put(TSPAlgorithms.SHA384, ConstantesTSA.SHA384);
        algoritmosVSoids.put(TSPAlgorithms.SHA512, ConstantesTSA.SHA512);
        algoritmosVSoids.put(TSPAlgorithms.MD5, ConstantesTSA.MD5);
    }

    /**
     * Devuelve el algoritmo de digest asociado con el OID de algoritmo de digest indicado.
     * 
     * @param oid
     *            Cadena de texto con el OID del algoritmo
     * 
     * @return MessageDigest del OID indicado, o <code>null</code> si no se dispone de un algoritmo de digest asociado
     *         al OID indicado.
     */
    public static MessageDigest getDigest(final String oid) {
        String algName = algoritmosVSoids.get(oid);
        if (algName == null) {
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance(algName);
            return md;
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * <p>
     * Devuelve un array con los valores permitidos de algoritmos de Digest.
     * </p>
     * 
     * @return Array de Strings con os valores permitidos
     */
    public static String[] getValoresPermitidos() {
        String[] valoresPermitidos = new String[6];
        valoresPermitidos[0] = ConstantesTSA.SHA1;
        valoresPermitidos[1] = ConstantesTSA.SHA2;
        valoresPermitidos[2] = ConstantesTSA.SHA224;
        valoresPermitidos[3] = ConstantesTSA.SHA256;
        valoresPermitidos[4] = ConstantesTSA.SHA384;
        valoresPermitidos[5] = ConstantesTSA.SHA512;

        return valoresPermitidos;
    }
}
