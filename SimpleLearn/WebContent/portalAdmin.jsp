<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <body>
<div class="sidenav">
	
	<c:url var="classesLink" value="AdminAction">
		<c:param name="command" value="CLASSES" />
	</c:url>

	<c:url var="subjectsLink" value="AdminAction">
		<c:param name="command" value="SUBJECTS" />
	</c:url>

	<c:url var="teachersLink" value="AdminAction">
		<c:param name="command" value="TEACHERS" />
	</c:url>

	<c:url var="studentsLink" value="AdminAction">
		<c:param name="command" value="STUDENTS" />
	</c:url>
	
	<a class="bar-item" href="${classesLink}">Classes</a> 
		<a class="bar-item" href="${subjectsLink}">Subjects</a>
		<a class="bar-item" href="${teachersLink}">Teachers</a> 
		<a class="bar-item" href="${studentsLink}">Students</a> 
		<a class="bar-item" href="login.jsp">Log out</a>

</div>
</body> 
