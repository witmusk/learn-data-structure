public class ArrayList<E> {
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elements;

    public ArrayList(E... elements) {
        this.elements = new Object[elements.length];
        this.size = 0;
        for (E element : elements) {
            this.elements[size++] = element;
        }
    }

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public ArrayList(int size) {
        elements = new Object[size];
        this.size = size;
    }

    public int size() {
        return this.size;
    }

    public ArrayList<E> add(E e) {
        if (elements.length - size > 0) {
            elements[size++] = e;
            return this;
        }
        int newCapacity = this.grow(elements.length + 1);
        Object[] newElements = new Object[newCapacity];
        int idx = 0;
        for (Object o : elements) {
            newElements[idx++] = o;
        }
        newElements[size++] = e;
        Object[] oldElements = this.elements;
        this.elements = newElements;
        oldElements = null;
        newElements = null;
        return this;
    }

    public ArrayList<E> add(int i, E e) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("index " + i + "out of bounds, size:" + size);
        }

        if (elements.length - size > 0) {
            for (int idx = size; idx > i; idx--) {
                elements[idx] = elements[idx - 1];
            }
            elements[i] = e;
            size++;
            return this;
        }

        int newCapacity = this.grow(elements.length + 1);
        Object[] newElements = new Object[newCapacity];
        int idx = 0;
        for (Object o : elements) {
            if (idx == i) {
                newElements[idx++] = e;
            }
            newElements[idx++] = o;
        }
        size++;
        Object[] oldElements = this.elements;
        this.elements = newElements;
        oldElements = null;
        newElements = null;
        return this;
    }

    public E remove(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("index " + i + "out of bounds, size:" + size);
        }
        E e = (E) elements[i];

        //move elements backward from i+1 to size-2
        for (; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        //set last elements to null for gc, and decrease size
        elements[--size] = null;
        return e;
    }

    public boolean remove(E e) {
        if (e == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    this.remove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (e.equals(elements[i])) {
                    this.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("index " + i + "out of bounds, size:" + size);
        }
        return (E) elements[i];
    }

    public boolean set(int i, E e) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("index " + i + "out of bounds, size:" + size);
        }
        elements[i] = e;
        return true;
    }

    private int grow(int minCapacity) {
        int currentCapacity = elements.length;
        int newCapacity = currentCapacity + (currentCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            return minCapacity;
        }

        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            //overflows
            if (minCapacity < 0) {
                throw new OutOfMemoryError();
            }
            return minCapacity - MAX_ARRAY_SIZE > 0 ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
        }

        return newCapacity;
    }

    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>(0, 2, 3, 4, 5);
        intList.add(6);
        intList.add(1, 1);

    }
}
