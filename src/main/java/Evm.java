import java.util.Scanner;

public abstract class Evm {

    void calculate() {
        if (!getPower()) {
            System.out.println("turn on computer");
            return;
        }
        try {

            int result = 0;
            Scanner in = new Scanner(System.in);
            System.out.println("Write task");
            String task = in.nextLine();
            int plus = task.indexOf('+');
            int minus = task.indexOf('-');
            int mul = task.indexOf('*');
            int div = task.indexOf('/');
            int f = task.indexOf('f');

            heat();
            System.out.println("Curren temperature  "+temperature());
            if (temperature() > criticalTemp()) {
                setPower(false);
                startTemp();
            }


            if (f >= 0) {
                String[] fibon = task.split("f");
                int n = Integer.parseInt(fibon[0]);
                int[] fib = new int[n];
                fib[0] = 0;
                fib[1] = 1;
                for (int i = 2; i < fib.length; ++i) {
                    fib[i] = fib[i - 1] + fib[i - 2];
                }
                result = fib[n - 1];

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
            else {
                throw new RuntimeException();
            }
            System.out.println(result);
        } catch (Exception ex){
            System.out.println("неверный ввод");
        }
    }
    abstract void startTemp();
    abstract int temperature();
    abstract int criticalTemp();
    abstract void heat();
    abstract boolean getPower();
    abstract void setPower(boolean power);

}
