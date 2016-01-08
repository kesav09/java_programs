package pattern.builder;

public class Client {

	public static void main(String[] args) {
		Person person = new Person.PersonBuilder("sasser", "san jose").age(12).build();
		Person person2 = new Person.PersonBuilder("sasser", "san jose").build();
		System.out.println(person2.getAge());
	}
}
