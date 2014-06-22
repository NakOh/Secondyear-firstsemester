import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calender extends JFrame {

	String[] days = { "일", "월", "화", "수", "목", "금", "토" };
	JButton[] button = new JButton[49];
	JButton btnBefore, btnAfter;
	JTextField txtMonth, txtYear;
	JPanel panWest, menu;
	Calendar cal, today;
	int year ,month,day,todays,memoday=0;

	public Calender() {
		
		today = Calendar.getInstance();
        cal = new GregorianCalendar();
        year = today.get(Calendar.YEAR);
        month = today.get(Calendar.MONTH)+1;
		menu = new JPanel();
		menu.add(btnBefore = new JButton("Before"));
		menu.add(txtYear = new JTextField(year + "년"));
		menu.add(txtMonth = new JTextField(month + "월", 3));
		txtYear.setEnabled(false);
		txtMonth.setEnabled(false);
		menu.add(btnAfter = new JButton("After"));
		add(menu, "South");		
	
		panWest = new JPanel(new GridLayout(7, 7));
		gridInit();
		calSet();
		hideInit();
		
		add(panWest, "Center");
		setTitle("달력");
		setBounds(200, 200, 345, 250);
		setVisible(true);
		
	}

    public void calSet(){
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH,(month-1));
        cal.set(Calendar.DATE,1);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
   
        int j=0;
        int hopping=0;
    
        for(int i=cal.getFirstDayOfWeek();i<dayOfWeek;i++){  j++;  }
        
        hopping=j;
        for(int kk=0;kk<hopping;kk++){
               button[kk+7].setText("");
        }
        for(int i=cal.getMinimum(Calendar.DAY_OF_MONTH);
                      i<=cal.getMaximum(Calendar.DAY_OF_MONTH);i++){
            cal.set(Calendar.DATE,i);
               if(cal.get(Calendar.MONTH) !=month-1){
                      break;
               }
         
               button[i+6+hopping].setText((i)+"");
        }
  }
	
	
	
	
	
	public void hideInit() {
		for (int i = 0; i < button.length; i++) {
			if ((button[i].getText()).equals(""))
				button[i].setEnabled(false);
		}
	}

	public void gridInit() {

		for (int i = 0; i < days.length; i++) {
			panWest.add(button[i] = new JButton(days[i]));
		
		}

		for (int i = days.length; i < 49; i++) {
			panWest.add(button[i] = new JButton(""));
			button[i].addActionListener((ActionListener) this);
		}
	}


}