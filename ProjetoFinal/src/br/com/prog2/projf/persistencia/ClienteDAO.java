package br.com.prog2.projf.persistencia;
import java.util.List;

import br.com.prog2.projf.model.Cliente;
public interface ClienteDAO {
	public String inserir(Cliente c);
	public String alterar(Cliente c);
	public String excluir(Cliente c);
	public List<Cliente> listarTodos();
	public Cliente pesquisarPorId(Integer codCliente);
	
}
