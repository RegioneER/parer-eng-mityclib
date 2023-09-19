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

/**
 * <http://www.gnu.org/licenses/>.
 * 
 * Copyright 2008 Ministerio de Industria, Turismo y Comercio
 *
 */

package es.mityc.firmaJava.libreria.utilidades;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase para enlazar objetos del tipo (0..n) -> (0..1)
 *
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 0.9 beta
 */
public class NTo1Link<E> implements Iterable<NTo1Link<E>> {

    private ArrayList<NTo1Link<E>> prevs;
    private NTo1Link<E> next;
    private E data;

    public NTo1Link(E obj) {
        data = obj;
    }

    @Override
    public boolean equals(Object obj) {
        Object comp = obj;
        if (obj instanceof NTo1Link) {
            comp = ((NTo1Link) obj).getData();
        }
        if ((comp != null) && (comp.equals(data))) {
            return true;
        }
        return false;
    }

    /**
     * Establece el dato
     * 
     * @param obj
     *            dato que se enlaza, <code>null</code> si no hay ninguno
     */
    public void setData(E obj) {
        data = obj;
    }

    /**
     * Devuelve el dato que se enlaza
     * 
     * @return
     */
    public E getData() {
        return data;
    }

    /**
     * Añade un nuevo enlace hacia este objeto
     * 
     * @param node
     */
    public void addPrev(NTo1Link<E> node) {
        if (prevs == null)
            prevs = new ArrayList<NTo1Link<E>>();
        prevs.add(node);
    }

    /**
     * Devuelve un <code>Iterator</code> a los elementos que enlazan a este elemento.
     * 
     * @return iterator a elementos que enlazan a este elemento, <code>null</code> si no hay ninguno
     */
    public Iterator<NTo1Link<E>> getPrevs() {
        if (prevs != null)
            return prevs.iterator();
        return null;
    }

    /**
     * Devuelve el número de elementos que enlazan a este elemento
     * 
     * @return
     */
    public int getNumPrevs() {
        if (prevs != null)
            return prevs.size();
        return 0;
    }

    /**
     * Establece el enlace hacia el siguiente elemento.
     * 
     * @param node
     *            Siguiente elemento, <code>null</code> si no se quiere enlazar ningún elemento
     */
    public void setNext(NTo1Link<E> node) {
        next = node;
    }

    /**
     * Devuelve el siguiente elemento
     * 
     * @return
     */
    public NTo1Link<E> getNext() {
        return next;
    }

    public Iterator<NTo1Link<E>> iterator() {
        return new NTo1LinkIterator<E>(this);
    }

}
