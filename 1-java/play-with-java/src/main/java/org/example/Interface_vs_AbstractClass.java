package org.example;

/**
 * Author : Nag
 */

//------------------------------------------------
// Top-Level : 100% Abstractions with 'interface' type
//------------------------------------------------

interface Collection {

    // Constant State . static final variables
    // No construction logic

    void add(Object o);

    void remove(Object o);

    boolean contains(Object o);

    int size();

    void clear();

    default void forEach() {
        //..
    }
}

interface List extends Collection {
    void add(int index, Object o);

    void remove(int index);
}

//-----------------------------------------------------------
// Middle-Level : Partial Implementations with Abstract class
//-----------------------------------------------------------

abstract class AbstractList implements List {

    // Mutable state
    // Has constructor logic

    //abstract void xx();

    public void clear() {
        //..
    }
}

//-----------------------------------------------------------
// Bottom-Level : complete implementation
//-----------------------------------------------------------

//using 'array' data-structure
class ArrayList extends AbstractList implements List {

    @Override
    public void add(Object o) {

    }

    @Override
    public void remove(Object o) {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(int index, Object o) {

    }

    @Override
    public void remove(int index) {

    }
}

//using 'linkedlist' data-structure
class LinkedList extends AbstractList implements List {
    @Override
    public void add(Object o) {

    }

    @Override
    public void remove(Object o) {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(int index, Object o) {

    }

    @Override
    public void remove(int index) {

    }
}


public class Interface_vs_AbstractClass {
    public static void main(String[] args) {

        List list = new ArrayList();
        list = new LinkedList();

    }
}