package pattern.abstractfactory;

public class ComputerFactory {
	 
    public static Computer getComputer(IComputerAbstractFactory factory){
        return factory.createComputer();
    }
}
