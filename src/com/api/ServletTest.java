package com.api;

import javax.servlet.ServletInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wdq on 16-9-22.
 */
public class ServletTest extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String userName = request.getParameter("userName");

        ServletInputStream inputStream = request.getInputStream();
        byte []b=new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while((len=inputStream.read(b))!=-1){
            sb.append(new String(b,0,len));
        }

        System.out.println(sb);

        Map<String,Object> s = new HashMap<>();
        s.put("aa","aa");
        s.put("bb","bb");
        s.put("userName",userName);
        response.setHeader("content-type","application/json");
        response.getOutputStream().write("{\"userName\":\"aa\",\"bb\":\"ccc\"}".getBytes());
    }
}
