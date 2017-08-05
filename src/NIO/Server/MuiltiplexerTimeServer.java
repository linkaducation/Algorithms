package NIO.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Ellen on 2017/8/4.
 */
public class MuiltiplexerTimeServer implements Runnable {
	private Selector selector;

	private ServerSocketChannel serverSocketChannel;

	private volatile boolean stop;

	/**
	 * 初始化多路复用器，绑定监听端口
	 *
	 * @param port
	 */
	public MuiltiplexerTimeServer(int port) {
		try {
			selector = Selector.open();
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.bind(new InetSocketAddress(port), 1024);
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("The time server is start in port: " + port);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void stop() {
		this.stop = true;
	}

	@Override
	public void run() {
		while (!stop) {
			try {
				selector.select(1000);
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectionKeys.iterator();
				SelectionKey key = null;
				while (iterator.hasNext()) {
					key = iterator.next();
					iterator.remove();
					try {
						handlerInput(key);
					} catch (Exception e) {
						if (key != null) {
							key.cancel();
							if (key.channel() != null) {
								key.channel().close();
							}
						}
						e.printStackTrace();
					}
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}

		if (selector != null) {
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void handlerInput(SelectionKey key) throws IOException {
		//处理新接入的请求消息
		if (key.isValid()) {
			if (key.isAcceptable()) {
				//accept the new connection
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				//Add the new connection to the selector
				sc.register(selector, SelectionKey.OP_READ);
			}
			if (key.isReadable()) {
				//Read the data
				SocketChannel sc = (SocketChannel) key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if (readBytes > 0) {
					//改为读模式
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes, "UTF-8");
					System.out.println("The time server receive order: " + body);
					String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? (new Date(System.currentTimeMillis()).toString()) : "BAD ORDER";
					doWirte(sc, currentTime);
				} else if (readBytes < 0) {
					//对端链路关闭
					key.cancel();
					sc.close();
				}
			}
		}
	}

	private void doWirte(SocketChannel channel, String response) throws IOException {
		if (response != null && response.trim().length() > 0) {
			byte[] bytes = response.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			channel.write(writeBuffer);
		}
	}
}
