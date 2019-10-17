<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/deal.css" />
</head>
<script type="text/javascript">
	function fillOther(){
		var initP = o("beanPath").value;
		var spit = getSplt(initP);
		var tabelName = initP.substring(initP.lastIndexOf(spit)+1,initP.lastIndexOf("."));
		o("tabelName").value = tabelName;
		o("daoPath").value = initP.replace(tabelName,tabelName+"Dao");
		o("servicePath").value = initP.replace(tabelName,tabelName+"Service");
		o("serviceimplPath").value = initP.replace(tabelName,tabelName+"ServiceImpl");
		o("controllerPath").value = initP.replace(tabelName,tabelName+"Controller");
	}
	
	function o(id){
		return document.getElementById(id);
	}
	
	function getSplt(str){
		var n = str.indexOf("/");
		return n>0?"/":"\\";
	}
</script>
<body>
	<h2>创建项目文件</h2>
		<form action="/csf/DealServlet" method="post" name="MyForm">
			<ul>
				<li><label>表名：</label><input type="text" name="tabelName" id="tabelName" placeholder="User"/></li>
				<li><label>字段：</label><input type="text" name="fieldsName" id="fieldsName" placeholder="id,name..." style="width: 300px"/></li>
				<h3>路径：</h3>
				<li><label>bean：</label><input type="text" id="beanPath" name="beanPath" placeholder="C://path" onblur="fillOther()" style="width: 300px" /></li>
				<li><label>dao：</label><input type="text" id="daoPath" name="daoPath" placeholder="C://path" style="width: 300px"/></li>
				<li><label>service：</label><input type="text" id="servicePath" name="servicePath" placeholder="C://path" style="width: 300px"/></li>
				<li><label>serviceimpl：</label><input type="text" id="serviceimplPath" name="serviceimplPath" placeholder="C://path" style="width: 300px"/></li>
				<li><label>controller：</label><input type="text" id="controllerPath" name="controllerPath" placeholder="C://path" style="width: 300px"/></li>
				<li><input type="submit" value="创建"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset"/></li>
			</ul>
		</form>
</body>
</html>