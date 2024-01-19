package hw.task1;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main   {
    public static void main(String[] args) {
        List<Animal> animals =  List.of(
                new Animal("Зверь", 10),
                new Dog("Собака", 15),
                new Cat("Кот", 20));

        for (Animal animal : animals) {
            Class<?> clazz = animal.getClass();
            System.out.println(clazz.toString());
        }
        System.out.println("\n");

        for (Animal animal : animals) {
            Class<?> clazz = animal.getClass();
            try {
                clazz.getMethod("makeSound").invoke(animal);
            } catch (NoSuchMethodException e) {
                System.out.println("у класса "+clazz.getName()+" нет метода makeSound");

            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
