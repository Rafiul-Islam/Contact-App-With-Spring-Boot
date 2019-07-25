package com.rafiulislam;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentsRepo extends JpaRepository<Students, Integer> {

	List<Students> findByTech(String tech);

	List<Students> findByIdGreaterThan(int id);

	@Query("from Students where tech=?1 order by name")
	List<Students> findByTechSorted(String tech);

	@Query("from Students order by name")
	List<Students> findByNameSorted();
	
	@Query("from Students order by id")
	List<Students> findByName();

}
