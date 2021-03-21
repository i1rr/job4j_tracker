package ru.job4j.stream;

public class Motorcycle {
    private String brand;
    private String model;
    private int engine;
    private int year;
    private String vin;
    private String color;
    private boolean learner;

    @Override
    public String toString() {
        String rsl;
        if (learner) {
            rsl = "Leaner approved";
        } else {
            rsl = "Full licence only";
        }
        return "Motorcycle details: " + System.lineSeparator()
                + brand + " " + model + " " + year + System.lineSeparator()
                + "engine capacity: " + engine + "cc" + System.lineSeparator()
                + "VIN: " + vin + System.lineSeparator()
                + "color: " + color + System.lineSeparator()
                + "licence restriction: " + rsl;
    }

    static class Builder {
        private String brand;
        private String model;
        private int engine;
        private int year;
        private String vin;
        private String color;
        private boolean learner; //Learner approved

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildEngine(int engine) {
            this.engine = engine;
            return this;
        }

        Builder buildYear(int year) {
            this.year = year;
            return this;
        }

        Builder buildVin(String vin) {
            this.vin = vin;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildLearner(Boolean learner) {
            this.learner = learner;
            return this;
        }

        Motorcycle build() {
            Motorcycle motorcycle = new Motorcycle();
            motorcycle.brand = brand;
            motorcycle.model = model;
            motorcycle.engine = engine;
            motorcycle.year = year;
            motorcycle.vin = vin;
            motorcycle.color = color;
            motorcycle.learner = learner;
            return motorcycle;
        }
    }

    public static void main(String[] args) {
        Motorcycle hondaCBR1000RR = new Builder().buildBrand("Honda")
                .buildModel("CBR1000RR")
                .buildEngine(1000)
                .buildYear(2016)
                .buildVin("JH2SC5905GK800265")
                .buildColor("white")
                .buildLearner(false)
                .build();
        System.out.println(hondaCBR1000RR);
    }
}
