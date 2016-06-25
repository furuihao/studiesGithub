package struts2.action;

import struts2.models.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//实现ModeleDriven接口,参数传递使用name=kk&age=19,在Struts2中使用getModel()方法获取User对象,再为对象属性赋值
//在Action的User要先new();
public class UserAction extends ActionSupport 
//implements ModelDriven<User>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -99199186347968583L;

	private User user;

	public String add() {
		System.out.println(user.getName() + ":" + user.getAge());
		if(user.getName()==null || user.getName().length()>4){
			this.addFieldError("name", "name is error");
			this.addFieldError("name", "名字太长");
			return "error";
		}
		return "addSuccess";
	}

	public String delete() {
		return "deletSuccess";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	@Override
//	public User getModel() {
//		return user;
//	}

}
