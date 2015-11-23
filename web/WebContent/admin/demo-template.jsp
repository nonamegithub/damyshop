<%@page import="java.io.File"%>
<%@page import="com.bansach.model.bo.SanPhamBO"%>
<%@page import="com.bansach.model.bean.SanPham"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="../templates/admin-template.jsp">

	<tiles:putAttribute name="content">
		<div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">This is demo-templatepage</h1>
            </div>
            <!-- /.col-lg-12  -->
        </div>
        
        <!--body  -->
        <h3>
        	<%
        		SanPham sp = new SanPhamBO().getSanPhamTheoMa(1);
        		String realPath = getServletContext().getRealPath("") + "reso2urces\\images" + java.io.File.separator + sp.getAnh() ;
        		out.println(realPath);
        		
        		File f = new File(realPath);
        		out.println(f.exists());
        	%>
        </h3>
        
	</tiles:putAttribute>
	
	<tiles:putAttribute name="javascript-source">
	</tiles:putAttribute>

</tiles:insertTemplate>