package pattern.decorator;

public class HorizontalWindowDecorator extends WindowDecorator{
	public HorizontalWindowDecorator(IWindow window){
		super(window);
	}
	
	public void draw(){
		super.draw();
		System.out.println("draw horizontal window. ");
	}
	
	public void getDescription(){
		super.getDescription();
		System.out.println("horizontal window description.");
	}
}
