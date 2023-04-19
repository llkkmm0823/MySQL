package JDBC01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


class InsertForm extends JFrame implements ActionListener{
	JTextField name;
	JTextField phone;
	JTextField birthday;
	JTextField gender;

	
	InsertForm(){
		
		Font f = new Font("굴림",Font.BOLD,20);
		
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp1.setLayout(new GridLayout(4,1));
		jp2.setLayout(new GridLayout(4,1));

		JLabel lb1 = new JLabel("  성        명 : ");
		JLabel lb2 = new JLabel("  전 화 번 호 : ");
		JLabel lb3 = new JLabel("  생 년 월 일 : ");
		JLabel lb4 = new JLabel("  성        별 : ");
		JButton title = new JButton("★★★회 원 추 가★★★");
		
		lb1.setFont(f);lb2.setFont(f);lb3.setFont(f);lb4.setFont(f);
		jp1.add(lb1);jp1.add(lb2);jp1.add(lb3);jp1.add(lb4);
		con.add(jp1,BorderLayout.WEST);
		
		name = new JTextField();
		phone = new JTextField();
		birthday = new JTextField();
		gender = new JTextField();

		name.setFont(f); 
		phone.setFont(f); birthday.setFont(f); gender.setFont(f);
		jp2.add(name);jp2.add(phone);jp2.add(birthday);jp2.add(gender);
		con.add(jp2,BorderLayout.CENTER);
		
		JButton jb = new JButton("추가");
		jb.setFont(f);
		con.add(jb,BorderLayout.SOUTH);
		
		title.setFont(f);
		con.add(title,BorderLayout.NORTH);
		
		
		jb.addActionListener(this);
	
		setTitle ("레코드 추가");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MemberDto mdto = new MemberDto();
		
		if(name.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"이름을 입력하세요"); // 팝업메세지박스
			return;
		}
		if(phone.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"전화번호를 입력하세요");
			return;
		}
		if(birthday.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"생년월일을 입력하세요");
			return;
		}
		if(gender.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"성별을 입력하세요");
			return;
		}
		
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.insertMember(mdto);
		if(result==1) {
			JOptionPane.showMessageDialog(null,"레코드 추가 성공");
			name.setText(""); phone.setText(""); birthday.setText("");gender.setText("");
		}else{
		JOptionPane.showMessageDialog(null,"레코드 추가 실패");
		}
	}
}

public class Member_Insert {

	public static void main(String[] args) {
		new InsertForm();
	}

}