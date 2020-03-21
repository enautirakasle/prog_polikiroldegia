<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Actividad</title>
  </head>

	<div class="container mt-2 rounded border border-dark">
		<div class="row">
			<div class="col">
				<h1 class="text-center">${actividad.nombre}</h1>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col text-center font-weight-bold">Fecha Inicio</div>
			<div class="col text-center font-weight-bold">${actividad.getFecha_inicio() }</div>
		</div>
		<br>
		<div class="row">
			<div class="col text-center font-weight-bold">Dias Semana</div>
			<div class="col text-center font-weight-bold">${actividad.getDias() }</div>
		</div>
		<br>
		<div class="row">
			<div class="col text-center font-weight-bold">Horas</div>
			<div class="col text-center font-weight-bold">${actividad.getHoras() }</div>
		</div>
		<br>
		<div class="row">
			<div class="col text-center font-weight-bold">Max Participantes</div>
			<div class="col text-center font-weight-bold">${actividad.getMaxParticipantes()}</div>
		</div>
		<br>
		<div class="row">
			<div class="col text-center font-weight-bold">Precio</div>
			<div class="col text-center font-weight-bold">${actividad.getPrecio() } Eur</div>
		</div>
		<br>
		<br>
		<div class="row">
		
			<div class="col text-center font-weight-bold">
				<a class="btn btn-secondary" href="EditarActividad?id=${actividad.getId()}">Editar</a>
			</div>
			<div class="col text-center font-weight-bold">
				<a class="btn btn-danger" href="ElimnarActividad?id=${actividad.getId()}">Eliminar</a>
			</div>
			    
		</div>
		<div class="row mt-3">
			<div class="col">
				<a href="VerActividades">Ver actividades</a>
			</div>
			
		</div>
		<br>
	</div>
	
			
	<div class="container mt-2 py-2 rounded border border-dark">
		<div class="row">
			<div class="col">
				<c:if test = "${msg == 'cancelacion_ok'}">
					<div class="alert alert-success alert-dismissible fade show" role="alert">
					  <strong>OK!</strong> Inscripcion cancelada correctamente
					  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
					    <span aria-hidden="true">&times;</span>
					  </button>
					</div>
				</c:if>
				<c:if test = "${msg == 'inscripcion_ok'}">
					<div class="alert alert-success alert-dismissible fade show" role="alert">
					  <strong>OK!</strong> Usuario inscrito correctamente
					  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
					    <span aria-hidden="true">&times;</span>
					  </button>
					</div>
				</c:if>
				<c:if test="${msg == 'inscripcion_nok'}">
					<div class="alert alert-danger alert-dismissible fade show" role="alert">
					  <strong>ERROR!</strong> El usuario no se ha podido inscribir
					  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
					    <span aria-hidden="true">&times;</span>
					  </button>
					</div>
				</c:if>
			</div>
		</div>
	
		<div class="row">
			<div class="col">
			
				<h2>Formulario de inscripcion</h2>
				<form action="InscribirUsuario" method="POST">
					<input type="hidden" value="${actividad.id }" name="idactividad">
					<select name="idusuarios" size="${usuarios.size()/2 }">
						<option value="0"></option>
						<c:forEach items="${usuarios}" var="usuario">
							<option value="${usuario.id}">${usuario.nombreApellido} - ${usuario.codigo}</option>
						</c:forEach>
					</select>
					<input type="submit" value="Inscribir">
				</form>
			</div>
			<div class="col">
			
				<h2>Usuarios inscritos</h2>
				<table class="table">
					<c:forEach items="${actividad.iscripciones }" var="inscripcion">
					<tr>
						<td>${inscripcion.usuario.nombreApellido } - ${inscripcion.usuario.codigo }</td>
						<td><a class="btn btn-danger" href="EliminarInscripcion?idactividad=${actividad.id}&idusuario=${inscripcion.usuario.id}">Cancelar inscripcion</a></td>
					</tr>
					</c:forEach>
				</table>
			</div>
			
		
			
		</div>
	</div>
	
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>