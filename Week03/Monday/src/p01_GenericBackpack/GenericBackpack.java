package p01_GenericBackpack;

public class GenericBackpack {
	public static void main(String[] args) {
		Backpack<String> backpack = new Backpack<>("backpack1");
		
		System.out.println(backpack.getObj());
		
		backpack.setObj("new backpack");
		System.out.println(backpack.getObj());
		

	}

}
