package dev.muse;

import dev.muse.localnamespace.ClassA;

public class Main {

    public static void main(String[] args) {

        ClassA classA = new ClassA();
        classA.entryPoint();

        ClassB classB = new ClassB();
        classB.sourceMethod("very sensitive data");

        callSourceAndSinkBad1("x");
        callSourceAndSinkBad1("y");
    }

    static String mainSrc() {
        return "val";
    }

    static void mainSink(String userString) {
        System.out.print(userString);
    }

    private static void mainSanitizer(String userString) {
        userString.replaceAll("/", ".");
    }

    static void sourceAndSink(String s) {
        mainSink(s);
        s = mainSrc();
    }

    static void callSourceAndSinkOk(String s) {
        sourceAndSink(s);
    }

    static void callSourceAndSinkBad1(String s) {
        sourceAndSink(s);
        mainSink(s);
    }


    static void callSourceAndSinkBad2(String s) {
        s = mainSrc();
        sourceAndSink(s);
    }
}
