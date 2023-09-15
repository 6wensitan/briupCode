package Demo_all;
import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Objects;
/**
 * @Auther: Green Park
 * @Date: 2023/9/4-09-04-9:59
 * @Description：多线程服务客户端
 */
/*注释：
*  // 3.获取客户端请求(获取输入流) localhost:9999
    // 3.1 获取请求行 根据第二个资源URI 判断访问的资源
    *
    * // GET / HTTP/1.1 默认访问 /
      // GET /a.txt HTTP/1.1 /a.txt a.html 静态资源
      // GET /student/hello HTTP/1.1 /student/hello 动态资源
      *
      * // 4.1 响应行(固定) 换行
      * // 4.2 响应头(固定)
        // text/plain 普通文本 text/html 解析html标签
        *
        * // /static/a.txt /static/b.html
        * // static/a.txt
        *
        * // /student/findAll
             // 反射获取获取class对象 /teacher/findAll Tehacer /student/findAll
            //  Class<?> aClass = Class.forName("com.vanse.server.Student");
      * */

public class MyThreadHandler implements Runnable {
    private Socket socket;
    public MyThreadHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintStream ps = new PrintStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String requestLine = br.readLine();
            String requestURI = requestLine.split(" ")[1];
            System.out.println("requestURI = " + requestURI);

            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type: text/plain; charset=UTF-8");
            ps.println();
            // 4.3 响应体(写回的数据)
            //首页
            if ("/".equals(requestURI)) {
                ps.println("欢迎来到首页");
            }
            //静态资源
            else if (requestURI.startsWith("/static")) {
                requestURI = requestURI.substring(1);
                BufferedReader brf = new BufferedReader(new FileReader(requestURI));
                String line;
                while ((line = brf.readLine()) != null) {
                    ps.println(line);
                }
                brf.close();
            }
            //动态资源
            else {
                String[] split = requestURI.split("/");
                if (Objects.nonNull(split) && split.length > 2) {
                    String className = split[1];
                    Class aClass = MyServer.map.get("/" + className);
                    // 反射创建实例
                    Object obj = aClass.newInstance();
                    // 反射调用方法
//                    Method method = aClass.getMethod(split[2]);
                    Method method = aClass.getMethod("defaultMethod");
                    // 反射执行方法
                    Object result = method.invoke(obj);
                    if (Objects.nonNull(result)) {
                        ps.println(result);
                    }
                }
            }
            // 4.响应数据给客户端(发送输出流) 写一行 PrintWriter BufferedWriter PrintStream
            ps.flush();
            ps.close();
            br.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}