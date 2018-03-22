package br.com.joselucianorc.livraria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.joselucianorc.livraria.model.Livro;


@Repository
public class LivroDaoImpl implements LivroDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public Integer save(Livro livro) {
      sessionFactory.getCurrentSession().save(livro);
      return livro.getSku();
   }

   @Override
   public Livro get(Integer sku) {
      return sessionFactory.getCurrentSession().get(Livro.class, sku); //OK
   }

   @Override
   public List<Livro> list(double price, int limit) {
      Session session = sessionFactory.getCurrentSession();
      
      Criteria c = session.createCriteria(Livro.class);
      if (price > 0.0) {
    	  c.add(Restrictions.lt("price", new BigDecimal(price)));
      }
      if (limit > 0) {
    	  c.setMaxResults(limit);
      }
      List<Livro> objetos = c.list();
      return c.list();
   }

   @Override
   public void delete(Integer sku) {
      Session session = sessionFactory.getCurrentSession();
      Livro livro = session.byId(Livro.class).load(sku);
      session.delete(livro);
   }
}