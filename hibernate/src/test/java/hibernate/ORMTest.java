package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bjsxt.hibernate.models.Group;
import com.bjsxt.hibernate.models.Student;
import com.bjsxt.hibernate.models.Teacher;
import com.bjsxt.hibernate.models.User;
import com.bjsxt.hibernate.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class ORMTest {
	private static SessionFactory sessionFactory = null;

	@BeforeClass
	public static void beforeClass() {
		// new SchemaExport(new AnnotationConfiguration().configure()).create(
		// true, true);
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
		System.out.println(user.getName());
		System.out.println(user.getGroup().getName());
	}

	@Test
	public void testLoadUser() {
		testGroupSave();
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		User user = (User) s.load(User.class, 1);
		// System.out.println(user.getName());
		System.out.println(user.getGroup().getName());
		s.getTransaction().commit();
	}

	@Test
	public void testUpdteUser() {
		testGroupSave();
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		User user = (User) s.get(User.class, 1);
		s.getTransaction().commit();
		// System.out.println(user.getName());
		System.out.println(user.getGroup().getName());
		user.setName("user");
		user.getGroup().setName("group");

		Session s2 = sessionFactory.getCurrentSession();
		s2.beginTransaction();
		s2.update(user);
		s2.getTransaction().commit();
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

	@Test
	public void testDeleteUser() {
		testGroupSave();
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		User user = (User) s.get(User.class, 1);
		// 因为User中的Group的Cascade设置为All,在删除User时会将Group也删除掉,
		// 而且Group中的Users属性也是Cascade设置为All,所以也会将对应的User删除掉
		// 所以想要删除某个User但不想级联删除Group时,可以将User中的Group对象设置为null,打破关联关系
		// user.setGroup(null);
		// s.delete(user);
		// 也可以直接用HQL语句进行删除
		s.createQuery("delete from User u where id=1").executeUpdate();
		s.getTransaction().commit();
	}

	@Test
	public void testDeleteGroup() {
		testGroupSave();
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		Group group = (Group) s.get(Group.class, 1);
		// Group中的Users属性的Cascade设置为All,所以会删除所有的User
		s.delete(group);
		s.getTransaction().commit();
	}

	@Test
	public void testSaveTeacher() {
		Teacher t = new Teacher();
		t.setName("t1");
		t.setTitle("hight");

		Teacher t2 = new Teacher();
		t2.setName("t2");
		t2.setTitle("middle");

		Student s = new Student();
		s.setName("t1");
		s.setAge(18);
		Student s2 = new Student();
		s2.setName("t2");
		s2.setAge(20);

		t.getStudents().add(s);
		t.getStudents().add(s2);

		t2.getStudents().add(s);
		t2.getStudents().add(s2);

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(t);
		session.save(t2);
		session.save(s);
		session.save(s2);
		session.getTransaction().commit();

		// Session session2 = sessionFactory.getCurrentSession();
		// session2.beginTransaction();
		// Teacher teacher = (Teacher) session2.get(Teacher.class, 1);
		// Student student = (Student) session2.get(Student.class, 1);
		// teacher.getStudents().add(student);
		// session2.save(t2);
		// session2.getTransaction().commit();
	}

	@Test
	public void testDeleteTeacher() {
		testSaveTeacher();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher) session.get(Teacher.class, 1);
		t.setStudents(null);
		session.delete(t);
		session.getTransaction().commit();
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
