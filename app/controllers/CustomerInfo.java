package controllers;

import java.util.*;
import org.joda.time.*;

public class CustomerInfo implements Comparable<CustomerInfo> {
	private int id;
	private String name;
	private String duetime;
	private String jointime;

	public CustomerInfo() {
	}

	public CustomerInfo(int id, String name, String duetime, String jointime) {
		if (name == null || duetime == null || jointime == null)
			throw new NullPointerException();
		this.id = id;
		this.name = name;
		this.duetime = duetime;
		this.jointime = jointime;
	}

	public boolean equals(Object o) {
		if (!(o instanceof CustomerInfo))
			return false;
		CustomerInfo c = (CustomerInfo) o;
		return (c.id == id) && (c.name.equals(name))
			&& (c.duetime.equals(duetime)) && (c.jointime.equals(jointime));
	}

	public int hashCode() {
		return 31*name.hashCode() + duetime.hashCode() + jointime.hashCode();
	}

	public String toString() {
		return name + "-" + duetime;
	}

	public int compareTo(CustomerInfo c) {
		return 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuetime() {
		return duetime;
	}

	public void setDuetime(String duetime) {
		this.duetime = duetime;
	}

	public String getJointime() {
		return jointime;
	}

	public void setJointime(String jointime) {
		this.jointime = jointime;
	}

	public static final Comparator<CustomerInfo> DUETIME_ORDER = 
					new Comparator<CustomerInfo>() {
			public int compare(CustomerInfo c1, CustomerInfo c2) {
				DateTime c1due = DateTime.parse(c1.duetime);
				DateTime c2due = DateTime.parse(c2.duetime);
				return c1due.compareTo(c2due);
			}
					};

}

