<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Pessoas</title>
<link rel="stylesheet" href="css/Novo.css">
</head>
<body
	style="background: url(image/imagemfundodd.jpg); display: flex; justify-content: center;">
	<div class="div-pai">
		<h1 class="titulo-div">Cadastrar</h1>
		<div class="div-form">
		<form name="frmPessoas" action="insert">
			<tr>
				<td><input type="text" class="div-text-form" name="nome" placeholder="Nome"></td>
			</tr>
			<tr>
				<td><input type="text" class="div-text-form" name="email" placeholder="Email"></td>
			</tr>
			<tr>
				<td><input type="text" class="div-text-form" name="cargo" placeholder="Cargo"></td>
			</tr>
			<input type="button" class="botao-adicionar" value="Adicionar" class="Botaodd"
				onclick="validar()">
		</form>
		</div>
	</div>
	<script src="scripts/validador.js"></script>
</body>
</html>