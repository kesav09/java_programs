package pattern.factory;

public class India implements ICurrency {

	@Override
	public String getCurrency() {
		return "rupee";
	}

	@Override
	public String getSymbol() {
		return "RS";
	}
}
