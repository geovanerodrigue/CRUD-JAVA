package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOpessoas {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/escola";
	private String user = "root";
	private String password = "180897";

	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public void inserirPessoas(Pessoas pessoas) {
		String create = "insert into pessoas (nome, email, cargo) values (?, ?, ?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, pessoas.getNome());
			pst.setString(2, pessoas.getEmail());
			pst.setString(3, pessoas.getCargo());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public ArrayList<Pessoas> listarPessoas() {

		ArrayList<Pessoas> pessoas = new ArrayList<>();

		String read = "select * from pessoas order by nome";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String cargo = rs.getString(4);

				pessoas.add(new Pessoas(id, nome, email, cargo));
			}

			con.close();
			return pessoas;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// crud update

	// selecionar pessoas

	public void selecionarPessoas(Pessoas pessoas) {
		String read2 = "select * from pessoas where id = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, pessoas.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				pessoas.setId(rs.getString(1));
				pessoas.setNome(rs.getString(2));
				pessoas.setEmail(rs.getString(3));
				pessoas.setCargo(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// editar pessoas
	public void alterarPessoas(Pessoas pessoas) {
		String create = "update pessoas set  nome=?, email=?, cargo=? where id=?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(4, pessoas.getId());
			pst.setString(1, pessoas.getNome());
			pst.setString(2, pessoas.getEmail());
			pst.setString(3, pessoas.getCargo());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// delete pessoas
	public void deletarPessoas(Pessoas pessoas) {
		String delete = "delete from pessoas where id=?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, pessoas.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
