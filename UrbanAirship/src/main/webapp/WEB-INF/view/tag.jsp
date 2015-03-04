<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Tag Setting</title>
	</head>
	<Script type="text/javascript">
		function setTag(){
			document.frm.action = "/setTag.do";
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
		<form name="frm" id="frm" method="post" action="/setTag.do">
			<table>
				<tr>
					<td><a href="#" onclick="goDeviceList()">DeviceList 가져오기 </a></td>
					<td><a href="#" onclick="goTagSetting()">Tag 설정</a></td>
				</tr>
			</table>
			
			<table style="margin-top:50px;">
				<tr>
					<td>캠페인명</td>
					<td>
						<select name="cell_id">
							<c:forEach var="list" items="${campList}">
								<option value="${list.cell_id}">${list.camp_name}</option>
							</c:forEach>
							
						</select> 
					</td>
				</tr>
				<tr>
					<td>Key</td>
					<td>
						<select name="key">
							<option value="cus_num">CUS_NUM</option>
							<option value="device_uid">DEVICE_UID</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Tag</td>
					<td><input type="text" name="tag_name"/> </td>
				</tr>
				<tr> 
					<td>Tag Set</td>
					<td><button onclick="setTag()">실행</button></td>
				</tr>
			
			</table>
		</form>
	</body>
</html>
