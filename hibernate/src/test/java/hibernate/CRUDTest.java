package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bjsxt.hibernate.models.practice.Course;
import com.bjsxt.hibernate.models.practice.Score;
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
//		Student stu2 = new Student();
//		stu2.setName("stu2");
//		Student stu3 = new Student();
//		stu3.setName("stu3");

		Course cos1 = new Course();
		cos1.setName("cos1");
//		Course cos2 = new Course();
//		cos2.setName("cos2");
		
//		cos1.setScore(sco);
//		cos2.setScore(sco2);
		
		Score sco = new Score();
		sco.setMark(78d);
		
		sco.setCourse(cos1);
		sco.setStudent(stu1);
		
		cos1.setScore(sco);
		
//		cos1.getStudents().add(stu1);
//		cos1.getStudents().add(stu2);
//		cos2.getStudents().add(stu1);
//		cos2.getStudents().add(stu2);

		stu1.getCourses().add(cos1);
//		stu1.getCourses().add(cos2);
//		stu2.getCourses().add(cos1);
//		stu2.getCourses().add(cos2);
//		stu3.getCourses().add(cos1);
//		stu3.getCourses().add(cos2);

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(stu1);
		session.save(cos1);
		session.save(sco);

		session.getTransaction().commit();
	}
	
	@Test
	public void testAddScore(){
		test();
		Score sco = new Score();
		sco.setMark(78d);
		Score sco2 = new Score();
		sco2.setMark(90d);
		
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Student student = (Student)session.get(Student.class, 1);
		for(Course c : student.getCourses()){
			System.out.println(c.getName());
//			c.setScore(sco);
			System.out.println(c.getScore().getMark());
		}
		session.update(student);
		session.getTransaction().commit();
	}
	
	@Test
	public void testGetStudent(){
//		test();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Student student = (Student)session.get(Student.class, 1);
		for(Course c : student.getCourses()){
			System.out.println(c.getName());
			System.out.println(c.getScore().getMark());
		}
		session.getTransaction().commit();
	}

	public static void main(String[] args) {
		 beforeClass();
	}
}
