package dev.muse;

import com.google.common.base.Joiner;

public class ClassB {

    public void sourceMethod(String userInput) {
        path1(userInput);
        path2(userInput);
        path3(userInput);
        path4();
        path5(userInput, false);
    }

    private void sinkMethod(String data) {
        System.out.println("Here's the data: " + data);
    }

    private String sanitizeMethod(String data) {
        return data.replaceAll("sensitive", "safe");
    }

    // No sanitizer
    private void path1(String data) {
        sinkMethod(data);
    }

    // Sanitizer
    private void path2(String data) {
        sinkMethod(sanitizeMethod(data));
    }

    // One hop sanitizer
    private void path3(String data) {
        path2(data);
    }

    // No dataflow
    private void path4() {
        sinkMethod("non-user data");
    }

    // No control flow
    private void path5(String data, boolean doOutput) {
        if(doOutput) {
            sinkMethod(data);
        }
    }
}
