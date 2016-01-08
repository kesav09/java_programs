package pattern.factory;

public class USA implements ICurrency{

	@Override
	public String getCurrency() {
		return "dollar";
	}

	@Override
	public String getSymbol() {
		return "$";
	}
	
}
