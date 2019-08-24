package com.vinit.Foodplazabootweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vinit.Foodplazabootweb.model.RoleModel;

@Repository
@Transactional
public class RoleDaoJpaImpl implements RoleDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public RoleModel findByRoleId(int id) {
		return em.find(RoleModel.class, id);
	}

	@Override
	public List<RoleModel> findAllRoles() {
		TypedQuery<RoleModel> typedQuery = em.createQuery("SELECT r FROM RoleModel r", RoleModel.class);
		return typedQuery.getResultList();
	}

	@Override
	public int saveRole(RoleModel role) {
		if (em.merge(role) != null) {
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteByRoleId(int id) {
		Query q = em.createQuery("DELETE FROM RoleModel r WHERE r.roleId = :id");
		q.setParameter("id", id);
		return q.executeUpdate();
	}

}
