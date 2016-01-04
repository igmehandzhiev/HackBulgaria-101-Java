package p27_NoClonesStack;

public class StackMain {
	
	public static void main(String[] args) {
		MyStackNoClones st1 = new MyStackNoClones(2);
		try {
			st1.push(5);
			st1.push(2);
			st1.push(8);
			st1.push(4);
			st1.push(1);
			st1.push(5);
		} catch (IllegalArgumentException e1) {
			System.out.println(e1.getMessage());
		}
		st1.printStack();		
	}
}
