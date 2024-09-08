package br.com.prog2.projf.controller;

import java.util.List;

import br.com.prog2.projf.model.Cliente;
import br.com.prog2.projf.persistencia.ClienteDAOImp;

public class ClienteController {
	public String inserir(Cliente c) {
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.inserir(c);
		
	}
	public String alterar(Cliente c) {
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.alterar(c);
	}
	public String excluir(Cliente c) {
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.excluir(c);
	}
	public List<Cliente> listarTodos() {
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.listarTodos();
	}
	public Cliente pesquisarPorId(Integer codCliente) {
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.pesquisarPorId(codCliente);
	}
}

