package com.thread.priority.daemon;

/**
 * @ClassName DeamonThreadDemo
 * @Author WuRui
 * @Date 2020/6/26 9:03
 * @Version 1.0
 * @Description //TODO
 **/
public class DeamonThreadDemo {

    public static void main(String[] args) {
        CommonThread commonThread = new CommonThread();
        Thread daemonThread = new Thread(new MyDaemon());
        // 在线程启动前设置守护线程，当用户主线程执行完毕，守护线程未执行玩也将退出
        daemonThread.setDaemon(Boolean.TRUE);
        daemonThread.start();
        commonThread.start();
    }
}
