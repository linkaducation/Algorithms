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
		attachment.asynchronousServerSocketChannel.accept(attachment, this);
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		result.read(buffer, buffer, new ReadCompletionHandler(result));
	}

	@Override
	public void failed(Throwable exc, AsyncTimeServerHander attachment) {
		((AsyncTimeServerHander) attachment).latch.countDown();
	}
}
