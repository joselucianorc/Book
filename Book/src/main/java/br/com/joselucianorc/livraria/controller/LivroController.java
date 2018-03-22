package br.com.joselucianorc.livraria.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.joselucianorc.livraria.dto.SaraivaDto;
import br.com.joselucianorc.livraria.model.Livro;
import br.com.joselucianorc.livraria.service.LivroService;
import br.com.joselucianorc.livraria.util.SaraivaUtil;

@RestController
public class LivroController {

	   @Autowired
	   private LivroService bookService;

	   @PostMapping("/book")
	   public ResponseEntity<?> save(@RequestParam("sku") Integer sku) {
		   		  
		   SaraivaDto dtoLido = SaraivaUtil.getBooksInfo(sku);		   
		   Livro novoLivro = preencherCampos(sku, dtoLido);
		   long id = bookService.save(novoLivro); // OK
		   return new ResponseEntity<>(novoLivro, HttpStatus.CREATED);
	   }
	   
	   @SuppressWarnings("rawtypes")
	   @DeleteMapping("/book/{sku}")
	   public ResponseEntity<?> delete(@PathVariable("sku") Integer sku) {
	      bookService.delete(sku); //OK
	      return new ResponseEntity(HttpStatus.NO_CONTENT);
	   }

	   @GetMapping("/book/{sku}")
	   public ResponseEntity<Livro> get(@PathVariable("sku") Integer sku) {
	      Livro book = bookService.get(sku); //OK
	      return ResponseEntity.ok().body(book);
	   }

	   @GetMapping("/book")
	   public ResponseEntity<List<Livro>> list(@RequestParam("price") double price, @RequestParam("limit") int limit) {
	      List<Livro> books = bookService.list(price, limit); //OK
	      return ResponseEntity.ok().body(books);
	   }
	   
		private Livro preencherCampos(Integer sku, SaraivaDto dtoLido) {
			Livro novoLivro = new Livro();
			   novoLivro.setSku(sku);
			   novoLivro.setBrand(dtoLido.getBrand());
			   novoLivro.setName(dtoLido.getName());
			   String price = dtoLido.getPrice().getOriginal().replace(",",".");		   
			   novoLivro.setPrice(new BigDecimal(price));
			return novoLivro;
		}
}
