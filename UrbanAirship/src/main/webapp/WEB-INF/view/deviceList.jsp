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
		function getDeviceList(){
			document.frm.action = "/getDeviceList.do";
			document.frm.submit();
		}
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
			
			<table style="margin-top:50px;">
				<tr>
					<td>DeviceList 가져오기 </td>
					<td><button onclick="getDeviceList()">실행</button></td>
				</tr>
			</table>
			<table style="margin-top:50px;">
				<tr>
					<td>Device List </td>
				</tr>
			</table>
			<table>
				<tr>
					<td>total count</td>
					<td>${count}</td>
				</tr>
				<tr>
					<td>active count</td>
					<td>${activeCount}</td>
				</tr>
			</table>
			<table border="1" style="margin-top:15px;">
				<tr>
					<td>DEVICE</td>
					<td>DEVICE_TYPE</td>
					<td>CUS_NUM</td>
					<td>DEVICE_UID</td>
					<td>TAGS</td>
					<td>ACTIVE</td>
					<td>CREATE_DATE</td>
				</tr>
				<c:forEach var="list" items="${deviceList}">
					<tr>
						<td>${list.device_key}</td>
						<td>${list.device_type}</td>
						<td>${list.cus_num}</td>
						<td>${list.device_uid}</td>
						<td>${list.tag}</td>
						<td>${list.active}</td>
						<td>${list.created}</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</body>
</html>
