package Demo_all;

import java.io.FileReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: vanse(lc)
 * @Date: 2023/9/4-09-04-9:14
 * @Description：接收请求 并响应
 * http协议
 * 请求 请求行(get /a.txt http 1.1) 请求头 请求体
 * 响应 响应行 响应头 响应体
 */
public class MyServer {
    public static Map<String,Class<?>> map = new HashMap<>();
    public static Properties properties = new Properties();
    static {
        // 初始化资源 一次 加载properties文件 Map<String,Class>
        try {
            FileReader fileReader = new FileReader("init.properties");
            properties.load(fileReader);
            properties.forEach((k,v) -> {
                try {
                    map.put((String) k,Class.forName((String) v));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        try {
            // 1.创建服务端
            ServerSocket serverSocket = new ServerSocket(9999);
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            while (true) {
                // 2.连接客户端 (浏览器)
                Socket socket = serverSocket.accept();
                System.out.println("socket = " + socket);
//                new MyThreadHandler(socket).start();
                // 提交线程任务 把任务给线程池里的线程
                executorService.submit(new MyThreadHandler(socket));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}