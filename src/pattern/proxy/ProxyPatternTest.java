package pattern.proxy;

/**
 * http://www.journaldev.com/1572/proxy-design-pattern-in-java-example-tutorial
 * @author kvenkata
 */
public class ProxyPatternTest {
	 
    public static void main(String[] args){
        ICommandExecutor executor = new CommandExecutorProxy("Pankaj", "wrong_pwd");
        try {
            executor.runCommand("ls -ltr");
            executor.runCommand(" rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception Message::"+e.getMessage());
        }
        
        ICommandExecutor impl = new CommandExecutorImpl();
        try {
			impl.runCommand("rm -rf abc.pdf");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
    }
 
}
