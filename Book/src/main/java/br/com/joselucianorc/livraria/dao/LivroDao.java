package br.com.joselucianorc.livraria.dao;

import java.util.List;

import br.com.joselucianorc.livraria.model.Livro;

public interface LivroDao {
	
	   Integer save(Livro book);
	   Livro get(Integer sku);
	   List<Livro> list(double price, int limit);
	   void delete(Integer sku);
}
