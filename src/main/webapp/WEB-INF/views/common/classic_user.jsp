  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html lang="en">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <body>
        <!-- Menu -->
        <tiles:insertAttribute name="menu" />
        <!-- Header-->
        <tiles:insertAttribute name="header" />
        <!-- content -->
        <tiles:insertAttribute name="body" />
        <!-- Footer-->
        <tiles:insertAttribute name="footer" />
    </body>
</html>