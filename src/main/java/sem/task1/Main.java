package sem.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {


    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Class<?> personalClass = Class.forName("sem.task1.Person");

        // получить список всех полей
        Field[] fields = personalClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("FIELD = " +field.getName());
        }

        // получить список конструкторов
        Constructor[] constructors = personalClass.getConstructors();

        // создание экземпляра класса
        Object  personInstance = constructors[0].newInstance(null);

        // Устанавливаем значения полей
        Field nameFieldName  = personalClass.getDeclaredField("name");
        nameFieldName.setAccessible(true);
        nameFieldName.set(personInstance, "ivan");

        Field nameFieldAge  = personalClass.getDeclaredField("age");
        nameFieldAge.setAccessible(true);
        nameFieldAge.set(personInstance, 30);

        // вызов метода
        Method displayInfo = personalClass.getDeclaredMethod("displayInfo");
        displayInfo.invoke(personInstance);

    }


}
