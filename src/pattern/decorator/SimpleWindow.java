package pattern.decorator;

public class SimpleWindow implements IWindow{
	public void draw(){
		System.out.println("simple window.");
	}
	
	public void getDescription(){
		System.out.println("simple window description.");
	}
}
