package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Ellen on 2017/8/4.
 */
public class TimeClientHandler implements Runnable {

	private String host;
	private int port;
	private Selector selector;
	private SocketChannel socketChannel;
	private volatile boolean stop;

	public TimeClientHandler(String host, int port) {
		this.host = host == null ? "127.0.0.1" : host;
		this.port = port;
		try {
			selector = Selector.open();
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void run() {
		try {
			doConnect();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
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
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		//关闭多路复用
		if (selector != null) {
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void handlerInput(SelectionKey key) throws IOException {
		if (key.isValid()) {
			//判断是否连接成功
			SocketChannel sc = (SocketChannel) key.channel();
			if (key.isConnectable()) {
				if (sc.finishConnect()) {
					sc.register(selector, SelectionKey.OP_READ);
					doWrite(sc);
				} else {
					//连接失败
					System.exit(1);
				}
				if (key.isReadable()) {
					ByteBuffer readBuffer = ByteBuffer.allocate(1024);
					int readBytes = sc.read(readBuffer);
					if (readBytes > 0) {
						readBuffer.flip();
						byte[] bytes = new byte[readBuffer.remaining()];
						readBuffer.get(bytes);
						String body = new String(bytes, "UTF-8");
						System.out.println("Now is : " + body);
						this.stop = true;
					} else if (readBytes < 0) {
						//对端链路关闭
						key.cancel();
						sc.close();
					}
				}
			}
		}
	}

	private void doConnect() throws IOException {
		//如果连接成功，注册到多路复用器上，发送请求消息，读应答
		if (socketChannel.connect(new InetSocketAddress(host, port))) {
			socketChannel.register(selector, SelectionKey.OP_READ);
			doWrite(socketChannel);
		} else {
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
		}
	}

	private void doWrite(SocketChannel socketChannel) throws IOException {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			byte[] req = in.next().getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
			writeBuffer.put(req);
			writeBuffer.flip();
			socketChannel.write(writeBuffer);
			if (!writeBuffer.hasRemaining()) {
				System.out.println("Send order 2 server success.");
			}
		}
	}
}
