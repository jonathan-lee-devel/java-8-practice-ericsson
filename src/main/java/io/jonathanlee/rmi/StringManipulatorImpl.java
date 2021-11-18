package io.jonathanlee.rmi;

public class StringManipulatorImpl implements StringManipulator {

    @Override
    public String convertToUpper(String string) {
        return string.toUpperCase();
    }

}
