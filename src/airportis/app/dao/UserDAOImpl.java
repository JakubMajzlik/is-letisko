package airportis.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airportis.app.entity.PassengerDetail;
import airportis.app.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User findUserByEmail(String email) {
		System.out.println("Finding User " + email);
		Session session = sessionFactory.getCurrentSession();
		Query<User> theQuery = session.createQuery("from User where username=:uName", User.class);
		theQuery.setParameter("uName", email);
		User user = null;
		try {
			user = theQuery.getSingleResult();
		} catch (Exception e) {
			user = null;
		}
		return user;
	}

	@Override
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}
}
