<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<title>系统测试页面</title>
	<link rel="stylesheet" href="../css/systemteststyle.css" type="text/css"/>
	<script type="text/javascript" src="../js/sendandget.js"></script>
</head>
<body>
	<h1>系统运行测试页面</h1>
	<hr/>
	<p><button id="buttontest" class="buttons">测试js生效否</button><br/></p>
	<p><a class="jstest" href="javascript:void(0)">js测试</a><br/></p>
	<hr/>
	<div>
		<span>
			<p><button id="findAllUser"  class="buttons">查询所有用户</button><br/></p>
			<p><a href="findAllUser">查询所有用户</a></p>
		</span>

		<span>
			<div id="userhz">
				<div id="actable">
					<table id="mytb">
						<thead>
						   <tr>
							  <th>　用户ID　</th>
							  <th>　用户名　</th>
							  <th>　性别　</th>
							  <th>　年龄　</th>
							  <th>　学历　</th>
							  <th>　专业　</th>
							  <th>　　籍贯地址　　</th>
							  <th>　　所属部门　　</th>
							  <th>　　联系电话　　</th>
						   </tr> 
						</thead>
						<tbody id="tbmain"></tbody>
					</table>
				</div>
			</div>
		</span>
	</div>
	
	<hr/>
	<div>
		<p>通过条件查询</p>
		<p>
			<select id="tjfindUser">
			  <option value="uid">----用户ID----</option>
			  <option value="uname">----用户名----</option>
			  <option value="usex">----性别----</option>
			  <option value="uage">----年龄----</option>
			  <option value="ueducate">----学历----</option>
			  <option value="umajor">----专业----</option>
			  <option value="ulocal">----籍贯地址----</option>
			  <option value="udepartment">----所属部门----</option>
			  <option value="uphone">----联系电话----</option>
			</select>
		</p>	
		<p>查询：<input type="text" id="tjcxfindUser"></input></p>	
		<p><button id="tjcxfindUserButton" class="buttons">查询</button></p>
		<span>
			<div id="userhz1">
				<div id="actable1">
					<table id="mytb1">
						<thead>
						   <tr>
							  <th>　用户ID　</th>
							  <th>　用户名　</th>
							  <th>　性别　</th>
							  <th>　年龄　</th>
							  <th>　学历　</th>
							  <th>　专业　</th>
							  <th>　　籍贯地址　　</th>
							  <th>　　所属部门　　</th>
							  <th>　　联系电话　　</th>
						   </tr> 
						</thead>
						<tbody id="tbmain1"></tbody>
					</table>
				</div>
			</div>
		</span>
	</div>

	<hr/>
	<p>通用mapper修改用户</p>
		<p>
			<div>
				<form action="TYupdateUser" method="post">
					<table id="mytb3">
						<thead>
						   <tr>
							  <th>　ID</th>
							  <th>　用户名　</th>
							  <th>　性别　</th>
							  <th>　年龄　</th>
							  <th>　学历　</th>
							  <th>　专业　</th>
							  <th>　　籍贯地址　　</th>
							  <th>　　所属部门　　</th>
							  <th>　　联系电话　　</th>
						   </tr> 
						</thead>
						<tbody >
							<tr class="tbmain3">
							  <th><input name="uid" type="text">必填</th>
							  <th><input name="uname" type="text">必填</th>
							  <th><input name="usex" type="text"></th>
							  <th><input name="uage" type="text"></th>
							  <th><input name="ueducate" type="text"></th>
							  <th><input name="umajor" type="text"></th>
							  <th><input name="ulocal" style="width:150px" type="text"></th>
							  <th><input name="udepartment" style="width:150px" type="text"></th>
							  <th><input name="uphone" style="width:150px" type="text"></th>
						   </tr> 
						</tbody>
					</table>
					<p><input id="updateUser" type="submit" value="更新信息" class="buttons"/></p>
				</form>
			</div>
		</p>
	<hr/>
	<p>通用mapper增加用户</p>
	<span>
		<div id="userhz2">
			<div id="actable2">
				<form action="TYsaveUser" method="post">
					<table id="mytb2">
						<thead>
						   <tr>
							  <th>　用户名　</th>
							  <th>　性别　</th>
							  <th>　年龄　</th>
							  <th>　学历　</th>
							  <th>　专业　</th>
							  <th>　　籍贯地址　　</th>
							  <th>　　所属部门　　</th>
							  <th>　　联系电话　　</th>
						   </tr> 
						</thead>
						<tbody >
							<tr class="tbmain2">
							  <th><input name="uname" type="text"></th>
							  <th><input name="usex" type="text"></th>
							  <th><input name="uage" type="text"></th>
							  <th><input name="ueducate" type="text"></th>
							  <th><input name="umajor" type="text"></th>
							  <th><input name="ulocal" style="width:150px" type="text"></th>
							  <th><input name="udepartment" style="width:150px" type="text"></th>
							  <th><input name="uphone" style="width:150px" type="text"></th>
						   </tr> 
						</tbody>
					</table>
					<p><input id="addusers" type="submit" value="添加"  class="buttons"/></p>
				</form>
			</div>
		</div>
	</span>
	
	
	
	<hr/>
		<p>通用mapper删除用户</p>
		<p>
			<select id="deleteUser">
			  <option value="uid">----用户ID----</option>
			  <option value="uname">----用户名----</option>
			</select>
		</p>
		<p>删除：<input type="text" id="DeleteUser"></input></p>	
		<p><button id="deleteUserButton" class="buttons">删除</button></p>
	<hr/>

</body>
</html>