import java.util.Scanner;

public class Computer {
    private double temp = 18;
    private boolean power = false;
    private int ping = 1500;

    public double getTemp() {
        return temp;
    }

    void powerOn() {
        power = true;
    }

    void calculate() {
        if (!power) {
            System.out.println("turn on computer");
            return;
        }

        int result = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Write task");
        String task = in.nextLine();
        int plus = task.indexOf('+');
        int minus = task.indexOf('-');
        int mul = task.indexOf('*');
        int div = task.indexOf('/');
        int f = task.indexOf('f');
        if (f >= 0) {
            String[] fibon = task.split("f");
            int n = Integer.parseInt(fibon[0]);
            int[] fib = new int[n];
            fib[0] = 0;
            fib[1] = 1;
            for (int i = 2; i < fib.length; ++i) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
            result = fib[n-1];

        } else if (plus >= 0) {
            String[] primer = task.split("\\+");
            int a = Integer.parseInt(primer[0]);
            int b = Integer.parseInt(primer[1]);
            result = a + b;


        } else if (minus >= 0) {
            String[] primer = task.split("-");
            int a = Integer.parseInt(primer[0]);
            int b = Integer.parseInt(primer[1]);
            result = a - b;


        } else if (mul >= 0) {
            String[] primer = task.split("\\*");
            int a = Integer.parseInt(primer[0]);
            int b = Integer.parseInt(primer[1]);
            result = a * b;


        } else if (div >= 0) {
            String[] primer = task.split("/");
            int a = Integer.parseInt(primer[0]);
            int b = Integer.parseInt(primer[1]);
            result = a / b;

        }
        System.out.println(result);
    }
    void menu(){
        printMenu();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int menubutton = in.nextInt();
            switch (menubutton) {
                case 1:
                    powerOn();
                    break;
                case 2:
                    calculate();
                    break;
            }
            printMenu();
        }
    }

    private void printMenu() {
        System.out.println("1-TurnOn");
        System.out.println("2-Calculate");
    }

}

