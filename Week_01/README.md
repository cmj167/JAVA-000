学习笔记

Week01 作业题目（周四）：

1.（选做）自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后自己分析一下对应的字节码，有问题群里讨论。

java源码

```
package com.caimj.java.week01;

/**
 *
 * 功能：写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后自己分析一下对应的字节码
 *
 * @author caimeijiao
 * @date 2020-10-21
 */
public class Hello {

    public static void main(String[] args) {

       int sum = 0;
       int num = 5;
        for (int i = 0; i < num; i++) {
            sum = sum + i;
        }
        System.out.println("sum=" + sum);

       float a = 2.5f;
       double b = 3.0d;
       float x = sum/a;
       if (x > 3) {
           double y = 3 * b;
           System.out.println("y=" + y);
       }

    }
}

```
字节码

```
Classfile /Users/caimeijiao/Documents/学习资料/java训练营/homework_code/src/main/java/com/caimj/java/week01/Hello.class
  Last modified 2020-10-21; size 1100 bytes
  MD5 checksum 2272406aa6cdea162bbd463ff7cdcf9d
  Compiled from "Hello.java"
public class com.caimj.java.week01.Hello
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #17.#42        // java/lang/Object."<init>":()V
   #2 = Fieldref           #43.#44        // java/lang/System.out:Ljava/io/PrintStream;
   #3 = Class              #45            // java/lang/StringBuilder
   #4 = Methodref          #3.#42         // java/lang/StringBuilder."<init>":()V
   #5 = String             #46            // sum=
   #6 = Methodref          #3.#47         // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   #7 = Methodref          #3.#48         // java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
   #8 = Methodref          #3.#49         // java/lang/StringBuilder.toString:()Ljava/lang/String;
   #9 = Methodref          #50.#51        // java/io/PrintStream.println:(Ljava/lang/String;)V
  #10 = Float              2.5f
  #11 = Double             3.0d
  #13 = Float              3.0f
  #14 = String             #52            // y=
  #15 = Methodref          #3.#53         // java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
  #16 = Class              #54            // com/caimj/java/week01/Hello
  #17 = Class              #55            // java/lang/Object
  #18 = Utf8               <init>
  #19 = Utf8               ()V
  #20 = Utf8               Code
  #21 = Utf8               LineNumberTable
  #22 = Utf8               LocalVariableTable
  #23 = Utf8               this
  #24 = Utf8               Lcom/caimj/java/week01/Hello;
  #25 = Utf8               main
  #26 = Utf8               ([Ljava/lang/String;)V
  #27 = Utf8               i
  #28 = Utf8               I
  #29 = Utf8               y
  #30 = Utf8               D
  #31 = Utf8               args
  #32 = Utf8               [Ljava/lang/String;
  #33 = Utf8               sum
  #34 = Utf8               num
  #35 = Utf8               a
  #36 = Utf8               F
  #37 = Utf8               b
  #38 = Utf8               x
  #39 = Utf8               StackMapTable
  #40 = Utf8               SourceFile
  #41 = Utf8               Hello.java
  #42 = NameAndType        #18:#19        // "<init>":()V
  #43 = Class              #56            // java/lang/System
  #44 = NameAndType        #57:#58        // out:Ljava/io/PrintStream;
  #45 = Utf8               java/lang/StringBuilder
  #46 = Utf8               sum=
  #47 = NameAndType        #59:#60        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  #48 = NameAndType        #59:#61        // append:(I)Ljava/lang/StringBuilder;
  #49 = NameAndType        #62:#63        // toString:()Ljava/lang/String;
  #50 = Class              #64            // java/io/PrintStream
  #51 = NameAndType        #65:#66        // println:(Ljava/lang/String;)V
  #52 = Utf8               y=
  #53 = NameAndType        #59:#67        // append:(D)Ljava/lang/StringBuilder;
  #54 = Utf8               com/caimj/java/week01/Hello
  #55 = Utf8               java/lang/Object
  #56 = Utf8               java/lang/System
  #57 = Utf8               out
  #58 = Utf8               Ljava/io/PrintStream;
  #59 = Utf8               append
  #60 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
  #61 = Utf8               (I)Ljava/lang/StringBuilder;
  #62 = Utf8               toString
  #63 = Utf8               ()Ljava/lang/String;
  #64 = Utf8               java/io/PrintStream
  #65 = Utf8               println
  #66 = Utf8               (Ljava/lang/String;)V
  #67 = Utf8               (D)Ljava/lang/StringBuilder;
{
  public com.caimj.java.week01.Hello();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 10: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lcom/caimj/java/week01/Hello;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=4, locals=9, args_size=1
         0: iconst_0                       //int型整数0入栈 
         1: istore_1                       //将0存放于槽位1中
         2: iconst_5                       //int型整数5入栈 
         3: istore_2                       //将5存放于槽位2中
         4: iconst_0                       //变量i int型整数0入栈
         5: istore_3                       //将0存放于槽位3中
         6: iload_3                        //将槽位3中的变量压入栈顶 
         7: iload_2                        //将槽位2中的变量压入栈顶 
         8: if_icmpge     21               //比较变量i是否小于5，若不小于5，跳转22行
        11: iload_1                        //将槽位1中的变量压入栈顶 
        12: iload_3                        //将槽位3中的变量压入栈顶 
        13: iadd                           //栈顶两元素0和0出栈并相加
        14: istore_1                       //将结果10存放于槽位1
        15: iinc          3, 1             //变量i+1，槽位3的值为5
        18: goto          6                //跳转到第6行
        21: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        24: new           #3                  // class java/lang/StringBuilder
        27: dup
        28: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
        31: ldc           #5                  // String sum=
        33: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        36: iload_1                           //将槽位1中的变量压入栈顶
        37: invokevirtual #7                  // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        40: invokevirtual #8                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        43: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        46: ldc           #10                 // float 2.5f  
        48: fstore_3                          //将2.5存放于槽位3
        49: ldc2_w        #11                 // double 3.0d
        52: dstore        4                   //将4存放于槽位4
        54: iload_1                           //将槽位1中的变量压入栈顶
        55: i2f                               //转换int变量
        56: fload_3                           //将槽位3的变量压入栈顶
        57: fdiv                              //栈顶两元素10和2.5相除
        58: fstore        6                   //将结果值4存放于槽位6中
        60: fload         6                   //将槽位6的变量压入栈顶
        62: ldc           #13                 // float 3.0f 
        64: fcmpl                             //栈顶两个元素做比较,并将比较结果压入栈顶
        65: ifle          102                 //如果比较结果小于0,跳转至102行
        68: ldc2_w        #11                 // double 3.0d
        71: dload         4                   //将double型数值压入栈顶
        73: dmul                              //栈顶两元素3*3相乘
        74: dstore        7                   //将结果值9存放于槽位7
        76: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        79: new           #3                  // class java/lang/StringBuilder
        82: dup
        83: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
        86: ldc           #14                 // String y=
        88: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        91: dload         7                   //将槽位7的值压入栈顶
        93: invokevirtual #15                 // Method java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
        96: invokevirtual #8                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        99: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       102: return
      LineNumberTable:
        line 14: 0
        line 15: 2
        line 16: 4
        line 17: 11
        line 16: 15
        line 19: 21
        line 21: 46
        line 22: 49
        line 23: 54
        line 24: 60
        line 25: 68
        line 26: 76
        line 29: 102
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            6      15     3     i   I
           76      26     7     y   D
            0     103     0  args   [Ljava/lang/String;
            2     101     1   sum   I
            4      99     2   num   I
           49      54     3     a   F
           54      49     4     b   D
           60      43     6     x   F
      StackMapTable: number_of_entries = 3
        frame_type = 254 /* append */
          offset_delta = 6
          locals = [ int, int, int ]
        frame_type = 250 /* chop */
          offset_delta = 14
        frame_type = 254 /* append */
          offset_delta = 80
          locals = [ float, double, float ]
}
SourceFile: "Hello.java"

```



2.（必做）自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。文件群里提供。
java源码

```
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

```



3.（必做）画一张图，展示 Xmx、Xms、Xmn、Meta、DirectMemory、Xss 这些内存参数的关系。

```
-Xms  初始堆内存大小，默认物理内存64/1

-Xmx  最大堆内存，默认物理内存4/1

-Xss 栈内存大小

-Xmn 年轻代大小

meta 元数据

Direct Memory 直接内存，并不是虚拟机运行时数据区的一部分，也不是Java虚拟机规范中定义的内存区域
```




4.（选做）检查一下自己维护的业务系统的 JVM 参数配置，用 jstat 和 jstack、jmap 查看一下详情，并且自己独立分析一下大概情况，思考有没有不合理的地方，如何改进。

注意：如果没有线上系统，可以自己 run 一个 web/java 项目。

Week01 作业题目（周六）：

1.（选做）本机使用 G1 GC 启动一个程序，仿照课上案例分析一下 JVM 情况。