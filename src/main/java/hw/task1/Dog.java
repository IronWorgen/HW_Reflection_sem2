package hw.task1;

import lombok.Data;


public class Dog extends Animal{
    private String breed;
    public Dog(String name, int age) {
        super(name, age);

    }
    public void makeSound(){
        System.out.println("Я собака, я говорю");
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
