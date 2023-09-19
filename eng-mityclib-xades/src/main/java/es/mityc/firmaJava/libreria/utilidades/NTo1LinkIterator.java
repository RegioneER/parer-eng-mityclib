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

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NTo1LinkIterator<E> implements Iterator<NTo1Link<E>> {

    private NTo1Link<E> nextNode;

    NTo1LinkIterator(NTo1Link<E> first) {
        nextNode = first;
    }

    public boolean hasNext() {
        return (nextNode != null);
    }

    public NTo1Link<E> next() {
        if (nextNode == null)
            throw new NoSuchElementException();
        NTo1Link<E> node = nextNode;
        nextNode = nextNode.getNext();
        return node;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

}
