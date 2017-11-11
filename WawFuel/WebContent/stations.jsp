<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stations</title>
<style type="text/css">
.filterable {
	margin-top: 15px;
}

.filterable .panel-heading .pull-right {
	margin-top: -20px;
}

.filterable .filters input[disabled] {
	background-color: transparent;
	border: none;
	cursor: auto;
	box-shadow: none;
	padding: 0;
	height: auto;
}

.filterable .filters input[disabled]::-webkit-input-placeholder {
	color: #333;
}

.filterable .filters input[disabled]::-moz-placeholder {
	color: #333;
}

.filterable .filters input[disabled]:-ms-input-placeholder {
	color: #333;
}
</style>

<script type="text/javascript">

$(document).ready(function(){
    $('.filterable .btn-filter').click(function(){
        var $panel = $(this).parents('.filterable'),
        $filters = $panel.find('.filters input'),
        $tbody = $panel.find('.table tbody');
        if ($filters.prop('disabled') == true) {
            $filters.prop('disabled', false);
            $filters.first().focus();
        } else {
            $filters.val('').prop('disabled', true);
            $tbody.find('.no-result').remove();
            $tbody.find('tr').show();
        }
    });

    $('.filterable .filters input').keyup(function(e){
        /* Ignore tab key */
        var code = e.keyCode || e.which;
        if (code == '9') return;
        /* Useful DOM data and selectors */
        var $input = $(this),
        inputContent = $input.val().toLowerCase(),
        $panel = $input.parents('.filterable'),
        column = $panel.find('.filters th').index($input.parents('th')),
        $table = $panel.find('.table'),
        $rows = $table.find('tbody tr');
        /* Dirtiest filter function ever ;) */
        var $filteredRows = $rows.filter(function(){
            var value = $(this).find('td').eq(column).text().toLowerCase();
            return value.indexOf(inputContent) === -1;
        });
        /* Clean previous no-result if exist */
        $table.find('tbody .no-result').remove();
        /* Show all rows, hide filtered ones (never do that outside of a demo ! xD) */
        $rows.show();
        $filteredRows.hide();
        /* Prepend no-result row if all rows are filtered */
        if ($filteredRows.length === $rows.length) {
            $table.find('tbody').prepend($('<tr class="no-result text-center"><td colspan="'+ $table.find('.filters th').length +'">No result found</td></tr>'));
        }
    });
});
</script>

</head>
<body>
<%-- ${lower} --%>
<div class="container">
		
		<hr>
		<div class="row">
			<div class="panel panel-primary filterable">
				<div class="panel-heading">
					<h3 class="panel-title">Warsaw fuel stations</h3>
					<div class="pull-right">
						<button class="btn btn-default btn-xs btn-filter">
							<span class="glyphicon glyphicon-filter"></span>
							filter
						</button>
					</div>
				</div>
				<table class="table">
					<thead>
						<tr class="filters">
							<th><input type="text" class="form-control" placeholder="id" disabled></th>						
							<th><input type="text" class="form-control" placeholder="Station brand" disabled></th>
							<th><input type="text" class="form-control" placeholder="Address" disabled></th>
							<th><input type="text" class="form-control" placeholder="fuel type" disabled></th>
							<th><input type="text" class="form-control" placeholder="price" disabled></th>
							<th><input type="text" class="form-control" placeholder="update from" disabled></th>
							<th><input type="text" class="form-control" placeholder="rate" disabled></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${result}" var="resultList" varStatus="status">
						<%-- <c:forEach items="${result.getResultList()}" var="resultList" varStatus="status"> --%>
							<tr>
								<td>${resultList.getIdStation()}</td>
								<td><c:out value="${resultList.getStationBrand()}" /></td>
								<!-- another short example to get method  -->
								<td>${resultList.getAddress()}</td>
								<td>${resultList.getFuelType()}</td>
								<td>${resultList.getPrice()}</td>
								<td>${resultList.getDate()}</td>
								<td>${resultList.getRate()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>


<%-- 


<table class="table">
					<thead>
						<tr class="filters">
							<th><input type="text" class="form-control" placeholder="id" disabled></th>						
							<th><input type="text" class="form-control" placeholder="Station brand" disabled></th>
							<th><input type="text" class="form-control" placeholder="Address" disabled></th>
							<th><input type="text" class="form-control" placeholder="fuel type" disabled></th>
							<th><input type="text" class="form-control" placeholder="price" disabled></th>
							<th><input type="text" class="form-control" placeholder="update from" disabled></th>
                       
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${result.getResultList()}" var="resultList" varStatus="status">
							<tr>
								<td>${resultList.getIdStation()}</td>
								<td><c:out value="${resultList.getStationBrand()}" /></td>
								<!-- another short example to get method  -->
								<td>${resultList.getAddress()}</td>
								<td>${planets.getFuelType()}</td>
								<td>${planets.getPrice()}</td>
								<td>${planets.getDate()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table> --%>

</body>
</html>