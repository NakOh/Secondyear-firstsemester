package Address;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class AddressBook extends JFrame {
	static ArrayList<String> myArrayList = new ArrayList<String>(); 
	static int i = 0;
	// Specify the size of five string fields in the record
	final static int NAME_SIZE = 32;
	final static int STREET_SIZE = 32;
	final static int CITY_SIZE = 20;
	final static int STATE_SIZE = 2;
	final static int ZIP_SIZE = 5;
	final static int RECORD_SIZE =
			(NAME_SIZE + STREET_SIZE + CITY_SIZE + STATE_SIZE + ZIP_SIZE);

	// Access address.dat using RandomAccessFile
	private File accords;

	// Text fields
	private JTextField jtfName = new JTextField(NAME_SIZE);
	private JTextField jtfStreet = new JTextField(STREET_SIZE);
	private JTextField jtfCity = new JTextField(CITY_SIZE);
	private JTextField jtfState = new JTextField(STATE_SIZE);
	private JTextField jtfZip = new JTextField(ZIP_SIZE);

	// Buttons
	private JButton jbtAdd = new JButton("Add");
	private JButton jbtFirst = new JButton("First");
	private JButton jbtNext = new JButton("Next");
	private JButton jbtPrevious = new JButton("Previous");
	private JButton jbtLast = new JButton("Last");
	private JButton jbtClear = new JButton("Clear");
	private JButton jbtSearch = new JButton("Search");
	private JButton jbtDelete = new JButton("Delete");

	public AddressBook() throws IOException {

		accords = new File("address.dat"); 
		if(!accords.exists())
			accords.createNewFile();
		readText(myArrayList);

		// Panel p1 for holding labels Name, Street, and City
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3, 1));
		p1.add(new JLabel("Name"));
		p1.add(new JLabel("Street"));
		p1.add(new JLabel("City"));

		// Panel jpState for holding state
		JPanel jpState = new JPanel();
		jpState.setLayout(new BorderLayout());
		jpState.add(new JLabel("State"), BorderLayout.WEST);
		jpState.add(jtfState, BorderLayout.CENTER);

		// Panel jpZip for holding zip
		JPanel jpZip = new JPanel();
		jpZip.setLayout(new BorderLayout());
		jpZip.add(new JLabel("Zip"), BorderLayout.WEST);
		jpZip.add(jtfZip, BorderLayout.CENTER);

		// Panel p2 for holding jpState and jpZip
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		p2.add(jpState, BorderLayout.WEST);
		p2.add(jpZip, BorderLayout.CENTER);

		// Panel p3 for holding jtfCity and p2
		JPanel p3 = new JPanel();
		p3.setLayout(new BorderLayout());
		p3.add(jtfCity, BorderLayout.CENTER);
		p3.add(p2, BorderLayout.EAST);

		// Panel p4 for holding jtfName, jtfStreet, and p3
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(3, 1));
		p4.add(jtfName);
		p4.add(jtfStreet);
		p4.add(p3);

		// Place p1 and p4 into jpAddress
		JPanel jpAddress = new JPanel(new BorderLayout());
		jpAddress.add(p1, BorderLayout.WEST);
		jpAddress.add(p4, BorderLayout.CENTER);

		// Set the panel with line border
		jpAddress.setBorder(new BevelBorder(BevelBorder.RAISED));

		// Add buttons to a panel
		JPanel jpButton = new JPanel();
		jpButton.add(jbtAdd);
		jpButton.add(jbtFirst);
		jpButton.add(jbtNext);
		jpButton.add(jbtPrevious);
		jpButton.add(jbtLast);
		jpButton.add(jbtClear);
		jpButton.add(jbtSearch);
		jpButton.add(jbtDelete);

		// Add jpAddress and jpButton to the frame
		add(jpAddress, BorderLayout.CENTER);
		add(jpButton, BorderLayout.SOUTH);

		jbtAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeAddress();
				i=myArrayList.size()-1; //맨 뒤로 보내서 현재 추가 한 값이 맨뒤에 저장 됬다고 전재
			}
		});

		jbtFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (i>0) 
					{
						readAddress(0);
						i=0;
					}

				}
				catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		jbtNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(i < myArrayList.size()-1){
						++i;
						readAddress(i);
					}
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
		});
		jbtPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(i>0)
					{
						--i;
						readAddress(i);
					}

				}
				catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		jbtLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					i=myArrayList.size()-1;
					readAddress(i);

				} catch (IOException e1) {

					e1.printStackTrace();
				}				
			}
		});

		jbtClear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jtfName.setText("");
				jtfStreet.setText("");
				jtfCity.setText("");
				jtfState.setText("");
				jtfZip.setText("");
			}			
		});

		jbtSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String Name = jtfName.getText();
				String Street = jtfStreet.getText();
				String City = jtfCity.getText();
				String State = jtfState.getText();
				String Zip = jtfState.getText();

				for(i=0;i<myArrayList.size()-1;i++){
					
					String s = myArrayList.get(i);

					if(s.matches(".*"+Name+".*") && s.matches(".*"+Street+".*") && s.matches(".*"+City+".*") && s.matches(".*"+State+".*") && s.matches(".*"+Zip+".*")){
						try {
							readAddress(i);
							break;
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else{
						
					}

				}

			}


		});

		jbtDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				myArrayList.remove(i);

				try {
					AddressRecord.deleteAddress(i,accords);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if(i<=myArrayList.size()-1){
					try {
						readAddress(i);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					try {
						readAddress(i-1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						i--;
					}

				}




			}


		});

		// Display the first record if exists
		try {
			if (myArrayList.size() > 0) readAddress(0);


		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}


	public void writeRecordArrayList(){

		myArrayList.add(jtfName.getText()+";"+jtfStreet.getText()+";"+jtfCity.getText()+";"+jtfState.getText()+";"+jtfZip.getText());
		i=myArrayList.size()-1;
	}

	/** Write a record at the end of the file */
	public void writeAddress() {
		try {

			writeRecordArrayList();
			AddressRecord.writeString(myArrayList.get(i),accords);

		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}


	/** Read a record at the specified position */
	public void readAddress(int i) throws IOException {

		StringTokenizer address = new StringTokenizer(myArrayList.get(i),";");
		String name = address.nextToken();
		String street = address.nextToken();
		String city = address.nextToken();
		String state = address.nextToken();
		String zip = address.nextToken();

		jtfName.setText(name);
		jtfStreet.setText(street);
		jtfCity.setText(city);
		jtfState.setText(state);
		jtfZip.setText(zip);
	}

	public static void main(String[] args) throws IOException {
		AddressBook frame = new AddressBook();
		frame.pack();
		frame.setTitle("AddressBook");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}


	public void readText(ArrayList<String> MyArrayList) throws FileNotFoundException{


		MyArrayList = AddressRecord.readText(myArrayList,accords);


	}

}

