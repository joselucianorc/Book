package br.com.joselucianorc.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.joselucianorc.livraria.dao.LivroDao;
import br.com.joselucianorc.livraria.model.Livro;

@Service
@Transactional(readOnly = true)
public class LivroServiceImpl implements LivroService {

   @Autowired
   private LivroDao bookDao;

   @Transactional
   @Override
   public Integer save(Livro book) {
      return bookDao.save(book);
   }

   @Override
   public Livro get(Integer sku) {
      return bookDao.get(sku);//OK
   }

   @Override
   public List<Livro> list(double price, int limit) {
      return bookDao.list(price, limit);
   }

   @Transactional
   @Override
   public void delete(Integer sku) {
      bookDao.delete(sku);
   }

}