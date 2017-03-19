package java_test_source;

import java.util.Map;

/**
 * Hello World is old school
 *
 * Created by Sundeep on 1/8/2016.
 */
public class HelloUniverse {

    public static final String greeting = "hello";
    private boolean bigger = false;
    private Map<String, String> someMap;

    public static void main(String[] args) {
        System.out.println("Hello Universe!");
    }

    public static String noArgs() {
        System.out.println("No Args");
    }

    public static void TwoArgs(String str, int x) {
        System.out.println(str + x);
    }
}
