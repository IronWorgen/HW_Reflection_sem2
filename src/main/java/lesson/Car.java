package lesson;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
public class Car {
    String name;
    public String price;
    public String engType;
    public String engPower;
    public int maxSpeed;

    public Car(String name) {
        this.name = name;
        this.price = "1000";
        this.engType = "V8";
        this.engPower = "123";
        this.maxSpeed = 100;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
