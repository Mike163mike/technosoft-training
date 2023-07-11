package org.technosoft.phone;

public class Phone {

    private String number;
    private String model;
    private int weight;

    public Phone() {
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone(String number, String model, int weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public int getWeight() {
        return weight;
    }

    public void receiveCall(String name) {
        System.out.printf("%s is calling.%n", name);
    }

    public static void main(String[] args) {

        Phone iPhone = new Phone("+7 (927) 354-54-76", "SE", 148);
        System.out.printf("%s number is %s.\n", "iPhone", iPhone.getNumber());
        System.out.printf("%s model is %s.\n", "iPhone", iPhone.getModel());
        System.out.printf("%s weight is %s g.\n", "iPhone", iPhone.getWeight());
        iPhone.receiveCall("Jeff Bezos");
        System.out.println();

        Phone samsung = new Phone("+7 (927) 484-98-11", "Galaxy S21 Fe", 172);
        System.out.printf("%s number is %s.\n", "Samsung", samsung.getNumber());
        System.out.printf("%s model is %s.\n", "Samsung", samsung.getModel());
        System.out.printf("%s weight is %s g\n", "Samsung", samsung.getWeight());
        iPhone.receiveCall("Brad Pitt");
        System.out.println();

        Phone nokia = new Phone("+7 (937) 435-55-29", "8", 160);
        System.out.printf("%s number is %s.\n", "Nokia", nokia.getNumber());
        System.out.printf("%s model is %s.\n", "Nokia", nokia.getModel());
        System.out.printf("%s weight is %s g.\n", "Nokia", nokia.getWeight());
        iPhone.receiveCall("J.Lo");
        System.out.println();
    }
}
