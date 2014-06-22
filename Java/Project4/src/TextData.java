import java.io.*;
import java.util.*;


public class TextData {
	public static void writeSchedule(String record, File accords) throws IOException{
		PrintWriter output = new PrintWriter(new FileWriter(accords,true));//추가되는 내용이 있으면 이어서 적습니다.
		output.println(record);
		output.close();
		
	}
	
	public static ArrayList<String> readSchedule(ArrayList<String> Schedule,File accords ) throws FileNotFoundException{
		
		Scanner read = new Scanner(accords);

		
		while(read.hasNext()){    	

			Schedule.add(read.nextLine());//text파일에 있는 모든 내용을 schedule에 담아냅니다.

		}

		read.close();	
		return Schedule;
		
	}

}
