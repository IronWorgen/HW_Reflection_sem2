package hw.task1;

import lombok.Data;


public class Cat extends Animal{
    private String color;
    public Cat(String name, int age) {
        super(name, age);

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
