package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bjsxt.hibernate.models.Group;
import com.bjsxt.hibernate.models.User;
import com.bjsxt.hibernate.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class ORMTest {
	private static SessionFactory sessionFactory = null;

	@BeforeClass
	public static void beforeClass() {
//		new SchemaExport(new AnnotationConfiguration().configure()).create(
//				true, true);
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Test
	public void testUserSave() {
		Group g = new Group();
		g.setName("g1");

		User u = new User();
		u.setName("u1");
		u.setGroup(g);

		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		// s.save(g);
		s.save(u);
		s.getTransaction().commit();
	}

	@Test
	public void testGroupSave() {

		User u = new User();
		u.setName("u1ttttt");

		User u1 = new User();
		u1.setName("u2");

		Group g = new Group();
		g.setName("g1");
		g.getUsers().add(u);
		g.getUsers().add(u1);

		u.setGroup(g);
		u1.setGroup(g);

		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		s.save(g);
		// s.save(u1);
		s.getTransaction().commit();
	}

	@Test
	public void testGetUser() {
		testGroupSave();
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		User user = (User) s.get(User.class, 1);
		s.getTransaction().commit();
	}
	
	@Test
	public void testGetGroup() {
		testGroupSave();
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		Group group = (Group) s.get(Group.class, 1);
		s.getTransaction().commit();
		for (User user : group.getUsers()) {
			System.out.println(user.getName());
		}
	}

	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}

	@Test
	public void testSchemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(
				true, true);
	}

	public static void main(String[] args) {
		beforeClass();
		System.out.println("初始化完成");
	}
}
