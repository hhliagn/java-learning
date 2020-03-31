package com.javalearning.demo.complex_pojo.helper;

import java.io.*;

public class SerializeHelper {

    public static byte[] serialize(Object object) throws IOException {
        byte[] result = null;
        ObjectOutputStream out = null;
        try {
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            out = new ObjectOutputStream(buf);
            out.writeObject(object);
            byte[] bytes = buf.toByteArray();
            result = bytes;
        }catch (Exception e){

        }finally {
            if (out != null){
                out.close();
            }
        }
        return result;
    }

    public static <T> T deserialize(byte[] bytes, Class<T> tClass) throws IOException {

        T t = null;
        ObjectInputStream in = null;
        try {
            ByteArrayInputStream buf = new ByteArrayInputStream(bytes);
            in = new ObjectInputStream(buf);
            t = (T) in.readObject();
        }catch (Exception e){

        }finally {
            if (in != null){
                in.close();
            }
        }

        return t;

    }
}
