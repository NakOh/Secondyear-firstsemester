import java.io.*;
import java.util.*;


public class TextData {
	public static void writeSchedule(String record, File accords) throws IOException{
		PrintWriter output = new PrintWriter(new FileWriter(accords,true));//�߰��Ǵ� ������ ������ �̾ �����ϴ�.
		output.println(record);
		output.close();
		
	}
	
	public static ArrayList<String> readSchedule(ArrayList<String> Schedule,File accords ) throws FileNotFoundException{
		
		Scanner read = new Scanner(accords);

		
		while(read.hasNext()){    	

			Schedule.add(read.nextLine());//text���Ͽ� �ִ� ��� ������ schedule�� ��Ƴ��ϴ�.

		}

		read.close();	
		return Schedule;
		
	}

}
