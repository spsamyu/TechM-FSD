package tasks;

public class CapitalizeAlt {
	   public static String capitalizeAlt(String s) {
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < s.length(); i++) {
	            sb.append(i % 2 == 0 ? Character.toUpperCase(s.charAt(i)) : Character.toLowerCase(s.charAt(i)));
	        }
	        return sb.toString();
	    }
	    public static void main(String[] args) {
	        System.out.println(capitalizeAlt("Varshni")); 
	    }
}
