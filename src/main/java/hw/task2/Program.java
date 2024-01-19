package hw.task2;

import java.util.UUID;

/**
 * Задача 2: Реализовать простой фреймворк для создания SQL-запросов на основе Java объектов
 * <p>
 * Фреймворк должен позволять аннотировать классы и поля для связывания их
 * с таблицами и столбцами в базе данных.
 * <p>
 * 1. Аннотации для маппинга:
 * Создайте аннотации, такие как @Table, @Column для маппинга классов,
 * таблиц и полей в базе данных.
 * <p>
 * 2. Механизм генерации SQL-запросов:
 * Реализуйте класс QueryBuilder, который может принимать объект и генерировать
 * SQL-запросы для выполнения операций CRUD (Create, Read, Update, Delete) на основе аннотаций.
 * Используйте Reflection для получения метаданных класса,
 * аннотированного объекта, чтобы построить соответствующий SQL-запрос.
 * <p>
 * 3. Пример использования:
 * Создайте простой класс, аннотированный для маппинга с базой данных.
 * Используйте ваш фреймворк для генерации SQL-запросов для различных операций,
 * таких как вставка, выборка, обновление и удаление.
 */

public class Program {
    public static void main(String[] args) throws IllegalAccessException {
        Employee employee = new Employee("Ivan", "qwe@mail.ru");

        QueryBuilder queryBuilder = new QueryBuilder();
        System.out.println("\nInsert query = " + queryBuilder.BuildInsertQuery(employee));
        System.out.println("\nSelect query = " + queryBuilder.buildSelectQuery(Employee.class, UUID.randomUUID()));
        System.out.println("\nUpdate query :\n" + queryBuilder.buildUpdateQuery(employee, UUID.randomUUID()));

        //HomeWork
        System.out.println("\n--------------------\nHomeWork");
        System.out.println("Delete query = "+queryBuilder.BuildDeleteQuery(Employee.class, UUID.randomUUID()));


    }
}
