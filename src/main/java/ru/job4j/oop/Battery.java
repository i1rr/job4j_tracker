package ru.job4j.oop;

public class Battery {

    private int charge;

    public Battery(int mAh) {
        this.charge = mAh;
    }

    public void exchange(Battery another) {
        this.charge = this.charge + another.charge;
        another.charge = 0;
    }

    public static void main(String[] args) {
        Battery one = new Battery(2500);
        Battery two = new Battery(4800);

        System.out.println("Battery one charge = " + one.charge + "mAh\n" + "Battery two charge = " + two.charge + "mAh");
        one.exchange(two);
        System.out.println("Recharging...");
        System.out.println("Battery one charge = " + one.charge + "mAh\n" + "Battery two charge = " + two.charge + "mAh");
    }
}
