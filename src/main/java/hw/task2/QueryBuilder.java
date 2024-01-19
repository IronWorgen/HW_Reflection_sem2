package hw.task2;

import hw.task2.annotations.Column;
import hw.task2.annotations.Table;

import java.lang.reflect.Field;
import java.util.UUID;

public class QueryBuilder {
    /**
     * создать запрос на удаление из БД по UUID
     * @param clazz
     * @param id
     * @return
     */
    public String BuildDeleteQuery(Class<?> clazz, UUID id){
        StringBuilder query = new StringBuilder("DELETE FROM ");
        if (clazz.isAnnotationPresent(Table.class)){
            Table tableAnnotation =  clazz.getAnnotation(Table.class);
            query
                    .append(tableAnnotation.name())
                    .append(" WHERE ");

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if(field.isAnnotationPresent(Column.class)){
                    Column columnAnnotation = field.getAnnotation(Column.class);
                    if (columnAnnotation.primaryKey()){
                        query
                                .append(columnAnnotation.name())
                                .append(" = '")
                                .append(id)
                                .append("'");
                    }
                }
            }
        }else {
            return "";
        }
        return query.toString();
    }

    /**
     * создать запрос на добавление в БД
     * @param object
     * @return
     */
    public String BuildInsertQuery(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        StringBuilder query = new StringBuilder("INSERT INTO ");

        if(clazz.isAnnotationPresent(Table.class)){
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            query
                    .append(tableAnnotation.name())
                    .append(" (");

            //добавление названий полей с аннотацией Column
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)){
                    query
                            .append(field.getAnnotation(Column.class).name())
                            .append(", ");
                }
            }
            if (query.charAt(query.length()-2)==','){
                query.delete(query.length()-2, query.length());
            }

            query.append(") VALUES (");
            for (Field field : fields) {
                if(field.isAnnotationPresent(Column.class)){
                    field.setAccessible(true);
                    query
                            .append("'")
                            .append(field.get(object))
                            .append("', ");
                }
            }
            if (query.charAt(query.length()-2)==','){
                query.delete(query.length()-2, query.length());
            }
            query.append(");");
        }
        return query.toString();
    }

    /**
     * создание Select запроса
     * @param clazz
     * @param primaryKey
     * @return
     */
    public String buildSelectQuery(Class<?> clazz, UUID primaryKey){
        StringBuilder query = new StringBuilder("SELECT * FROM ");
        if (clazz.isAnnotationPresent(Table.class)){
            query
                    .append(clazz.getAnnotation(Table.class).name())
                    .append(" WHERE ");

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)){
                    if(field.getAnnotation(Column.class).primaryKey()){
                        query
                                .append(field.getAnnotation(Column.class).name())
                                .append(" = ")
                                .append(primaryKey);
                        break;
                    }
                }
            }

        }
        return query.toString();
    }


    /**
     * запрос на обновление поля таблицы по id
     * @param object
     * @param id
     * @return
     */
    public String buildUpdateQuery (Object object, UUID id ) throws IllegalAccessException {
        StringBuilder query = new StringBuilder("UPDATE ");
        Class<?> clazz = object.getClass();

        if(clazz.isAnnotationPresent(Table.class)){
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            query
                    .append(tableAnnotation.name())
                    .append("\nSET ");

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)){
                    Column columnAnnotation = field.getAnnotation(Column.class);
                    if (!columnAnnotation.primaryKey()) {
                        field.setAccessible(true);
                        query
                                .append(columnAnnotation.name())
                                .append(" = ")
                                .append(field.get(object))
                                .append(",\n\t");
                    }

                }
            }
            if (query.charAt(query.length()-3)==','){
                query.delete(query.length()-3, query.length());
            }

            query.append(" \nWHERE ");
            for (Field field : fields) {
                if(field.isAnnotationPresent(Column.class)){
                    if (field.getAnnotation(Column.class).primaryKey()){
                        field.setAccessible(true);
                        query
                                .append(field.getAnnotation(Column.class).name())
                                .append(" = ")
                                .append(id);
                    }
                }
            }

        }
        return query.toString();
    }
}
