package pattern.builder;

public class Person {
	private String name;
	private String address;
	private int age;

	private Person(PersonBuilder personBuilder) {
		this.name = personBuilder.name;
		this.address = personBuilder.address;
		this.age = personBuilder.age;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public int getAge(){
		return this.age;
	}

	public static class PersonBuilder {
		private String name;
		private String address;
		private int age;

		public PersonBuilder(String name, String address) {
			this.name = name;
			this.address = address;
		}
		
		public PersonBuilder age(int age) {
			this.age = age;
			return this;
		}

		public Person build() {
			return new Person(this);
		}
	}
}