package ma.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.dao.IDao;
import ma.projet.entities.Filiere;
import ma.projet.repository.FiliereRepository;

@Service
public class FiliereService  implements IDao<Filiere>{
	@Autowired
	private FiliereRepository filiereRepository;

	@Override
	public Filiere create(Filiere o) {
		return filiereRepository.save(o);
	}

	@Override
	public boolean delete(Filiere o) {
		try {
			filiereRepository.delete(o);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public Filiere update(Filiere o) {
		return filiereRepository.save(o);
	}

	@Override
	public List<Filiere> findAll() {
		return filiereRepository.findAll();
	}

	@Override
	public Filiere findById(Long id) {
		return filiereRepository.findById(id).orElse(null);
	}
	

}
