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

import java.util.Locale;
import java.util.ResourceBundle;

import es.mityc.firmaJava.libreria.ConstantesXADES;

/**
 * Clase que permite la internacionalizacion de las cadenas de texto de la aplicacion
 *
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 0.9 beta
 */
public class I18n {

    private static Locale locale = new Locale(ConstantesXADES.DEFAULT_LOCALE,
            ConstantesXADES.DEFAULT_LOCALE.toUpperCase());

    /**
     * Obtiene el valor de una cadena definida para el idioma por defecto configurado
     * 
     * @param clave
     *            Clave que identifica la cadena de texto
     * 
     * @return cadena traducida para un determinado idioma
     */
    public static String getResource(String clave) {
        return getResource(clave, locale);
    }

    /**
     * Obtiene el valor de una cadena definida para el idioma pasado por parametro en el Locale
     * 
     * @param clave
     *            Clave que identifica la cadena de texto
     * @param locale
     *            Locale del idioma del cual queremos la traduccion
     * 
     * @return cadena traducida para un determinado idioma
     */
    public static String getResource(String clave, Locale locale) {
        return ResourceBundle.getBundle(ConstantesXADES.LOCALE_FILES, locale).getString(clave);
    }

    /**
     * Obtiene el Locale que se utiliza en ese momento
     * 
     * @return Locale que se utiliza en ese momento
     */
    public static Locale getLocale() {
        return locale;
    }

    /**
     * Asigna el Locale que se utilizara en las traducciones
     * 
     * @param locale
     *            Locale que se utilizara en las traducciones
     */
    // public static void setLocale(Locale _locale)
    // {
    // locale = _locale;
    // }
    //

    /**
     * Asigna el Locale que se utilizara en las traducciones
     * 
     * @param pais
     *            Pais
     * @param dialecto
     *            Dialecto del idioma
     */
    public static void setLocale(String pais, String dialecto) {
        locale = new Locale(pais, dialecto);
    }

}
