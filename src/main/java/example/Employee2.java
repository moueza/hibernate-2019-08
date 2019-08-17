package example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/** https://www.tutorialspoint.com/hibernate/hibernate_examples.htm */
@Entity
public class Employee2 {

	private Integer id;

	// private int id;

	private String fn;

	private String ln;

	// private int salary;

	public Employee2() {
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public Employee2(String fname, String lname, int salary) {
		this.fn = fname;
		this.ln = lname;
		// this.salary = salary;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}