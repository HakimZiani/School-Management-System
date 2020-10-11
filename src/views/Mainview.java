package views;

import java.awt.BorderLayout;
import common.*;
import java.util.ArrayList;
import java.awt.EventQueue;
import java.awt.Window.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import java.awt.Rectangle;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;


import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JPasswordField;

import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.Point;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.Toolkit;



public class Mainview extends JFrame {

	private JPanel contentPane;
	private JButton btnExit;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JButton btnLogin;
	private JTextField txtIdNumber;
	private JButton btnFind;
	private JButton btnLogOut;
	private JButton btnNewButton_1;
	private JTextField txtTeacherIdNumber;
	private JButton btnAdd;
	private JButton btnFindTeacher;
	private JButton button_1;
	private JTextField teacherID;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JButton button_2;
	private JButton addTeacher;
	
	Connection myConn = null;
	Statement myStat = null;
	ResultSet myRes = null;
	Etudiant etud = null;
	Enseignant ens =null;
	private int xOffset = 0;
    private int yOffset = 0;
	private JPanel login;
	private JPanel home;
	private JPanel etudiant;
	private JPanel enseignant;
	private JPanel admin;
	private JPanel search;
	private JPanel studentshow;
	private JPanel teachersearch;
	private JPanel teachershow;
	private JPanel addteacher;
	private JLabel IDNumber_1;
	private JLabel Nom;
	private JLabel prenom;
	private JLabel datenaissance;
	private JLabel Address;
	private JLabel teacherIDNumber;
	private JLabel teacherNom;
	private JLabel teacherFirstName;
	private JButton button;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField NOM_ENS;
	private JTextField PRENOM_ENS;
	private JTextField MATRICULE_ENS;
	private JTextField textField_11;
	private JTextField LIBELLE;
	private JTextField CODE_UNITE_;
	private JTextField NBR_HEURES_;
	private JTextField MATRICULE_ENS_;
	private JTextField textField_17;
	private JTextField NOTE_TP;
	private JTextField NOTE_EXAMEN;
	private JTextField CODE_UNITE__;
	private JTextField NOTE_CC;
	private JTextField textField_22;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JButton button_15;
	private JButton button_14;
	private JButton button_13;
	private JPanel etudiantTable;
	private JPanel empty;
	private JPanel enseignantTable;
	private JPanel uniteTable;
	private JPanel panel;
	private JComboBox comboBox;
	private JPanel etudiantUniteTable;
	private JButton btnGo;
	private JButton button_4;
	private JButton button_3;
	private JButton button_8;
	private JButton button_12;
	private JButton btnDelete;
	private JButton btnAdd_1;
	private JButton button_6;
	private JButton button_10;
	private JButton button_7;
	private JButton button_11;
	private JButton btnUpdate;
	private JButton button_5;
	private JButton button_9;
	private JButton btnExecute;
	private JComboBox comboBox_1;
	private JTable table_4;
	private JButton button_16;
	private JPanel TP68;
	private JButton button_17;
	private JComboBox comboBox_2;
	private JButton button_18;
	private JLabel lblNewLabel_14;
	private JLabel lblStudentManegementSystem;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainview frame = new Mainview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mainview() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Mainview.class.getResource("/ressources/user (1).png")));

		initContents();
		createEvents();
		
	}
	//_____________________________________________________________________
	
	public ArrayList listStudent()
	{
		ArrayList<Etudiant> listStudent = new ArrayList<>();
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants","BDDAdmin","TPAdmin");
			myStat = myConn.createStatement();
			myRes= myStat.executeQuery("SELECT * FROM etudiant;");
			Etudiant etud;
			while(myRes.next())
			{
				etud = new Etudiant(myRes.getString("MATRICULE_ETU"),myRes.getString("PRENOM_ETU"),myRes.getString("NOM_ETU"),myRes.getString("DATE_NAISSANCE"),myRes.getString("ADRESSE"));
				listStudent.add(etud);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listStudent;
	}
	public void show_Students()
	{
		ArrayList<Etudiant> list = listStudent();
		DefaultTableModel model = (DefaultTableModel )table.getModel();
		for(int j=0;j<table.getRowCount();j++)
		{
			model.removeRow(j);
		}
		for(int j=0;j<table.getRowCount();j++)
		{
			model.removeRow(j);
		}
		for(int j=0;j<table.getRowCount();j++)
		{
			model.removeRow(j);
		}
		Object[] row = new Object[5];
		for(int i=0;i<list.size();i++)
		{
			row[0] = list.get(i).getMatricule();
			row[1] = list.get(i).getFName();
			row[2] = list.get(i).getLName();
			row[3] = list.get(i).getDateN();
			row[4] = list.get(i).getAdd();
			model.addRow(row);

		}
		table.setModel(model);
	}
	/////////////////////////////////////////////////////////////////////////////
	public ArrayList listTeachers()
	{
		ArrayList<Enseignant> listTeachers = new ArrayList<>();
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants","BDDAdmin","TPAdmin");
			myStat = myConn.createStatement();
			myRes= myStat.executeQuery("SELECT * FROM ENSEIGNANT;");
			Enseignant ens;
			while(myRes.next())
			{
				ens= new Enseignant(myRes.getString("MATRICULE_ENS"),myRes.getString("NOM_ENS"),myRes.getString("PRENOM_ENS"));
				listTeachers.add(ens);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listTeachers;
	}
	public void show_Teachers()
	{
		//table.setModel(new DefaultTableModel());
		ArrayList<Enseignant> list = listTeachers();
		DefaultTableModel model = (DefaultTableModel )table_1.getModel();
		for(int j=0;j<table_1.getRowCount();j++)
		{
			model.removeRow(j);
		}
		for(int j=0;j<table_1.getRowCount();j++)
		{
			model.removeRow(j);
		}
		for(int j=0;j<table_1.getRowCount();j++)
		{
			model.removeRow(j);
		}
		Object[] row = new Object[5];
		for(int i=0;i<list.size();i++)
		{
			row[0] = list.get(i).getMatricule();
			row[1] = list.get(i).getNom();
			row[2] = list.get(i).getPrenom();
			
			model.addRow(row);

		}
		table_1.setModel(model);
	}
	
	///////////////////////////////////////////////////////////////////////
	public ArrayList listUnits()
	{
		ArrayList<Unite> listUnits = new ArrayList<>();
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants","BDDAdmin","TPAdmin");
			myStat = myConn.createStatement();
			myRes= myStat.executeQuery("SELECT * FROM UNITE;");
			Unite un;
			while(myRes.next())
			{
				un= new Unite(myRes.getString("CODE_UNITE"),myRes.getString("MATRICULE_ENS"),myRes.getString("LIBELLE"),myRes.getString("NBR_HEURES"));
				listUnits.add(un);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUnits;
	}
	public void show_Units()
	{
		//table.setModel(new DefaultTableModel());
		ArrayList<Unite> list = listUnits();
		DefaultTableModel model = (DefaultTableModel )table_2.getModel();
		for(int j=0;j<table_2.getRowCount();j++)
		{
			model.removeRow(j);
		}
		for(int j=0;j<table_2.getRowCount();j++)
		{
			model.removeRow(j);
		}
		for(int j=0;j<table_2.getRowCount();j++)
		{
			model.removeRow(j);
		}
		Object[] row = new Object[5];
		for(int i=0;i<list.size();i++)
		{
			row[0] = list.get(i).getCode_Unite();
			row[1] = list.get(i).getMatricule_ens();
			row[2] = list.get(i).getLibelle();
			row[3] = list.get(i).getNbr_heures();

			model.addRow(row);

		}
		table_2.setModel(model);
	}
	///////////////////////////////////////////////////////////////////////
	public ArrayList listEtudiantUnits()
	{
		ArrayList<EtudiantUnite> listEtudiantUnits = new ArrayList<>();
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants","BDDAdmin","TPAdmin");
			myStat = myConn.createStatement();
			myRes= myStat.executeQuery("SELECT * FROM etudiantunite;");
			EtudiantUnite un;
			while(myRes.next())
			{
				un= new EtudiantUnite(myRes.getString("MATRICULE_ETU"),myRes.getString("CODE_UNITE"),myRes.getString("NOTE_CC"),myRes.getString("NOTE_TP"),myRes.getString("NOTE_EXAMEN"));
				listEtudiantUnits.add(un);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listEtudiantUnits;
	}
	public void show_EtudiantUnits()
	{
		//table.setModel(new DefaultTableModel());
		ArrayList<EtudiantUnite> list = listEtudiantUnits();
		DefaultTableModel model = (DefaultTableModel )table_3.getModel();
		for(int j=0;j<table_3.getRowCount();j++)
		{
			model.removeRow(j);
		}
		for(int j=0;j<table_3.getRowCount();j++)
		{
			model.removeRow(j);
		}
		for(int j=0;j<table_3.getRowCount();j++)
		{
			model.removeRow(j);
		}
		Object[] row = new Object[5];

		for(int i=0;i<list.size();i++)
		{
			row[0] = list.get(i).getMatricule_etu();
			row[1] = list.get(i).getCode_unite();
			row[2] = list.get(i).getNote_CC();
			row[3] = list.get(i).getNote_TP();
			row[4] = list.get(i).getNote_examen();

			model.addRow(row);

		}

		table_3.setModel(model);
	}
	
	
	
	//---------------------------------------------------------------------
	
	private void initContents() {
		setUndecorated(true);
		
		JPanel g1 = new JPanel();
		getContentPane().add(g1, BorderLayout.CENTER);
		g1.setLayout(null);
		
		JPanel header = new JPanel();
		
	////////////////////////////////////////////////////////////
		
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xOffset = e.getX();
				yOffset = e.getY();
			}
		});
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent evt) 
			{
				
				setLocation(evt.getXOnScreen()-xOffset,evt.getYOnScreen()-yOffset);
				
			}
		});
		
		
		
		///////////////////////////////////////////////////////
		
		
		
		
		header.setBounds(0, 0, 1006, 38);
		g1.add(header);
		header.setLayout(null);
		
		lblStudentManegementSystem = new JLabel("Student Manegement System - BDD");
		lblStudentManegementSystem.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblStudentManegementSystem.setBounds(45, -4, 317, 42);
		header.add(lblStudentManegementSystem);
		
		lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/user (3).png")));
		lblNewLabel_14.setBounds(12, 0, 32, 38);
		header.add(lblNewLabel_14);
		
		btnExit = new JButton("X");
		btnExit.setBorderPainted(false);
		btnExit.setBackground(SystemColor.inactiveCaptionText);

		btnExit.setFocusPainted(false);
		btnExit.setBorder(null);
		btnExit.setForeground(Color.LIGHT_GRAY);
		btnExit.setFont(new Font("Yu Gothic", Font.PLAIN, 22));
		btnExit.setBounds(949, 0, 57, 51);
		header.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("");
	
		lblNewLabel.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/background - Copy.jpg")));
		lblNewLabel.setBounds(0, 0, 1006, 38);
		header.add(lblNewLabel);
		
		JPanel body = new JPanel();
		body.setBackground(Color.LIGHT_GRAY);
		body.setBounds(0, 38, 1006, 634);
		g1.add(body);
		body.setLayout(new CardLayout(0, 0));
		
		home = new JPanel();
		body.add(home, "name_2709775737300");
		home.setLayout(new CardLayout(0, 0));
		
		JLabel backroundColor = new JLabel("");
		backroundColor.setBackground(SystemColor.inactiveCaptionText);
		backroundColor.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/background - Copy.jpg")));
		home.add(backroundColor, "name_34941445036899");
		
		etudiant = new JPanel();
		home.add(etudiant, "name_34945289704100");
		etudiant.setLayout(new CardLayout(0, 0));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/background - Copy.jpg")));
		label.setBackground(Color.BLACK);
		etudiant.add(label, "name_35466619825900");
		
		search = new JPanel();
		etudiant.add(search, "name_35470786678400");
		search.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Log Out ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_7.setBounds(38, 595, 72, 28);
		search.add(lblNewLabel_7);
		
		btnLogOut = new JButton("");

		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBorderPainted(false);
		btnLogOut.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/logout.png")));
		btnLogOut.setBounds(28, 514, 97, 109);
		search.add(btnLogOut);
		
		btnFind = new JButton("Find ");

		btnFind.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADFG.jpg")));
		btnFind.setIconTextGap(0);
		btnFind.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFind.setForeground(Color.WHITE);
		btnFind.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
		btnFind.setContentAreaFilled(false);
		btnFind.setBackground(SystemColor.windowBorder);
		btnFind.setBounds(350, 382, 339, 51);
		search.add(btnFind);
		
		txtIdNumber = new JTextField();
		txtIdNumber.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		txtIdNumber.setForeground(Color.GRAY);
		txtIdNumber.setText("Student ID Number ");
		txtIdNumber.setBounds(249, 295, 570, 51);
		search.add(txtIdNumber);
		txtIdNumber.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/search.png")));
		lblNewLabel_6.setBounds(433, 131, 216, 136);
		search.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("STUDENT SEARCH");
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD, 43));
		lblNewLabel_5.setBounds(341, 47, 446, 73);
		search.add(lblNewLabel_5);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/background - Copy.jpg")));
		label_1.setBackground(Color.BLACK);
		label_1.setBounds(0, 0, 1006, 634);
		search.add(label_1);
		
		studentshow = new JPanel();
		etudiant.add(studentshow, "name_35481410964500");
		studentshow.setLayout(null);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		lblAddress.setBounds(241, 413, 144, 28);
		studentshow.add(lblAddress);
		
		Address = new JLabel("ID NUMBER : ");
		Address.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		Address.setBounds(393, 413, 402, 28);
		studentshow.add(Address);
		
		JLabel lblNewLabel_10 = new JLabel("Return ");
		lblNewLabel_10.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(56, 598, 65, 25);
		studentshow.add(lblNewLabel_10);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/return.png")));
		btnNewButton_1.setBounds(21, 512, 115, 111);
		studentshow.add(btnNewButton_1);
		
		JLabel lblBirthday = new JLabel("BirthDay :");
		lblBirthday.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		lblBirthday.setBounds(241, 367, 144, 28);
		studentshow.add(lblBirthday);
		
		datenaissance = new JLabel("ID NUMBER : ");
		datenaissance.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		datenaissance.setBounds(393, 367, 402, 28);
		studentshow.add(datenaissance);
		
		prenom = new JLabel("ID NUMBER : ");
		prenom.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		prenom.setBounds(393, 325, 402, 28);
		studentshow.add(prenom);
		
		JLabel lblPrenom = new JLabel("First Name :");
		lblPrenom.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		lblPrenom.setBounds(241, 325, 144, 28);
		studentshow.add(lblPrenom);
		
		IDNumber_1 = new JLabel("ID NUMBER : ");
		IDNumber_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		IDNumber_1.setBounds(393, 240, 402, 28);
		studentshow.add(IDNumber_1);
		
		Nom = new JLabel("ID NUMBER : ");
		Nom.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		Nom.setBounds(393, 286, 402, 28);
		studentshow.add(Nom);
		
		JLabel lblNom = new JLabel("Last Name : ");
		lblNom.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		lblNom.setBounds(241, 286, 144, 28);
		studentshow.add(lblNom);
		
		JLabel lblNewLabel_9 = new JLabel("ID NUMBER : ");
		lblNewLabel_9.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		lblNewLabel_9.setBounds(241, 240, 144, 28);
		studentshow.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/dgfl.png")));
		lblNewLabel_8.setBounds(418, 26, 164, 149);
		studentshow.add(lblNewLabel_8);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/background - Copy.jpg")));
		label_2.setBackground(Color.BLACK);
		label_2.setBounds(0, 0, 1006, 634);
		studentshow.add(label_2);
		
		enseignant = new JPanel();
		home.add(enseignant, "name_34966336701700");
		enseignant.setLayout(new CardLayout(0, 0));
		
		teachersearch = new JPanel();
		teachersearch.setLayout(null);
		enseignant.add(teachersearch, "name_37639309555400");
		
		btnAdd = new JButton("ADD New ");
		
		btnAdd.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		btnAdd.setIconTextGap(0);
		btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBackground(SystemColor.windowBorder);
		btnAdd.setBounds(372, 447, 339, 51);
		teachersearch.add(btnAdd);
		
		JLabel label_3 = new JLabel("Log Out ");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_3.setBounds(38, 595, 72, 28);
		teachersearch.add(label_3);
		
		button = new JButton("");
	
		button.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/logout.png")));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(28, 514, 97, 109);
		teachersearch.add(button);
		
		btnFindTeacher = new JButton("Find ");
	
		btnFindTeacher.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		btnFindTeacher.setIconTextGap(0);
		btnFindTeacher.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFindTeacher.setForeground(Color.WHITE);
		btnFindTeacher.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
		btnFindTeacher.setContentAreaFilled(false);
		btnFindTeacher.setBackground(SystemColor.windowBorder);
		btnFindTeacher.setBounds(372, 376, 339, 51);
		teachersearch.add(btnFindTeacher);
		
		txtTeacherIdNumber = new JTextField();
		txtTeacherIdNumber.setText("Teacher ID Number ");
		txtTeacherIdNumber.setForeground(Color.GRAY);
		txtTeacherIdNumber.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		txtTeacherIdNumber.setColumns(10);
		txtTeacherIdNumber.setBounds(271, 289, 570, 51);
		teachersearch.add(txtTeacherIdNumber);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/search.png")));
		label_4.setBounds(455, 125, 216, 136);
		teachersearch.add(label_4);
		
		JLabel lblTeacherSearch = new JLabel("TEACHER SEARCH");
		lblTeacherSearch.setFont(new Font("Trebuchet MS", Font.BOLD, 43));
		lblTeacherSearch.setBounds(363, 41, 446, 73);
		teachersearch.add(lblTeacherSearch);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/background - Copy.jpg")));
		label_6.setBackground(Color.BLACK);
		label_6.setBounds(0, 0, 1006, 634);
		teachersearch.add(label_6);
		
		teachershow = new JPanel();
		teachershow.setLayout(null);
		enseignant.add(teachershow, "name_37928357381500");
		
		JLabel label_5 = new JLabel("Return ");
		label_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		label_5.setBounds(56, 598, 65, 25);
		teachershow.add(label_5);
		
		button_1 = new JButton("");
	
		button_1.setContentAreaFilled(false);
		button_1.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/return.png")));
		button_1.setBorderPainted(false);
		button_1.setBounds(21, 512, 115, 111);
		teachershow.add(button_1);
		
		teacherFirstName = new JLabel("ID NUMBER : ");
		teacherFirstName.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		teacherFirstName.setBounds(269, 308, 402, 28);
		teachershow.add(teacherFirstName);
		
		JLabel label_10 = new JLabel("First Name :");
		label_10.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		label_10.setBounds(117, 308, 144, 28);
		teachershow.add(label_10);
		
		teacherIDNumber = new JLabel("ID NUMBER : ");
		teacherIDNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		teacherIDNumber.setBounds(269, 223, 402, 28);
		teachershow.add(teacherIDNumber);
		
		teacherNom = new JLabel("ID NUMBER : ");
		teacherNom.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		teacherNom.setBounds(269, 269, 402, 28);
		teachershow.add(teacherNom);
		
		JLabel label_13 = new JLabel("Last Name : ");
		label_13.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		label_13.setBounds(117, 269, 144, 28);
		teachershow.add(label_13);
		
		JLabel label_14 = new JLabel("ID NUMBER : ");
		label_14.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		label_14.setBounds(117, 223, 144, 28);
		teachershow.add(label_14);
		
		JLabel label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/dgfl.png")));
		label_15.setBounds(418, 26, 164, 149);
		teachershow.add(label_15);
		
		JLabel label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/background - Copy.jpg")));
		label_16.setBackground(Color.BLACK);
		label_16.setBounds(0, 0, 1006, 634);
		teachershow.add(label_16);
		
		addteacher = new JPanel();
		enseignant.add(addteacher, "name_38096624256000");
		addteacher.setLayout(null);
		
		addTeacher = new JButton("ADD");
	
		addTeacher.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		addTeacher.setIconTextGap(0);
		addTeacher.setHorizontalTextPosition(SwingConstants.CENTER);
		addTeacher.setForeground(Color.WHITE);
		addTeacher.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
		addTeacher.setContentAreaFilled(false);
		addTeacher.setBackground(SystemColor.windowBorder);
		addTeacher.setBounds(475, 431, 339, 51);
		addteacher.add(addTeacher);
		
		JLabel label_8 = new JLabel("Return ");
		label_8.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		label_8.setBounds(58, 598, 65, 25);
		addteacher.add(label_8);
		
		button_2 = new JButton("");
		
		button_2.setOpaque(false);
		button_2.setContentAreaFilled(false);
		button_2.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/return.png")));
		button_2.setBorderPainted(false);
		button_2.setBounds(23, 512, 115, 111);
		addteacher.add(button_2);
		
		txtLastName = new JTextField();
		txtLastName.setText("  Last Name");
		txtLastName.setForeground(Color.GRAY);
		txtLastName.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		txtLastName.setColumns(10);
		txtLastName.setBorder(null);
		txtLastName.setBounds(233, 354, 581, 47);
		addteacher.add(txtLastName);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("  First Name ");
		txtFirstName.setForeground(Color.GRAY);
		txtFirstName.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		txtFirstName.setColumns(10);
		txtFirstName.setBorder(null);
		txtFirstName.setBounds(233, 283, 581, 47);
		addteacher.add(txtFirstName);
		
		teacherID = new JTextField();
		teacherID.setBorder(null);
		teacherID.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		teacherID.setForeground(Color.GRAY);
		teacherID.setText("  Teacher ID Number ");
		teacherID.setBounds(233, 214, 581, 47);
		addteacher.add(teacherID);
		teacherID.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/add (1).png")));
		lblNewLabel_11.setBounds(437, 29, 169, 165);
		addteacher.add(lblNewLabel_11);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/background - Copy.jpg")));
		label_7.setBackground(Color.BLACK);
		label_7.setBounds(0, 0, 1006, 634);
		addteacher.add(label_7);
		
		admin = new JPanel();
		home.add(admin, "name_34978572667400");
		admin.setLayout(null);
		
		JLabel lblTp = new JLabel("TP 6,8");
		lblTp.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblTp.setBounds(799, 106, 72, 28);
		admin.add(lblTp);
		
		button_16 = new JButton("");
	
		button_16.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/monitor.png")));
		button_16.setContentAreaFilled(false);
		button_16.setBorderPainted(false);
		button_16.setBounds(784, 12, 87, 107);
		admin.add(button_16);
		
		btnGo = new JButton("GO");
		btnGo.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
	
		btnGo.setIconTextGap(0);
		btnGo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGo.setForeground(Color.WHITE);
		btnGo.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btnGo.setContentAreaFilled(false);
		btnGo.setBackground(SystemColor.windowBorder);
		btnGo.setBounds(467, 107, 64, 28);
		admin.add(btnGo);
		
		button_4 = new JButton("");
	
		button_4.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/logout.png")));
		button_4.setContentAreaFilled(false);
		button_4.setBorderPainted(false);
		button_4.setBounds(907, 12, 87, 107);
		admin.add(button_4);
		
		JLabel label_19 = new JLabel("Log Out ");
		label_19.setIcon(null);
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_19.setBounds(917, 105, 72, 28);
		admin.add(label_19);
		
		panel = new JPanel();
		panel.setBounds(0, 156, 1006, 478);
		admin.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		etudiantTable = new JPanel();
		panel.add(etudiantTable, "name_30127598085600");
		etudiantTable.setLayout(null);
		
		btnUpdate = new JButton("UPDATE");
		
		btnUpdate.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		btnUpdate.setIconTextGap(0);
		btnUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBackground(SystemColor.windowBorder);
		btnUpdate.setBounds(145, 414, 129, 30);
		etudiantTable.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
	
		btnDelete.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		btnDelete.setIconTextGap(0);
		btnDelete.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBackground(SystemColor.windowBorder);
		btnDelete.setBounds(215, 372, 114, 30);
		etudiantTable.add(btnDelete);
		
		btnAdd_1 = new JButton("ADD");
		
		btnAdd_1.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		btnAdd_1.setIconTextGap(0);
		btnAdd_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdd_1.setForeground(Color.WHITE);
		btnAdd_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btnAdd_1.setContentAreaFilled(false);
		btnAdd_1.setBackground(SystemColor.windowBorder);
		btnAdd_1.setBounds(89, 372, 114, 30);
		etudiantTable.add(btnAdd_1);
		
		JLabel MATRICULE_ETU = new JLabel("MATRICULE_ETU");
		MATRICULE_ETU.setBounds(40, 158, 114, 16);
		etudiantTable.add(MATRICULE_ETU);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBounds(160, 276, 114, 20);
		etudiantTable.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBounds(117, 321, 114, 20);
		etudiantTable.add(textField_5);
		
		JLabel lblDatenaissance = new JLabel("DATE_NAISSANCE");
		lblDatenaissance.setBounds(40, 278, 114, 16);
		etudiantTable.add(lblDatenaissance);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBounds(117, 195, 114, 20);
		etudiantTable.add(textField_2);
		
		JLabel lblAdresse = new JLabel("ADRESSE");
		lblAdresse.setBounds(40, 323, 72, 16);
		etudiantTable.add(lblAdresse);
		
		JLabel PRENOM_ETU = new JLabel("PRENOM_ETU");
		PRENOM_ETU.setBounds(40, 237, 92, 16);
		etudiantTable.add(PRENOM_ETU);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBounds(145, 235, 114, 20);
		etudiantTable.add(textField_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBounds(145, 156, 114, 20);
		etudiantTable.add(textField_1);
		
		JLabel NOM_ETU = new JLabel("NOM_ETU");
		NOM_ETU.setBounds(40, 197, 72, 16);
		etudiantTable.add(NOM_ETU);
		
		button_3 = new JButton("Find ");
	
		button_3.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		button_3.setIconTextGap(0);
		button_3.setHorizontalTextPosition(SwingConstants.CENTER);
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		button_3.setContentAreaFilled(false);
		button_3.setBackground(SystemColor.windowBorder);
		button_3.setBounds(223, 78, 86, 20);
		etudiantTable.add(button_3);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setBounds(89, 77, 114, 20);
		etudiantTable.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Student ID :");
		lblNewLabel_12.setBounds(12, 79, 72, 16);
		etudiantTable.add(lblNewLabel_12);
		
		JLabel lblEditTable = new JLabel("Edit Table :");
		lblEditTable.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblEditTable.setBounds(12, 12, 120, 42);
		etudiantTable.add(lblEditTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(405, 59, 589, 407);
		etudiantTable.add(scrollPane);
		
		table = new JTable();
	
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matricule_ETU", "NOM_ETU", "PRENOM_ETU", "DATE_NAISSANCE", "ADRESSE"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(118);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(88);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(99);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(121);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(111);
		scrollPane.setViewportView(table);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/background - Copy.jpg")));
		label_11.setBackground(Color.BLACK);
		label_11.setBounds(0, 0, 1006, 634);
		etudiantTable.add(label_11);
		
		empty = new JPanel();
		empty.setLayout(null);
		panel.add(empty, "name_103437451214400");
		
		JLabel label_12 = new JLabel("EMPTY");
		label_12.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/directory.png")));
		label_12.setFont(new Font("Dialog", Font.BOLD, 23));
		label_12.setBounds(407, 160, 134, 118);
		empty.add(label_12);
		
		JLabel lblNewLabel_13 = new JLabel("No Table Set!");
		lblNewLabel_13.setFont(new Font("Dialog", Font.BOLD, 23));
		lblNewLabel_13.setBounds(402, 246, 183, 90);
		empty.add(lblNewLabel_13);
		
		JLabel label_28 = new JLabel("");
		label_28.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/background - Copy.jpg")));
		label_28.setBackground(Color.BLACK);
		label_28.setBounds(0, 0, 1006, 634);
		empty.add(label_28);
		
		enseignantTable = new JPanel();
		enseignantTable.setLayout(null);
		panel.add(enseignantTable, "name_103636024531700");
		
		button_5 = new JButton("UPDATE");
		button_5.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		button_5.setIconTextGap(0);
		button_5.setHorizontalTextPosition(SwingConstants.CENTER);
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		button_5.setContentAreaFilled(false);
		button_5.setBackground(SystemColor.windowBorder);
		button_5.setBounds(145, 414, 129, 30);
		enseignantTable.add(button_5);
		
		button_6 = new JButton("DELETE");
		button_6.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		button_6.setIconTextGap(0);
		button_6.setHorizontalTextPosition(SwingConstants.CENTER);
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		button_6.setContentAreaFilled(false);
		button_6.setBackground(SystemColor.windowBorder);
		button_6.setBounds(215, 372, 114, 30);
		enseignantTable.add(button_6);
		
		button_7 = new JButton("ADD");
		button_7.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		button_7.setIconTextGap(0);
		button_7.setHorizontalTextPosition(SwingConstants.CENTER);
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		button_7.setContentAreaFilled(false);
		button_7.setBackground(SystemColor.windowBorder);
		button_7.setBounds(89, 372, 114, 30);
		enseignantTable.add(button_7);
		
		JLabel lblMatriculeens = new JLabel("MATRICULE_ENS");
		lblMatriculeens.setBounds(40, 158, 114, 16);
		enseignantTable.add(lblMatriculeens);
		
		NOM_ENS = new JTextField();
		NOM_ENS.setColumns(10);
		NOM_ENS.setBorder(null);
		NOM_ENS.setBounds(117, 195, 114, 20);
		enseignantTable.add(NOM_ENS);
		
		JLabel lblPrenomens = new JLabel("PRENOM_ENS");
		lblPrenomens.setBounds(40, 237, 92, 16);
		enseignantTable.add(lblPrenomens);
		
		PRENOM_ENS = new JTextField();
		PRENOM_ENS.setColumns(10);
		PRENOM_ENS.setBorder(null);
		PRENOM_ENS.setBounds(145, 235, 114, 20);
		enseignantTable.add(PRENOM_ENS);
		
		MATRICULE_ENS = new JTextField();
		MATRICULE_ENS.setColumns(10);
		MATRICULE_ENS.setBorder(null);
		MATRICULE_ENS.setBounds(145, 156, 114, 20);
		enseignantTable.add(MATRICULE_ENS);
		
		JLabel lblNomens = new JLabel("NOM_ENS");
		lblNomens.setBounds(40, 197, 72, 16);
		enseignantTable.add(lblNomens);
		
		button_8 = new JButton("Find ");
		button_8.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		button_8.setIconTextGap(0);
		button_8.setHorizontalTextPosition(SwingConstants.CENTER);
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		button_8.setContentAreaFilled(false);
		button_8.setBackground(SystemColor.windowBorder);
		button_8.setBounds(223, 78, 86, 20);
		enseignantTable.add(button_8);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBorder(null);
		textField_11.setBounds(89, 77, 114, 20);
		enseignantTable.add(textField_11);
		
		JLabel lblTeacherId = new JLabel(" Teacher ID :");
		lblTeacherId.setBounds(12, 79, 72, 16);
		enseignantTable.add(lblTeacherId);
		
		JLabel label_23 = new JLabel("Edit Table :");
		label_23.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label_23.setBounds(12, 12, 120, 42);
		enseignantTable.add(label_23);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(405, 59, 589, 407);
		enseignantTable.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"MATRICULE_ENS", "NOM_ENS", "PRENOM_ENS"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		scrollPane_1.setViewportView(table_1);
		
		JLabel label_24 = new JLabel("");
		label_24.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/background - Copy.jpg")));
		label_24.setBackground(Color.BLACK);
		label_24.setBounds(0, 0, 1006, 634);
		enseignantTable.add(label_24);
		
		uniteTable = new JPanel();
		uniteTable.setLayout(null);
		panel.add(uniteTable, "name_103647430273300");
		
		button_9 = new JButton("UPDATE");
		button_9.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		button_9.setIconTextGap(0);
		button_9.setHorizontalTextPosition(SwingConstants.CENTER);
		button_9.setForeground(Color.WHITE);
		button_9.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		button_9.setContentAreaFilled(false);
		button_9.setBackground(SystemColor.windowBorder);
		button_9.setBounds(145, 414, 129, 30);
		uniteTable.add(button_9);
		
		button_10 = new JButton("DELETE");
		button_10.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		button_10.setIconTextGap(0);
		button_10.setHorizontalTextPosition(SwingConstants.CENTER);
		button_10.setForeground(Color.WHITE);
		button_10.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		button_10.setContentAreaFilled(false);
		button_10.setBackground(SystemColor.windowBorder);
		button_10.setBounds(215, 372, 114, 30);
		uniteTable.add(button_10);
		
		button_11 = new JButton("ADD");
		button_11.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		button_11.setIconTextGap(0);
		button_11.setHorizontalTextPosition(SwingConstants.CENTER);
		button_11.setForeground(Color.WHITE);
		button_11.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		button_11.setContentAreaFilled(false);
		button_11.setBackground(SystemColor.windowBorder);
		button_11.setBounds(89, 372, 114, 30);
		uniteTable.add(button_11);
		
		JLabel lblMatriculeens_1 = new JLabel("MATRICULE_ENS");
		lblMatriculeens_1.setBounds(40, 158, 114, 16);
		uniteTable.add(lblMatriculeens_1);
		
		LIBELLE = new JTextField();
		LIBELLE.setColumns(10);
		LIBELLE.setBorder(null);
		LIBELLE.setBounds(160, 276, 114, 20);
		uniteTable.add(LIBELLE);
		
		JLabel lblLibelle = new JLabel("LIBELLE");
		lblLibelle.setBounds(40, 278, 114, 16);
		uniteTable.add(lblLibelle);
		
		CODE_UNITE_ = new JTextField();
		CODE_UNITE_.setColumns(10);
		CODE_UNITE_.setBorder(null);
		CODE_UNITE_.setBounds(117, 195, 114, 20);
		uniteTable.add(CODE_UNITE_);
		
		JLabel lblNbrheures = new JLabel("NBR_HEURES");
		lblNbrheures.setBounds(40, 237, 92, 16);
		uniteTable.add(lblNbrheures);
		
		NBR_HEURES_ = new JTextField();
		NBR_HEURES_.setColumns(10);
		NBR_HEURES_.setBorder(null);
		NBR_HEURES_.setBounds(145, 235, 114, 20);
		uniteTable.add(NBR_HEURES_);
		
		MATRICULE_ENS_ = new JTextField();
		MATRICULE_ENS_.setColumns(10);
		MATRICULE_ENS_.setBorder(null);
		MATRICULE_ENS_.setBounds(145, 156, 114, 20);
		uniteTable.add(MATRICULE_ENS_);
		
		JLabel lblCodeunite = new JLabel("CODE_UNITE");
		lblCodeunite.setBounds(40, 197, 72, 16);
		uniteTable.add(lblCodeunite);
		
		button_12 = new JButton("Find ");
		
		button_12.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		button_12.setIconTextGap(0);
		button_12.setHorizontalTextPosition(SwingConstants.CENTER);
		button_12.setForeground(Color.WHITE);
		button_12.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		button_12.setContentAreaFilled(false);
		button_12.setBackground(SystemColor.windowBorder);
		button_12.setBounds(223, 78, 86, 20);
		uniteTable.add(button_12);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBorder(null);
		textField_17.setBounds(89, 77, 114, 20);
		uniteTable.add(textField_17);
		
		JLabel lblCodeUnite = new JLabel("Code Unite :");
		lblCodeUnite.setBounds(12, 79, 72, 16);
		uniteTable.add(lblCodeUnite);
		
		JLabel label_32 = new JLabel("Edit Table :");
		label_32.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label_32.setBounds(12, 12, 120, 42);
		uniteTable.add(label_32);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(405, 59, 589, 407);
		uniteTable.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"CODE_UNITE", "NBR_HEUERES", "MATRICULE_ENS", "LIBELLE"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_2.getColumnModel().getColumn(0).setResizable(false);
		table_2.getColumnModel().getColumn(1).setResizable(false);
		table_2.getColumnModel().getColumn(2).setResizable(false);
		table_2.getColumnModel().getColumn(3).setResizable(false);
		scrollPane_2.setViewportView(table_2);
		
		JLabel label_33 = new JLabel("");
		label_33.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/background - Copy.jpg")));
		label_33.setBackground(Color.BLACK);
		label_33.setBounds(0, 0, 1006, 634);
		uniteTable.add(label_33);
		
		etudiantUniteTable = new JPanel();
		etudiantUniteTable.setLayout(null);
		panel.add(etudiantUniteTable, "name_103656980545100");
		
		button_13 = new JButton("UPDATE");
		button_13.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		button_13.setIconTextGap(0);
		button_13.setHorizontalTextPosition(SwingConstants.CENTER);
		button_13.setForeground(Color.WHITE);
		button_13.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		button_13.setContentAreaFilled(false);
		button_13.setBackground(SystemColor.windowBorder);
		button_13.setBounds(145, 414, 129, 30);
		etudiantUniteTable.add(button_13);
		
		button_14 = new JButton("DELETE");
		button_14.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		button_14.setIconTextGap(0);
		button_14.setHorizontalTextPosition(SwingConstants.CENTER);
		button_14.setForeground(Color.WHITE);
		button_14.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		button_14.setContentAreaFilled(false);
		button_14.setBackground(SystemColor.windowBorder);
		button_14.setBounds(215, 372, 114, 30);
		etudiantUniteTable.add(button_14);
		
		button_15 = new JButton("ADD");
		button_15.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		button_15.setIconTextGap(0);
		button_15.setHorizontalTextPosition(SwingConstants.CENTER);
		button_15.setForeground(Color.WHITE);
		button_15.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		button_15.setContentAreaFilled(false);
		button_15.setBackground(SystemColor.windowBorder);
		button_15.setBounds(89, 372, 114, 30);
		etudiantUniteTable.add(button_15);
		
		JLabel label_34 = new JLabel("MATRICULE_ETU");
		label_34.setBounds(40, 158, 114, 16);
		etudiantUniteTable.add(label_34);
		
		NOTE_TP = new JTextField();
		NOTE_TP.setColumns(10);
		NOTE_TP.setBorder(null);
		NOTE_TP.setBounds(160, 276, 114, 20);
		etudiantUniteTable.add(NOTE_TP);
		
		NOTE_EXAMEN = new JTextField();
		NOTE_EXAMEN.setColumns(10);
		NOTE_EXAMEN.setBorder(null);
		NOTE_EXAMEN.setBounds(160, 321, 114, 20);
		etudiantUniteTable.add(NOTE_EXAMEN);
		
		JLabel lblNotetp = new JLabel("NOTE_TP");
		lblNotetp.setBounds(40, 278, 114, 16);
		etudiantUniteTable.add(lblNotetp);
		
		CODE_UNITE__ = new JTextField();
		CODE_UNITE__.setColumns(10);
		CODE_UNITE__.setBorder(null);
		CODE_UNITE__.setBounds(117, 195, 114, 20);
		etudiantUniteTable.add(CODE_UNITE__);
		
		JLabel lblNoteexamen = new JLabel("NOTE_EXAMEN");
		lblNoteexamen.setBounds(40, 323, 102, 16);
		etudiantUniteTable.add(lblNoteexamen);
		
		JLabel lblNotec = new JLabel("NOTE_CC");
		lblNotec.setBounds(40, 237, 92, 16);
		etudiantUniteTable.add(lblNotec);
		
		NOTE_CC = new JTextField();
		NOTE_CC.setColumns(10);
		NOTE_CC.setBorder(null);
		NOTE_CC.setBounds(145, 235, 114, 20);
		etudiantUniteTable.add(NOTE_CC);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBorder(null);
		textField_22.setBounds(145, 156, 114, 20);
		etudiantUniteTable.add(textField_22);
		
		JLabel lblCodeunite_1 = new JLabel("CODE_UNITE");
		lblCodeunite_1.setBounds(40, 197, 72, 16);
		etudiantUniteTable.add(lblCodeunite_1);
		
		JLabel label_40 = new JLabel("Edit Table :");
		label_40.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label_40.setBounds(12, 12, 120, 42);
		etudiantUniteTable.add(label_40);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(405, 59, 589, 407);
		etudiantUniteTable.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"MATRICULE_ETU", "CODE_UNITE", "NOTE_CC", "NOTE_TP", "NOTE_EXAMEN"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_3.getColumnModel().getColumn(0).setResizable(false);
		table_3.getColumnModel().getColumn(1).setResizable(false);
		table_3.getColumnModel().getColumn(2).setResizable(false);
		table_3.getColumnModel().getColumn(3).setResizable(false);
		table_3.getColumnModel().getColumn(4).setResizable(false);
		scrollPane_3.setViewportView(table_3);
		
		JLabel label_41 = new JLabel("");
		label_41.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/background - Copy.jpg")));
		label_41.setBackground(Color.BLACK);
		label_41.setBounds(0, 0, 1006, 634);
		etudiantUniteTable.add(label_41);
		
		TP68 = new JPanel();
		panel.add(TP68, "name_2879309646300");
		TP68.setLayout(null);
		
		JLabel lblReturn = new JLabel("Return ");
		lblReturn.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblReturn.setBounds(27, 450, 72, 28);
		TP68.add(lblReturn);
		
		button_18 = new JButton("");
		
		button_18.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/return.png")));
		button_18.setContentAreaFilled(false);
		button_18.setBorderPainted(false);
		button_18.setBounds(12, 356, 87, 122);
		TP68.add(button_18);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "Creer la vue V_ETUDIANT_LISTE qui contient le nom et le prenom des etudiants"}));
		comboBox_2.setBounds(29, 52, 812, 25);
		TP68.add(comboBox_2);
		
		button_17 = new JButton("Execute");
	
		button_17.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		button_17.setIconTextGap(0);
		button_17.setHorizontalTextPosition(SwingConstants.CENTER);
		button_17.setForeground(Color.WHITE);
		button_17.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		button_17.setContentAreaFilled(false);
		button_17.setBackground(SystemColor.windowBorder);
		button_17.setBounds(853, 51, 100, 28);
		TP68.add(button_17);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(111, 144, 801, 322);
		TP68.add(scrollPane_4);
		
		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"-", "-", "-", "-"
			}
		));
		scrollPane_4.setViewportView(table_4);
		
		btnExecute = new JButton("Execute");
		
		btnExecute.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		btnExecute.setIconTextGap(0);
		btnExecute.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExecute.setForeground(Color.WHITE);
		btnExecute.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btnExecute.setContentAreaFilled(false);
		btnExecute.setBackground(SystemColor.windowBorder);
		btnExecute.setBounds(853, 11, 100, 28);
		TP68.add(btnExecute);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "Afficher les noms et prénoms des étudiants ayant obtenus des notes d'examens égales à 20.", "Afficher les noms et prénoms des étudiants qui ne sont pas inscrits dans l'unité « POO ».", "Afficher les libellés des unités d'enseignement dont aucun étudiant n'est inscrit.", "Afficher pour chaque étudiant, son nom, son prénom sa moyenne par unité d'enseignement ainsi que le libellé de l'unité."}));
		comboBox_1.setBounds(29, 12, 812, 25);
		TP68.add(comboBox_1);
		
		JLabel label_17 = new JLabel("");
		label_17.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/background - Copy.jpg")));
		label_17.setBackground(Color.BLACK);
		label_17.setBounds(0, 0, 1006, 634);
		TP68.add(label_17);
		
		JLabel lblSelectTableTo = new JLabel("Select table to work with : ");
		lblSelectTableTo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblSelectTableTo.setBounds(12, 97, 270, 42);
		admin.add(lblSelectTableTo);
		
		comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {" ", " ETUDIANT", " ENSEIGNANT", " UNITE", " ETUDIANTUNITE"}));
		comboBox.setBounds(275, 108, 171, 25);
		admin.add(comboBox);
		
		
		JLabel lblAdminPanel = new JLabel("ADMIN PANEL ");
		lblAdminPanel.setFont(new Font("Trebuchet MS", Font.BOLD, 43));
		lblAdminPanel.setBounds(12, 12, 292, 73);
		admin.add(lblAdminPanel);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/background - Copy.jpg")));
		label_9.setBackground(Color.BLACK);
		label_9.setBounds(0, 0, 1006, 634);
		admin.add(label_9);
		
		login = new JPanel();
		body.add(login, "name_31290400576000");
		login.setLayout(null);
		
		btnLogin = new JButton("LOGIN");
	
		
		JLabel lblNewLabel_4 = new JLabel("BDD Poject - Student Management System Made BY Hakim Ziani & Ihab Khelifa");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(297, 554, 451, 14);
		login.add(lblNewLabel_4);
		
		btnNewButton = new JButton("Forgot Password?");
		btnNewButton.setContentAreaFilled(false);
		
		btnNewButton.setFont(new Font("Segoe UI Symbol", Font.ITALIC, 13));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(603, 472, 145, 23);
		login.add(btnNewButton);
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogin.setIconTextGap(0);
		btnLogin.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/ADF.jpg")));
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBackground(SystemColor.windowBorder);
		btnLogin.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(271, 377, 499, 51);
		
		login.add(btnLogin);
		
		pwdPassword = new JPasswordField();
	
		pwdPassword.setForeground(SystemColor.windowBorder);
		pwdPassword.setBorder(null);
		pwdPassword.setText("passwrodhere ");
		pwdPassword.setBounds(271, 315, 499, 51);
		login.add(pwdPassword);
		
		txtUsername = new JTextField();
	
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsername.setBorder(null);
		txtUsername.setForeground(SystemColor.windowBorder);
		txtUsername.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		txtUsername.setText("Username");
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setBounds(271, 242, 499, 51);
		login.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/user (1).png")));
		lblNewLabel_3.setBounds(442, 57, 145, 136);
		login.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(SystemColor.controlShadow);
		lblNewLabel_2.setBounds(new Rectangle(4, 250, 0, 500));
		lblNewLabel_2.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		lblNewLabel_2.setBounds(215, 129, 590, 413);
		login.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("UTILISATEUR");
		lblNewLabel_1.setForeground(SystemColor.windowBorder);
		lblNewLabel_1.setBorder(null);
		lblNewLabel_1.setIcon(new ImageIcon(Mainview.class.getResource("/ressources/background - Copy.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1006, 634);
		login.add(lblNewLabel_1);
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1006, 672);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		home.setVisible(false);
		login.setVisible(true);
		
		
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Please contact the administrator at Hakimziani92@yahoo.fr");
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UserName = txtUsername.getText();
				String Password = pwdPassword.getText();
				txtUsername.setText("");
				pwdPassword.setText("");
				try {
					myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants",UserName,Password);
					
					//Correct UserName and Password :
					
					if(UserName.equals("BDDAdmin"))
					{
						login.setVisible(false);
						home.removeAll();
						home.add(admin);
						home.repaint();
						home.revalidate();
						admin.setVisible(true);
						panel.setVisible(true);
						panel.removeAll();
						panel.add(empty);
						panel.repaint();
						panel.revalidate();
						empty.setVisible(true);
						
						
					}
					else if(UserName.toUpperCase().equals("ENSEIGNANT"))
					{
						login.setVisible(false);
						home.removeAll();
						home.add(teachersearch);
						home.repaint();
						home.revalidate();
						teachersearch.setVisible(true);
					}
					else if (UserName.toUpperCase().equals("ETUDIANT")) {
						login.setVisible(false);
						home.removeAll();
						home.add(search);
						home.repaint();
						home.revalidate();
						search.setVisible(true);
					}
					else {JOptionPane.showMessageDialog(null,"ERROR: Wrong UserName or Password.");
}
										
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
					JOptionPane.showMessageDialog(null,"Cannot Connect to DataBase, Wrong UserName or Password.");
				}
				
			}
		});
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.setVisible(false);
				login.setVisible(true);
			}
		});
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IDNumber = txtIdNumber.getText();
				try {
					myStat = myConn.createStatement();
					String myQuery = "SELECT * FROM ETUDIANT "
							+ "WHERE MATRICULE_ETU = "+IDNumber+";";
					myRes = myStat.executeQuery(myQuery);
					while(myRes.next())
					{
						etud = new Etudiant(myRes.getString("MATRICULE_ETU"),myRes.getString("PRENOM_ETU"),
								myRes.getString("NOM_ETU"),myRes.getString("DATE_NAISSANCE"),
								myRes.getString("ADRESSE"));
					}
					IDNumber_1.setText(etud.getMatricule());
					Nom.setText(etud.getLName());
					prenom.setText(etud.getFName());
					datenaissance.setText(etud.getDateN());
					Address.setText(etud.getAdd());
					
					search.setVisible(false);
					home.removeAll();
					home.add(studentshow);
					home.repaint();
					home.revalidate();
					studentshow.setVisible(true);
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

					JOptionPane.showMessageDialog(null,"Student Not Found.");
				}
				
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentshow.setVisible(false);
				home.removeAll();
				home.add(search);
				home.repaint();
				home.revalidate();
				search.setVisible(true);
			}
		});
		btnFindTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IDNumber = txtTeacherIdNumber.getText();
				try {
					myStat = myConn.createStatement();
					String myQuery = "SELECT * FROM ENSEIGNANT "
							+ "WHERE MATRICULE_ENS = "+IDNumber+";";
					myRes = myStat.executeQuery(myQuery);
					while(myRes.next())
					{	
						ens = new Enseignant(myRes.getString("MATRICULE_Ens"),myRes.getString("NOM_ENS"),
								myRes.getString("PRENOM_ENS"));
					}
					
					teacherIDNumber.setText(ens.getMatricule());
					teacherNom.setText(ens.getNom());
					teacherFirstName.setText(ens.getPrenom());
				
					
					teachersearch.setVisible(false);
					home.removeAll();
					home.add(teachershow);
					home.repaint();
					home.revalidate();
					teachershow.setVisible(true);
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

					JOptionPane.showMessageDialog(null,"Teacher Not Found.");
				}
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teachershow.setVisible(false);
				home.removeAll();
				home.add(teachersearch);
				home.repaint();
				home.revalidate();
				teachersearch.setVisible(true);
				
			}
		});
		
		
		addTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String teacherIDN = teacherID.getText();
				String firstName = txtFirstName.getText();
				String lastName = txtLastName.getText();
				//ens = new Enseignant(teacherIDN,firstName,lastName);
				String Query = "INSERT INTO ENSEIGNANT(MATRICULE_ENS,NOM_ENS,PRENOM_ENS)"
						+ "VALUES('"+teacherIDN+"','"+firstName+"','"+lastName+"');";
				try {
					myStat =myConn.createStatement();
					myStat.executeUpdate(Query);
					JOptionPane.showMessageDialog(null,"Teacher Added Successfully.");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"Cannot Add Teacher ");

				}
				
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addteacher.setVisible(false);
				home.removeAll();
				home.add(teachersearch);
				home.repaint();
				home.revalidate();
				teachersearch.setVisible(true);
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teachersearch.setVisible(false);
				home.removeAll();
				home.add(addteacher);
				home.repaint();
				home.revalidate();
				addteacher.setVisible(true);
			}
		});
			button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teachersearch.setVisible(false);
				home.removeAll();
				home.setVisible(false);
				login.setVisible(true);
			}
		});
			txtUsername.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txtUsername.setText("");
				}
			});
			pwdPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					pwdPassword.setText("");
				}
			});
			btnGo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int tableID = comboBox.getSelectedIndex();
					if(tableID==1)
					{
						panel.removeAll();
						panel.add(etudiantTable);
						panel.repaint();
						panel.revalidate();
						etudiantTable.setVisible(true);
						show_Students();
					}
					else if (tableID==2)
					{
						panel.removeAll();
						panel.add(enseignantTable);
						panel.repaint();
						panel.revalidate();
						enseignantTable.setVisible(true);
						show_Teachers();
					}
					else if (tableID==3)
					{
						panel.removeAll();
						panel.add(uniteTable);
						panel.repaint();
						panel.revalidate();
						uniteTable.setVisible(true);
						show_Units();
					}
					else if (tableID==4)
					{
						panel.removeAll();
						panel.add(etudiantUniteTable);
						panel.repaint();
						panel.revalidate();
						etudiantUniteTable.setVisible(true);
						show_EtudiantUnits();
					}
				
				}
			});
			button_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					home.setVisible(false);
					login.setVisible(true);
				}
			});
			
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int rowid =table.getSelectedRow();
					ArrayList<Etudiant> listS = listStudent();
					textField_1.setText(listS.get(rowid).getMatricule());
					textField_2.setText(listS.get(rowid).getLName());
					textField_3.setText(listS.get(rowid).getFName());
					textField_4.setText(listS.get(rowid).getDateN());
					textField_5.setText(listS.get(rowid).getAdd());				
				}
			});
			table_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int rowid =table_1.getSelectedRow();
					ArrayList<Enseignant> listS = listTeachers();
					MATRICULE_ENS.setText(listS.get(rowid).getMatricule());
					NOM_ENS.setText(listS.get(rowid).getNom());
					PRENOM_ENS.setText(listS.get(rowid).getPrenom());
							
				}
			});
			table_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int rowid =table_2.getSelectedRow();
					ArrayList<Unite> listS = listUnits();
					MATRICULE_ENS_.setText(listS.get(rowid).getMatricule_ens());
					CODE_UNITE_.setText(listS.get(rowid).getCode_Unite());
					LIBELLE.setText(listS.get(rowid).getLibelle());
					NBR_HEURES_.setText(listS.get(rowid).getNbr_heures());
				}
			});
			table_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int rowid =table_3.getSelectedRow();
					ArrayList<EtudiantUnite> listS = listEtudiantUnits();
					textField_22.setText(listS.get(rowid).getMatricule_etu());
					CODE_UNITE__.setText(listS.get(rowid).getCode_unite());
					NOTE_CC.setText(listS.get(rowid).getNote_CC());
					NOTE_TP.setText(listS.get(rowid).getNote_TP());
					NOTE_EXAMEN.setText(listS.get(rowid).getNote_examen());				
				}
			});
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String StudentID = textField.getText();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					for(int i =0;i<table.getRowCount();i++)
					{
						if(model.getValueAt(i,0).equals(StudentID))
						{
							table.setRowSelectionInterval(i, i);
							textField.setText("");
						}
					}
				}
			});
			button_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String TeacherID = textField_11.getText();
					DefaultTableModel model = (DefaultTableModel) table_1.getModel();
					for(int i =0;i<table_1.getRowCount();i++)
					{
						if(model.getValueAt(i,0).equals(TeacherID))
						{
							table_1.setRowSelectionInterval(i, i);
							textField.setText("");
						}
					}
				}
			});
			
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String StudentID =(String) table.getValueAt(table.getSelectedRow(),0);
					try {
						myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants","BDDAdmin","TPAdmin");
						myStat = myConn.createStatement();
						myStat.executeUpdate("DELETE FROM ETUDIANT WHERE MATRICULE_ETU="+StudentID+";");
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					show_Students();
				}
			});
			button_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String TeacherID =(String) table_1.getValueAt(table_1.getSelectedRow(),0);
					try {
						myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants","BDDAdmin","TPAdmin");
						myStat = myConn.createStatement();
						myStat.executeUpdate("DELETE FROM ENSEIGNANT WHERE MATRICULE_ENS="+TeacherID+";");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					show_Teachers();
				}
			});
			button_10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String UnitID =(String) table_2.getValueAt(table_2.getSelectedRow(),0);
					try {
						myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants","BDDAdmin","TPAdmin");
						myStat = myConn.createStatement();
						myStat.executeUpdate("DELETE FROM UNITE WHERE CODE_UNITE='"+UnitID+"';");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					show_Units();
				}
			});
			button_14.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String MATRICULE_ETU =(String) table_3.getValueAt(table_3.getSelectedRow(),0);
					String CODE_UNITE =(String) table_3.getValueAt(table_3.getSelectedRow(),1);

					try {
						myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants","BDDAdmin","TPAdmin");
						myStat = myConn.createStatement();
						String q =" DELETE FROM ETUDIANTUNITE WHERE MATRICULE_ETU = "+MATRICULE_ETU+
							    " AND CODE_UNITE ='"+CODE_UNITE+"';";
						myStat.executeUpdate(q);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					show_EtudiantUnits();
				}
			});
			btnAdd_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String MATRICULE_ETU = textField_1.getText();
					String NOM_ETU = textField_2.getText();
					String PRENOM_ETU= textField_3.getText();
					String DATEN = textField_4.getText();
					String ADRESSE= textField_5.getText();
					try {
						myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants","BDDAdmin","TPAdmin");
						myStat = myConn.createStatement();
						String q ="INSERT INTO ETUDIANT(MATRICULE_ETU,NOM_ETU,PRENOM_ETU,DATE_NAISSANCE,ADRESSE)"
								+ " VALUES("+MATRICULE_ETU+",'"+NOM_ETU+"','"+PRENOM_ETU+"','"+DATEN+"','"+ADRESSE+"');";
						myStat.executeUpdate(q);
						 textField_1.setText("");
						textField_2.setText("");
						 textField_3.setText("");
						 textField_4.setText("");
						 textField_5.setText("");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					show_Students();

				}
			});
			button_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String MATRICULE_E = MATRICULE_ENS.getText();
					String NOM_E = NOM_ENS.getText();
					String PRENOM_E= PRENOM_ENS.getText();
					try {
						myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants","BDDAdmin","TPAdmin");
						myStat = myConn.createStatement();
						String q ="INSERT INTO ENSEIGNANT(MATRICULE_ENS,NOM_ENS,PRENOM_ENS)"
								+ " VALUES("+MATRICULE_E+",'"+NOM_E+"','"+PRENOM_E+"');";
						myStat.executeUpdate(q);
						MATRICULE_ENS.setText("");
						NOM_ENS.setText("");
						PRENOM_ENS.setText("");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					show_Teachers();

				}
			});
			button_11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String MATRICULE_E = MATRICULE_ENS_.getText();
					String CODE_U = CODE_UNITE_.getText();
					String LIBB= LIBELLE.getText();
					String NBR = NBR_HEURES_.getText();
					try {
						myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants","BDDAdmin","TPAdmin");
						myStat = myConn.createStatement();
						String q ="INSERT INTO UNITE(CODE_UNITE,LIBELLE,NBR_HEURES,MATRICULE_ENS)"
								+ " VALUES('"+CODE_U+"','"+LIBB+"',"+NBR+","+MATRICULE_E+");";
						myStat.executeUpdate(q);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					show_Units();

				}
			});
			button_15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String MATRICULE_E = textField_22.getText();
					String code_unite = CODE_UNITE__.getText();
					String NOTETP= NOTE_TP.getText();
					String NOTECC = NOTE_CC.getText();
					String NOTEEXAMEN= NOTE_EXAMEN.getText();
					try {
						myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants","BDDAdmin","TPAdmin");
						myStat = myConn.createStatement();
						String q ="INSERT INTO ETUDIANTUNITE(MATRICULE_ETU,CODE_UNITE,NOTE_CC,NOTE_TP,NOTE_EXAMEN)"
								+ " VALUES("+MATRICULE_E+",'"+code_unite+"',"+NOTECC+","+NOTETP+","+NOTEEXAMEN+");";
						myStat.executeUpdate(q);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					show_EtudiantUnits();

				}
			});
			
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String MATRICULE_ETU = textField_1.getText();
					String NOM_ETU = textField_2.getText();
					String PRENOM_ETU= textField_3.getText();
					String DATEN = textField_4.getText();
					String ADRESSE= textField_5.getText();
					
					try {
						myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants","BDDAdmin","TPAdmin");
						myStat = myConn.createStatement();
						Statement myStat2 = myConn.createStatement();

						String q2="DELETE FROM ETUDIANT WHERE MATRICULE_ETU="+MATRICULE_ETU+";";
						String q ="INSERT INTO ETUDIANT(MATRICULE_ETU,NOM_ETU,PRENOM_ETU,DATE_NAISSANCE,ADRESSE)"
								+ " VALUES("+MATRICULE_ETU+",'"+NOM_ETU+"','"+PRENOM_ETU+"','"+DATEN+"','"+ADRESSE+"');";
						myStat.executeUpdate(q2);
						myStat2.executeUpdate(q);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					show_Students();
				}
			});
			
			button_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String MATRICULE_E = MATRICULE_ENS.getText();
					String NOM_E = NOM_ENS.getText();
					String PRENOM_E= PRENOM_ENS.getText();
					
					try {
						myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants","BDDAdmin","TPAdmin");
						myStat = myConn.createStatement();
						Statement myStat2 = myConn.createStatement();

						String q2="DELETE FROM ENSEIGNANT WHERE MATRICULE_ENS="+MATRICULE_E+";";
						String q ="INSERT INTO ENSEIGNANT(MATRICULE_ENS,NOM_ENS,PRENOM_ENS)"
								+ " VALUES("+MATRICULE_E+",'"+NOM_E+"','"+PRENOM_E+"');";
						myStat.executeUpdate(q2);
						myStat2.executeUpdate(q);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					show_Teachers();
				}
			});

			button_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String MATRICULE_E = MATRICULE_ENS_.getText();
					String CODE_U = CODE_UNITE_.getText();
					String LIBB= LIBELLE.getText();
					String NBR = NBR_HEURES_.getText();
					
					try {
						myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants","BDDAdmin","TPAdmin");
						myStat = myConn.createStatement();
						Statement myStat2 = myConn.createStatement();

						String q2="DELETE FROM UNITE WHERE CODE_UNITE='"+CODE_U+"';";
						String q ="INSERT INTO UNITE(CODE_UNITE,LIBELLE,NBR_HEURES,MATRICULE_ENS)"
								+ " VALUES('"+CODE_U+"','"+LIBB+"',"+NBR+","+MATRICULE_E+");";
						myStat.executeUpdate(q2);
						myStat2.executeUpdate(q);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					show_Units();
				}
			});

			button_13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String MATRICULE_E = textField_22.getText();
					String code_unite = CODE_UNITE__.getText();
					String NOTETP= NOTE_TP.getText();
					String NOTECC = NOTE_CC.getText();
					String NOTEEXAMEN= NOTE_EXAMEN.getText();
					
					try {
						myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants","BDDAdmin","TPAdmin");
						myStat = myConn.createStatement();
						Statement myStat2 = myConn.createStatement();

						String q2=" DELETE FROM ETUDIANTUNITE WHERE MATRICULE_ETU = "+MATRICULE_E+
							    " AND CODE_UNITE ='"+code_unite+"';";;
						String q ="INSERT INTO ETUDIANTUNITE(MATRICULE_ETU,CODE_UNITE,NOTE_CC,NOTE_TP,NOTE_EXAMEN)"
								+ " VALUES("+MATRICULE_E+",'"+code_unite+"',"+NOTECC+","+NOTETP+","+NOTEEXAMEN+");";
						myStat.executeUpdate(q2);
						myStat2.executeUpdate(q);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					show_EtudiantUnits();
				}
			});
			button_12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String CODE_UNITE = textField_17.getText();
					DefaultTableModel model = (DefaultTableModel) table_2.getModel();
					for(int i =0;i<table_2.getRowCount();i++)
					{
						if(model.getValueAt(i,0).equals(CODE_UNITE))
						{
							table_2.setRowSelectionInterval(i, i);
							textField_17.setText("");
						}
					}
				}
			});
			//////////////////////////////////////////////////////////////////////////////////////
			button_16.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					panel.removeAll();
					panel.add(TP68);
					panel.repaint();
					panel.revalidate();
					TP68.setVisible(true);
				}
			});
			btnExecute.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int queryID = comboBox_1.getSelectedIndex();
					try {
						myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants","BDDAdmin","TPAdmin");
						
						if(queryID==0)
						{}
						else if(queryID==1)
						{
							myStat = myConn.createStatement();
							myRes = myStat.executeQuery("SELECT NOM_ETU,PRENOM_ETU FROM ETUDIANT" + 
									" WHERE MATRICULE_ETU IN(SELECT MATRICULE_ETU FROM ETUDIANTUNITE WHERE NOTE_EXAMEN=20);");
							DefaultTableModel model = (DefaultTableModel) table_4.getModel();
							Object[] row = new Object[2];
							for(int j=0;j<table_4.getRowCount();j++)
							{
								model.removeRow(j);
							}
							for(int j=0;j<table_4.getRowCount();j++)
							{
								model.removeRow(j);
							}
							for(int j=0;j<table_4.getRowCount();j++)
							{
								model.removeRow(j);
							}
							while(myRes.next())
							{
								row[0]= myRes.getString("NOM_ETU");
								row[1]= myRes.getString("PRENOM_ETU");
								model.addRow(row);
							}
							table_4.getColumnModel().getColumn(0).setHeaderValue("NOM_ETU");
							table_4.getColumnModel().getColumn(1).setHeaderValue("PRENOM_ETU");
							table_4.getColumnModel().getColumn(2).setHeaderValue("-");
							table_4.getColumnModel().getColumn(3).setHeaderValue("-");

							table_4.getTableHeader().repaint();
							table_4.setModel(model);
						}
						else if(queryID==2)
						{
							myStat = myConn.createStatement();
							myRes = myStat.executeQuery("SELECT NOM_ETU,PRENOM_ETU FROM ETUDIANT" + 
									" WHERE MATRICULE_ETU NOT IN(SELECT MATRICULE_ETU FROM ETUDIANTUNITE WHERE CODE_UNITE IN (SELECT CODE_UNITE FROM UNITE WHERE LIBELLE='POO'));");
							DefaultTableModel model = (DefaultTableModel) table_4.getModel();
							Object[] row = new Object[2];
							for(int j=0;j<table_4.getRowCount();j++)
							{
								model.removeRow(j);
							}
							for(int j=0;j<table_4.getRowCount();j++)
							{
								model.removeRow(j);
							}
							for(int j=0;j<table_4.getRowCount();j++)
							{
								model.removeRow(j);
							}
							while(myRes.next())
							{
								row[0]= myRes.getString("NOM_ETU");
								row[1]= myRes.getString("PRENOM_ETU");
								model.addRow(row);
							}
							table_4.getColumnModel().getColumn(0).setHeaderValue("NOM_ETU");
							table_4.getColumnModel().getColumn(1).setHeaderValue("PRENOM_ETU");
							table_4.getColumnModel().getColumn(2).setHeaderValue("-");
							table_4.getColumnModel().getColumn(3).setHeaderValue("-");

							table_4.getTableHeader().repaint();
							table_4.setModel(model);
						}
						else if(queryID==3)
						{
							myStat = myConn.createStatement();
							myRes = myStat.executeQuery("SELECT LIBELLE FROM UNITE" + 
									" WHERE CODE_UNITE NOT IN(SELECT CODE_UNITE FROM ETUDIANTUNITE);");
							DefaultTableModel model = (DefaultTableModel) table_4.getModel();
							Object[] row = new Object[1];
							for(int j=0;j<table_4.getRowCount();j++)
							{
								model.removeRow(j);
							}
							for(int j=0;j<table_4.getRowCount();j++)
							{
								model.removeRow(j);
							}
							for(int j=0;j<table_4.getRowCount();j++)
							{
								model.removeRow(j);
							}
							while(myRes.next())
							{
								row[0]= myRes.getString("LIBELLE");
								model.addRow(row);
							}
							table_4.getColumnModel().getColumn(0).setHeaderValue("LIBELLE");
							table_4.getColumnModel().getColumn(1).setHeaderValue("-");
							table_4.getColumnModel().getColumn(2).setHeaderValue("-");
							table_4.getColumnModel().getColumn(3).setHeaderValue("-");

							table_4.getTableHeader().repaint();
							table_4.setModel(model);

						}
						else if(queryID==4)
						{
							myStat = myConn.createStatement();
							myRes = myStat.executeQuery("SELECT ETUDIANT.NOM_ETU,ETUDIANT.PRENOM_ETU, ((ETUDIANTUNITE.NOTE_CC+ETUDIANTUNITE.NOTE_TP)/2)*0.4+ETUDIANTUNITE.NOTE_EXAMEN*0.6 AS MOYENNE,UNITE.LIBELLE" + 
									" FROM ETUDIANT,ETUDIANTUNITE,UNITE" + 
									" WHERE ETUDIANT.MATRICULE_ETU = ETUDIANTUNITE.MATRICULE_ETU" + 
									" AND ETUDIANTUNITE.CODE_UNITE = UNITE.CODE_UNITE; ");
							DefaultTableModel model = (DefaultTableModel) table_4.getModel();
							Object[] row = new Object[4];
							for(int j=0;j<table_4.getRowCount();j++)
							{
								model.removeRow(j);
							}
							for(int j=0;j<table_4.getRowCount();j++)
							{
								model.removeRow(j);
							}
							for(int j=0;j<table_4.getRowCount();j++)
							{
								model.removeRow(j);
							}
							while(myRes.next())
							{
								row[0]= myRes.getString("NOM_ETU");
								row[1]= myRes.getString("PRENOM_ETU");
								row[2]= myRes.getString("MOYENNE");
								row[3]= myRes.getString("LIBELLE");

								model.addRow(row);
							}
							table_4.getColumnModel().getColumn(0).setHeaderValue("NOM_ETU");
							table_4.getColumnModel().getColumn(1).setHeaderValue("PRENOM_ETU");
							table_4.getColumnModel().getColumn(2).setHeaderValue("MOYENNE");
							table_4.getColumnModel().getColumn(3).setHeaderValue("LIBELLE");

							table_4.getTableHeader().repaint();
							table_4.setModel(model);
						}
						else if(queryID==5)
						{
							myStat = myConn.createStatement();
							myRes = myStat.executeQuery("SELECT * FROM V_ETUDIANT_LISTE;");
							DefaultTableModel model = (DefaultTableModel) table_4.getModel();
							Object[] row = new Object[2];
							for(int j=0;j<table_4.getRowCount();j++)
							{
								model.removeRow(j);
							}
							for(int j=0;j<table_4.getRowCount();j++)
							{
								model.removeRow(j);
							}
							for(int j=0;j<table_4.getRowCount();j++)
							{
								model.removeRow(j);
							}
							while(myRes.next())
							{
								row[0]= myRes.getString("NOM_ETU");
								row[1]= myRes.getString("PRENOM_ETU");
							

								model.addRow(row);
							}
							table_4.getColumnModel().getColumn(0).setHeaderValue("NOM_ETU");
							table_4.getColumnModel().getColumn(1).setHeaderValue("PRENOM_ETU");
							table_4.getColumnModel().getColumn(2).setHeaderValue("-");
							table_4.getColumnModel().getColumn(3).setHeaderValue("-");

							table_4.getTableHeader().repaint();
							table_4.setModel(model);
						}
						
						
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			button_17.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int queryID = comboBox_2.getSelectedIndex();
					try {
						myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants","BDDAdmin","TPAdmin");
						if(queryID==1)
						{
							myStat = myConn.createStatement();
							myStat.executeUpdate("CREATE VIEW V_ETUDIANT_LISTE AS" + 
									" SELECT NOM_ETU,PRENOM_ETU FROM ETUDIANT;");
							comboBox_1.addItem("Afficher la vue V_ETUDIANT_LISTE");
							JOptionPane.showMessageDialog(null,"View Created Successfully!"
									+ "\n You can Display it if you want.");
						}
						
					}
					catch(Exception e1)
					{e1.printStackTrace();}
				}
			});
			button_18.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					panel.add(empty);
					panel.repaint();
					panel.revalidate();
					empty.setVisible(true);
				}
			});


	}
}

