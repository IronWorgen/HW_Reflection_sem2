package sem.task2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sem.task2.annotations.Column;
import sem.task2.annotations.Table;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Employee {
    @Column(name = "id", primaryKey = true)
    private UUID id;
    @Column(name="username")
    private String username;
    @Column(name = "email")
    private String email;

    //поля для примера (не являются полями таблицы)
    private int param1;
    private int param2;


    public Employee(String username, String email) {
        id = UUID.randomUUID();
        this.username = username;
        this.email = email;
    }
}
