package com.ah_service.dps.interceptor;

import com.ah_service.dps.model.Doctor;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Objects;

public class LoginHandlerInterceptor implements HandlerInterceptor {


    /**
     * 检测session中是否存有对应的token
     */
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception {
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
                //如果访问医院系统，那么需要对应的医院管理权限,
                if (user.getIsadmin()) {
                    //如果用户为管理员，那么可以操作所有的权限
                    return true;
                } else if (user.getIshosadmin()) {
                    //如果是医院管理员，那么不能进入到添加医院界面
                    if (url.contains("hospitallist")) {
                        req.getRequestDispatcher("/content/common/error-403.html").forward(req, res);
                        return false;
                    }
                } else {
                    if (url.contains("hospital")) {
                        //返回到没有对应权限页面
                        req.getRequestDispatcher("/content/common/error-403.html").forward(req, res);
                        return false;
                    }
                }
                return true;
            }
            return true;
        } else {
            res.setHeader("session_invalid", "true");
            //判断如果是ajax请求，那么返回401
            if (Objects.equals(req.getHeader("X-Requested-With"), "XMLHttpRequest")) {
                res.setStatus(HttpStatus.UNAUTHORIZED.value());
            } else {
                req.getRequestDispatcher("/login.html").forward(req, res);
            }
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }

}
