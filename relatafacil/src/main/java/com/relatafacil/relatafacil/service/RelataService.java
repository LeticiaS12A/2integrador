package com.relatafacil.relatafacil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relatafacil.relatafacil.model.RelataModel;
import com.relatafacil.relatafacil.repository.RelataRepository;

@Service
public class RelataService {

	@Autowired
    private RelataRepository relataRepository;

	// Retorna todos os relatórios.
    public List<RelataModel> listarTodos() {
        return relataRepository.findAll(); 
    }

    // Salva ou atualiza um relatório.
    public RelataModel salvar(RelataModel relata){ 
        return relataRepository.save(relata); 
    }
    
    // Busca um relatório pelo ID.
    public RelataModel buscarPorId(Long id) {
        return relataRepository.findById(id).orElse(null); 
    }

    // Deleta um relatório pelo ID.
    public void deletar(Long id) {
        relataRepository.deleteById(id); 
    }
	
}
