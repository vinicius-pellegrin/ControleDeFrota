package br.upf.ads.controleFrota.testes;

import java.io.Serializable;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import br.upf.ads.controleFrota.entidades.*;
import org.junit.Test;

import br.upf.ads.controleFrota.uteis.JPAUtil;

public class teste1 implements Serializable{

	public Usuario usuario;
	public Usuario selecionado;
	
	
	@Test
	public void Teste1() throws SQLException {
		
		//inserirUsuario.AddUser("insert into usuario(nome, status, tipo) values ('testede inserçAo', false, A)");
		System.out.println("selecionando o usuario");
		selecionado = new Usuario();
		System.out.println("setando nome");
		selecionado.setNome("teste");
		System.out.println("setando o status");
		selecionado.setStatus(true);
		System.out.println("setando o tipo");
		selecionado.setTipo('A');
		
		System.out.println("testando a inserção"+selecionado.getNome()+selecionado.getTipo()+selecionado.getStatus());
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
    	em.persist(selecionado);
    	System.out.println("fechando a conexão");
    	em.close();
    	    	
		
	} 
	
}
