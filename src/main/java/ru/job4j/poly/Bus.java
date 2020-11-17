package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void toDrive() {
    }

    @Override
    public void passengers(int amount) {
    }

    @Override
    public double refuel(int gasAmount) {
        double gasPrice = gasAmount * 1.46; //price in $$$
        return gasPrice;
    }
}
