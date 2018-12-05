package com.ah_service.dps.configuration;

import com.ah_service.dps.model.Doctor;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Configuration
public class ConfigurationFilter {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new AuthFilter());
        registrationBean.addUrlPatterns("/*");//设置过滤路径，/*所有路径
        registrationBean.setName("AuthFilter");//设置优先级
        registrationBean.setOrder(1);//设置优先级
        return registrationBean;
    }

    public class AuthFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            HttpServletResponse res = (HttpServletResponse) servletResponse;
            if (req.getRequestURI().endsWith(".png")
                    || req.getRequestURI().endsWith(".jpg")
                    || req.getRequestURI().endsWith(".gif")
                    || req.getRequestURI().endsWith(".jpeg")
                    || req.getRequestURI().endsWith("/login.html")
                    || req.getRequestURI().endsWith("defaultKaptcha")
                    || req.getRequestURI().endsWith(".js")
                    || req.getRequestURI().endsWith(".css")
                    || req.getRequestURI().endsWith(".svg")
                    || req.getRequestURI().endsWith(".eot")
                    || req.getRequestURI().endsWith(".woff")
                    || req.getRequestURI().endsWith(".ttf")
                    || req.getRequestURI().endsWith(".ico")
                    || req.getRequestURI().endsWith(".jsp")
                    || req.getRequestURI().endsWith("/freightToOut") //过滤运价接口
                    || req.getRequestURI().contains("/:") //处理前端页面
                    || req.getRequestURI().endsWith("/login") //登录页面
                    || req.getRequestURI().endsWith("/reg")   //注册页面
                    || req.getRequestURI().endsWith(".php")//不拦截.php请求
                    || req.getRequestURI().endsWith(".pc")//不拦截pc客户端的接口请求
                    || req.getRequestURI().contains("test")//不拦截pc客户端的接口请求
                    || req.getRequestURI().endsWith("/ws")//不拦截socket请求
                    || req.getRequestURI().contains("/common/") //通用页面不做拦截
                    ) {
                filterChain.doFilter(req, res);
                return ;
            }
            if (req.getSession().getAttribute("user") != null) {
                if (Objects.equals(req.getHeader("session_invalid"), "true")) {
                    //重新将头设置为未失效状态
                    res.setHeader("session_invalid", null);
                }
                //校验用户是否有访问此页面的权限, 通用页访问不需要权限， 所有用户都能访问首页, common目录下为通用页，不需要权限就可以访问
                if (req.getRequestURI().endsWith(".html")
                        && !req.getRequestURI().endsWith("index.html")
                        && !StringUtils.contains(req.getRequestURI(), "/common/")) {
                    Doctor user = (Doctor) req.getSession().getAttribute("user");

                    //监测用户权限
                    String url = req.getRequestURI().substring(req.getRequestURI().indexOf("content") + 8).replace(".html", "");
                    System.out.println(url);
                    //如果访问医院系统，那么需要对应的医院管理权限,
                    if (user.getIsadmin() != null && user.getIsadmin()) {
                        //如果用户为管理员，那么可以操作所有的权限
                        filterChain.doFilter(req, res);
                    } else if (user.getIshosadmin() != null && user.getIshosadmin()) {
                        //如果是医院管理员，那么不能进入到添加医院界面
                        if (url.contains("hospitallist")) {
                            req.getRequestDispatcher("/content/common/error-403.html").forward(req, res);
                            return;
                        }
                    } else {
                        if (url.contains("hospital")) {
                            //返回到没有对应权限页面
                            req.getRequestDispatcher("/content/common/error-403.html").forward(req, res);
                            return;
                        }
                    }
                    filterChain.doFilter(req, res);
                }
                filterChain.doFilter(req, res);
            } else {
                res.setHeader("session_invalid", "true");
                //判断如果是ajax请求，那么返回401
                if (Objects.equals(req.getHeader("X-Requested-With"), "XMLHttpRequest")) {
                    res.setStatus(HttpStatus.UNAUTHORIZED.value());
                } else {
                    req.getRequestDispatcher("/login.html").forward(req, res);
                }
            }
        }

        @Override
        public void destroy() {

        }
    }
}
