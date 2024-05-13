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

            // ��ȡ�ű����
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line);  // ��ÿһ�����ֱ�ӷ��͵��ͻ���
                out.flush();  // ȷ�����ݼ�ʱ����
            }
            int exitCode = process.waitFor();
            out.println("Script executed with exit code " + exitCode);
        } catch (Exception e) {
            e.printStackTrace(out);
            out.println("Failed to run the script: " + e.getMessage());
        }
    }
}
