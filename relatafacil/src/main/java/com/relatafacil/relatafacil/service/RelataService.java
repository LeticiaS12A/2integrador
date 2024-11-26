package com.relatafacil.relatafacil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relatafacil.relatafacil.model.RelataModel;
import com.relatafacil.relatafacil.repository.RelataRepository;

@Service
public class RelataService {

	@Autowired
    private RelataRepository relataRepository;

	// Retorna todos os relatórios.
    public List<RelataModel> findAll() {
        return relataRepository.findAll(); 
    }

    // Busca um relatório pelo ID.
    public Optional<RelataModel> findById(Long id) {
        return relataRepository.findById(id); 
    }

    // Salva ou atualiza um relatório.
    public RelataModel save(RelataModel relata)
    { 
        return relataRepository.save(relata); 
    }

    // Deleta um relatório pelo ID.
    public void delete(Long id) {
        relataRepository.deleteById(id); 
    }
	
}
