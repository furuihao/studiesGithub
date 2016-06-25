package struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -99199186347968583L;
	
	@Override
	public String execute() throws Exception {
		return "action2";
	}
}
