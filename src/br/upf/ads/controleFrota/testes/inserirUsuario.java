package br.upf.ads.controleFrota.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.jms.ConnectionFactory;
import javax.persistence.Persistence;

import org.hibernate.dialect.ColumnAliasExtractor;

import br.upf.ads.controleFrota.entidades.Usuario;
import net.bytebuddy.asm.Advice.This;

public class inserirUsuario {

	private static Connection connection;

	// dados
	Long id;
	public String nome;
	public Boolean status;
	public char tipo;

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//Usuario usuario = new Usuario();

		System.out.println("Abrindo Conexão!");
		// Connection connection = new inserirUsuario().Conexao();
		Conexao();
		System.out.println("conexão aberta");
		
		System.out.println("teste de inserção");
		
		AddUser("insert into pessoas (nome, status, tipo) values('test100', true, 'a' )");
		System.out.println("passou pelo metodo");

	}

//Teste de  Conexão

	public static void Conexao() {
		try {

			String url = "jdbc:postgresql://localhost:5433/ControleFrota";
			String usuario = "postgres";
			String senha = "123";

			Class.forName("org.postgresql.Driver");

			connection = null;

			connection = DriverManager.getConnection(url, usuario, senha);

			System.out.println("Conexão realizada com sucesso.");

		} catch (Exception e) {
			System.out.println(
					"Problemas na conexão. Verifique a digitação dos nomes e a existência da fonte de dados. \n Recompile e execute novamente.");

		}
		

	}

	// Teste de inserção

	public static void AddUser(String sql) throws SQLException {
		System.out.println("Entrou no metodo");

		System.out.println("vai inserir "+sql);
Statement st = connection.createStatement();
System.out.println("statement"+st);

System.out.println("statement carregado "+st);
st.executeUpdate(sql);
		//Conexao().createStatement().executeQuery("insert into usuario (nome,status,tipo) values('test1', true, 'A' )");

		System.out.println("tentou iserir");

		// Connection connection = new inserirUsuario().Conexao();

		//Conexao().close();
		System.out.println("Fexou");
//	 Statement usuario = connection.createStatement();

		// PreparedStatement usuario = connection.prepareStatement("insert into usuario
		// (nome,status,tipo) values(?,?,?)");

		// usuario.executeUpdate("INSERT INTO usuarios (id, nome, status, tipo)
		// values(100, 'test1', true, 'A' )");
		System.out.println("Usuário incluso com sucesso!");
		// connection.close();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

}

// 
