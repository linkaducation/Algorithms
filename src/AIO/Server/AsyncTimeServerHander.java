package AIO.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Ellen on 2017/8/5.
 */
public class AsyncTimeServerHander implements Runnable {

	private int port;
	CountDownLatch latch;
	AsynchronousServerSocketChannel asynchronousServerSocketChannel;

	/**
	 * 构造方法，创建一个异步的服务端通道AsynchronousServerSocketChannel，调用它的bind方法绑定监
	 * 听端口，绑定成功则打印提示到输入台
	 *
	 * @param port
	 */
	public AsyncTimeServerHander(int port) {
		this.port = port;
		try {
			asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
			asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
			System.out.println("The time server is start in port " + port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		latch = new CountDownLatch(1);
		doAccept();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 连接客户端的方法，采用的CompletionHandler方法，接收AcceptCompletionHandler作为采用的CompletionHandler方
	 * 法实例
	 */
	public void doAccept() {
		asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandler());
	}

}
