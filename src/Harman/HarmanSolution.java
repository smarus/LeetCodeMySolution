package Harman;

public class HarmanSolution {
    public static void main(String[] args) {
        String test = "Harman Connected Services";
        KotlinFactory factory = new KotlinFactory();
        System.out.println(factory.transpose(test, "LOWER"));
        System.out.println(factory.transpose(test, "UPPER"));

        String test1 = null;
        String test2 = "";

        if (factory.transpose(test1, "LOWER") == null) {
            System.out.println("String is null");
        }


        if (factory.transpose(test2, "UPPER") == null) {
            System.out.println("String is null test 2");
        }


    }


//    private static String transpose(String input , String type){
//
//        if ( input == null || input.length() == 0){
//            return null;
//        }
//        Factory factory = new Factory();
//        Operation operation = factory.getOperation(type);
//        return operation.operation(input);
//    }


    private static void capitalize(String words) {
        words = words.toUpperCase();
    }

    private static void removeChar(String words) {
        words = words.replace("a", "");
    }

    private static String reverseString(String words) {
        StringBuilder sb = new StringBuilder(words);
        return sb.reverse().toString();
    }
}


