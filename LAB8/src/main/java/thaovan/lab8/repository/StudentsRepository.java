package thaovan.lab8.repository;

import org.springframework.data.repository.CrudRepository;
import thaovan.lab8.entity.StudentsEntity;

public interface StudentsRepository extends CrudRepository<StudentsEntity,String> {

}
