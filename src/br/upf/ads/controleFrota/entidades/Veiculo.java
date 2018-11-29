package br.upf.ads.controleFrota.entidades;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Carro
 *
 */
@Entity

public class Veiculo implements Serializable {

	
	private String placa;
	private String modelo;
	private String marca;   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "carroId")
	@SequenceGenerator(name = "carroId", sequenceName = "carroId", allocationSize = 1)
	private Long id;
	private Long kmInicial;
	private Long kmFinal;
	private Boolean status;
	private static final long serialVersionUID = 1L;

	public Veiculo() {
		super();
	}   
	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}   
	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}   
	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Long getKmInicial() {
		return this.kmInicial;
	}

	public void setKmInicial(Long kmInicial) {
		this.kmInicial = kmInicial;
	}   
	public Long getKmFinal() {
		return this.kmFinal;
	}

	public void setKmFinal(Long kmFinal) {
		this.kmFinal = kmFinal;
	}   
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
   
}
