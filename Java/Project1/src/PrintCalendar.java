import java.util.Scanner;

public class PrintCalendar {
  /** Main method */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);  

    // Prompt the user to enter year
    System.out.print("Enter full year (e.g., 2001): ");
    int year = input.nextInt();

    // Prompt the user to enter month
    System.out.print("Enter month in number smaller than 12 "); //�� �κ� ���� �ʿ�. 0�Է��ҽ� ��� ���� ����ؾ���.  0 ���ϵ� ����.
    int month = input.nextInt(); // �޾Ƽ� month�� ����. �� �κ��� 1~12�� �����Ǿ��ִ�. �� ���� ������ ��� �����߻���.
   
    if(month<1){
      int yul=2;
	printMonth(year,month,yul); //�̰� ��µǸ� �Ǵ°���.. �����. printMonth Ŭ�󽺷� �Ѿ. 21��°��
    }
    else
   printMonth(year, month);
  }

  /** Print the calendar for a month in a year */
  public static void printMonth(int year, int month) {
    // Print the headings of the calendar
    printMonthTitle(year, month); //�� �̸� 30�� ������.

    // Print the body of the calendar
    printMonthBody(year, month); //�� ���� 59��
  }

  /** Print the month title, e.g., May, 1999 */
  public static void printMonthTitle(int year, int month) { //month 0�϶� �ݺ����� �ʿ�. 1����2��. ���⼭ if������ month�� 0�����϶� while������ month�� 1�� 12�� ���� ������Ų��.

	System.out.println("         " + getMonthName(month) //getMonthName�� ȣ���� 38��
      + " " + year);
    System.out.println("-----------------------------");
    System.out.println(" Sun Mon Tue Wed Thu Fri Sat");//���� �ϳ��� ������ ���������� 12�� �� ������ �����ȵ�. //2�� �̻��� ǥ���ؾ��� . �̴�� �ϸ� �� ������ ǥ����. 6���� �̻��� ������. 
 
  }

  /** Get the English name for the month */
  public static String getMonthName(int month) { //���⼭ ��ȯ �ʿ�. 0�� ����������? ��� ���� �� ����ؾ���.
    String monthName = "";
    
    switch (month) {
      case 1: monthName = "January"; break;
      case 2: monthName = "February"; break;
      case 3: monthName = "March"; break;
      case 4: monthName = "April"; break;
      case 5: monthName = "May"; break;
      case 6: monthName = "June"; break;
      case 7: monthName = "July"; break;
      case 8: monthName = "August"; break;
      case 9: monthName = "September"; break;
      case 10: monthName = "October"; break;
      case 11: monthName = "November"; break;
      case 12: monthName = "December";
      
    }

    return monthName;
  }

  /** Print month body */
  public static void printMonthBody(int year, int month) { //26�ٿ��� �Ѿ�� ������ �ް� �Ͽ�ȭ����� ��±��� ��. ��¥�� ���ߵ�.. 
    // Get start day of the week for the first date in the month
    int startDay = getStartDay(year, month); //GetStartDayȣ����. 82�� 

    // Get number of days in the month
    int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

    // Pad space before the first day of the month
    int i = 0;
    for (i = 0; i < startDay; i++)
      System.out.print("    ");//��÷�� ��ĭ�� �ʿ����� 

    for (i = 1; i <= numberOfDaysInMonth; i++) {
      System.out.printf("%4d", i); //��¥ ����ֱ�.

      if ((i + startDay) % 7 == 0)
        System.out.println();//Enter��°Ű���. 
    }

    System.out.println();
  }

  /** Get the start day of month/1/year */
  public static int getStartDay(int year, int month) { //61�ٿ��� �Ѿ�Դ�. ��¥ ���ϱ�. 
    final int START_DAY_FOR_JAN_1_1800 = 3;
    // Get total number of days from 1/1/1800 to month/1/year
    int totalNumberOfDays = getTotalNumberOfDays(year, month); //getTotalNumberOfDays ȣ�� 92��

    // Return the start day for month/1/year
    return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7; //���ؿ� �� �հ� ���ڿ��ٰ� 7�� ������ �������� �������ν� �� ���������ڰ� 3�̸�, 3���� ��¥�����̶�°�. 
  }

  /** Get the total number of days since January 1, 1800 */
  public static int getTotalNumberOfDays(int year, int month) { //85�ٿ��� �Ѿ��
    int total = 0;

    // Get the total days from 1800 to 1/1/year
    for (int i = 1800; i < year; i++)
      if (isLeapYear(i)) //isLeapYear ȣ�� 124��, �����̸� 366��. �ƴϸ� 365��.
        total = total + 366; //�װ� �� ���ұ�? TOTAL�̶�°� ��� �ʿ��Ѱ�? ���� ��������. 7�� ������ ������ ���ڷ� �����ϴ� ���� ����.
      else
        total = total + 365;

    // Add days from Jan to the month prior to the calendar month
    for (int i = 1; i < month; i++)
      total = total + getNumberOfDaysInMonth(year, i); //getNumberOfdaysInMonth ȣ�� .  110��

    return total;
  }

  /** Get the number of days in a month */
  public static int getNumberOfDaysInMonth(int year, int month) { //month�� 0�� ���� ��� month�� �� ��ȯ�ؾ���. ���� �ʿ�.
    if (month == 1 || month == 3 || month == 5 || month == 7 ||
      month == 8 || month == 10 || month == 12)
      return 31;

    if (month == 4 || month == 6 || month == 9 || month == 11)
      return 30;

    if (month == 2) return isLeapYear(year) ? 29 : 28; //�����̸� 29, �ƴϸ� 28

    return 0; // If month is incorrect
  }

  /** Determine if it is a leap year */
  public static boolean isLeapYear(int year) { //97�ٿ��� ȣ��. 
    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0); //�̰� �������ΰ�. �ؼ��� �������� ���� ���ϴ� �����ε�.
  }
  
  
  
  
   public static void printMonth(int year,int month,int yul){
	// Print the headings of the calendar 
	          for(month=1;month<13;month=month+2){
	    		printMonthTitle(year,month,yul);
	    	  	printMonthBody(year,month,yul);
	          }
	   
	}  
	    //�� ���� 59��
   
   public static void printMonthTitle(int year,int month,int yul){ //month 0�϶� �ݺ����� �ʿ�. 1����2��. ���⼭ if������ month�� 0�����϶� while������ month�� 1�� 12�� ���� ������Ų��.
     
		System.out.println("         " + getMonthName(month) + " " + year+"         " +"         " + getMonthName(month+1) + " " + year+
				           "\n"+"-----------------------------"+"-----------------------------"+"\n"+" Sun Mon Tue Wed Thu Fri Sat"+"  Sun Mon Tue Wed Thu Fri Sat");
	   	   		  
	  }

	 

	  /** Print month body */
	  public static void printMonthBody(int year,int month,int yul) { //26�ٿ��� �Ѿ�� ������ �ް� �Ͽ�ȭ����� ��±��� ��. ��¥�� ���ߵ�.. 
	  
		
	    int startDay1 = getStartDay(year, month);
	    int startDay2 = getStartDay(year, month+1);
	    int numberOfDaysInMonth1 = getNumberOfDaysInMonth(year, month);
        int numberOfDaysInMonth2 = getNumberOfDaysInMonth(year, month+1);
	   
	    int i = 0;
	    int j = 0;
	    int k = 1;
	   
	    for (i = 0; i < startDay1; i++)
	      System.out.print("    ");

	    for (i = 1; i <= numberOfDaysInMonth1; i++) {
	      System.out.printf("%4d", i); 

	      if ((i + startDay1) % 7 == 0){
	    	  if(j==0){
	    	  for (j=0; j < startDay2; j++){
	    		      System.out.print("    ");
	    	      }
	    	  }
	    	  
	    	  for (j = 1; j <numberOfDaysInMonth2; k++) {
	    		       j=k;
	    	    	   System.out.printf("%4d", k); 
	    	    	   if ((k + startDay2) % 7 == 0){
	    	    		System.out.println();
	    	        	k=k+1;
	    	            break;
	    	            } 
	    	    	   if(k==numberOfDaysInMonth2){
	    	    		   System.out.println();
	    	    	   }
	    	           	            
	    	    }
	   
	        
	        System.out.println(); 
	      }
	    }
	    if(i==numberOfDaysInMonth1+1){
	    	 for(int m=0;m<=7-((i-1+startDay1)%7);m++){
		        	System.out.printf("   ");    	    
	    	    }
	    	for (j = k; j < numberOfDaysInMonth2; k++) {
	        j=k;
	       
	        System.out.printf("%4d", k);
	        if ((k + startDay2) % 7 == 0){
	        	System.out.println();
	        	if(k+1!=32){
	        	System.out.printf("%32d",k+1);
	        	break;}
    	    }
	    	
	    }

	    System.out.println();
	    
	   
	    
	  }
	  }
	  
	  }
   

