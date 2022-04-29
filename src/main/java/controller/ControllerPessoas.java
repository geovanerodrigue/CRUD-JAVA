package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAOpessoas;
import model.Pessoas;



@WebServlet(urlPatterns = { "/ControllerPessoas", "/main", "/insert", "/select", "/update", "/delete"})
public class ControllerPessoas extends HttpServlet{
	
		private static final long serialVersionUID = 1L;

		DAOpessoas dao = new DAOpessoas();
		Pessoas pessoas = new Pessoas();

		public ControllerPessoas() {
			super();

		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			String action = request.getServletPath();
			
			switch(action) {		
			case "/main": 
				pessoas(request, response);
				break;
			case "/insert":
				novoPessoas(request, response);
			    break;
			case "/select":
				listarPessoas(request, response);
				break;
			case "/update":
				editarPessoas(request, response);
				break;
			case "/delete":
				removerPessoas(request, response);
				break;				
			}
			
		}

		// listar pessoas
		protected void pessoas(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			ArrayList<Pessoas> lista = dao.listarPessoas();

			request.setAttribute("pessoas", lista);
			RequestDispatcher rd = request.getRequestDispatcher("Pessoas.jsp");
			rd.forward(request, response);

		}

		// criar pessoas
		protected void novoPessoas(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

			pessoas.setNome(request.getParameter("nome"));
			pessoas.setEmail(request.getParameter("email"));
			pessoas.setCargo(request.getParameter("cargo"));
			dao.inserirPessoas(pessoas);
			// redirecionar
			response.sendRedirect("main");

		}

		// listar pessoas primeiro pra depois eitar

		protected void listarPessoas(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			String id = request.getParameter("id");
			pessoas.setId(id);
			dao.selecionarPessoas(pessoas);
			request.setAttribute("id", pessoas.getId());
			request.setAttribute("nome", pessoas.getNome());
			request.setAttribute("email", pessoas.getEmail());
			request.setAttribute("cargo", pessoas.getCargo());
			RequestDispatcher rd = request.getRequestDispatcher("Editar.jsp");
			rd.forward(request, response);
		}

		// editar pessoas

		protected void editarPessoas(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

			pessoas.setId(request.getParameter("id"));
			pessoas.setNome(request.getParameter("nome"));
			pessoas.setEmail(request.getParameter("email"));
			pessoas.setCargo(request.getParameter("cargo"));
			dao.alterarPessoas(pessoas);

			response.sendRedirect("main");

		}

		// remover pessoas

		protected void removerPessoas(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

			String id = request.getParameter("id");

			pessoas.setId(id);

			dao.deletarPessoas(pessoas);

			response.sendRedirect("main");

		}
}
