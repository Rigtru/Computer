import java.util.Scanner;

public class Computer  extends Evm{
    private int temp = 18;
    private boolean power = false;
    private int ping = 1500;

    public double getTemp() {
        return temp;
    }

    void powerOn() {
        power = true;
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

    @Override
    void startTemp() {
        temp = 18;
    }

    @Override
    int temperature() {
        return temp;
    }

    @Override
    int criticalTemp() {
        return 100;
    }

    @Override
    void heat() {
        temp+=2;

    }

    @Override
    boolean getPower() {
        return power;
    }

    @Override
    void setPower(boolean power) {
this.power=power;
    }
}

