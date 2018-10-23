package airportis.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airportis.app.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Role getRoleByName(String roleName) {
		Session session = sessionFactory.getCurrentSession();
		Query<Role> query = session.createQuery("from Role where roleName=:name", Role.class);
		query.setParameter("name", roleName);
		return query.getSingleResult();
	}

}
