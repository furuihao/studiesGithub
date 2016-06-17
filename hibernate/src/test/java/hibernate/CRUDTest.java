package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bjsxt.hibernate.models.practice.Course;
import com.bjsxt.hibernate.models.practice.Student;
import com.bjsxt.hibernate.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class CRUDTest {
	private static SessionFactory sessionFactory = null;

	@BeforeClass
	public static void beforeClass() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}

	@Test
	public void testSchemaExpot() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(
				false, true);
	}

	@Test
	public void test() {
		Student stu1 = new Student();
		stu1.setName("stu1");
		Student stu2 = new Student();
		stu2.setName("stu2");

		Course cos1 = new Course();
		cos1.setName("cos1");
		Course cos2 = new Course();
		cos2.setName("cos2");

		stu1.getCourses().add(cos1);

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(stu1);
		session.save(stu2);

		session.getTransaction().commit();
	}

	public static void main(String[] args) {
		// beforeClass();
	}
}
