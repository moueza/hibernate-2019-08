package net.roseindia;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.roseindia.EmployeeAnnot;


import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author Deepak Kumar * Web: http://www.roseindia.net
 *         roseindia.net/hibernate/hibernate4.3/Hibernate-4-hello-world-example.shtml
 */
public class Main {
	public static void main(String[] args) throws Exception {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();

		// org.hibernate.Transaction tr0 = session.beginTransaction();
		// session.createSQLQuery("create table EmpShrunk( id int, nom varchar(25)
		// );").executeUpdate();
		// tr0.commit();

		try {
			sessFact = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		/**
		 * org.hibernate.Transaction tr = session.beginTransaction(); String strSql =
		 * "select o from EmployeeShrunk o"; // String strSql = "select o from
		 * EmployeeAnnot o"; Query query = session.createQuery(strSql); List lst =
		 * query.list(); for (Iterator it = lst.iterator(); it.hasNext();) {
		 * 
		 * EmployeeShrunk emp = (EmployeeShrunk) it.next(); System.out.println("Hello: "
		 * + emp.getEmpName()); }
		 * 
		 * tr.commit();
		 */
		System.out.println("Data displayed");
		sessFact.close();
	}
}
