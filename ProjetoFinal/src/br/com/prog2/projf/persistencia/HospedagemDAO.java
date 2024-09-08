package br.com.prog2.projf.persistencia;
import java.util.List;

import br.com.prog2.projf.model.Hospedagem;
public interface HospedagemDAO {
	public String inserir(Hospedagem h);
	public String alterar(Hospedagem h);
	public String excluir(Hospedagem h);
	public List<Hospedagem> listarTodos();
	public Hospedagem pesquisarPorId(Integer codHospedagem);
	
}
