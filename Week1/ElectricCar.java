package Week1;

public class ElectricCar extends Car {
	private int batteryRange;

    // Constructor to initialize ElectricCar properties
    public ElectricCar(String make, String model, int year, int batteryRange) {
        super(make, model, year);
        this.batteryRange = batteryRange;
    }

    // Getter for battery range
    public int getBatteryRange() { return batteryRange; }

    // Setter for battery range
    public void setBatteryRange(int batteryRange) { this.batteryRange = batteryRange; }

    // Method to charge the battery
    public void chargeBattery() {
        System.out.println("Battery charging for " + getMake() + " and  " + getModel());
    }

    // Overriding startEngine() to include electric car behavior
    @Override
    public void startEngine() {
        System.out.println("Electric motor started for " + getMake() + " and " + getModel());
    }

}
