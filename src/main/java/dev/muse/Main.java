package dev.muse;

import dev.muse.localnamespace.ClassA;

public class Main {

    public static void main(String[] args) {

        ClassA classA = new ClassA();
        classA.entryPoint();

        ClassB classB = new ClassB();
        classB.sourceMethod("very sensitive data");

        sinkSource("a");
        sourceSink("b");

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

    static String sinkSource(String userString) {
        String n = mainSrc(userString);
        return mainSink(n);
    }

    static String sourceSink(String userString) {
        String n = mainSink(userString);
        return mainSrc(n);
    }

    private static void mainSanitizer(String userString) {
        userString.replaceAll("/", ".");
    }
}
