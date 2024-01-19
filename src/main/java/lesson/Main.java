package lesson;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// - 10 минут из жизни

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Car car = new Car("BMW");
        Class<?> car1 = Class.forName("lesson.Car");
        Constructor<?>[] constructor = car1.getConstructors();
        System.out.println(constructor);
        Object gaz = constructor[0].newInstance("Газ");
        System.out.println(gaz);

        Field[] fields = gaz.getClass().getFields();
        int temp = fields[fields.length-1].getInt(gaz);
        fields[fields.length-1].setInt(gaz,0);
        System.out.println(temp);
        System.out.println(fields[fields.length-1].getInt(gaz));
        Method[]  methods = gaz.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
