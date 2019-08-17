package example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/** https://www.tutorialspoint.com/hibernate/hibernate_examples.htm*/
@Entity
@Table(name="employee2")
public class Employee2 {

 
	private Long id;

	// private int id;
	
	private String firstName;


	private String lastName;

	//private int salary;

	public Employee2() {
	}

	public Employee2(String fname, String lname, int salary) {
		this.firstName = fname;
		this.lastName = lname;
		//this.salary = salary;
	}

	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name = "fn")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	@Column(name = "ln")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

 
}