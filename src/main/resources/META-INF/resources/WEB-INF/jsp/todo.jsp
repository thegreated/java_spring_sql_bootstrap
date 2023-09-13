
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <h2>Add Todo Details</h2>
    <form:form class="form-group" method="POST" modelAttribute="todo">
        <div class="form-control">
            <form:input type="hidden" path="id" />

            <fieldset class="mb-3">
                <form:label path="description">Description:</form:label>
                <form:input type="text" path="description" />
                <form:errors path="description" cssClass="text-danger" />
            </fieldset
            <fieldset class="mb-3">
                <form:label path="targetDate">To do Date:</form:label>
                <form:input type="text" path="targetDate" />
                <form:errors path="targetDate" cssClass="text-danger" />
            </fieldset>

            <form:input type="hidden" path="done" />
        </div>
        <input class="mt-2 btn btn-primary" type="submit">
    </form:form>

</div>

<%@ include file="common/footer.jspf" %>
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd',
    });
</script>
