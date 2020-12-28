package com.hodong.jpaprac;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@SpringBootApplication
public class JpapracApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpapracApplication.class, args);
	}

}

@Entity
class Employee {
	@Id
	@GeneratedValue
	private Long id;

	private String name;

	public Employee() {

	}

	public Employee(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee id : " + this.id + " name : " + this.name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@RepositoryRestResource
	interface EmployeeRepository extends JpaRepository<Employee, Long> {

	}
}
