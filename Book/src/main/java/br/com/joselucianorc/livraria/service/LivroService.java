package br.com.joselucianorc.livraria.service;

import java.util.List;

import br.com.joselucianorc.livraria.model.Livro;

public interface LivroService {
	
	   Integer save(Livro book);
	   Livro get(Integer sku);
	   List<Livro> list(double price, int limit);
	   void delete(Integer sku);
}
