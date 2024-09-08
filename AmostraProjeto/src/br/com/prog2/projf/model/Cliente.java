package br.com.prog2.projf.model;

public class Cliente {
	private Integer codCliente;
    private String nomeCliente;
    private String rgCliente;
    private String enderecoCliente;
    private String bairroCliente;
    private String cidadeCliente;
    private String estadoCliente;
    private String CEPCliente;
    private java.sql.Date nascimentoCliente;
    public Cliente() {
    	
    }
	public Integer getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getRgCliente() {
		return rgCliente;
	}
	public void setRgCliente(String rgCliente) {
		this.rgCliente = rgCliente;
	}
	public String getEnderecoCliente() {
		return enderecoCliente;
	}
	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}
	public String getBairroCliente() {
		return bairroCliente;
	}
	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
	}
	public String getCidadeCliente() {
		return cidadeCliente;
	}
	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}
	public String getEstadoCliente() {
		return estadoCliente;
	}
	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}
	public String getCEPCliente() {
		return CEPCliente;
	}
	public void setCEPCliente(String cEPCliente) {
		CEPCliente = cEPCliente;
	}
	public java.sql.Date getNascimentoCliente() {
		return nascimentoCliente;
	}
	public void setNascimentoCliente(java.sql.Date nascimentoCliente) {
		this.nascimentoCliente = nascimentoCliente;
	}
	


}

