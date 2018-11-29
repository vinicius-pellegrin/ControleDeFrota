package br.upf.ads.controleFrota.controle;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;


import br.upf.ads.controleFrota.entidades.Veiculo;
import br.upf.ads.controleFrota.uteis.JPAUtil;

public class VeiculoCon implements Serializable{

	private List<Veiculo> lista;
    private Veiculo selecionado;
    private Boolean editando;
	
    
    
    public void incluir() {
    	selecionado = new Veiculo();
    	editando = true;
    }
    
    
    public void editar() {
    	editando = true;
    }
	
    
    // para editar clicando na linha do datatable
    public void editar(Long id) {
    	EntityManager em = JPAUtil.getEntityManager();
    	selecionado = em.find(Veiculo.class, id);
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
    	selecionado = em.find(Veiculo.class, id);
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
    	lista = em.createQuery("from Veiculo").getResultList();
    	em.close();
    }
    
    
    // Construtor necessário para o padrão javabean
    public VeiculoCon() {
		super();
		editando = false;
	}
	// Getters e setters. São necessários!!!
	public List<Veiculo> getLista() {
		return lista;
	}
	public void setLista(List<Veiculo> lista) {
		this.lista = lista;
	}
	public Veiculo getSelecionado() {
		return selecionado;
	}
	public void setSelecionado(Veiculo selecionado) {
		this.selecionado = selecionado;
	}
	public Boolean getEditando() {
		return editando;
	}
	public void setEditando(Boolean editando) {
		this.editando = editando;
	}
    
    
    
}
