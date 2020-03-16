<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

	<title>Hello, world!</title>
</head>

<body>

	<div class="container mt-3">
		<h1>Formulario para crear actividad</h1>

		<form action="InsertarActividad" method="POST">
			<div class="form-group">
				<label for="nombre">Nombre actividad</label>
				<input type="text" class="form-control" id="nombre" name="nombre">
			</div>

			<div class="form-group">
				<label for="fecha_inicio">Fecha inicio</label>
				<input type="text" class="form-control" id="fecha_inicio" name="fecha_inicio" placeholder="yyyy-MM-dd">
			</div>

			<div class="form-group">
				<label for="dias_semana">Dias semana</label>
				<input type="text" class="form-control" id="dias_semanabre" name="dias_semana">
			</div>

			<div class="form-group">
				<label for="horas">Duracion (horas)</label>
				<input type="text" class="form-control" id="horas" name="horas">
			</div>

			<div class="form-group">
				<label for="max_participantes">Máximo numero de participantes</label>
				<input type="text" class="form-control" id="max_participantes" name="max_participantes">
			</div>

			<div class="form-group">
				<label for="precio">Precio</label>
				<input type="text" class="form-control" id="precio" name="precio">
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>



	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>

</html>