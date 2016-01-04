package p23_FastAndFurious;

public class P23_FastAndFurious {
	public static void main(String[] args) {
		Car audi1 = new Audi(160000);
		System.out.println("Audi mileage: " + audi1.getMileage());
		System.out.println("Audi is ecofriendly: " + audi1.isEcoFriendly(false));
		
		Car vw = new Volkswagen();
		System.out.println("Volkswagen is ecofriendly: " + vw.isEcoFriendly(false));
		
		Car bmw = new BMW();
		System.out.println("BMW is ecofriendly: " + bmw.isEcoFriendly(true));

	}
}
