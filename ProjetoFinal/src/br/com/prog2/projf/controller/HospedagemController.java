package br.com.prog2.projf.controller;

import java.util.List;

import br.com.prog2.projf.model.Hospedagem;
import br.com.prog2.projf.persistencia.HospedagemDAOImp;

public class HospedagemController {
    public String inserir(Hospedagem h) {
        HospedagemDAOImp dao = new HospedagemDAOImp();
        return dao.inserir(h);
    }
    
    public String alterar(Hospedagem h) {
        HospedagemDAOImp dao = new HospedagemDAOImp();
        return dao.alterar(h);
    }
    
    public String excluir(Hospedagem h) {
        HospedagemDAOImp dao = new HospedagemDAOImp();
        return dao.excluir(h);
    }
    
    public List<Hospedagem> listarTodos() {
        HospedagemDAOImp dao = new HospedagemDAOImp();
        return dao.listarTodos();
    }
    
    public Hospedagem pesquisarPorId(Integer codHospedagem) {
        HospedagemDAOImp dao = new HospedagemDAOImp();
        return dao.pesquisarPorId(codHospedagem);
    }
}
