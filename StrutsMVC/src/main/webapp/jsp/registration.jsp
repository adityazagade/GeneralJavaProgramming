<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<h1>Player Registration Form</h1>
<html:form action="register" method="post">
	<table>
		<tr>
			<td>Name:</td>
			<td><html:text property="name"></html:text></td>
			<td><html:errors property="name_e" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><html:text property="email"></html:text></td>
			<td><html:errors property="email_e" /></td>
		</tr>
		<tr>
			<td>Gender:</td>
			<td><html:errors property="gender_e" /></td>
		<tr>
			<td>MALE:</td>
			<td><html:radio property="gender" value=""></html:radio></td>
		</tr>
		<tr>
			<td>FEMALE:</td>
			<td><html:radio property="gender" value=""></html:radio></td>
		</tr>
		<tr>
			<td>Address:</td>
			<td><html:textarea property="address"></html:textarea></td>
			<td><html:errors property="address_e" /></td>
		</tr>
		<tr>
			<td></td>
			<td><html:submit></html:submit></td>
			<td></td>
		</tr>
	</table>
</html:form>