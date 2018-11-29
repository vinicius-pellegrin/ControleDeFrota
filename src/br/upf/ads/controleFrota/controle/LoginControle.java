package br.upf.ads.controleFrota.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.upf.ads.controleFrota.entidades.Login;
import br.upf.ads.controleFrota.uteis.JPAUtil;



@ManagedBean // Para definir como um bean geranciado pelo JSF
@SessionScoped // Para definir que ficar� no escopo da sess�o
public class LoginControle implements Serializable {
	private static final long serialVersionUID = 1L;
	private String login;
	private String senha;
	/**
	 * Atributo para controle do usu�rio logado. � inicializado quando informados
	 * login e senha v�lidos. Setado para null quando o usu�rio sair do sistema.
	 */
	private Login usuarioLogado = null;

	public LoginControle() {
	}

	/**
	 * M�todo respons�vel por valodar o login e senha do usu�rio. Se for v�lido
	 * inicializa o usu�rio logado com a instancia do usu�rio respectivo ao login e
	 * senha informados e redireciona para a tela principal da aplica��o.
	 * 
	 * @throws Exception
	 */
	public String entrar() {

		EntityManager em = JPAUtil.getEntityManager();
		Query qry = em.createQuery("from Login where login = :login and senha = :senha");
		qry.setParameter("login", login);
		qry.setParameter("senha", senha);
		List<Login> list = qry.getResultList();
		em.close();
		if (list.size() <= 0) {
			usuarioLogado = null;
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha inv�lida!", "");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			return "";
		} else {
			usuarioLogado = list.get(0);
			return "/faces/Privado/UsuarioForm.xhtml?faces-redirect=true";
			
		}
	}

	/**
	 * M�todo respons�vel por desconectar o usu�rio e abrir a p�gina de login
	 * 
	 * @throws Exception
	 */
	public String sair() {
		usuarioLogado = null;
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio Desconectado!", "");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
		return "/faces/Login/LoginForm.xhtml";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Login getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Login usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}
