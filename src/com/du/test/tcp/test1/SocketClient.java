package com.du.test.tcp.test1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2018/6/11
 * @Time 18:34
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 55523;
        Socket socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好";
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        socket.close();
        outputStream.close();

    }
}
