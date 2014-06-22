package calendar;

import java.util.Date;


public class Schedule {
	
	public Schedule(){
		super();
	}
	
	public Schedule(Date time, String schedule) {
		super();
		this.time = time;
		this.schedule = schedule;
	}
	
	private Date time;
	private String schedule;
	public Date getTime() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String toStirng(){
		return time.getTime() + "\t" + schedule;
	}
	

}
