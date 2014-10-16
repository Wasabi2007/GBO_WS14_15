package simpleClasses;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Actor brucewilles = new Actor();
		brucewilles.addRole(()->System.out.println("Ha!"));
		brucewilles.addRole(()->System.out.println("Hu!"));
		brucewilles.addRole(()->System.out.println("Hi!"));
		brucewilles.addRole(()->System.out.println("DIE!"));
		
		brucewilles.action();
	}

}
