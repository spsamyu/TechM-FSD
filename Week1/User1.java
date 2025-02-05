package Week1;

public class User1 {
	private String name;
    private int age;

    // Constructor with all arguments
    public User1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters for all the private variable
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Overriding toString method
    
    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }

    // Overriding hashCode method
    
    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    // Overriding equals method
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User1 user1 = (User1) obj;
        return age == user1.age && name.equals(user1.name);
    }

}
