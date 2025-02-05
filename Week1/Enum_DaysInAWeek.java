package Week1;

public class Enum_DaysInAWeek {
	
	// Method to check if the day is a holiday
    static void checkHoliday(DaysInAWeek day) {
        if (day == DaysInAWeek.SATURDAY || day == DaysInAWeek.SUNDAY) {
            System.out.println(day + ": Holiday");
        } else {
            System.out.println(day + ": Not Holiday");
        }
    }

    public static void main(String[] args) {
        // Testing the checkHoliday method with different days
        checkHoliday(DaysInAWeek.MONDAY);
        checkHoliday(DaysInAWeek.SATURDAY);
        checkHoliday(DaysInAWeek.SUNDAY);
        checkHoliday(DaysInAWeek.WEDNESDAY);
    }

}
