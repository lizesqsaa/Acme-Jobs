<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<h2>
	<acme:message code="administrator.dashboard.form.title.company-records"/>
</h2>

<div>
	<canvas id="canvas1"></canvas>
</div>



<script type="text/javascript">
$(document).ready(function() {
	var data = {
			labels : [
				<jstl:forEach items="${companySector}" var="section">
					'<jstl:out value="${section.key}"/>',
				</jstl:forEach>
			],
			
			datasets : [
				{
					data : [
						<jstl:forEach items="${companySector}" var="section">
							<jstl:out value="${section.value}"/>,
						</jstl:forEach>
					]
				}
			]			
	};
	
	var options = {
			scales : {
				yAxes : [
					{
						ticks : {
							suggestedMin : 0, 
							suggestedMax : 8
						}
					}
				]
			},
			legend : {
				display : false
			}
	};
	
	var canvas, context;
	
	canvas = document.getElementById("canvas1");
	context = canvas.getContext("2d");
	new Chart(context, {
		type : "bar", 
		data : data,
		options : options
	});
});
</script>





<h2>
	<acme:message code="administrator.dashboard.form.title.investor"/>
</h2>

<div>
	<canvas id="canvas2"></canvas>
</div>

<script type="text/javascript">
$(document).ready(function() {
	var data = {
			labels : [
				<jstl:forEach items="${investorSector}" var="section">
					'<jstl:out value="${section.key}"/>',
				</jstl:forEach>
			],
			
			datasets : [
				{
					data : [
						<jstl:forEach items="${investorSector}" var="section">
							<jstl:out value="${section.value}"/>,
						</jstl:forEach>
					]
				}
			]			
	};
	
	var options = {
			scales : {
				yAxes : [
					{
						ticks : {
							suggestedMin : 0, 
							suggestedMax : 8
						}
					}
				]
			},
			legend : {
				display : false
			}
	};
	
	var canvas, context;
	
	canvas = document.getElementById("canvas2");
	context = canvas.getContext("2d");
	new Chart(context, {
		type : "bar", 
		data : data,
		options : options
	});
});
</script>