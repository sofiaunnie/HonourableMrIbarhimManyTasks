import java.util.ArrayList;
import java.util.Scanner;

public class EditString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> history = new ArrayList<>();

        System.out.println("Enter the initial string:");
        String String_Input = input.nextLine();
        history.add(String_Input);

        while (true) {

            System.out.println("Enter your change operation (U, L, R, C ch1 ch2, Z, or X to exit):");
            String Change_String_Input = input.nextLine();

            if (Change_String_Input.equals("X")) { // Exit condition
                System.out.println("You have exited the program.");
                break;
            }

            if (Change_String_Input.equals("U")) {
                String_Input = String_Input.toUpperCase();
                history.add(String_Input);
                System.out.println(String_Input);
            }
            else if (Change_String_Input.equals("L")) {
                String_Input = String_Input.toLowerCase();
                history.add(String_Input);
                System.out.println(String_Input);
            }
            else if(Change_String_Input.equals("R")) {
                StringBuilder sb = new StringBuilder().append(String_Input);
                String_Input = sb.reverse().toString();
                history.add(String_Input);
                System.out.println(String_Input);
            }
            else if(Change_String_Input.startsWith("C ")) {
                String[] parts = Change_String_Input.split(" ");
                if (parts.length == 3) {
                    char ch1 = parts[1].charAt(0);
                    char ch2 = parts[2].charAt(0);
                    String_Input = String_Input.replace(ch1, ch2);
                    history.add(String_Input);
                    System.out.println(String_Input);
                } else {
                    System.out.println("Invalid input for C command. Use the format: C ch1 ch2");
                }
            }
                else if (Change_String_Input.equals("Z")) {
                    if (history.size() > 1) {
                        history.remove(history.size() - 1);
                        String_Input = history.get(history.size() - 1);
                        System.out.println(String_Input);
                    } else {
                        System.out.println("No more operations to undo.");
                    }
            }
            else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}



