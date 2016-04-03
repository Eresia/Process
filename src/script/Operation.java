package script;

public enum Operation {

	MV("000"),
	MVI("001"),
	ADD("010"),
	SUB("011"),
	AND("100"),
	OR("101"),
	NOT("110"),
	JUMP("111");
	
	private final String name;
	
	private Operation(String name){
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
}
