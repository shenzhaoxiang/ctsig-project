package com.ctsig.common.utils;

/**
 * 它的作用就是把对象转化为byte数组，或把byte数组转化为对象。
 */

import java.io.*;

public class SerializeUtils {

    public static byte[] serialize(Object o) {
        if(o==null){
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ObjectOutputStream outo = new ObjectOutputStream(out);
            outo.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }

    public static Object deserialize(byte[] b) {
        if(b==null){
            return null;
        }
        ObjectInputStream oin;
        try {
            oin = new ObjectInputStream(new ByteArrayInputStream(b));
            try {
                return oin.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
