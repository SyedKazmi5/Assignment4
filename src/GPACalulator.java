//import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
//import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import ButtonFrame.ButtonHandler;

//import javax.swing.SwingConstants;
import javax.swing.JPanel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JScrollPane;

public class GPACalulator extends JFrame{
	//Labels Declaration
	JFrame myFrame= new JFrame();
	JPanel myPanel = new JPanel();
	private JPanel _contentPane; // JPanel Container
	private JLabel _headinglabel;
	private JLabel _creditHoursEarnedLabel;
	private JLabel _currentGPALabel;
	private JLabel _numberOfCoursesLabel;
	private JLabel _snoLabel;
	private JLabel _courseCodeLabel;
	private JLabel _creditHoursLabel;
	private JLabel _gradeLabel;
	private JLabel _yourGPALabel;
	private JLabel _finalGPALabel;
	
	private String[] _numboerofCoursesArray = { "1", "2", "3", "4", "5","6" };
	//private JScrollPane _todoScrollPane;

	//Text Fields Declaration
	private JTextField _creditHoursEarnedField;
	private JTextField _currentGPAField;
	
	//Combo Box Declaration
	private JComboBox<String> _numboerofCoursesComboBox;
	private JButton _calculateButton;
	
	
	
	
	String[] creditHoursArray = { "1", "2", "3", "4", "5","6" };
	String[] gradeArray = { "A+ 90-100", "A 80-89", "B+ 75-79", "B 70-74", "C+ 65-69", "C 60-60", "D+ 55-59", "D 50-54", "F 0-49"};
	
	ArrayList<JLabel> labelSNOArrayList = new  ArrayList<JLabel>();
	ArrayList<JTextField> textFieldArrayList = new ArrayList<JTextField>();
	ArrayList<JComboBox<String>> creditHoursComboBox = new ArrayList<JComboBox<String>>();
	ArrayList<JComboBox<String>> GradeComboBox = new ArrayList<JComboBox<String>>();
	public GPACalulator()
	{
		_generateGUI();
		//register event handlers
		_comboBoxHandler handler = new _comboBoxHandler();
		this._numboerofCoursesComboBox.addActionListener(handler);

		//_buttonHandler buttonHandler = new _buttonHandler();
		this._calculateButton.addActionListener(handler);
		//fancyJButton.addActionListener(handler);

	}
	private void _generateGUI() {
		setLayout(null);
		//this.setLayout(new FlowLayout());
		myPanel.setBorder(new EmptyBorder(5,5,5,5));
		myPanel.setLayout(new BorderLayout(0,0));
		myFrame.setContentPane(myPanel);
		myFrame.setVisible(true);

		_initializeLabels();
		_initializeFields();
		_initializeComboBox();
		//_createDynamicControls();
		
		_calculateButton = new JButton("Calculate");
		_calculateButton.setBounds(520, 400, 100, 29);
		add(_calculateButton);

//		this._todoScrollPane = new JScrollPane();
//		_todoScrollPane.setBounds(100, 120, 194, 152 );
//		this._todoScrollPane.setPreferredSize(new Dimension(8, 8));
//		this._todoScrollPane.setAutoscrolls(true);
//		add(_todoScrollPane);
	
	}
	
	private void _initializeLabels(){
		_headinglabel = new JLabel("GPA Calculator");
		_headinglabel.setBounds(325,10,100,10);
		add(_headinglabel);

		_creditHoursEarnedLabel = new JLabel("Credit Hours Earned: ");
		_creditHoursEarnedLabel.setBounds(10,30,150,10);
		add(_creditHoursEarnedLabel);

		_currentGPALabel = new JLabel("Current GPA: ");
		_currentGPALabel.setBounds(550,30,150,10);
		add(_currentGPALabel);

		_numberOfCoursesLabel = new JLabel("Number of Courses: ");
		_numberOfCoursesLabel.setBounds(510,80,150,10);
		add(_numberOfCoursesLabel);

		_snoLabel = new JLabel("SNO. ");
		_snoLabel.setBounds(60,150,100,25);
		add(_snoLabel);

		_courseCodeLabel = new JLabel("Course Code");
		_courseCodeLabel.setBounds(100, 150 ,100,25);
		add(_courseCodeLabel);

		_creditHoursLabel = new JLabel("Credit Hours ");
		_creditHoursLabel.setBounds(250, 150,  100,25);
		add(_creditHoursLabel);

		_gradeLabel = new JLabel("Grade");
		_gradeLabel.setBounds(400, 150 ,100,25);
		add(_gradeLabel);
		
		_yourGPALabel = new JLabel("Your GPA is ");
		_yourGPALabel.setBounds(300, 500 ,100,25);
		add(_yourGPALabel);

		_finalGPALabel = new JLabel("0");
		_finalGPALabel.setBounds(400, 500 ,100,25);
		add(_finalGPALabel);
	
//		label3 = new JLabel();
//		label3.setText("Label with icon and test at bottom");
//		label3.setHorizontalTextPosition(SwingConstants.CENTER);
//		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
//		label3.setToolTipText("This is label3");
//		add(label3);

	}
	
