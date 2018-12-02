package airportis.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airportis.app.dao.RoleDAO;
import airportis.app.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDAO roleDAO;
	
	@Override
	@Transactional
	public Role getRoleByName(String roleName) {
		return roleDAO.getRoleByName(roleName);
	}

}
