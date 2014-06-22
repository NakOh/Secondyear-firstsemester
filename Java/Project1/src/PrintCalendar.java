import java.util.Scanner;

public class PrintCalendar {
  /** Main method */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);  

    // Prompt the user to enter year
    System.out.print("Enter full year (e.g., 2001): ");
    int year = input.nextInt();

    // Prompt the user to enter month
    System.out.print("Enter month in number smaller than 12 "); //이 부분 수정 필요. 0입력할시 모든 월을 출력해야함.  0 이하도 가능.
    int month = input.nextInt(); // 받아서 month로 들어간다. 이 부분은 1~12로 설정되어있다. 그 외의 숫자일 경우 오류발생됨.
   
    if(month<1){
      int yul=2;
	printMonth(year,month,yul); //이게 출력되면 되는거지.. 결과임. printMonth 클라스로 넘어감. 21번째줄
    }
    else
   printMonth(year, month);
  }

  /** Print the calendar for a month in a year */
  public static void printMonth(int year, int month) {
    // Print the headings of the calendar
    printMonthTitle(year, month); //달 이름 30줄 가본다.

    // Print the body of the calendar
    printMonthBody(year, month); //달 내용 59줄
  }

  /** Print the month title, e.g., May, 1999 */
  public static void printMonthTitle(int year, int month) { //month 0일때 반복실행 필요. 1월후2월. 여기서 if문으로 month가 0이하일때 while문으로 month를 1과 12로 각각 증가시킨다.

	System.out.println("         " + getMonthName(month) //getMonthName을 호출함 38줄
      + " " + year);
    System.out.println("-----------------------------");
    System.out.println(" Sun Mon Tue Wed Thu Fri Sat");//달이 하나만 나오면 성립되지만 12달 다 나오면 성립안됨. //2열 이상을 표현해야함 . 이대로 하면 쭉 행으로 표현됨. 6개월 이상은 옆으로. 
 
  }

  /** Get the English name for the month */
  public static String getMonthName(int month) { //여기서 변환 필요. 0이 들어왔을때는? 모든 달을 다 출력해야함.
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
  public static void printMonthBody(int year, int month) { //26줄에서 넘어옴 위에서 달과 일월화수목금 출력까지 함. 날짜가 들어가야됨.. 
    // Get start day of the week for the first date in the month
    int startDay = getStartDay(year, month); //GetStartDay호출함. 82줄 

    // Get number of days in the month
    int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

    // Pad space before the first day of the month
    int i = 0;
    for (i = 0; i < startDay; i++)
      System.out.print("    ");//맨첨에 빈칸이 필요하지 

    for (i = 1; i <= numberOfDaysInMonth; i++) {
      System.out.printf("%4d", i); //날짜 집어넣기.

      if ((i + startDay) % 7 == 0)
        System.out.println();//Enter라는거겠지. 
    }

    System.out.println();
  }

  /** Get the start day of month/1/year */
  public static int getStartDay(int year, int month) { //61줄에서 넘어왔다. 날짜 구하기. 
    final int START_DAY_FOR_JAN_1_1800 = 3;
    // Get total number of days from 1/1/1800 to month/1/year
    int totalNumberOfDays = getTotalNumberOfDays(year, month); //getTotalNumberOfDays 호출 92줄

    // Return the start day for month/1/year
    return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7; //구해온 총 합계 숫자에다가 7을 나눠서 나머지를 구함으로써 그 나머지숫자가 3이면, 3부터 날짜시작이라는거. 
  }

  /** Get the total number of days since January 1, 1800 */
  public static int getTotalNumberOfDays(int year, int month) { //85줄에서 넘어옴
    int total = 0;

    // Get the total days from 1800 to 1/1/year
    for (int i = 1800; i < year; i++)
      if (isLeapYear(i)) //isLeapYear 호출 124줄, 윤달이면 366일. 아니면 365일.
        total = total + 366; //그걸 왜 더할까? TOTAL이라는게 어디에 필요한거? 위에 나와있음. 7로 나눠서 나머지 숫자로 시작하는 날을 맞춤.
      else
        total = total + 365;

    // Add days from Jan to the month prior to the calendar month
    for (int i = 1; i < month; i++)
      total = total + getNumberOfDaysInMonth(year, i); //getNumberOfdaysInMonth 호출 .  110줄

    return total;
  }

  /** Get the number of days in a month */
  public static int getNumberOfDaysInMonth(int year, int month) { //month가 0일 경우는 모든 month를 다 소환해야함. 수정 필요.
    if (month == 1 || month == 3 || month == 5 || month == 7 ||
      month == 8 || month == 10 || month == 12)
      return 31;

    if (month == 4 || month == 6 || month == 9 || month == 11)
      return 30;

    if (month == 2) return isLeapYear(year) ? 29 : 28; //윤달이면 29, 아니면 28

    return 0; // If month is incorrect
  }

  /** Determine if it is a leap year */
  public static boolean isLeapYear(int year) { //97줄에서 호출. 
    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0); //이게 무슨말인가. 해석은 힘들지만 윤달 구하는 공식인듯.
  }
  
  
  
  
   public static void printMonth(int year,int month,int yul){
	// Print the headings of the calendar 
	          for(month=1;month<13;month=month+2){
	    		printMonthTitle(year,month,yul);
	    	  	printMonthBody(year,month,yul);
	          }
	   
	}  
	    //달 내용 59줄
   
   public static void printMonthTitle(int year,int month,int yul){ //month 0일때 반복실행 필요. 1월후2월. 여기서 if문으로 month가 0이하일때 while문으로 month를 1과 12로 각각 증가시킨다.
     
		System.out.println("         " + getMonthName(month) + " " + year+"         " +"         " + getMonthName(month+1) + " " + year+
				           "\n"+"-----------------------------"+"-----------------------------"+"\n"+" Sun Mon Tue Wed Thu Fri Sat"+"  Sun Mon Tue Wed Thu Fri Sat");
	   	   		  
	  }

	 

	  /** Print month body */
	  public static void printMonthBody(int year,int month,int yul) { //26줄에서 넘어옴 위에서 달과 일월화수목금 출력까지 함. 날짜가 들어가야됨.. 
	  
		
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
   

