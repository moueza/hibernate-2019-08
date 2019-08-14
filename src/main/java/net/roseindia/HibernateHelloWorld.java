package net.roseindia;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import net.roseindia.EmployeeAnnot;
/**
 * @author Deepak Kumar * Web: http://www.roseindia.net
 * roseindia.net/hibernate/hibernate4.3/Hibernate-4-hello-world-example.shtml
 */
public class HibernateHelloWorld {
	public static void main(String[] args) throws Exception {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();

		String strSql = "from EmployeeAnnot o";
		//String strSql = "select o from EmployeeAnnot o";
		Query query = session.createQuery(strSql);
		List lst = query.list();
		for (Iterator it = lst.iterator(); it.hasNext();) {

			EmployeeAnnot emp = (EmployeeAnnot) it.next();
			System.out.println("Hello: " + emp.getEmpName());
		}

		tr.commit();
		System.out.println("Data displayed");
		sessFact.close();
	}
}
