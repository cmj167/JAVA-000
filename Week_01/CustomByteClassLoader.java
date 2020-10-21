package com.caimj.java.week01;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自定义字节类加载器
 * 功能：加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件
 *
 * @author caimeijiao
 * @date 2020-10-21
 *
 */
public class CustomByteClassLoader extends ClassLoader{

    //字节数组大小
    public static final int BUFFER_SIZE = 1024;
    public static final String FILE_NAME = "/Users/caimeijiao/Documents/学习资料/java训练营/week01/Hello/Hello.xlass";

    public static void main(String[] args) {

        try {

            Class clazz = new CustomByteClassLoader().findClass("Hello");
            Object object = clazz.newInstance();
            Method helloMethod = clazz.getMethod("hello");
            helloMethod.invoke(object);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] bytes = null;
        try {
            bytes = readXlassFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

    /**
     * 读取xclass文件，输出class类的字节数组
     *
     * @return
     * @throws FileNotFoundException
     */
    private byte[] readXlassFile() throws FileNotFoundException {

        //判断文件是否存在
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }


        int fileLength = (int) file.length();
        byte[] classByteArr = new byte[fileLength];

        ByteArrayOutputStream baos = new ByteArrayOutputStream(fileLength);
        FileInputStream fis = null;

        try {

            fis = new FileInputStream(FILE_NAME);
            byte[] bytes = new byte[BUFFER_SIZE];

            int  len = 0;
            while((len = fis.read(bytes, 0, BUFFER_SIZE)) != -1) {
                baos.write(bytes, 0, len);
            }
            byte[] totalBytes = baos.toByteArray();
            for (int i = 0; i < totalBytes.length; i++) {
                classByteArr[i] = (byte) (255 - totalBytes[i]);
            }

        }
        catch(Exception e) {
            e.printStackTrace();
            throw new FileNotFoundException();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ignored) {
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException ignored) {
                }
            }
        }
        return classByteArr;
    }
}
