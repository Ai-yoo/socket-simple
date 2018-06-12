package com.du.test.tcp.test2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2018/6/11
 * @Time 18:44
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        int port = 55523;
        ServerSocket server = new ServerSocket(port);
        System.out.println("server在等待消息");
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len;
        StringBuilder stringBuilder = new StringBuilder();
        while ((len = inputStream.read(buf)) != -1) {
            stringBuilder.append(new String(buf, 0, len, "UTF-8"));
        }
        System.out.println("Client的消息是："+stringBuilder);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello Client,I get the message.".getBytes("UTF-8"));
        inputStream.close();
        outputStream.close();
        server.close();
        socket.close();
    }
}
