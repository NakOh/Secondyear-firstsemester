package Address;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressRecord {


	/** Write fixed number of characters to a DataOutput stream */
	public static void writeString(String record, File accords) throws IOException {
		PrintWriter output = new PrintWriter(new FileWriter(accords,true));
		output.println(record);
		output.close();
	}


	public static ArrayList<String> readText(ArrayList<String> myArrayList,File accords) throws FileNotFoundException{



		Scanner read = new Scanner(accords);


		while(read.hasNext()){    	

			myArrayList.add(read.nextLine());

		}

		read.close();	  
		return myArrayList;
	}

	public static void deleteAddress(int position, File accords) throws IOException{
	
				String dummy = "";
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(accords)));
				
					
					//1. �����ϰ��� �ϴ� position ���������� �̵��ϸ� dummy�� ����
					String line;
					for(int i=0; i<position; i++) {
					    line = br.readLine(); //������ �̵�
					    dummy += (line + "\r\n" ); 
					}
					
					//2. �����ϰ��� �ϴ� �����ʹ� �ǳʶٱ�
					String delData = br.readLine();
					
					//3. �����ϰ��� �ϴ� position ���ĺ��� dummy�� ����
					while((line = br.readLine())!=null) {
						dummy += (line + "\r\n" ); 
					}
					
					//4. FileWriter�� �̿��ؼ� �����
					FileWriter fw = new FileWriter(accords);
					fw.write(dummy);			
					
					//bw.close();
					fw.close();
					br.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}
}
