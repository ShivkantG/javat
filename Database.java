import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private PreparedStatement pstm = null;
	private Connection con = null;
	private Statement stm = null;

	public PreparedStatement getPstm() {
		return pstm;
	}

	public void setPstm(PreparedStatement pstm) {
		this.pstm = pstm;
	}

	public Statement getStm() {
		return stm;
	}

	public void setStm(Statement stm) {
		this.stm = stm;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	boolean connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "1245");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	void Insert(String n, String e, String p, String m) {
			   try {
				   pstm = con.prepareStatement("insert into record (name,email,password,mobilenum) values(?,?,?,?)");
				   pstm.setString(1, n);
		           pstm.setString(2, e);
		           pstm.setString(3, p);
		           pstm.setString(4, m);
		           pstm.executeUpdate();
		        } catch (SQLException e1) {
		            // TODO Auto-generated catch block
		            e1.printStackTrace();
		        }
		    }

	void Updatedata(String n, String e, String p, String m) {

		try {
			System.out.println("iyiuioiu");
			pstm = con.prepareStatement("update record set name =?, mobilenum =?, password=? where email= ?");
			pstm.setString(1, n);
			pstm.setString(2, p);
			pstm.setString(3, m);
			pstm.setString(4, e);
			pstm.executeUpdate();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	}

	public int delete(String sno) {
		try {
			pstm = con.prepareStatement("delete from record where sno=?");

			return pstm.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return 0;
		}

	}
}
