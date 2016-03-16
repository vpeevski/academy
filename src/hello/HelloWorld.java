package hello;

import java.util.Scanner;

public class HelloWorld {

  public static void main(String[] args) {
    
    if (args.length > 0) {
      for (String name : args) {
        System.out.println("Hello World: " + name);
      }
    } else {
      input();
    }

  }

  private static void input() {
    Scanner scanner = null;
    try {
      scanner = new Scanner(System.in);
      String answer = "y";
      while (answer.toLowerCase().trim().equals("y")) {
        System.out.println("Enter your name: ");
        String name = scanner.next();
        System.out.println("Hello World: " + name);
        System.out.println("Would you like to continue (y/n): ");
        answer = scanner.next();
        while (!answer.toLowerCase().trim().equals("y") && !answer.toLowerCase().trim().equals("n")) {
          System.out.println("Would you like to continue (y/n): ");
          answer = scanner.next();
        }
      }
    } finally {
      if (scanner != null) {
        scanner.close();
      }
    }

  }

}
