package calendar;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;




public class FileManager {
	public void save() throws IOException{
		PrintWriter out = new PrintWriter(new FileWriter("save"));
		HashMap<Date, Schedule> map = Commons.scheduleManager.getScheduleMap();
		
		for(Schedule s : map.values()){
			out.println(s.toString());
		}
		out.close();
	}
	
	public void load(){
		Scanner in = new Scanner("save");
		
		while(in.hasNext()){
			Commons.scheduleManager.create(parse(in.nextLine()));
		}
	}
	
	private Schedule parse(String data){
		String[] temp = data.split("\t");
		Date time = new Date(Long.parseLong(temp[0]));
		
				
		return new Schedule(time, temp[1]);
	}
}
