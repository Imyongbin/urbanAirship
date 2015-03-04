<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>DeviceList</title>
	</head>
	<Script type="text/javascript">
		function goDeviceList(){
			document.frm.action = "deviceList.do";
			document.frm.submit();
		}
		function goTagSetting(){
			document.frm.action = "tag.do";
			document.frm.submit();
		}
	</Script> 
	<body>
		<form name="frm" id="frm" action="/getDeviceList.do">
			<table>
			
				<tr>
					<td><a href="#" onclick="goDeviceList()">DeviceList 가져오기 </a></td>
					<td><a href="#" onclick="goTagSetting()">Tag 설정</a></td>
				</tr>
			</table>
		</form>
	</body>
</html>
