package com.sue.stusystem.client.interceptor;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URL;

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        String isLogin = (String) session.getAttribute("isLogin");
        if (isLogin != null) {
            return true;
        }
        System.out.println("pass");
        String token = request.getParameter("token");
        System.out.println(token);
        if (!StringUtils.isEmpty(token)) {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet("http://www.sso.com:9100/checkToken?token="+token);
            CloseableHttpResponse httpResponse = null;
            try {
                httpResponse=client.execute(httpGet);

                HttpEntity entity = httpResponse.getEntity();

//                String res = new String();
//                System.out.println(EntityUtils.toString(entity,"UTF-8"));
                String res = EntityUtils.toString(entity,"UTF-8");


                if("true".equals(res)){
                    session.setAttribute("isLogin",token);
                    System.out.println("yes");
                    return true;
                }


            }catch (Exception e){
                e.printStackTrace();
            }finally {

                client.close();
                httpResponse.close();
            }
        }
        URL url = new URL("http://www.sso.com:9100/");
        StringBuilder sb = new StringBuilder();
        sb.append(url.toString()).append("checkLogin")
                .append("?").append("redirectUrl=").append("http://www.client.com:9001/system");



        response.sendRedirect(sb.toString());

        return false;


    }
}
