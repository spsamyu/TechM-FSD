package Week1;

public class DriverClass {
	public static void main(String[] args) {
        // Creating an array of Car objects containing both Car and ElectricCar
        Car[] cars = {
            new Car("Maruthi", "Audi", 2020),
            new ElectricCar("Tesla", "Model S", 2023, 400)
        };

        // Looping through the array and calling startEngine() on each object
        for (Car car : cars) {
            car.startEngine(); // Calls appropriate method based on object type
        }
    }
}
