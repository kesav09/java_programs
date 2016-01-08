package pattern.proxy;

import java.io.IOException;

public class CommandExecutorImpl implements ICommandExecutor {
	 
    @Override
    public void runCommand(String cmd) throws IOException {
                //some heavy implementation
        Runtime.getRuntime().exec(cmd);
        System.out.println("'" + cmd + "' command executed.");
    }
 
}

