<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
   response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
   //response.setHeader("Location","https://www.baidu.com");
   response.setHeader("Location",request.getParameter("url"));
%>