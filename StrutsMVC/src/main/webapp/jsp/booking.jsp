<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<h1>Slot Booking Form</h1>
<script type="text/javascript">
	doNext()
	{
		var startTime = document.getElementById("startTime").value;
		var endTime = document.getElementById("startTime").value;
		document.getElementById("st").value = startTime;
		document.getElementById("et").value = endTime;
	}
</script>
<html:javascript formName="slotBooking"/>
<html:form action="book" method="post" onsubmit="doNext()">
	<table>
		<tr>
			<td>Stadium:</td>
			<td><html:text property="stadium"></html:text></td>
			<td><html:errors property="stadium_e" /></td>
		</tr>
		<tr>
			<td>StartTime:</td>
			<html:html>
			<input type="date" id="startTime" name="startTime" />
			</html:html>
			<td><html:errors property="startTime_e" /></td>
		</tr>
		<tr>
			<td>EndTime:</td>
			<html:html>
			<input type="date" id="endTime" name="endTime" />
			</html:html>
			<td><html:errors property="endTime_e" /></td>
		</tr>
		<tr>
			<td></td>
			<td><html:submit>Book</html:submit></td>
			<td></td>
		</tr>
	</table>
</html:form>