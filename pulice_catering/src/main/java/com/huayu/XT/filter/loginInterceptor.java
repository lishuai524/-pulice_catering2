package com.huayu.XT.filter;

import com.huayu.XT.staffs.entity.Staffs;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class loginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Staffs staffs = (Staffs) httpServletRequest.getSession().getAttribute("user");
        List<String> list = (ArrayList)httpServletRequest.getSession().getAttribute("twoList");
        //System.out.println(list.size());
        System.out.println(httpServletRequest.getRequestURI());
        if(httpServletRequest.getRequestURI().equals("/staffs/staffs/login.do")){
            return true;
        }
        if(staffs == null){
            httpServletRequest.getRequestDispatcher("/jsp/login.jsp").forward(httpServletRequest,httpServletResponse);
            return false;
        }
        if(!list.contains(httpServletRequest.getRequestURI())){
            httpServletRequest.getRequestDispatcher("/jsp/tishi.jsp").forward(httpServletRequest,httpServletResponse);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
