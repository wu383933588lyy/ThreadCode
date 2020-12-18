package concurrent.communication;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.CountDownLatch;

/**
 * @Author WuRui
 * @ClassName PipedCommunication
 * @Date 2020/12/17 14:27
 * @Version 1.0
 * @Description //TODO 线程间通信 - 管道输入、输出流
 * 和普通的文件输入/输出流或者网络输入/输出流不同之处在于
 * 它主要用于线程之间的数据传输，而传输的媒介为内存。
 * 管道输入/输出流主要包括了如下4种具体实现：
 * PipedOutputStream、PipedInputStream
 * PipedReader 和  PipedWriter
 * 前两种面向字节，而后两种面向字符。
 **/
public class PipedCommunication {

    /**
     * 数据写入线程
     */
    private static class Writer implements Runnable {

        /**
         * 管道字符输出流
         */
        private PipedWriter pipedWriter;

        /**
         * 构造器
         *
         * @param pipedWriter 管道字符输出流
         */
        public Writer(PipedWriter pipedWriter) {
            this.pipedWriter = pipedWriter;
        }

        @Override
        public void run() {
            // 输入的字符
            int receive;
            try {
                // 读取控制台写入的字符
                while ((receive = System.in.read()) != -1) {
                    System.out.println(Thread.currentThread().getName() + "写入字符：" + (char) receive);
                    // 写入字符到管道字符输出流中
                    pipedWriter.write(receive);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    pipedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 打印数据的线程
     */
    private static class Printer implements Runnable{

        /**
         * 管道字符输入流
         */
        private PipedReader pipedReader;

        /**
         * 构造器
         * @param in 管道字符输入流
         */
        public Printer(PipedReader in) {
            this.pipedReader = in;
        }

        @Override
        public void run() {
            // 输入的字符
            int receive;
            try {
                // 管道字符输入流读取数据
                while ((receive = pipedReader.read()) != -1) {
                    System.out.println(Thread.currentThread().getName() + "打印字符:" + (char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        // 链接输入流输出流
        out.connect(in);
        // 打印线程
        Thread inThread = new Thread(new Printer(in), "打印线程");
        inThread.start();
        Thread outThread = new Thread(new Writer(out), "写入线程");
        outThread.start();

    }
}
