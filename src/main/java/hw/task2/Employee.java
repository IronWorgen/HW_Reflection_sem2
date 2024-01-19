package hw.task2;

import hw.task2.annotations.Column;
import hw.task2.annotations.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
