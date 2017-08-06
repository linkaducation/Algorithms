package AIO.Client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Ellen on 2017/8/6.
 */
public class AsyncTimeClientHandler implements CompletionHandler<Void, AsyncTimeClientHandler>, Runnable {

	private String host;
	private int port;
	private AsynchronousSocketChannel client;
	private CountDownLatch latch;

	/**
	 * 构造方法，初始化初始化新的AsynchronousSocketChannel
	 *
	 * @param host
	 * @param port
	 */
	public AsyncTimeClientHandler(String host, int port) {
		this.host = host;
		this.port = port;
		try {
			//初始化新的AsynchronousSocketChannel
			client = AsynchronousSocketChannel.open();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 异步连接成功方法回调
	 *
	 * @param result
	 * @param attachment
	 */
	@Override
	public void completed(Void result, AsyncTimeClientHandler attachment) {
		//请求体
		byte[] req = "QUERY TIME ORDER".getBytes();
		ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
		writeBuffer.put(req);
		writeBuffer.flip();
		//异步写，写操作完成后的动作
		client.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
			//写操作完成后的动作
			@Override
			public void completed(Integer result, ByteBuffer buffer) {
				//如果缓冲区还有数据，继续发送
				if (buffer.hasRemaining()) {
					client.write(buffer, buffer, this);
				} else {
					//发送完成，执行异步读取操作
					ByteBuffer readBuffer = ByteBuffer.allocate(1024);

					//客户端异步读取服务端应答消息的处理逻辑
					//read读取服务端相应信息
					client.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
						@Override
						public void completed(Integer result, ByteBuffer buffer1) {
							//读取完成时，获取消息结果，打印结果
							buffer1.flip();
							byte[] bytes = new byte[buffer1.remaining()];
							buffer1.get(bytes);
							String body;
							try {
								body = new String(bytes, "UTF-8");
								System.out.println("Now is : " + body);
								latch.countDown();
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
						}

						@Override
						public void failed(Throwable exc, ByteBuffer attachment) {
							try {
								client.close();
								latch.countDown();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					});
				}
			}

			@Override
			public void failed(Throwable exc, ByteBuffer attachment) {
				try {
					client.close();
					latch.countDown();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
		try {
			client.close();
			latch.countDown();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		//等待，防治异步操作没有执行完成县城就退出
		latch = new CountDownLatch(1);
		//发起异步操作
		//两个参数，attachment用于回调通知时作为入参被传递，handler(CompletionHanlder<Void, ? super A>)异步操作回调通知接口
		//handler即为this.completion
		client.connect(new InetSocketAddress(host, port), this, this);
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
