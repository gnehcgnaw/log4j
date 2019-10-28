package org.apache.log4j.samples;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;

import java.io.IOException;

/**
 *
 * 创建新的Appender,继承FileAppender，在构造中添加钩子程序代码
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/10/29 00:08
 */
public class HookFileAppender extends FileAppender {
    public HookFileAppender(){
        super();
        //添加钩子程序：
        Runtime.getRuntime().addShutdownHook(new Log4jHockThread());
    }
    public HookFileAppender(Layout layout, String filename) throws IOException {
        super(layout,filename);
        //添加钩子程序：
        Runtime.getRuntime().addShutdownHook(new Log4jHockThread());
    }
    public HookFileAppender(Layout layout, String filename, boolean append) throws IOException {
        super(layout,filename,append);
        //添加钩子程序：
        Runtime.getRuntime().addShutdownHook(new Log4jHockThread());
    }
    public HookFileAppender(Layout layout, String filename, boolean append, boolean bufferedIO,
                            int bufferSize) throws IOException {
        super(layout,filename,append,bufferedIO,bufferSize);
        Runtime.getRuntime().addShutdownHook(new Log4jHockThread());
    }

    class Log4jHockThread extends Thread{
        public void run() {
            //jvm结束之前，运行flush操作，将日志落盘；
            if(qw != null){
                qw.flush();
            }
        }
    }
}
