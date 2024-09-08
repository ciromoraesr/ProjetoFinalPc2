package br.com.prog2.projf.controller;

import java.util.List;

import br.com.prog2.projf.model.Chale;
import br.com.prog2.projf.persistencia.ChaleDAOImp;

public class ChaleController {
    public String inserir(Chale cl) {
        ChaleDAOImp dao = new ChaleDAOImp();
        return dao.inserir(cl);
    }
    
    public String alterar(Chale cl) {
        ChaleDAOImp dao = new ChaleDAOImp();
        return dao.alterar(cl);
    }
    
    public String excluir(Chale cl) {
        ChaleDAOImp dao = new ChaleDAOImp();
        return dao.excluir(cl);
    }
    
    public List<Chale> listarTodos() {
        ChaleDAOImp dao = new ChaleDAOImp();
        return dao.listarTodos();
    }
    
    public Chale pesquisarPorId(Integer codChale) {
        ChaleDAOImp dao = new ChaleDAOImp();
        return dao.pesquisarPorId(codChale);
    }
}
