<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro</title>
<link rel="stylesheet" href="css/Editar.css">
</head>
<body
	style="background: url(image/imagemfundodd.jpg); display: flex; justify-content: center;">
	<div class="div-pai">
		<h1 class="titulo-div">Editar Cadastro</h1>
		<div class="div-form">
		<form name="frmPessoas" action="update">
			<tr>
				<td><input type="text" class="div-text-form" name="id" readonly
					value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" class="div-text-form" name="nome"
					value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" class="div-text-form" name="email"
					value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" class="div-text-form" name="cargo"
					value="<%out.print(request.getAttribute("cargo"));%>"></td>
			</tr>
			<input type="button"  value="Salvar" class="botaodd"
				onclick="validar()">
		</form>
		</div>
	</div>
	<script src="scripts/validador.js"></script>
</body>
</html>