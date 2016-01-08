package pattern.strategy;
//http://www.journaldev.com/1754/strategy-design-pattern-in-java-example-tutorial
public class CreditCardStrategy implements IPaymentStrategy {
	private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;
     
    public CreditCardStrategy(String nm, String ccNum, String cvv, String expiryDate){
        this.name=nm;
        this.cardNumber=ccNum;
        this.cvv=cvv;
        this.dateOfExpiry=expiryDate;
    }
    @Override
    public void pay(int amount) {
        System.out.println(amount +" paid with credit/debit card");
    }
	
}
