package com.vinit.Foodplazabootweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vinit.Foodplazabootweb.model.RoleModel;
import com.vinit.Foodplazabootweb.model.UserModel;

@Repository
@Transactional
public class UserDaoJpaImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public UserModel findByUserId(int id) {

		return em.find(UserModel.class, id);
	}

	@Override
	public List<UserModel> findAllUsers() {
		TypedQuery<UserModel> typedQuery = em.createQuery("SELECT u FROM UserModel u", UserModel.class);

		return typedQuery.getResultList();
	}

	@Override
	public int saveUser(UserModel user) {
		if (em.merge(user) != null) {
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteByUserId(int id) {
		Query q = em.createQuery("DELETE FROM UserModel u WHERE u.userId = :id");
		q.setParameter("id", id);
		return q.executeUpdate();
	}

	@Override
	public List<RoleModel> findRolesByUserId(int userId) {

		UserModel user = em.find(UserModel.class, userId);
		return user.getRoles();
	}

}