	private void _initializeFields(){
		_creditHoursEarnedField = new JTextField("",2);
		_creditHoursEarnedField.setBounds(130,23,100,25);
		add(_creditHoursEarnedField);

		_currentGPAField = new JTextField("",4);
		_currentGPAField.setBounds(630,23,100,25);
		add(_currentGPAField);
		
//		JTextField _test;
//		_test = new JTextField("",4);
//		_test.setBounds(500,100,50,25);
//		add(_test);

	}

	private void _initializeComboBox(){
		//_numboerofCoursesComboBox.setModel(new DefaultComboBoxModel<String>(_numboerofCoursesArray}));
		_numboerofCoursesComboBox = new JComboBox(_numboerofCoursesArray);
		_numboerofCoursesComboBox.setSelectedIndex(0);
		_numboerofCoursesComboBox.setMaximumRowCount(6);
		_numboerofCoursesComboBox.setBounds(630,73,50,25);
		add(_numboerofCoursesComboBox);	

	}

	private class _comboBoxHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			if (event.getSource()== _numboerofCoursesComboBox)
			{
				myPanel.removeAll();
				_createDynamicControls();
				myPanel.revalidate();
	
			}
			if (event.getSource()== _calculateButton)
			{
				_calculateGPA();
			}
		}
	}
	
	private void _createDynamicControls(){
		
		//for(int i=0; i <= num ; i++){
		for(int i=0; i <= _numboerofCoursesComboBox.getSelectedIndex() ; i++){
			labelSNOArrayList.add(new JLabel());
			labelSNOArrayList.get(i).setText(String.valueOf(i+1));
			labelSNOArrayList.get(i).setBounds(70, 180 + (i*30),100,25);
			add(labelSNOArrayList.get(i));

			
			
			textFieldArrayList.add(new JTextField());
			textFieldArrayList.get(i).setBounds(100, 180 + (i*30),100,25);
			add(textFieldArrayList.get(i));

			//creditHoursComboBox = new JComboBox(_numboerofCoursesArray);
			creditHoursComboBox.add(new JComboBox<String>(creditHoursArray));
			creditHoursComboBox.get(i).setSelectedIndex(0);
			creditHoursComboBox.get(i).setMaximumRowCount(5);
			creditHoursComboBox.get(i).setBounds(250, 180 + (i*30),100,25);
			add(creditHoursComboBox.get(i));	

			GradeComboBox.add(new JComboBox<String>(gradeArray));
			GradeComboBox.get(i).setSelectedIndex(0);
			GradeComboBox.get(i).setMaximumRowCount(5);
			GradeComboBox.get(i).setBounds(400, 180 + (i*30),100,25);
			add(GradeComboBox.get(i));	

		}

	}
	
	private void _calculateGPA(){
		double _credits=0.0;
		double _gpaInNumber=0.0;
		double _finalGPA=0.0;
		int total = 0;
		String test;
		for(int i=0; i <= 1 ; i++){
			//_finalGPA = Integer.parseInt((String) creditHoursComboBox.get(i).getSelectedItem());

			
			if (GradeComboBox.get(i).getSelectedItem() == "A+ 90-100"){
				_gpaInNumber = Double.valueOf(4.5);
			}else if (GradeComboBox.get(i).getSelectedItem() == "A 80-89"){
				_gpaInNumber = Double.valueOf(4.0);
			}else if (GradeComboBox.get(i).getSelectedItem() == "B+ 75-79"){
				_gpaInNumber = Double.valueOf(3.5);
			}else if (GradeComboBox.get(i).getSelectedItem() == "B 70-74"){
				_gpaInNumber = Double.valueOf(3.0);
			}else if (GradeComboBox.get(i).getSelectedItem() == "C+ 65-69"){
				_gpaInNumber = Double.valueOf(2.5);
			}else if (GradeComboBox.get(i).getSelectedItem() == "C 60-60"){
				_gpaInNumber = Double.valueOf(2.0);
			}else if (GradeComboBox.get(i).getSelectedItem() == "D+ 55-59"){
				_gpaInNumber = Double.valueOf(1.5);
			}else if (GradeComboBox.get(i).getSelectedItem() == "D 50-54"){
				_gpaInNumber = Double.valueOf(1.0);
			}else {
				_gpaInNumber = Double.valueOf(0.0);
			}
			
			_credits = Double.valueOf(creditHoursComboBox.get(i).getSelectedItem().toString());
			_finalGPA = _finalGPA + (_credits * _gpaInNumber) / _credits;
			
			//_finalGPA = _finalGPA * _credits;
			//_finalGPALabel.setText(_finalGPA);
			//test = GradeComboBox.get(i).getSelectedItem().toString();
			//_finalGPALabel.setText(test);
			total = i;
		}
		
		
		_finalGPA = _finalGPA/(total+1)+ Double.valueOf(_currentGPAField.getText());
		_finalGPALabel.setText(String.valueOf(_finalGPA/(total+1))); 
	}


}
