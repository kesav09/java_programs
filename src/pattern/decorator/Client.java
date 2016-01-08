package pattern.decorator;

public class Client{
	public static void main(String[] args){
		IWindow window = new HorizontalWindowDecorator(new SimpleWindow());
		window.draw();
		window.getDescription();
	}
}
