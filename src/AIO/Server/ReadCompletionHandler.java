package AIO.Server;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

/**
 * Created by Ellen on 2017/8/5.
 */
public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

	private AsynchronousSocketChannel channel;

	/**
	 * 构造方法：将AsynchronousSocketChannel作为构造方法的参数传入，作为成员变量使用，
	 * 主要用于半包消息和发送应答
	 *
	 * @param channel
	 */
	public ReadCompletionHandler(AsynchronousSocketChannel channel) {
		if (channel != null) {
			this.channel = channel;
		}
	}

	/**
	 * 读取到消息的处理
	 *
	 * @param result
	 * @param attachment
	 */
	@Override
	public void completed(Integer result, ByteBuffer attachment) {
		attachment.flip();
		byte[] body = new byte[attachment.remaining()];
		attachment.get(body);
		try {
			String req = new String(body, "UTF-8");
			System.out.println("The time server receive order : " + req);
			//消息判断，如果是正确的消息，调用doWrite发送当前消息到客户端
			String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(req) ?
					new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
			doWrite(currentTime);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发送消息到客户端
	 *
	 * @param currentTime
	 */
	private void doWrite(String currentTime) {
		if (currentTime != null && currentTime.trim().length() > 0) {
			byte[] bytes = currentTime.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			channel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
				@Override
				public void completed(Integer result, ByteBuffer attachment) {
					//递归调用，如果没有发送完成，继续发送
					if (attachment.hasRemaining()) {
						channel.write(attachment, attachment, this);
					}
				}

				@Override
				public void failed(Throwable exc, ByteBuffer attachment) {
					try {
						channel.close();
					} catch (IOException e) {
						//ingore on close
					}
				}
			});
		}
	}

	@Override
	public void failed(Throwable exc, ByteBuffer attachment) {
		try {
			this.channel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
