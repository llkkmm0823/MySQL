package JDBC01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class MemberDao {

	private MemberDao() {
	}

	private static MemberDao itc = new MemberDao();

	public static MemberDao getInstance() {
		return itc;
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ArrayList<MemberDto> selectMember() {
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		con = DBManager.getConnection();
		String sql = "select " + "memberlist.*," 
		+ "date_format(birthday, '%Y%m%d')as bd,"
		+ "date_format(joindate,'%Y%m%d')as jd " 
		+ "from memberlist order by membernum desc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDto mdto = new MemberDto();
				mdto.setMembernum(rs.getInt("membernum"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setBirthday(rs.getString("bd"));
				mdto.setBpoint(rs.getInt("bpoint"));
				mdto.setJoindate(rs.getString("jd"));
				mdto.setAge(rs.getInt("age"));
				mdto.setGender(rs.getString("gender"));

				list.add(mdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return list;
	}

	
	public int insertMember(MemberDto mdto) {
		int result=0;
		
		con = DBManager.getConnection();
		String sql = "insert into memberlist (name,phone,birthday,gender,age,joindate)"
				+"values(?,?,str_to_date(concat('',?,''),'%Y-%m-%d'),?,?,date_format(now(),'%Y%m%d'))";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getName());
			pstmt.setString(2, mdto.getPhone());
			pstmt.setString(3, mdto.getBirthday());
			pstmt.setString(4, mdto.getGender());
			pstmt.setInt(5, mdto.getAge());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		}finally {DBManager.close(con, pstmt, rs);}
		
		return result;
	}

	
	
	
	public MemberDto getMember(int mnum) { // 수정
		MemberDto mdto = null; 
		con = DBManager.getConnection();
		String sql = "select date_format(birthday,'%Y-%m-%d') as bd,"
				+ "date_format(joindate,'%Y-%m-%d') as jd, memberlist.* from memberlist where membernum=?";  
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,mnum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				mdto = new MemberDto();
				mdto.setMembernum(rs.getInt("membernum"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setBirthday(rs.getString("bd"));
				mdto.setBpoint(rs.getInt("bpoint"));
				mdto.setJoindate(rs.getString("jd"));
				mdto.setGender(rs.getString("gender"));
				mdto.setAge(rs.getInt("age"));
				
			}				
		} catch (SQLException e) {e.printStackTrace();
		}finally {DBManager.close(con, pstmt, rs);}
		return mdto;
	}


	public int updateMember(MemberDto mdto) {
		int result=0;
		con = DBManager.getConnection();
		String sql = "update memberlist set name=?,phone=?,"
				+ "birthday=str_to_date(concat('',?,''),'%Y-%m-%d'),"
				+ "bpoint=?,joindate=str_to_date(concat('',?,''),'%Y-%m-%d'),"
				+ "gender=?,age=? where membernum = ?";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, mdto.getName());
			pstmt.setString(2, mdto.getPhone());
			pstmt.setString(3, mdto.getBirthday());
			pstmt.setInt(4, mdto.getBpoint());
			pstmt.setString(5, mdto.getJoindate());
			pstmt.setString(6, mdto.getGender());
			pstmt.setInt(7, mdto.getAge());
			pstmt.setInt(8, mdto.getMembernum());

			
			result = pstmt.executeUpdate();
		} catch (SQLException e1) {e1.printStackTrace();
		}finally {DBManager.close(con, pstmt, rs);}
		return result;
	}


	public int deleteMember(int mnum) {
		int result =0;
		con = DBManager.getConnection();
		String sql ="delete from Memberlist where Membernum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,mnum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		}
		return result;
	}
}
