package airportis.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import airportis.app.entity.ActivationToken;
import airportis.app.entity.User;
import airportis.app.entity.UserDetail;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	BCryptPasswordEncoder encoder;
	
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

	@Override
	public void remove(User user) {
		Session session = sessionFactory.getCurrentSession();
		
		session.remove(user);
		session.remove(user.getDetails());
	}

	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from User", User.class).list();
	}

	@Override
	public User findUserById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, id);
	}

	@Override
	public String getUserName(String email) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserDetail> theQuery = session.createQuery("from UserDetail where email=:email", UserDetail.class);
		theQuery.setParameter("email", email);
		UserDetail user;
		try {
			user = theQuery.getSingleResult();
		} catch (Exception e) {
			user = null;
		}
		return user.getFirstName();
	}

	@Override
	public String getUserSurname(String email) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserDetail> theQuery = session.createQuery("from UserDetail where email=:email", UserDetail.class);
		theQuery.setParameter("email", email);
		UserDetail user;
		try {
			user = theQuery.getSingleResult();
		} catch (Exception e) {
			user = null;
		}
		return user.getLastName();
	}

	@Override
	public void saveToken(User user) {
		Session session = sessionFactory.getCurrentSession();
		ActivationToken token = new ActivationToken(user.getId(), encoder.encode(user.getUsername()+"btrsgdghcgho7460&^"));
		session.saveOrUpdate(token);
	}

	@Override
	public String getToken(User user) {
		Session session = sessionFactory.getCurrentSession();
		ActivationToken token= session.get(ActivationToken.class, user.getId());
		return token.getToken();
	}

	@Override
	public void removeToken(User user) {
		Session session = sessionFactory.getCurrentSession();
		ActivationToken token= session.get(ActivationToken.class, user.getId());
		session.remove(token);
	}

	@Override
	public User findUserByToken(String token) {
		Session session = sessionFactory.getCurrentSession();
		Query<ActivationToken> tokens= session.createQuery("From ActivationToken where token= :token", ActivationToken.class);
		tokens.setParameter("token", token);
		User user= session.get(User.class, tokens.getSingleResult().getUserId());
		return user;
	}
}
