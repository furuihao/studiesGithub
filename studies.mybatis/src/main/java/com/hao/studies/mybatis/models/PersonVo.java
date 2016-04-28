package com.hao.studies.mybatis.models;

import java.util.List;

/**
 * 视图对象，可作为查询条件的输入对象
 * 
 * @author hao
 *
 */
public class PersonVo {
	private PersonCustom personCustom;

	private List<Integer> ids;

	public PersonCustom getPersonCustom() {
		return personCustom;
	}

	public void setPersonCustom(PersonCustom personCustom) {
		this.personCustom = personCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
}
