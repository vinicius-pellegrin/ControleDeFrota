package br.upf.ads.controleFrota.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Login implements Serializable{
@Id
@SequenceGenerator(name = "UsuarioId", allocationSize = 1, sequenceName = "UsuarioId")
@GeneratedValue(generator = "UsuarioId", strategy = GenerationType.SEQUENCE)
private Integer id;
@NotEmpty(message = "O nome deve ser informado!")
@Length(max = 60, min = 3, message = "O nome deve ter entre 3 e 60 caracteres!")
@Column(length = 60, nullable = false)
private String nome;
@NotEmpty(message = "O login deve ser informado!")
@Length(max = 20, min = 5, message = "O nome deve ter entre 5 e 20 caracteres!")
@Column(length = 20, nullable = false)
private String login;
@NotEmpty(message = "A senha deve ser informada!")
@Length(max = 40, min = 4, message = "O nome deve ter entre 4 e 40 caracteres!")
@Column(length = 40, nullable = false)
private String senha;



public Login() {

}



public Integer getId() {
	return id;
}



public void setId(Integer id) {
	this.id = id;
}



public String getNome() {
	return nome;
}



public void setNome(String nome) {
	this.nome = nome;
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





}



