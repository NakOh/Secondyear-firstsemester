package calendar;

import java.util.Date;
import java.util.HashMap;


public class ScheduleManager {

	private HashMap<Date, Schedule> scheduleMap;

	public HashMap<Date, Schedule> getScheduleMap() {
		return scheduleMap;
	}

	public void setScheduleMap(HashMap<Date, Schedule> scheduleMap) {
		this.scheduleMap = scheduleMap;
	}

	public void create(Schedule schedule){
		this.scheduleMap.put(schedule.getTime(), schedule);
	}

	public Schedule read(Date time){
		return scheduleMap.get(time);
	}

	public void update(Schedule schedule){
		scheduleMap.get(schedule.getTime()).setSchedule(schedule.getSchedule());
	}

	public void delete(Schedule schedule){
		scheduleMap.remove(schedule);
	}
}
