package Harman;

public class LowerCaseOperation implements Operation {
    @Override
    public String operation(String input) {
        return input.toLowerCase();
    }
}
