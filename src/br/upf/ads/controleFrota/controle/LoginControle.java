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
@SessionScoped // Para definir que ficará no escopo da sessão
public class LoginControle implements Serializable {
	private static final long serialVersionUID = 1L;
	private String login;
	private String senha;
	/**
	 * Atributo para controle do usuário logado. É inicializado quando informados
	 * login e senha válidos. Setado para null quando o usuário sair do sistema.
	 */
	private Login usuarioLogado = null;

	public LoginControle() {
	}

	/**
	 * Método responsável por valodar o login e senha do usuário. Se for válido
	 * inicializa o usuário logado com a instancia do usuário respectivo ao login e
	 * senha informados e redireciona para a tela principal da aplicação.
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
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha inválida!", "");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			return "";
		} else {
			usuarioLogado = list.get(0);
			return "/faces/Privado/UsuarioForm.xhtml?faces-redirect=true";
			
		}
	}

	/**
	 * Método responsável por desconectar o usuário e abrir a página de login
	 * 
	 * @throws Exception
	 */
	public String sair() {
		usuarioLogado = null;
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário Desconectado!", "");
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
