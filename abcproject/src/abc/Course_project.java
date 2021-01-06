package abc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class Course_project {

	private JFrame frame;
	private JTextField txt_ID;
	private JTextField txt_pwd;
	private JTextField txt_name;
	private JTextField txt_birthday;
	private JTextField txt_callnum;
	private JTextField txt_studentnum;
	private JTextField txt_joinids;
	private JTextField txt_joinpwd;
	private String print_id;
	private String print_pwd;
	private int C_One_sinchung = 0;
	private int C_Two_sinchung = 0;
	private int C_Three_sinchung = 0;
	private int Py_sinchung = 0;
	private int Dj_sinchung = 0;
	private int Ja_sinchung = 0;
	private int Css_sinchung = 0;
	ArrayList<Students> list;
	StudentsDAO dao = new StudentsDAO();
	String idtxt = "", passwordtxt = "", nametxt = "", callnumtxt = "", birthtxt = "", stunumtxt = "", gendertxt = "",
			majortxt = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Course_project window = new Course_project();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Course_project() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("GSM 수강신청");
		// ==============================================//

		// =============================================//

		EtchedBorder eborder;
		eborder = new EtchedBorder(EtchedBorder.RAISED);

		frame.getContentPane().setLayout(null);
		ImagePanel JoinPanel = new ImagePanel(
				new ImageIcon("D://java_workspace//Course_Registration_Program33333/img/Welcome3.png").getImage());
		ImagePanel welcomePanel = new ImagePanel(
				new ImageIcon("D://java_workspace//Course_Registration_Program33333/img/Welcome3.png").getImage());
		ImagePanel RegistPanel = new ImagePanel(
				new ImageIcon("D://java_workspace//Course_Registration_Program33333/img/Welcome3.png").getImage());

		RegistPanel.setVisible(false);

		

		JLabel Hello = new JLabel("GSM \uC218\uAC15\uC2E0\uCCAD \uD68C\uC6D0\uAC00\uC785");
		JLabel Label_name = new JLabel("\uC774\uB984");
		JLabel Label_callnum = new JLabel("\uC804\uD654\uBC88\uD638");
		JLabel Label_birthday = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		JLabel Label_studentid = new JLabel("\uD559\uBC88");
		JLabel Label_sex = new JLabel("\uC131\uBCC4");
		JLabel Label_Major = new JLabel("\uC804\uACF5\uACFC");
		JComboBox combo_gender = new JComboBox(new String[] { "남", "여" });
		JComboBox combo_major = new JComboBox(new String[] { "소프트웨어개발과", "임베디드개발과" });
		JButton btnNewButton = new JButton("\uD655\uC778");

		txt_callnum = new JTextField();
		txt_name = new JTextField();

		JoinPanel.setBackground(Color.WHITE);
		JoinPanel.setBounds(0, 0, 834, 527);
		frame.getContentPane().add(JoinPanel);
		JoinPanel.setLayout(null);
		JoinPanel.setVisible(false);

		Hello.setFont(new Font("HY중고딕", Font.BOLD, 21));
		Hello.setHorizontalAlignment(SwingConstants.CENTER);
		Hello.setBounds(133, 10, 556, 60);
		JoinPanel.add(Hello);

		JLabel label = new JLabel("\uC544\uC774\uB514");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("HY중고딕", Font.BOLD, 21));
		label.setBounds(63, 123, 152, 36);
		JoinPanel.add(label);

		JLabel label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("HY중고딕", Font.BOLD, 21));
		label_1.setBounds(448, 123, 152, 36);
		JoinPanel.add(label_1);

		Label_name.setHorizontalAlignment(SwingConstants.CENTER);
		Label_name.setFont(new Font("HY중고딕", Font.BOLD, 21));
		Label_name.setBounds(63, 198, 152, 36);
		JoinPanel.add(Label_name);

		Label_callnum.setHorizontalAlignment(SwingConstants.CENTER);
		Label_callnum.setFont(new Font("HY중고딕", Font.BOLD, 21));
		Label_callnum.setBounds(448, 198, 152, 36);
		JoinPanel.add(Label_callnum);

		Label_birthday.setHorizontalAlignment(SwingConstants.CENTER);
		Label_birthday.setFont(new Font("HY중고딕", Font.BOLD, 21));
		Label_birthday.setBounds(63, 272, 152, 36);
		JoinPanel.add(Label_birthday);

		Label_studentid.setHorizontalAlignment(SwingConstants.CENTER);
		Label_studentid.setFont(new Font("HY중고딕", Font.BOLD, 21));
		Label_studentid.setBounds(448, 272, 152, 36);
		JoinPanel.add(Label_studentid);

		Label_sex.setHorizontalAlignment(SwingConstants.CENTER);
		Label_sex.setFont(new Font("HY중고딕", Font.BOLD, 21));
		Label_sex.setBounds(63, 349, 152, 36);
		JoinPanel.add(Label_sex);

		Label_Major.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Major.setFont(new Font("HY중고딕", Font.BOLD, 21));
		Label_Major.setBounds(448, 349, 152, 36);
		JoinPanel.add(Label_Major);

		txt_joinids = new JTextField();
		txt_joinids.setColumns(10);
		txt_joinids.setBounds(203, 123, 174, 36);
		JoinPanel.add(txt_joinids);

		txt_joinpwd = new JTextField();
		txt_joinpwd.setColumns(10);
		txt_joinpwd.setBounds(588, 123, 174, 36);
		JoinPanel.add(txt_joinpwd);

		txt_name.setBounds(203, 198, 174, 36);
		JoinPanel.add(txt_name);
		txt_name.setColumns(10);

		txt_callnum.setColumns(10);
		txt_callnum.setBounds(588, 198, 174, 36);
		JoinPanel.add(txt_callnum);

		txt_birthday = new JTextField();
		txt_birthday.setColumns(10);
		txt_birthday.setBounds(203, 272, 174, 36);
		JoinPanel.add(txt_birthday);

		txt_studentnum = new JTextField();
		txt_studentnum.setColumns(10);
		txt_studentnum.setBounds(588, 272, 174, 36);
		JoinPanel.add(txt_studentnum);

		combo_gender.setBounds(203, 349, 174, 36);
		JoinPanel.add(combo_gender);

		combo_major.setBounds(588, 349, 174, 36);
		JoinPanel.add(combo_major);

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				idtxt = txt_joinids.getText();
				passwordtxt = txt_joinpwd.getText();
				nametxt = txt_name.getText();
				callnumtxt = txt_callnum.getText();
				stunumtxt = txt_studentnum.getText();
				birthtxt = txt_birthday.getText();
				gendertxt= combo_gender.getSelectedItem().toString();
				majortxt = combo_major.getSelectedItem().toString();
				
				Students s = new Students(idtxt,passwordtxt,nametxt,callnumtxt,stunumtxt,birthtxt,gendertxt,majortxt);
				
				int joinidchk = dao.insert(s);
				if(joinidchk == 1) {
					JOptionPane.showMessageDialog(null, "환영합니다!");
					welcomePanel.setVisible(true);
					JoinPanel.setVisible(false);
					txt_joinids.setText("");
					txt_joinpwd.setText("");
					txt_name.setText("");
					txt_callnum.setText("");
					txt_studentnum.setText("");
					txt_birthday.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "동일한 아이디의 회원이 있습니다.");
				}
			}

		});
		btnNewButton.setBounds(325, 439, 174, 54);
		JoinPanel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\uBA54\uC778\uC73C\uB85C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				welcomePanel.setVisible(true);
				JoinPanel.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(625, 24, 132, 38);
		JoinPanel.add(btnNewButton_2);

		RegistPanel.setBackground(Color.WHITE);
		RegistPanel.setBounds(0, 0, 834, 527);
		frame.getContentPane().add(RegistPanel);
		RegistPanel.setLayout(null);

		JLabel Regist_Title = new JLabel("\uC218\uAC15\uC2E0\uCCAD");
		Regist_Title.setOpaque(true);
		Regist_Title.setBackground(Color.GREEN);
		Regist_Title.setHorizontalAlignment(SwingConstants.CENTER);
		Regist_Title.setFont(new Font("굴림", Font.BOLD, 28));
		Regist_Title.setBounds(279, 10, 267, 63);
		RegistPanel.add(Regist_Title);

		JLabel C_One = new JLabel("C\uC5B8\uC5B4(\uACE0\uAE09\uBC18)");
		C_One.setOpaque(true);
		C_One.setBorder(eborder);
		C_One.setForeground(Color.BLACK);
		C_One.setBackground(Color.ORANGE);
		C_One.setHorizontalAlignment(SwingConstants.CENTER);
		C_One.setBounds(153, 154, 105, 40);
		RegistPanel.add(C_One);

		JLabel C_One_Num = new JLabel(
				"최대 인원수 : 15명  현재 인원수 : "+C_One_sinchung+"명");
		C_One_Num.setBorder(eborder);
		C_One_Num.setOpaque(true);
		C_One_Num.setBackground(new Color(255, 255, 0));
		C_One_Num.setForeground(new Color(0, 0, 0));
		C_One_Num.setHorizontalAlignment(SwingConstants.CENTER);
		C_One_Num.setBounds(255, 154, 217, 40);
		RegistPanel.add(C_One_Num);

		JLabel C_One_Teach = new JLabel("\uB2F4\uC784\uAD50\uC0AC : \uBC15\uD544\uC7AC");
		C_One_Teach.setBorder(eborder);
		C_One_Teach.setOpaque(true);
		C_One_Teach.setHorizontalAlignment(SwingConstants.CENTER);
		C_One_Teach.setBackground(new Color(0, 191, 255));
		C_One_Teach.setBounds(471, 154, 105, 40);
		RegistPanel.add(C_One_Teach);

		JButton C_One_btn = new JButton("\uC2E0     \uCCAD");
		C_One_btn.setBounds(583, 159, 97, 31);
		C_One_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				C_One_btn.setVisible(false);
				++C_One_sinchung;
				C_One_Num.setText("최대 인원수 : 15명  현재 인원수 : "+C_One_sinchung+"명");
			}
			
		});
		RegistPanel.add(C_One_btn);

		JLabel C_Two = new JLabel("C\uC5B8\uC5B4(\uC911\uAE09\uBC18)");
		C_Two.setBorder(eborder);
		C_Two.setOpaque(true);
		C_Two.setHorizontalAlignment(SwingConstants.CENTER);
		C_Two.setForeground(Color.BLACK);
		C_Two.setBackground(Color.ORANGE);
		C_Two.setBounds(153, 204, 105, 40);
		RegistPanel.add(C_Two);

		JLabel C_Two_Num = new JLabel(
				"최대 인원수 : 15명  현재 인원수 : "+C_Two_sinchung+"명");
		C_Two_Num.setBorder(eborder);
		C_Two_Num.setOpaque(true);
		C_Two_Num.setHorizontalAlignment(SwingConstants.CENTER);
		C_Two_Num.setForeground(Color.BLACK);
		C_Two_Num.setBackground(Color.YELLOW);
		C_Two_Num.setBounds(255, 204, 217, 40);
		RegistPanel.add(C_Two_Num);

		JLabel C_Two_Teach = new JLabel("\uB2F4\uC784\uAD50\uC0AC : \uBD09\uB9CC\uC601");
		C_Two_Teach.setBorder(eborder);
		C_Two_Teach.setOpaque(true);
		C_Two_Teach.setBackground(new Color(0, 191, 255));
		C_Two_Teach.setHorizontalAlignment(SwingConstants.CENTER);
		C_Two_Teach.setBounds(471, 204, 105, 40);
		RegistPanel.add(C_Two_Teach);

		JButton C_Two_btn = new JButton("\uC2E0     \uCCAD");
		C_Two_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				C_Two_btn.setVisible(false);
				++C_Two_sinchung;
				C_Two_Num.setText("최대 인원수 : 15명  현재 인원수 : "+C_Two_sinchung+"명");
			}
			
		});
		C_Two_btn.setBounds(583, 207, 97, 31);
		RegistPanel.add(C_Two_btn);

		JLabel C_Three = new JLabel("C\uC5B8\uC5B4(\uCD08\uAE09\uBC18)");
		C_Three.setBorder(eborder);
		C_Three.setOpaque(true);
		C_Three.setHorizontalAlignment(SwingConstants.CENTER);
		C_Three.setForeground(Color.BLACK);
		C_Three.setBackground(Color.ORANGE);
		C_Three.setBounds(153, 252, 105, 40);
		RegistPanel.add(C_Three);

		JLabel C_Three_Num = new JLabel(
				"최대 인원수 : 15명  현재 인원수 : "+C_Three_sinchung+"명");
		C_Three_Num.setBorder(eborder);
		C_Three_Num.setOpaque(true);
		C_Three_Num.setHorizontalAlignment(SwingConstants.CENTER);
		C_Three_Num.setForeground(Color.BLACK);
		C_Three_Num.setBackground(Color.YELLOW);
		C_Three_Num.setBounds(255, 252, 217, 40);
		RegistPanel.add(C_Three_Num);

		JLabel C_Three_Teach = new JLabel("\uB2F4\uC784\uAD50\uC0AC : \uCD5C\uB3D9\uC6B0");
		C_Three_Teach.setBorder(eborder);
		C_Three_Teach.setOpaque(true);
		C_Three_Teach.setHorizontalAlignment(SwingConstants.CENTER);
		C_Three_Teach.setBackground(new Color(0, 191, 255));
		C_Three_Teach.setBounds(471, 252, 105, 40);
		RegistPanel.add(C_Three_Teach);

		JButton C_Three_btn = new JButton("\uC2E0     \uCCAD");
		C_Three_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				C_Three_btn.setVisible(false);
				++C_Three_sinchung;
				C_Three_Num.setText("최대 인원수 : 15명  현재 인원수 : "+C_Three_sinchung+"명");
			}
			
		});
		C_Three_btn.setBounds(583, 257, 97, 31);
		RegistPanel.add(C_Three_btn);

		JLabel Py = new JLabel("\uD30C\uC774\uC36C");
		Py.setBorder(eborder);
		Py.setOpaque(true);
		Py.setHorizontalAlignment(SwingConstants.CENTER);
		Py.setForeground(Color.BLACK);
		Py.setBackground(Color.ORANGE);
		Py.setBounds(153, 302, 105, 40);
		RegistPanel.add(Py);

		JLabel Py_Num = new JLabel(
				"최대 인원수 : 15명  현재 인원수 : "+Py_sinchung+"명");
		Py_Num.setBorder(eborder);
		Py_Num.setOpaque(true);
		Py_Num.setHorizontalAlignment(SwingConstants.CENTER);
		Py_Num.setForeground(Color.BLACK);
		Py_Num.setBackground(Color.YELLOW);
		Py_Num.setBounds(255, 302, 217, 40);
		RegistPanel.add(Py_Num);

		JLabel Py_Teach = new JLabel("\uB2F4\uC784\uAD50\uC0AC : \uAE40\uD76C\uCCA0");
		Py_Teach.setBorder(eborder);
		Py_Teach.setOpaque(true);
		Py_Teach.setHorizontalAlignment(SwingConstants.CENTER);
		Py_Teach.setBackground(new Color(0, 191, 255));
		Py_Teach.setBounds(471, 302, 105, 40);
		RegistPanel.add(Py_Teach);

		JButton Py_btn = new JButton("\uC2E0     \uCCAD");
		Py_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				Py_btn.setVisible(false);
				++Py_sinchung;
				Py_Num.setText("최대 인원수 : 15명  현재 인원수 : "+C_One_sinchung+"명");
			}
			
		});
		Py_btn.setBounds(583, 307, 97, 31);
		RegistPanel.add(Py_btn);

		JLabel Dj = new JLabel("\uC7A5\uACE0");
		Dj.setBorder(eborder);
		Dj.setOpaque(true);
		Dj.setHorizontalAlignment(SwingConstants.CENTER);
		Dj.setForeground(Color.BLACK);
		Dj.setBackground(Color.ORANGE);
		Dj.setBounds(153, 352, 105, 40);
		RegistPanel.add(Dj);

		JLabel Dj_Num = new JLabel(
				"최대 인원수 : 15명  현재 인원수 : "+Dj_sinchung+"명");
		Dj_Num.setBorder(eborder);
		Dj_Num.setOpaque(true);
		Dj_Num.setHorizontalAlignment(SwingConstants.CENTER);
		Dj_Num.setForeground(Color.BLACK);
		Dj_Num.setBackground(Color.YELLOW);
		Dj_Num.setBounds(255, 352, 217, 40);
		RegistPanel.add(Dj_Num);

		JLabel Dj_teach = new JLabel("\uB2F4\uC784\uAD50\uC0AC : \uCD5C\uC6B0\uD615");
		Dj_teach.setBorder(eborder);
		Dj_teach.setOpaque(true);
		Dj_teach.setHorizontalAlignment(SwingConstants.CENTER);
		Dj_teach.setBackground(new Color(0, 191, 255));
		Dj_teach.setBounds(471, 352, 105, 40);
		RegistPanel.add(Dj_teach);

		JButton Dj_btn = new JButton("\uC2E0     \uCCAD");
		Dj_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				Dj_btn.setVisible(false);
				++Dj_sinchung;
				Dj_Num.setText("최대 인원수 : 15명  현재 인원수 : "+C_One_sinchung+"명");
			}
			
		});
		Dj_btn.setBounds(583, 357, 97, 31);
		RegistPanel.add(Dj_btn);

		JLabel Ja = new JLabel("\uC790\uBC14");
		Ja.setBorder(eborder);
		Ja.setOpaque(true);
		Ja.setHorizontalAlignment(SwingConstants.CENTER);
		Ja.setForeground(Color.BLACK);
		Ja.setBackground(Color.ORANGE);
		Ja.setBounds(153, 402, 105, 40);
		RegistPanel.add(Ja);

		JLabel Ja_Num = new JLabel(
				"최대 인원수 : 15명  현재 인원수 : "+Ja_sinchung+"명");
		Ja_Num.setBorder(eborder);
		Ja_Num.setOpaque(true);
		Ja_Num.setHorizontalAlignment(SwingConstants.CENTER);
		Ja_Num.setForeground(Color.BLACK);
		Ja_Num.setBackground(Color.YELLOW);
		Ja_Num.setBounds(255, 402, 217, 40);
		RegistPanel.add(Ja_Num);

		JLabel Ja_Teach = new JLabel("\uB2F4\uC784\uAD50\uC0AC : \uC7A5\uC7AC\uC6D0");
		Ja_Teach.setBorder(eborder);
		Ja_Teach.setOpaque(true);
		Ja_Teach.setHorizontalAlignment(SwingConstants.CENTER);
		Ja_Teach.setBackground(new Color(0, 191, 255));
		Ja_Teach.setBounds(471, 402, 105, 40);
		RegistPanel.add(Ja_Teach);

		JButton Ja_btn = new JButton("\uC2E0     \uCCAD");
		Ja_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				Ja_btn.setVisible(false);
				++Ja_sinchung;
				Ja_Num.setText("최대 인원수 : 15명  현재 인원수 : "+C_One_sinchung+"명");
			}
			
		});
		Ja_btn.setBounds(583, 407, 97, 31);
		RegistPanel.add(Ja_btn);

		JLabel Css = new JLabel("css");
		Css.setBorder(eborder);
		Css.setOpaque(true);
		Css.setHorizontalAlignment(SwingConstants.CENTER);
		Css.setForeground(Color.BLACK);
		Css.setBackground(Color.ORANGE);
		Css.setBounds(153, 452, 105, 40);
		RegistPanel.add(Css);

		JLabel Css_Num = new JLabel(
				"최대 인원수 : 15명  현재 인원수 : "+Css_sinchung+"명");
		Css_Num.setBorder(eborder);
		Css_Num.setOpaque(true);
		Css_Num.setHorizontalAlignment(SwingConstants.CENTER);
		Css_Num.setForeground(Color.BLACK);
		Css_Num.setBackground(Color.YELLOW);
		Css_Num.setBounds(255, 452, 217, 40);
		RegistPanel.add(Css_Num);

		JLabel Css_Teach = new JLabel("\uB2F4\uC784\uAD50\uC0AC : \uC1A1\uBBF8\uB77C");
		Css_Teach.setBorder(eborder);
		Css_Teach.setOpaque(true);
		Css_Teach.setHorizontalAlignment(SwingConstants.CENTER);
		Css_Teach.setBackground(new Color(0, 191, 255));
		Css_Teach.setBounds(471, 452, 105, 40);
		RegistPanel.add(Css_Teach);

		JButton Css_btn = new JButton("\uC2E0     \uCCAD");
		Css_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				Css_btn.setVisible(false);
				++Css_sinchung;
				Css_Num.setText("최대 인원수 : 15명  현재 인원수 : "+C_One_sinchung+"명");
			}
			
		});
		Css_btn.setBounds(583, 457, 97, 31);
		RegistPanel.add(Css_btn);

		JFormattedTextField info_gsm = new JFormattedTextField();
		info_gsm.setHorizontalAlignment(SwingConstants.CENTER);
		info_gsm.setText(
				"GSM\uC218\uAC15\uC2E0\uCCAD\uD504\uB85C\uADF8\uB7A8\uC785\uB2C8\uB2E4   |   \uAE30\uAC04 : 12\uC6D48\uC77C    |    \uD55C\uBC88\uC2E0\uCCAD\uD558\uBA74 \uCDE8\uC18C x");
		info_gsm.setBounds(180, 76, 448, 68);
		RegistPanel.add(info_gsm);

		JButton btnNewButton_1 = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistPanel.setVisible(false);
				welcomePanel.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(684, 29, 113, 37);
		RegistPanel.add(btnNewButton_1);

		JLabel Title = new JLabel("GSM \uC218\uAC15\uC2E0\uCCAD \uD504\uB85C\uADF8\uB7A8");
		JLabel LogIn = new JLabel("Log In");
		JLabel ID = new JLabel("ID : ");
		JLabel Password = new JLabel("PS : ");
		JButton LogIn_btn = new JButton("\uB85C\uADF8\uC778");
		JButton Signup_btn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		Signup_btn.setFont(new Font("HY중고딕", Font.BOLD, 16));
		Signup_btn.setBounds(414, 316, 158, 41);
		welcomePanel.add(Signup_btn);

		welcomePanel.setBounds(0, 0, 834, 527);
		frame.getContentPane().add(welcomePanel);
		welcomePanel.setLayout(null);
		
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("맑은 고딕", Font.BOLD, 39));
		Title.setBounds(198, 43, 579, 72);
		welcomePanel.add(Title);

		LogIn.setFont(new Font("Myanmar Text", Font.BOLD, 26));
		LogIn.setHorizontalAlignment(SwingConstants.CENTER);
		LogIn.setBounds(445, 144, 108, 41);
		welcomePanel.add(LogIn);

		ID.setFont(new Font("Myanmar Text", Font.BOLD, 26));
		ID.setHorizontalAlignment(SwingConstants.CENTER);
		ID.setBounds(382, 195, 75, 32);
		welcomePanel.add(ID);

		txt_ID = new JTextField();
		txt_ID.setBounds(455, 195, 230, 32);
		welcomePanel.add(txt_ID);
		txt_ID.setColumns(10);

		Password.setHorizontalAlignment(SwingConstants.CENTER);
		Password.setFont(new Font("Myanmar Text", Font.BOLD, 26));
		Password.setBounds(393, 249, 52, 32);
		welcomePanel.add(Password);

		txt_pwd = new JTextField();
		txt_pwd.setBounds(455, 249, 230, 32);
		welcomePanel.add(txt_pwd);

		LogIn_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String loginid = txt_ID.getText();
				String loginpwd = txt_pwd.getText();
				print_id = loginid;
				print_pwd = loginpwd;
				int a = login(loginid,loginpwd);
				if(a==1) {
					welcomePanel.setVisible(false);
					RegistPanel.setVisible(true);
					txt_ID.setText("");
					txt_pwd.setText("");
					C_One_btn.setVisible(true);
					C_Two_btn.setVisible(true);
					C_Three_btn.setVisible(true);
					Py_btn.setVisible(true);
					Dj_btn.setVisible(true);
					Ja_btn.setVisible(true);
					Css_btn.setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null,"아이디 또는 비밀번호가 다릅니다.");
				}
				
