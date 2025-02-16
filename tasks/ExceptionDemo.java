package tasks;

class ExceptionDemo {
    public static void main(String[] args) {
        try {
            throw new Exception("Custom Exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}