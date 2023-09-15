package Demo_all;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

enum Permission1 {
    GUEST, ADMIN, VIP
}

//获取txt资源
class Resource_txt1 {

    public static String getContent(String path) throws IOException {
//        缓冲流
        BufferedReader br = new BufferedReader(new FileReader(path));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            content.append(line).append("\n");
        }
        br.close();
//        返回
        return content.toString();
    }
}

//控制权限
class ControlPermission1 {
//	map集合存权限，读取
	private final Map<String, Permission1> role=new HashMap<>();
    public ControlPermission1() {
        role.put("guest", Permission1.GUEST);
        role.put("admin", Permission1.ADMIN);
        role.put("vip", Permission1.VIP);
    }
    public Permission1 getRolePermission(String role1) {
        return role.getOrDefault(role1, Permission1.GUEST);
    }

	//处理动态请求
	public String handleDynamicRequest(String role) {
		Permission1 per = Permission1.ADMIN;
		// 获取权限，访问权限
		Permission1 user = getRolePermission(role);
		// 内置Enum方法ordinal()
		if (user.ordinal() >= per.ordinal()) {
			return "Hello boy";
		} else {
			return "Insufficient permissions";
		}
	}
}

//服务端的编写
public class WebServer1 {
	public static void main(String[] args) {
//        Resource_txt1 rt = new Resource_txt1();
        ControlPermission1 cp=new ControlPermission1();

//        等待客户端连接
        try (ServerSocket serverSocket=new ServerSocket(9999)) {
            while (true) {
//				监听端口
                Socket client = serverSocket.accept();
                System.out.println("客户端连接："+client);

                Thread clientThread=new Thread(()-> {
////                	@Override
//                	public void run() {
                	    try (
                	        // 创建缓冲流
                	        BufferedReader br = new BufferedReader(
									new InputStreamReader(client.getInputStream()));

                	        BufferedWriter bw = new BufferedWriter(
									new OutputStreamWriter(client.getOutputStream()))
                	    ) {
                	        // 流读取
                	        String content = br.readLine();
                	        // 请求一:GET /hello.txt HTTP/1.1
							String[] parts = content.split(" ");
							if (parts.length == 3) {
								String path = parts[1];
								if (path.equals("/hello.txt")) {
									String resContent = Resource_txt1.getContent("hello.txt");
									bw.write("HTTP/1.1 200 OK\n");
									bw.write("Content-Type: text/plain; charset=utf-8\n");
									//时间戳
									long currentTimeMillis = System.currentTimeMillis();
									Date currentDate = new Date(currentTimeMillis);
									bw.write("Date: "+currentDate + "\n\n");
									bw.write(resContent);
									bw.flush();

								} else if (path.equals("ControlPermission1")) {
									String role = "admin";
									Permission1 per = Permission1.ADMIN;
									// 获取权限，访问权限
									Permission1 user = cp.getRolePermission(role);
									String dynamicResponse = cp.handleDynamicRequest(role);
									//内置Enum方法ordinal()
									if (user.ordinal() >= per.ordinal()) {
										bw.write("HTTP/1.1 200 OK\n");
										bw.write("Content-Type: text/plain; charset=utf-8\n");
										//时间戳
										long currentTimeMillis = System.currentTimeMillis();
										Date currentDate = new Date(currentTimeMillis);
										bw.write("Date: "+currentDate + "\n\n");
										bw.write(dynamicResponse);
									} else {
										bw.write("HTTP/1.1 403 Forbidden\n");
										bw.write("Content-Type: text/plain; charset=utf-8\n");
										//时间戳
										long currentTimeMillis = System.currentTimeMillis();
										Date currentDate = new Date(currentTimeMillis);
										bw.write("Date: "+currentDate + "\n\n");
										bw.write(dynamicResponse);
									}
									bw.flush();
								} else {
									bw.write("HTTP/1.1 404 Resource no found\n");
									bw.write("Content-Type: text/plain; charset=utf-8\n");
									//时间戳
									long currentTimeMillis = System.currentTimeMillis();
									Date currentDate = new Date(currentTimeMillis);
									bw.write("Date: "+currentDate + "\n\n");
									bw.write("Resource not found");
									bw.flush();
								}
							}
//                	    }// 关流
                	    bw.close();
						br.close();
                	    client.close();
                	    } catch (IOException e) {
                	        e.printStackTrace();
                	    }
//                	}
                });
//          线程开启
            clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