//				if (txt_ID.getText().equals("NGJ") && Arrays.equals(Ps_Field.getPassword(), "hello".toCharArray())) {
//					System.out.println("Hello NGJ");
//					RegistPanel.setVisible(true);
//					welcomePanel.setVisible(false);
//				} else {
//					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 다릅니다.");
//				}

			}

			private int login(String loginid, String loginpwd) {
				String url="jdbc:oracle:thin:@localhost:1521:xe";
                Connection con=null;
                Statement st=null;
                ResultSet rs=null;
                String selectsql="select * from students";
                
                try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection(url,"NGJ","12345");
					
					st = con.createStatement();
					rs = st.executeQuery(selectsql);
					
					String id,pwd;
					
					while(rs.next()) {
						id=rs.getString(1);
						pwd=rs.getString(2);
						if(loginid.equals(id)&&loginpwd.equals(pwd)) {
							JOptionPane.showMessageDialog(null, "로그인 성공");
							return 1;
						}
						else {
							continue;
						}
					}
                } catch (Exception e) {
                	System.out.println("Dont find JDBC Driver");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
				return 0;
			}
		});

		LogIn_btn.setFont(new Font("HY중고딕", Font.BOLD, 16));
		LogIn_btn.setBounds(584, 316, 158, 41);
		welcomePanel.add(LogIn_btn);

		Signup_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcomePanel.setVisible(false);
				JoinPanel.setVisible(true);
			}
		});
		frame.setJMenuBar(menuBar());
		frame.setSize(840, 576);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JMenuBar menuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("정보");
		JMenu aboutMenu = new JMenu("Quit");

		bar.add(fileMenu);
		bar.add(aboutMenu);

		JMenuItem Virson = new JMenuItem("Virson");
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(Virson);
		aboutMenu.add(exit);

		Virson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Virson : 2020.12.01");
			}
		});
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		return bar;
	}
}

class ImagePanel extends JPanel {
	private Image img;

	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}

	public int getWidth() {
		return img.getWidth(null);
	}

	public int getHeight() {
		return img.getHeight(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
