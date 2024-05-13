package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class XHJPHMServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("\"D:\\tools\\Anaconda\\envs\\tensorflow_2.6\\python.exe\"", "D:\\WebPHM\\pythonProject\\.idea\\dataoutput.py");
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            // 读取脚本输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line);  // 将每一行输出直接发送到客户端
                out.flush();  // 确保数据即时发送
            }
            int exitCode = process.waitFor();
            out.println("Script executed with exit code " + exitCode);
        } catch (Exception e) {
            e.printStackTrace(out);
            out.println("Failed to run the script: " + e.getMessage());
        }
    }
}
