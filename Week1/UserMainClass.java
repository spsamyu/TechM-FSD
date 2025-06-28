package Week1;

public class UserMainClass {
	public static void main(String[] args) {
	 // Creating objects of User1 and User2
    User1 firstuser1 = new User1("Sam", 25);
    User1 firstuser2 = new User1("Sam", 25);
    User2 secondUser1 = new User2("Sam", 25);
    User2 secondUser2 = new User2("Sam", 25);
    
    // Printing objects using toString()
    System.out.println("firstUser 1: " + firstuser1);
    System.out.println("firstUser 2: " + firstuser2);
    System.out.println();
    System.out.println("SecondUser 1: " + secondUser1);
    System.out.println("SecondUser 2: " + secondUser2);

    // Comparing objects using equals()
    System.out.println("\nComparing User objects using equals():");
    System.out.println("firstuser1.equals(firstuser2): " + firstuser1.equals(firstuser2)); // true, because both have the same data

    System.out.println("\nComparing SecondUser objects using equals():");
    System.out.println("secondUser1.equals(secondUser2): " + secondUser1.equals(secondUser2)); // false, because equals() is not overridden

    // Comparing hashCode values
    System.out.println("\nComparing hashCode of User objects:");
    System.out.println("firstuser1.hashCode(): " + firstuser1.hashCode());
    System.out.println("firstuser2.hashCode(): " + firstuser2.hashCode());

    System.out.println("\nComparing hashCode of SecondUser objects:");
    System.out.println("secondUser1.hashCode(): " + secondUser1.hashCode());
    System.out.println("secondUser2.hashCode(): " + secondUser2.hashCode());
    
	}
}


