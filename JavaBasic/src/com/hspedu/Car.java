package com.hspedu;

public class Car {
    public String brand = "abc";
    public double price = 1.0;
    public String color = "red";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
