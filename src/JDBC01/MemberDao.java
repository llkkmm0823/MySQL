package JDBC01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBC05.DBManager;

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
		String sql = "insert into memberlist (name,phone,bd,bpoint,jd,age,gender)"
				+"values(?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mdto.getMember());
			pstmt.setInt(2, mdto.getMembernum());
			pstmt.setInt(3, mdto.getDiscount());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		}finally {DBManager.close(con, pstmt, rs);}
		return result;
	}
}
