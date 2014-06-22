import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;


public class ScheduleData {
	public static void Dividetext() throws FileNotFoundException{
		int index;
		ArrayList<String> schedule = new ArrayList<String>();
		File accords = new File("Schedule.dat"); 
		TextData.readSchedule(schedule, accords);
		index = schedule.indexOf("year-month-day");
	}

}
