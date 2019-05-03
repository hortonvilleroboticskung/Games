package Concepts;

public class Instances {
	
	private static Instances instance = null;
	
	public String text;
	
	private Instances() {
		text = "Ok then...";
	}
	
	public static Instances getInstance() {
       return instance == null ? instance = new Instances(): instance;
    }
	
	public static void main(String[] args) {
		Instances one = Instances.getInstance();
		System.out.println(one.text);
		Instances two = Instances.getInstance();
		two.text = " No ok";
		System.out.println(two.text);
		System.out.println(one.text);
	}
}
	
