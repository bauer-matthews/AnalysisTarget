package dev.muse;

import dev.muse.localnamespace.ClassA;

public class Main {

    public static void main(String[] args) {

        ClassA classA = new ClassA();
        classA.entryPoint();



        ClassB classB = new ClassB();
        classB.sourceMethod("very sensitive data");
    }
}
