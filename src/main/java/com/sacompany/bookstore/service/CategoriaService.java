package com.sacompany.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacompany.bookstore.domain.Categoria;
import com.sacompany.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElse(null);
	}
}
