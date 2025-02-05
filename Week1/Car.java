package Week1;

public class Car {
	private String make;
    private String model;
    private int year;

    // Constructor to initialize Car properties
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getter methods
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }

    // Setter methods
    public void setMake(String make) { this.make = make; }
    public void setModel(String model) { this.model = model; }
    public void setYear(int year) { this.year = year; }

    // Method to start the car engine
    public void startEngine() {
        System.out.println("Engine started for " + make + " " + model);
    }

}
