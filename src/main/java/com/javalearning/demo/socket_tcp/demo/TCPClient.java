package com.javalearning.demo.socket_tcp.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author lhh
 * @date 2021/3/31
 */
public class TCPClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 8888);

        // read and write file..
        FileInputStream fis = new FileInputStream("C:\\Users\\lhh\\Desktop\\pic_word.jpg");
        OutputStream os = socket.getOutputStream();

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }

        // 需要告诉服务端文件传送结束
        socket.shutdownOutput();

        // receive the sever feedback..
        InputStream is = socket.getInputStream();
        while ((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        // close resource..
        fis.close();
        socket.close();
    }
}
