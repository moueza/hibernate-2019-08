package example;

import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/** https://www.tutorialspoint.com/hibernate/hibernate_examples.htm */
public class Main {
	private static SessionFactory factory;

	public static void main(String[] args) {
//		https://www.baeldung.com/hibernate-mappingexception-unknown-entity 
		// configuration.addAnnotatedClass(Foo.class);
		Configuration cfg = new Configuration().addAnnotatedClass(Employee2.class);
		// configuration.addAnnotatedClass(Employee2.class);
		try {
			// factory = new Configuration().configure().buildSessionFactory();
			// factory = buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		System.out.println("lbl065");
		Main ME = new Main();

		/* Add few employee records in database */
		Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
		// Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
		// Integer empID3 = ME.addEmployee("John", "Paul", 10000);
		// System.out.println("lbl080");

		// List down all the employees
		// ME.listEmployees();

		// Update employee's records */
		// ME.updateEmployee(empID1, 5000);
		// System.out.println("lbl105");
		// Delete an employee from the database
		// ME.deleteEmployee(empID2);

		// List down new list of the employees
		// ME.listEmployees();

	}

	/* Method to CREATE an employee in the database */
	public Integer addEmployee(String fname, String lname, int salary) {
		factory = buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;

		try {
			tx = session.beginTransaction();
			Employee2 employee2 = new Employee2(fname, lname, salary);
			employeeID = (Integer) session.save(employee2);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	}

	/* Method to READ all the employees */
	public void listEmployees() {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM Employee2 e").list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				Employee2 employee2 = (Employee2) iterator.next();
				System.out.print("First Name: " + employee2.getFn());
				System.out.print("  Last Name: " + employee2.getLn());
				// System.out.println(" Salary: " + employee2.getSalary());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to UPDATE salary for an employee */
	public void updateEmployee(Integer EmployeeID, int salary) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Employee2 employee2 = (Employee2) session.get(Employee2.class, EmployeeID);
			// employee2.setSalary(salary);
			session.update(employee2);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to DELETE an employee from the records */
	public void deleteEmployee(Integer EmployeeID) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Employee2 employee2 = (Employee2) session.get(Employee2.class, EmployeeID);
			session.delete(employee2);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * https://stackoverflow.com/questions/33005348/hibernate-5-org-hibernate-mappingexception-unknown-entity
	 */
	private static SessionFactory buildSessionFactory() {
		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();

			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();

			return metadata.getSessionFactoryBuilder().build();

		} finally {
			// session.close();
		}
	}
}