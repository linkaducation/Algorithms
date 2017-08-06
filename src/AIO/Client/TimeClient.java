package AIO.Client;

/**
 * Created by Ellen on 2017/8/6.
 */
public class TimeClient {

	public static void main(String[] args) {
		int port = 8080;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (Exception e) {

			}
		}
		new Thread(new AsyncTimeClientHandler("127.0.01", port), "AIO-AsyncTimeClientHandler-001").start();
	}
}
