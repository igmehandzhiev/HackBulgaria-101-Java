package p10_genericStack;

public class Main {
	public static void main(String[] args) {
		GenericStackImpl<String> stackInts = new GenericStackImpl<>();
		stackInts.push(new String("asa"));
		stackInts.push(new String("dasa"));
		stackInts.push(new String ("casa"));
		stackInts.push(new String ("basa"));
		stackInts.printStack();
		stackInts.pop();
		stackInts.printStack();
		System.out.println(stackInts.peek());
	}
}
