package pattern.decorator;

public abstract class WindowDecorator implements IWindow{
	private IWindow window;

	public WindowDecorator(IWindow window) {
		this.window = window;
	}

	public void draw() {
		window.draw();
	}

	public void getDescription() {
		window.getDescription();
	}
}
