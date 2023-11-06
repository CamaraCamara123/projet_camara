package ma.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.dao.IDao;
import ma.projet.entities.Filiere;
import ma.projet.entities.Student;
import ma.projet.repository.FiliereRepository;
import ma.projet.repository.StudentRepository;

@Service
public class StudentService implements IDao<Student>{
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student create(Student o) {
		// TODO Auto-generated method stub
		return studentRepository.save(o);
	}

	@Override
	public boolean delete(Student o) {
		try {
			studentRepository.delete(o);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public Student update(Student o) {
		// TODO Auto-generated method stub
		return studentRepository.save(o);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student findById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).orElse(null);
	}
	
	
	public List<Student> findStudentsByFiliere(Filiere filiere) {
		// TODO Auto-generated method stub
		return studentRepository.findStudentsByFiliere(filiere);
	}

	

}
