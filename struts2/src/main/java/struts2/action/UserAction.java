package struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -99199186347968583L;

	public String add() {
		return "addSuccess";
	}
	public String delete() {
		return "deletSuccess";
	}
}
