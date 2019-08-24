package com.vinit.Foodplazabootweb.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SearchServiceImpl<T> implements SearchService<T> {

	@PersistenceContext
	private EntityManager em;

	private QueryBuilder getQueryBuilderFor(Class<T> t) {
		FullTextEntityManager ftem = Search.getFullTextEntityManager(em);
		return ftem
				.getSearchFactory()
				.buildQueryBuilder()
				.forEntity(t)
				.get();
	}

	@Override
	public List<T> searchBy(Class<T> t, String searchStr, String[] fields) {
		
		reCreateIndex();
		
		Query q = getQueryBuilderFor(t)
				.keyword()
				.onFields(fields)
				.matching(searchStr)
				.createQuery();
		return getJpaQuery(q, t).getResultList();
		
	}
	
	private FullTextQuery getJpaQuery(Query luceneQuery ,Class<T> t) {
		
		FullTextEntityManager ftem = Search.getFullTextEntityManager(em);
		return ftem.createFullTextQuery(luceneQuery, t);
	}
	
	private void reCreateIndex() {
		try {
			Search.getFullTextEntityManager(em).createIndexer().startAndWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
