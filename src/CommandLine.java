import java.util.Scanner;

public class CommandLine extends Utils {

    public static void start() {
        root.name = "root";
        root.fullPath = ".";

        boolean state = true;
        clearScreen();
        try (Scanner sc = new Scanner(System.in)) {
            while (state) {
                System.out.println();
                System.out.println();
                System.out.println(
                        ">>> Operations: pwd | md | touch | cd | showdirs | showfiles | showpath | X");
                System.out
                        .println("-----------------------------------------------------------------------------------");
                System.out.println();
                System.out.println(">>> pwd -- show working directory ------ <Operation>");
                System.out.println(">>> md -- create directory ------ <Operation> <name>");
                System.out.println(">>> touch -- create file ------ <Operation> <name>");
                System.out.println(">>> showdirs -- show subdirectories ------ <Operation>");
                System.out.println(">>> showfiles -- show files ------ <Operation>");
                System.out.println(">>> showpath -- show full path ------ <Operation>");
                System.out.println(">>> x -- exit ------ <Operation>");
                System.out.println();
                System.out
                        .println("-----------------------------------------------------------------------------------");

                // user input
                System.out.print(">>> ");
                String input = sc.nextLine();
                String[] inputArray = input.split(" ");
                String inputOperation = inputArray[0].toLowerCase();
                String inputName = "temp";
                if (inputArray.length == 2) {
                    inputName = inputArray[1].toLowerCase();
                }

                switch (inputOperation) {

                    case "pwd":
                        clearScreen();
                        showPwd();
                        break;

                    case "md":
                        clearScreen();
                        makeDir(inputName);
                        break;

                    case "touch":
                        clearScreen();
                        touch(inputName);
                        break;

                    case "cd":
                        clearScreen();
                        cd(inputName);
                        break;

                    case "showdirs":
                        clearScreen();
                        showSubDirs();
                        break;

                    case "showfiles":
                        clearScreen();
                        showFile();
                        break;

                    case "showpath":
                        clearScreen();
                        showPath();
                        break;

                    case "x":
                        state = false;
                        sc.close();
                        return;

                    default:
                        clearScreen();
                        System.out.println(">>> invaild operation");
                        break;
                }
                System.out
                        .println("-----------------------------------------------------------------------------------");

            }
        }
    }
}
