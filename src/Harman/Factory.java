package Harman;

public class Factory {

    public Operation getOperation(String type) {
        if (type.equals("LOWER")) {
            return new LowerCaseOperation();
        } else {
            return new UpperCaseOperation();
        }
    }
}
