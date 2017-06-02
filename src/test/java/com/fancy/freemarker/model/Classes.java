package com.fancy.freemarker.model;

import java.util.List;

public class Classes {

    private String classId; // 班级ID

    private String className; // 班级名称

    private List<User> users;

    public String getClassId() {
        return classId;
    }

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

    //省略settter和getter方法

}