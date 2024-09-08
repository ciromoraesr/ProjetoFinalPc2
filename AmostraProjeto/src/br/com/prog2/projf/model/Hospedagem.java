package br.com.prog2.projf.model;

public class Hospedagem {
	private Integer codHospedagem;
	private Integer codChale;
	private Integer codCliente;
	private java.sql.Date dataInicio;
	private java.sql.Date dataFim;
	private Integer qtdPessoas;
	private Double desconto;
	private Double valorFinal;
	
	public Hospedagem() {
		
	}

	public Integer getCodHospedagem() {
		return codHospedagem;
	}

	public void setCodHospedagem(Integer codHospedagem) {
		this.codHospedagem = codHospedagem;
	}

	public Integer getCodChale() {
		return codChale;
	}

	public void setCodChale(Integer codChale) {
		this.codChale = codChale;
	}

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}


	public java.sql.Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(java.sql.Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public java.sql.Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(java.sql.Date dataFim) {
		this.dataFim = dataFim;
	}

	public Integer getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(Integer qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}
	
	
	
	
	
	
	
	
}
