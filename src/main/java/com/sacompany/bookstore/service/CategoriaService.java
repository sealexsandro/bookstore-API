package com.sacompany.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sacompany.bookstore.domain.Categoria;
import com.sacompany.bookstore.dtos.CategoriaDTO;
import com.sacompany.bookstore.repositories.CategoriaRepository;
import com.sacompany.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria findById(Integer id) {

		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto Não Encontrado! Id: " + id + ", Tipo = " + Categoria.class.getName()));

	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Categoria create(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return categoriaRepository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.sacompany.bookstore.service.exceptions.DataIntegrityViolationException("Categoria Não Pode Ser Deletado, Possui Livros Associados");
		}
	}
}
