package NIO.Server;

/**
 * Created by Ellen on 2017/8/4.
 */
public class TimerServer {
	public static void main(String[] args) {
		int port = 8080;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		MuiltiplexerTimeServer timeServer = new MuiltiplexerTimeServer(port);
		new Thread(timeServer, "NIO-MuiltiplexerTimeServer-001").start();

	}
}
