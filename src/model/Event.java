package model;

import java.sql.Date;

public class Event {
	private long id;
	private String title_event;
	private String	comment_about_event;
	private Date performance_date;
	
	
	public Event(long id, String title_event, Date performance_date, String comment_about_event) {
		super();
		this.id = id;
		this.title_event = title_event;
		this.comment_about_event = comment_about_event;
		this.performance_date = performance_date;
	}
	
	
	
	public Event(String title_event, Date performance_date, String comment_about_event) {
		super();
		this.title_event = title_event;
		this.comment_about_event = comment_about_event;
		this.performance_date = performance_date;
	}



	public Event() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle_event() {
		return title_event;
	}
	public void setTitle_event(String title_event) {
		this.title_event = title_event;
	}
	public String getComment_about_event() {
		return comment_about_event;
	}
	public void setComment_about_event(String comment_about_event) {
		this.comment_about_event = comment_about_event;
	}
	public Date getPerformance_date() {
		return performance_date;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title_event=" + title_event + ", comment_about_event=" + comment_about_event
				+ ", performance_date=" + performance_date + "]";
	}
	public void setPerformance_date(Date performance_date) {
		this.performance_date = performance_date;
	}

}
