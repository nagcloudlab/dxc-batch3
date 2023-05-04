package org.example;

/*
    java.lang.String
    java.lang.StringBuffer
    java.lang.StringBuilder
 */

public class How_Handle_Strings {
    public static void main(String[] args) {

        // Immutable string
        String s1 = "dxc";
        String s11 = "dxc";
        System.out.println(s1 == s11);

        //------------------------------------------

        // Mutable string
        StringBuffer sb = new StringBuffer("dxc"); // thread safe  -> slow
        sb.append("-chennai");
        System.out.println(sb.toString());

        //------------------------------------------

        // Mutable + non-synchronized
        StringBuilder sb1 = new StringBuilder("dxc");
        sb1.append("-chennai");
        System.out.println(sb1.toString());

    }
}
