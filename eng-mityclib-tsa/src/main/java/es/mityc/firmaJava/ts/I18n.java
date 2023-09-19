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

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * <p>
 * Clase que permite la internacionalizacion de las cadenas de texto de la aplicacion.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class I18n implements ConstantesTSA {

    /** Internacionalizacion. */
    private static Locale locale = new Locale(ES_MINUSCULA, ES_MAYUSCULA);

    /**
     * <p>
     * Obtiene el valor de una cadena definida para el idioma por defecto configurado.
     * </p>
     * 
     * @param key
     *            Clave que identifica la cadena de texto
     * 
     * @return cadena traducida para un determinado idioma
     */
    public static String getResource(final String key) {
        return getResource(key, locale);
    }

    /**
     * <p>
     * Obtiene el valor de una cadena definida para el idioma pasado por parametro en el Locale.
     * </p>
     * 
     * @param key
     *            Clave que identifica la cadena de texto
     * @param locale
     *            Locale del idioma del cual queremos la traduccion
     * 
     * @return cadena traducida para un determinado idioma
     */
    public static String getResource(final String key, final Locale locale) {
        return ResourceBundle.getBundle(NOMBRE_LIBRERIA, locale).getString(key);
    }

    /**
     * <p>
     * Obtiene el Locale que se utiliza en ese momento.
     * </p>
     * 
     * @return Locale que se utiliza en ese momento
     */
    public static Locale getLocale() {
        return locale;
    }

    /**
     * <p>
     * Asigna el Locale que se utilizara en las traducciones.
     * </p>
     * 
     * @param _locale
     *            Locale que se utilizara en las traducciones
     */
    public static void setLocale(final Locale _locale) {
        locale = _locale;
    }

    /**
     * <p>
     * Asigna el Locale que se utilizara en las traducciones.
     * </p>
     * 
     * @param country
     *            Pais
     * @param dialect
     *            Dialecto del idioma
     */
    public static void setLocaleCountry(final String country, final String dialect) {
        locale = new Locale(country, dialect);
    }
}
