package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bjsxt.hibernate.models.practice.Org;
import com.bjsxt.hibernate.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class TreeTest {
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

	public static void main(String[] args) {
		beforeClass();
	}

	@Test
	public void testSaveOrg() {
		Org org = new Org();

		Org kf = new Org();
		kf.setName("开发");
		kf.setParent(org);

		Org java = new Org();
		java.setName("java");
		java.setParent(kf);
		Org an = new Org();
		an.setName("an");
		an.setParent(kf);
		Org ios = new Org();
		ios.setName("ios");
		ios.setParent(kf);

		kf.getChilds().add(java);
		kf.getChilds().add(an);
		kf.getChilds().add(ios);

		Org cw = new Org();
		cw.setName("财务");
		cw.setParent(org);

		Org sw = new Org();
		sw.setName("商务");
		sw.setParent(org);

		org.getChilds().add(sw);
		org.getChilds().add(cw);
		org.getChilds().add(kf);

		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		s.save(org);
		s.getTransaction().commit();
	}

	@Test
	public void testLoad() {
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		Org org = (Org) s.get(Org.class, 1);
		// for (Org child : kf.getChilds()) {
		// System.out.println(child.getName());
		// }
		print(org, 0);
		s.getTransaction().commit();
	}

	private void print(Org org, int level) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < level; i++) {
			sb.append("----");
		}
		System.out.println(sb.toString() + org.getName());
		for (Org child : org.getChilds()) {
			print(child, level + 1);
		}
	}

}
