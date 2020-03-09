package dev.muse;

import dev.muse.localnamespace.ClassA;

public class Main {

    public static void main(String[] args) {

        ClassA classA = new ClassA();
        //classA.calledMethodA();
        classA.testEntrypoint(10);



        ClassB classB = new ClassB();
        classB.sourceMethod("very sensitive data");
    }
}
