package com.rayschade;

import java.util.Scanner;

public class AlgebraApp {
    public static void main(String[] argv) {
        AlgebraHandleMethod method;
        System.out.println("Y for interactive mode, N for file mode");
        while (true) {
            var scanner = new Scanner(System.in);
            var in = scanner.nextLine();
            if (in.equals("Y")) {
                method = new InteractiveMethod();
                break;
            } else if (in.equals("N")) {
                method = new FileMethod("input");
                break;
            }
        }
        method.handle();
    }
}
