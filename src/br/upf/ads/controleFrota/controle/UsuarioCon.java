package br.upf.ads.controleFrota.controle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Trim;

import br.upf.ads.controleFrota.entidades.Usuario;
import br.upf.ads.controleFrota.uteis.JPAUtil;

@Named // Para definir como um bean geranciado pelo JSF
@SessionScoped

public class UsuarioCon implements Serializable {

	private List<Usuario> lista;
	private Usuario selecionado;
	private Boolean editando;
	private String categoria;

	public void incluir() {
		selecionado = new Usuario();
		editando = true;
	}

	public void editar() {
		editando = true;
	}

	// para editar clicando na linha do datatable
	public void editar(Long id) {
		EntityManager em = JPAUtil.getEntityManager();
		selecionado = em.find(Usuario.class, id);
		
		em.close();
		editando = true;
	}

	// para excluir clicando no botão acima do datatable
	public void excluir() {
		// Excluir do banco
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(selecionado));
		em.getTransaction().commit();
		em.close();
		initLista();
	}

	// para excluir clicando na linha do datatable
	public void excluir(Long id) {
		EntityManager em = JPAUtil.getEntityManager();
		selecionado = em.find(Usuario.class, id);
		em.getTransaction().begin();
		em.remove(selecionado);
		em.getTransaction().commit();
		em.close();
		initLista();
	}

	public void gravar() {
		// gravar no banco
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(selecionado);
		em.getTransaction().commit();
		editando = false;
		initLista();
	}

	public void cancelar() {
		editando = false;
		selecionado = null;
	}

	public void initLista() {
		// Carregar lista do banco
		EntityManager em = JPAUtil.getEntityManager();
		lista = em.createQuery("from Usuario").getResultList();
		em.close();
	}

	// trata o campo categoria que é obrigatorio se for colocado a cnh

	private Boolean liberaCat = true;

	public Boolean getLiberaCat() {
		return liberaCat;
	}

	public void setLiberaCat(Boolean liberaCat) {
		this.liberaCat = liberaCat;
		System.out.println(liberaCat);
	}

	public void mensagens() {
		if (selecionado.getCnh() != null || selecionado.getCnh().length()>0) {
			categoria="a categoria deve ser informada";
		}else {
			categoria="";
		}
	}
	
	 
	public String convertData(Date nasc) {
		String dataN;
		dataN= selecionado.getDtNasc().toString();
		return dataN;
	}
	public void trataCategoria() {
		if (selecionado.getCnh() == null || selecionado.getCnh().length()<=0) {
			liberaCat = true;
			selecionado.setCnhCat("");
				System.out.println(selecionado.getCnh());
				
		}else {		
			mensagens();
			selecionado.setCnhCat("digite a categoria..");
			liberaCat = false;
			System.out.println(selecionado.getCnh()+"essa éa cnh");
		}

	}

	// Construtor necessário para o padrão javabean
	public UsuarioCon() {
		super();
		editando = false;
	}

	// Getters e setters. São necessários!!!
	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	public Usuario getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Usuario selecionado) {
		this.selecionado = selecionado;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
