package AIO.Server;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by Ellen on 2017/8/5.
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHander> {
	@Override
	public void completed(AsynchronousSocketChannel result, AsyncTimeServerHander attachment) {
		/**
		 * 接收客户端请求，因为AsynchronousServerSocketChannel可以接收成千上万的客户端，
		 * 所以回调AsyncTimeServerHander中asynchronousServerSocketChannel.accept方法，
		 * 让新的客户端继续接入，最终形成一个循环
		 */
		attachment.asynchronousServerSocketChannel.accept(attachment, this);
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		/**异步读操作
		 * 第一个buffer：接收缓冲区
		 * 第二个buffer：异步Channel携带的附件，通知回调的时候作为入参使用（我的理解是当该Channel继续被调用时的参数）
		 * CompletionHandler：接收通知回调的业务Handler，这里的实现类是ReadCompletionHandler
		 */
		result.read(buffer, buffer, new ReadCompletionHandler(result));
	}

	@Override
	public void failed(Throwable exc, AsyncTimeServerHander attachment) {
		attachment.latch.countDown();
	}
}
