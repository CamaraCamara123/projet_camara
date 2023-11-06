package ma.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ma.projet.entities.Filiere;
import ma.projet.entities.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("select s from Student s where s.filiere = ?1")
	public List<Student> findStudentsByFiliere(Filiere filiere);
}
