package struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class PathAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -99199186347968583L;
	
	@Override
	public String execute() throws Exception {
		return "path";
	}
}
