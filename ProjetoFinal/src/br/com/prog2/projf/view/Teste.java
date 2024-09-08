package br.com.prog2.projf.view;

import java.sql.Connection;
import java.sql.Date;

import br.com.prog2.projf.controller.ChaleController;
import br.com.prog2.projf.controller.ClienteController;
import br.com.prog2.projf.controller.HospedagemController;
import br.com.prog2.projf.model.Chale;
import br.com.prog2.projf.model.Cliente;
import br.com.prog2.projf.model.Hospedagem;
import br.com.prog2.projf.persistencia.ConnectionFactory;

public class Teste {

	public static void main(String[] args) {
		Connection con = ConnectionFactory.getConnection();
		if(con != null) {
			System.out.println("OK");
			ConnectionFactory.close(con);
		}
		Cliente c = new Cliente();
		ClienteController control = new ClienteController();
		c.setCodCliente(3);
		c.setNomeCliente("João Silva");
		c.setRgCliente("4080385");
		c.setEnderecoCliente("Rua das Flores, 123");
		c.setBairroCliente("Centro");
		c.setCidadeCliente("São Paulo");
		c.setEstadoCliente("SP");
		c.setCEPCliente("01001-000");
		c.setNascimentoCliente(Date.valueOf("1990-05-15"));
		System.out.println(control.inserir(c));
		Chale cl = new Chale();
		ChaleController controler = new ChaleController();
		cl.setCodChale(1);
		cl.setLocalizacao("goias");
		cl.setValorAltaEstacao(150.5);
		cl.setValorBaixaEstacao(99.90);
		cl.setCapacidade(5);
		System.out.println(controler.inserir(cl));
		
		Hospedagem hospedagem = new Hospedagem();
		hospedagem.setCodHospedagem(2);
        hospedagem.setCodChale(cl.getCodChale());
        hospedagem.setCodCliente(c.getCodCliente());
        
        hospedagem.setDataInicio(Date.valueOf("2024-09-01")); 
        hospedagem.setDataFim(Date.valueOf("2024-09-10")); 
        hospedagem.setQtdPessoas(5); 
        hospedagem.setDesconto(10.0); 

        
        HospedagemController hospedagemController = new HospedagemController();
        System.out.println(hospedagemController.inserir(hospedagem));
		

	}

}
