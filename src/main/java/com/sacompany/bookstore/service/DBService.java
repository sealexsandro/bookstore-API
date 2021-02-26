package com.sacompany.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacompany.bookstore.domain.Categoria;
import com.sacompany.bookstore.domain.Livro;
import com.sacompany.bookstore.repositories.CategoriaRepository;
import com.sacompany.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "Informatica", "Livro De Informatica" );
		Categoria cat2 = new Categoria(null, "Psicologia", "Livro De Psicologia" );
		Categoria cat3 = new Categoria(null, "Legislação", "Livro De Legislação" );

		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat1);
		Livro l2 = new Livro(null, "Rápido Devagar Duas Formas de Pensar", "Daniel Kaneman", "Lorem Ipsum", cat2);
		Livro l3 = new Livro(null, "Constituição Brasileira", "Governo Federal", "Lorem Ipsum", cat3);
		Livro l4 = new Livro(null, "Informatica Basica", "Julian Matheus", "Lorem Ipsum", cat1);
		Livro l5 = new Livro(null, "Os Misterios do Cérebro Humano", "Douglas Santener", "Lorem Ipsum", cat2);


		cat1.getLivrosList().addAll(Arrays.asList(l1, l4));
		cat2.getLivrosList().addAll(Arrays.asList(l2, l5));
		cat3.getLivrosList().addAll(Arrays.asList(l3));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4 , l5));

	}

}
