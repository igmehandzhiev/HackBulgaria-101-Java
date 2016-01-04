package p23_FastAndFurious;

public abstract class Car {
	public boolean isEcoFriendly(boolean testing) {
		return true;
	}

	public int getMileage() {
		return 0;
	}
}

class Volkswagen extends Car {

	@Override
	public boolean isEcoFriendly(boolean testing) {
		return testing;
	}
}

class Audi extends Car {
	private int mileage;

	public Audi(int mil) {
		mileage = mil;
	}

	@Override
	public int getMileage() {
		return mileage;
	}
}

class BMW extends Car { }

class Honda extends Car { }

class Skoda extends Car { }
