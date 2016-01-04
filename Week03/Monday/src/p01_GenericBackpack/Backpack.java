package p01_GenericBackpack;

public class Backpack<F> {
	
	private F obj;
	
	public Backpack(F obj) {
		this.obj = obj;
	}
	
	public F getObj() {
		return this.obj;
	}
	
	public void setObj(F obj) {
		this.obj = obj;
	}
	
}
