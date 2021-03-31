package com.javalearning.demo.socket_tcp.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lhh
 * @date 2021/3/31
 */
public class TCPServer {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();

        // read and write to new file..
        FileOutputStream fos = new FileOutputStream("C:\\Users\\lhh\\Desktop\\ks\\xx.jpg");
        InputStream is = socket.getInputStream();

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = is.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }

        // send feedback to client..
        OutputStream os = socket.getOutputStream();
        os.write("上传成功".getBytes());

        // close resource..
        fos.close();
        socket.close();
        server.close();
    }
}
