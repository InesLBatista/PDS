package behavioral.iterator;

interface Iterator<T> {
    boolean hasNext();
    T next();
    void remove();
}
