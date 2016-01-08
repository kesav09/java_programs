package pattern.strategy;


interface IBrake{
	public void applyBrake();
}

class Brake implements IBrake{
	public void applyBrake(){
		System.out.println("apply normal brakes.");
	}
}

class BrakeWithAbs implements IBrake{
	public void applyBrake(){
		System.out.println("apply brakes with abs.");
	}
}

abstract class Car{
	IBrake ibrake;
	void applyBrake(){
		ibrake.applyBrake();
	}
	
	void setBehavior(IBrake ibrake){
		this.ibrake = ibrake;
	}
}

class Sedan extends Car{
	Sedan(){
		super.setBehavior(new Brake());
	}
		
}

class SUV extends Car{
	SUV(){
		super.setBehavior(new BrakeWithAbs());
	}
}

public class Client{

	public static void main(String[] args){
		Car sedan = new Sedan();
		sedan.applyBrake(); // "apply normal brakes.";
	
		Car suv = new SUV();
		suv.applyBrake(); // "apply brake with abs.";
	
		suv.setBehavior(new Brake());
		suv.applyBrake();//"apply brake with abs.";
	}
}
