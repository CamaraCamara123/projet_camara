package ma.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.dao.IDao;
import ma.projet.entities.Filiere;
import ma.projet.entities.Role;
import ma.projet.repository.RoleRepository;

@Service
public class RoleService implements IDao<Role> {
    @Autowired
    private RoleRepository repository;

    @Override
    public Role create(Role o) {
        return repository.save(o);
    }

    @Override
    public boolean delete(Role o) {
        try {
            repository.delete(o);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Role update(Role o) {
        return repository.save(o);
    }

    @Override
    public Role findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

}