package JDBC01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class DeleteForm extends JFrame implements ActionListener {
	JTextField membernum;
	JTextField name;
	JTextField phone;
	JTextField birthday;
	JTextField bpoint;
	JTextField joindate;
	JTextField gender;

	DeleteForm() {
		Font f = new Font("굴림", Font.BOLD, 20);

		Container con = getContentPane();
		con.setLayout(new BorderLayout());

		JPanel labelpanel = new JPanel();
		JPanel textpanel = new JPanel();
		labelpanel.setLayout(new GridLayout(7, 1));
		textpanel.setLayout(new GridLayout(7, 1));
		
		JLabel lb1 = new JLabel("  회 원 번 호 : ");
		JLabel lb2 = new JLabel("  성        명 : ");
		JLabel lb3 = new JLabel("  전 화 번 호 : ");
		JLabel lb4 = new JLabel("  생 년 월 일 : ");
		JLabel lb5 = new JLabel("  성        별 : ");
		JLabel lb6 = new JLabel("  포   인   트 : ");
		JLabel lb7 = new JLabel("  가   입   일 : ");

		JButton title = new JButton("★★★회 원 정 보 수 정★★★");

		lb1.setFont(f);
		lb2.setFont(f);
		lb3.setFont(f);
		lb4.setFont(f);
		lb5.setFont(f);
		lb6.setFont(f);
		lb7.setFont(f);
		labelpanel.add(lb1);
		labelpanel.add(lb2);
		labelpanel.add(lb3);
		labelpanel.add(lb4);
		labelpanel.add(lb5);
		labelpanel.add(lb6);
		labelpanel.add(lb7);
		con.add(labelpanel, BorderLayout.WEST);

		membernum = new JTextField(10);
		name = new JTextField();
		phone = new JTextField();
		birthday = new JTextField();
		gender = new JTextField();
		joindate = new JTextField();
		bpoint = new JTextField();

		JPanel jp22 = new JPanel();
		jp22.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton search = new JButton("조회");
		jp22.add(membernum);
		jp22.add(search);
		textpanel.add(jp22);

		name.setFont(f);
		joindate.setFont(f);
		bpoint.setFont(f);
		phone.setFont(f);
		birthday.setFont(f);
		gender.setFont(f);
		textpanel.add(name);
		textpanel.add(phone);
		textpanel.add(birthday);
		textpanel.add(gender);
		textpanel.add(bpoint);
		textpanel.add(joindate);
		con.add(textpanel, BorderLayout.CENTER);

		JButton jb = new JButton("수정");
		jb.setFont(f);
		con.add(jb, BorderLayout.SOUTH);

		title.setFont(f);
		con.add(title, BorderLayout.NORTH);

		search.addActionListener(this);
		jb.addActionListener(this);
		
		
		setTitle("멤버리스트 레코드 수정");
		setSize(500, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		MemberDto mdto = new MemberDto();
		String s = e.getActionCommand();
		MemberDao mdao = MemberDao.getInstance();

		switch (s) {
		case "조회":
			int mnum = Integer.parseInt(membernum.getText());
			mdto = mdao.getMember(mnum);
			if (mdto == null) {
				System.out.println("존재하지 않는 회원입니다");
				return;
			} else {
				membernum.setText(mdto.getMembernum() + "");
				name.setText(mdto.getName());
				phone.setText(mdto.getPhone());
				birthday.setText(mdto.getBirthday());
				gender.setText(mdto.getGender());
				bpoint.setText(mdto.getBpoint() + "");
				joindate.setText(mdto.getJoindate());
			}
			break;
		case "수정":
			mdto.setMembernum(Integer.parseInt(membernum.getText()));
			mdto.setName(name.getText());
			mdto.setPhone(phone.getText());
			mdto.setBirthday(birthday.getText());
			mdto.setGender(gender.getText());
			mdto.setBpoint(Integer.parseInt(bpoint.getText()));
			mdto.setJoindate(joindate.getText());

			// age
			Calendar today = Calendar.getInstance();
			int todayYear = today.get(Calendar.YEAR);
			int birthYear = Integer.parseInt(birthday.getText().substring(0, 4));
			mdto.setAge(todayYear - birthYear);

			int result = mdao.updateMember(mdto);
			if (result == 1) {
				JOptionPane.showMessageDialog(null, "레코드 수정 성공");
				membernum.setText("");
				name.setText("");
				phone.setText("");
				birthday.setText("");
				gender.setText("");
				bpoint.setText("");
				joindate.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "레코드 수정 실패");
			}
		}

	}
}

public class Member_Delete {

	public static void main(String[] args) {
		
		new DeleteForm();

		
	}
}