package sem.task1;

public class Person {
    private String name;
    private int age;

    public Person() {
        name = "ivan";
        age  =10;
    }
    public void displayInfo(){
        System.out.println("name = "+name+ ",  age = "+age);
    }
}
