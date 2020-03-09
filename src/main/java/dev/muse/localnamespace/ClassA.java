package dev.muse.localnamespace;

import com.google.common.base.Joiner;

public class ClassA {

    public void entryPoint() {
        intermediateMethod1();
        interMediateMethod2();
    }

    private void intermediateMethod1() {
        interMediateMethod2();
    }

    private void interMediateMethod2() {
        vulnerableMethod();
    }

    private void vulnerableMethod() {
    }

}
