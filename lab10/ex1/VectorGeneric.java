package Praticas.lab10.ex1;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class VectorGeneric<T> implements Iterable<T> {
    private T[] vec;   
    private int nElem;        
    private final static int ALLOC = 50;    
    private int dimVec = ALLOC;      
    
    @SuppressWarnings("unchecked")
    public VectorGeneric() {
        vec = (T[]) new Object[dimVec];
        nElem = 0;
    }
    
    public boolean addElem(T elem) {
        if (elem == null)
            return false;
        ensureSpace();
        vec[nElem++] = elem;
        return true;
    }
    
    private void ensureSpace() {
        if (nElem >= dimVec) {
            dimVec += ALLOC;
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[dimVec];
            System.arraycopy(vec, 0, newArray, 0, nElem);
            vec = newArray;
        }
    }
    
    public boolean removeElem(T elem) {
        for (int i = 0; i < nElem; i++) {
            if (vec[i].equals(elem)) {
                if (nElem - i - 1 > 0) // not last element
                    System.arraycopy(vec, i + 1, vec, i, nElem - i - 1);
                vec[--nElem] = null; // libertar último objecto para o GC
                return true;
            }
        }
        return false;
    }
    
    public int totalElem() {
        return nElem;
    }
    
    public T getElem(int i) {
        if (i < 0 || i >= nElem) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + nElem);
        }
        return vec[i];
    }

    // método iterador implementado
    // permite usar a classe em for-loops
    @Override
    public Iterator<T> iterator() {
        return new VectorIterator();
    }

    // retorna um listiterator que começa no início
    public ListIterator<T> listIterator() {
        return new VectorListIterator(0);
    }
    
    // retorna um listiterator que começa num índice específico
    public ListIterator<T> listIterator(int index) {
        if (index < 0 || index > nElem) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + nElem);
        }
        return new VectorListIterator(index);
    }

    // ITERATOR SIMPLES (VectorIterator)
    private class VectorIterator implements Iterator<T> {
        private int currentIndex = 0;
        private int lastReturned = -1;  // indica que next() ainda não foi chamado

        @Override
        public boolean hasNext() {
            return currentIndex < nElem;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = currentIndex;  // regista índice para possível remove()
            return vec[currentIndex++];
        }

        @Override
        public void remove() {
            if (lastReturned == -1) {
                throw new IllegalStateException();  // remove apenas depois do next()
            }
            
            // mesma lógica de removeElem mas apenas para o elemento lastReturned 
            System.arraycopy(vec, lastReturned + 1, vec, lastReturned, nElem - lastReturned - 1);
            vec[--nElem] = null;
            currentIndex--;  // ajusta o índice considerando a remoção
            lastReturned = -1;  // reset 
        }
    }

    // LISTITERATOR COMPLETO
    private class VectorListIterator implements ListIterator<T> {
        private int currentIndex;
        private int lastReturned = -1;

        public VectorListIterator(int index) {
            this.currentIndex = index;   // permite começar em qualquer índice válido
        }

        @Override
        public boolean hasNext() {
            return currentIndex < nElem;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = currentIndex;
            return vec[currentIndex++];  // incrementa após o retorno
        }

        @Override
        public boolean hasPrevious() {
            return currentIndex > 0;  
        }
    
        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            lastReturned = --currentIndex;  // decrementa antes de retornar
            return vec[currentIndex];
        }

        @Override
        public int nextIndex() {
            return currentIndex;  // retorna posição atual
        }

        @Override
        public int previousIndex() {
            return currentIndex - 1;  // -1 se estiver no início
        }

        @Override
        public void remove() {
            if (lastReturned == -1) {
                throw new IllegalStateException();
            }
            
            System.arraycopy(vec, lastReturned + 1, vec, lastReturned, nElem - lastReturned - 1);
            vec[--nElem] = null;
            
            // ajuste crítico: se removeu um elemento antes da posição atual
            if (lastReturned < currentIndex) {
                currentIndex--;
            }
            lastReturned = -1;
        }

        @Override
        public void set(T e) {
            if (lastReturned == -1) {
                throw new IllegalStateException();
            }
            if (e == null) {
                throw new NullPointerException();
            }
            vec[lastReturned] = e;
        }

        @Override
        public void add(T e) {
            if (e == null) {
                throw new NullPointerException();
            }
            
            ensureSpace();  // garante que há espaço suficiente
            
            // abre espaço no índice atual
            System.arraycopy(vec, currentIndex, vec, currentIndex + 1, nElem - currentIndex);
            vec[currentIndex] = e;
            nElem++;
            currentIndex++;  // move para posição após o elemento adicionado
            lastReturned = -1;  // reset - add() invalida último retorno
        }
    }
}