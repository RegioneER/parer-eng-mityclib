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

package es.mityc.javasign.i18n;

import java.util.Locale;

/**
 * <p>
 * Soporte de internacionalizador cacheado.
 * </p>
 * <p>
 * Permite optimizar el acceso a internacionalizadores cacheando un manager de un diccionario con el locale relativo.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
class ManagerCached {
    /** Manager de internacionalizacion. */
    private II18nManager managerCached;
    /** Locale del internacionalizador. */
    private Locale localeCached;

    /**
     * <p>
     * Constructor.
     * </p>
     * 
     * @param manager
     *            Manager de internacionalizacion
     * @param i18nLocale
     *            Locale del manager
     */
    public ManagerCached(final II18nManager manager, final Locale i18nLocale) {
        this.managerCached = manager;
        this.localeCached = i18nLocale;
    }

    /**
     * <p>
     * Devuelve si el locale indicado es el mismo que el del manager cacheado.
     * </p>
     * 
     * @param otherLocale
     *            Localizador a comparar
     * 
     * @return <code>true</code> si es el mismo locale, <code>false</code> en otro caso
     */
    public boolean isSameLocale(final Locale otherLocale) {
        if (otherLocale == null) {
            if (this.localeCached == null) {
                return true;
            }
            return false;
        }
        return otherLocale.equals(this.localeCached);
    }

    /**
     * <p>
     * Devuelve el manager asociado a esta caché.
     * </p>
     * 
     * @return internacionalizador
     */
    public II18nManager getI18nCached() {
        return managerCached;
    }
}
