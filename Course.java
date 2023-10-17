package coding.mentor.data;

import java.util.ArrayList;
import java.util.Date;

public class Course {

	private int id;
	private String name;
	private ArrayList<Mentor> teachingMentors;
	private Date begin;
	private Date end;
	private int fee;
	
	public Course() {
		
	}
	
	
	public Course(int id) {
		this.id = id;
	}


	public Course(int id, String name, ArrayList<Mentor> teachingMentors, Date begin, Date end, int fee) {
		this.id = id;
		this.name = name;
		this.teachingMentors = teachingMentors;
		this.begin = begin;
		this.end = end;
		this.fee = fee;
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
	public ArrayList<Mentor> getTeachingMentors() {
		return teachingMentors;
	}
	public void setTeachingMentors(ArrayList<Mentor> teachingMentors) {
		this.teachingMentors = teachingMentors;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	
	
}
