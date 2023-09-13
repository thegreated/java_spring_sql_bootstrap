
	<%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>

	<div class="container">
	<div>
		Welcome to accenture ${name}
	</div>
	<hr>
	<h1> Your Todos</h1>
			<table class="table">
				<thead>

					<th>Description 3</th>
					<th>Target date</th>
					<th>Is Done?</th>
					<th></th>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>

							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
							<td><a href="update-todo?id=${todo.id}" class="btn btn-success ">UPDATE</a> </td>
							<td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">DELETE</a> </td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
			<a class="btn btn-primary" href="add-todo">Add Todo</a>
	</div>
	<%@ include file="common/footer.jspf" %>
