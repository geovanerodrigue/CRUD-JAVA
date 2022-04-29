<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="model.Pessoas"%>
    <%@ page import="java.util.ArrayList"%>
    <%ArrayList<Pessoas> lista = (ArrayList<Pessoas>)request.getAttribute("pessoas");%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Pessoas</title>
<link rel="stylesheet" href="css/Pessoas.css">
</head>
<body style="background: url(image/imagemfundodd.jpg); display: flex; justify-content: center;">
<div class="div-pai">
<div class="div-filho-text"></div>
      <div class="div-text-botao">
          <div>Cadastros</div>
          <div class="div-botao">
          <a href="Novo.jsp"class="botao-novo">Novo Cadastro</a>
          </div>
      </div>
   <div class="div-table-filho">
    <table>
        <thead>
            <tr>
                 <th>Id</th>
                 <th>Nome</th>
                 <th>Email</th>
                 <th>Cargo</th>
                 <th>Opções</th>
            </tr>
        </thead>
        <tbody>
           <%for (int i = 0; i < lista.size(); i++){ %>
             <tr>
                 <td><%=lista.get(i).getId()%></td>
                 <td><%=lista.get(i).getNome()%></td>
                 <td><%=lista.get(i).getEmail()%></td>
                 <td><%=lista.get(i).getCargo()%></td>
                 <td><a href="select?id=<%=lista.get(i).getId()%>" class="botaoed">Editar</a>
                     <a href="javascript: confirmar(<%=lista.get(i).getId()%>)" class="botaoex">Excluir</a>
                 </td>
             </tr>
           <%} %>
        </tbody>
    </table>
    <script src="scripts/confirmador.js"></script>
   </div>
   </div>
</body>
</html>