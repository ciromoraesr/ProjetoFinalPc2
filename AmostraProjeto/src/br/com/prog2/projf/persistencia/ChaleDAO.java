package br.com.prog2.projf.persistencia;
import java.util.List;

import br.com.prog2.projf.model.Chale;
public interface ChaleDAO {
	public String inserir(Chale cl);
	public String alterar(Chale cl);
	public String excluir(Chale cl);
	public List<Chale> listarTodos();
	public Chale pesquisarPorId(Integer codChale);
	
}
