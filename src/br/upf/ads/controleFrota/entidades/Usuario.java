package br.upf.ads.controleFrota.entidades;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Format;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario implements Serializable {

	@Id
	@GeneratedValue(generator = "UsuarioId", strategy = SEQUENCE)
	@SequenceGenerator(name = "UsuarioId", sequenceName = "UsuarioId", allocationSize = 1)
	private Long id;
	
	@NotEmpty(message ="o nome deve ser informado")
	@Length(min=2, max=60, message="O nome deve ter entre {min} e {max} caracteres!")
	private String nome;   
	
	@Temporal(TemporalType.DATE)
	@Past(message="A Data deve estar no passado")
	@NotEmpty(message = "deve ser informada a data de nascimento")
	@NotNull(message = "Deve Haver uma data")
	private Date dtNasc;
	
	@CPF(message = "o CPF deve ser valido")
	@NotNull(message = "O CPF deve ser informado")
	private String cpf;
	

	
	private char tipo;
	
	
	private String cnhCat;
	
	private String cnh;
	
	private Boolean status;
	
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}   
	public char getTipo() {
		return this.tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public Date getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}
	public String getcpf() {
		return cpf;
	}
	public void setcpf(String CPF) {
		cpf = CPF;
	}

	public String getCnhCat() {
		return cnhCat;
	}
	public void setCnhCat(String cnhCat) {
		this.cnhCat = cnhCat;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
   
}
