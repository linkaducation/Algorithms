package NIO.Client;

/**
 * Created by Ellen on 2017/8/4.
 */
public class TimeClient {
	public static void main(String[] args) {
		int port = 8080;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		TimeClientHandler handler = new TimeClientHandler("localhost", port);
		new Thread(handler, "TimeClient-001").start();
	}
}
