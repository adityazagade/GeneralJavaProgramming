<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<table>
<tr height="20%">
	<tiles:insert attribute="header"/>
</tr>
<tr>
	<td width="20%"><tiles:insert attribute="nav"/></td>
	<td width="80%"><tiles:insert attribute="body"/></td>
</tr>
<tr height="20%">
	<td><tiles:insert attribute="footer"/></td>
</tr>
</table>
