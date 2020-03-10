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

    private static void mainSrc(String userString) {
        mainSink(userString);
        mainSanitizer(userString);
    }

    private static void mainSink(String userString) {
        System.out.println(userString);

    }

    private static void mainSanitizer(String userString) {
        userString.replaceAll("/", ".");
    }
}
