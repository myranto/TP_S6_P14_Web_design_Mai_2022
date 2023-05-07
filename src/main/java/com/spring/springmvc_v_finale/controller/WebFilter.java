//package com.spring.springmvc_v_finale.controller;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//
////@javax.servlet.annotation.WebFilter(urlPatterns = "/*")
//public class WebFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // Initialize filter
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//
//        // Récupération de l'URL
//        String url = httpRequest.getRequestURI();
//        System.out.println("URL : " + url.toString());
//        chain.doFilter(request, response);
//    }
//    public static String retrieveUrlFromRawUrl(String link) throws Exception {
//        String[] url=link.split("/");
//        if(url.length>0){
//            return url[url.length-1];
//        }
//        throw new Exception("Url not found");
//    }
//    @Override
//    public void destroy() {
//        // Cleanup resources used by filter
//    }
//
//}
