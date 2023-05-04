package org.example;

/**
 * why do we need generics?
 * ==> to create type-safety objects | methods | functions
 */

interface Subject {
}

class Java implements Subject {
}

class JavaScript implements Subject {
}

class Python implements Subject {
}

class Ruby implements Subject {
}

class Trainer<T extends Subject> {
    T subject;

    public void setSubject(T subject) {
        this.subject = subject;
    }

    public T getSubject() {
        return subject;
    }
}

public class Generics_Ex {
    public static void main(String[] args) {

        Trainer<Java> javaTrainer = new Trainer<>();
        javaTrainer.setSubject(new Java());

        //------------------------------------------------------

//        javaTrainer.setSubject(new JavaScript());

        //------------------------------------------------------
        // a room where we need java training
        //------------------------------------------------------

        Java java = javaTrainer.getSubject();
        System.out.println("Happy Learning Java");

        //------------------------------------------------------


    }
}
