import java.io.*;
import java.util.*;


class Count {

	private int[] counts = new int[52];

	public int[] countString(String string) {

		for (int i = 0; i < string.length(); i++) {

			if (string.charAt(i) >= 65 && string.charAt(i) <= 90) {
				counts[string.charAt(i) - 'A']++;
			} else if (string.charAt(i) >= 97 && string.charAt(i) <= 122) {
				counts[string.charAt(i) - 'a' + 26]++;
			}
		}
		return counts;
	}

	public void displayCounts() {
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] == 0)
				continue;
				if ((i + 1) % 10 == 0)
					if (i < 26) {
						System.out.println((char) (i + 'A') + " : " + counts[i]);
					} else {
						System.out.println((char) (i + 'a' - 26) + " : "
								+ counts[i]);
					}
				else {
					if (i < 26) {
						System.out.print((char) (i + 'A') + " : " + counts[i]
								+ "\t");
					} else {
						System.out.print((char) (i + 'a' - 26) + " : " + counts[i]
								+ "\t");
					}
				}
		}
	}
}


public class ReplaceText {
	public static void main(String[] args) throws Exception {

		Count count = new Count();

		if(args.length==4){//targetFile이있을경우진행
			// Check if source file exists
			if(!args[2].endsWith("txt")){
				System.out.println("텍스트파일만사용가능합니다.");
				System.exit(0);
			}


			File sourceFile = new File(args[2]);
			if (!sourceFile.exists()) {
				System.out.println("Source file " + args[2] + " does not exist");
				System.exit(0);
			}

			// Check if target file exists
			File targetFile = new File(args[3]);
			if (targetFile.exists()) {
				System.out.println("Target file " + args[3] + " already exists");
				System.exit(0);
			}

			// Create input and output files
			Scanner input = new Scanner(sourceFile);
			PrintWriter output = new PrintWriter(targetFile);

			System.out.println("텍스트파일의알파벳갯수");

			while (input.hasNext()) {

				String s1 = input.nextLine();
				String s2 = s1.replaceAll(args[0], args[1]);
				output.println(s2);
				count.countString(s2);

				System.out.println("");

			}
			count.displayCounts();
			input.close();
			output.close();
		}

		else if(args.length==3){//입력값이3개일때, 즉targerFile설정이안되었을때.
			if(!args[2].endsWith("txt")){
				System.out.println("텍스트파일만사용가능합니다.");
				System.exit(0);
			}

			File sourceFile = new File(args[2]);
			if (!sourceFile.exists()) {
				System.out.println("Source file " + args[2] + " does not exist");
				System.exit(0);
			}
			//임시파일생성
			int uniquevalue=(int) (Math.random()+System.currentTimeMillis()); // 현재시간값으로unique한이름생성

			File targetFile = new File(uniquevalue+".txt");


			// Create input and output files
			Scanner input = new Scanner(sourceFile);
			PrintWriter output = new PrintWriter(targetFile);

			while (input.hasNext()) {
				
				String s1 = input.nextLine();
				String s2 = s1.replaceAll(args[0], args[1]);
				output.println(s2);

			}

			input.close();
			output.close();

			Scanner input2 = new Scanner(targetFile);
			PrintWriter output2 = new PrintWriter(sourceFile);


			while (input2.hasNext()){
				String s1 = input2.nextLine();
				String s2 = new String(s1);
				output2.println(s2);
				output.println(s2);
				count.countString(s2);

			}

			count.displayCounts();
			input2.close();
			output2.close();
			targetFile.delete();
		}

		else{//뭔가입력값이잘못되었을때어떻게적어야하는지출력!
			System.out.println(
					"Usage: java ReplaceText oldStr newStr sourceFile targetFile"+"or java Replacementoldstr newStr sourceFile ");
			System.exit(0);

		}

	}



}


