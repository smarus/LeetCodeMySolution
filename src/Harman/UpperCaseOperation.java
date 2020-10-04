package Harman;

public class UpperCaseOperation implements Operation {
    @Override
    public String operation(String input) {
        return input.toUpperCase();
    }
}
