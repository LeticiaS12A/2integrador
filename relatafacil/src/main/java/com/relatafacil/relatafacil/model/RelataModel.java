package com.relatafacil.relatafacil.model;

import com.relatafacil.relatafacil.dto.RelataDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_relatorio")
public class RelataModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeRelatorio;
	private String nomeSetor;
	private String nomeCriador;
	private String urlImagem;
	private String texto;
	
	public RelataModel() {	
	}
	
	public RelataModel(Long id, String nomeRelatorio, String nomeSetor, String nomeCriador, String urlImagem,
			String texto) {
		super();
		this.id = id;
		this.nomeRelatorio = nomeRelatorio;
		this.nomeSetor = nomeSetor;
		this.nomeCriador = nomeCriador;
		this.urlImagem = urlImagem;
		this.texto = texto;
	}
	
	//constructor DTO
		public RelataModel(RelataDTO DTO) {
		
			this.nomeRelatorio = DTO.nomeRelatorio();
			this.nomeSetor = DTO.nomeSetor();
			this.nomeCriador = DTO.nomeCriador();
			this.urlImagem = DTO.urlImagem();
			this.texto = DTO.texto();
		}
		public void updateDTO(RelataDTO DTO) {	
			this.nomeRelatorio = DTO.nomeRelatorio();
			this.nomeSetor = DTO.nomeSetor();
			this.nomeCriador = DTO.nomeCriador();
			this.urlImagem = DTO.urlImagem();
			this.texto = DTO.texto();
		}
		
	//getters e setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeRelatorio() {
		return nomeRelatorio;
	}
	public void setNomeRelatorio(String nomeRelatorio) {
		this.nomeRelatorio = nomeRelatorio;
	}
	public String getNomeSetor() {
		return nomeSetor;
	}
	public void setNomeSetor(String nomeSetor) {
		this.nomeSetor = nomeSetor;
	}
	public String getNomeCriador() {
		return nomeCriador;
	}
	public void setNomeCriador(String nomeCriador) {
		this.nomeCriador = nomeCriador;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
