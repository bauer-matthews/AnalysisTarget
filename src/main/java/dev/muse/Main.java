package dev.muse;

import dev.muse.localnamespace.ClassA;

public class Main {

    public static void main(String[] args) {

        ClassA classA = new ClassA();
        classA.entryPoint();

        ClassB classB = new ClassB();
        classB.sourceMethod("very sensitive data");

        mainSrc("A sensitive string");
    }

    static String mainSrc(String userString) {
        return mainSink(userString);
        //mainSanitizer(userString);
    }

    static String mainSink(String userString) {
        System.out.println(userString);
        return userString;
    }

    private static void mainSanitizer(String userString) {
        userString.replaceAll("/", ".");
    }
}
