import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 * @author abcdef
 *
 */
public class Test {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Connection cnn = DBConnection.getConnection();
		String sql = "SELECT * FROM Student";
		Statement stmt = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		String query = "insert into student values(?)";
		ResultSet rs = stmt.executeQuery(sql);
//		int rows = stmt.executeUpdate(sql);
//		boolean check = stmt.execute(sql);

		rs.moveToInsertRow();
		rs.updateString(2, "insert 1");
		rs.insertRow();

		System.out.println();

//		rs.updateString(2, "insert");
//		rs.insertRow();

//		PreparedStatement preparedStatement = cnn.prepareStatement(query);
//		preparedStatement.setString(1, "hay");
//		System.out.println(preparedStatement.execute());

//		String prepareSql = "{call sp_test(?,?)}";
//		CallableStatement calStatement = cnn.prepareCall(prepareSql);
//		
//		calStatement.setString(2, "hay");
//		calStatement.registerOutParameter(1, java.sql.Types.INTEGER);
//		
//		calStatement.execute();
//		int result  = calStatement.getInt(1);
//		
//		System.out.println(result);

//		String prepareSql = "{? = call udf_test(?)}";
//		CallableStatement calStatement = cnn.prepareCall(prepareSql);
//
//		calStatement.setString(2, "hay");
//		calStatement.registerOutParameter(1, Types.INTEGER);
//
//		calStatement.execute();
//		int result = calStatement.getInt(1);
//
//		System.out.println(result);

	}

	public static void main1(String[] args) {
		try (Connection conn = DBConnection.getConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM HOC_SINH");
			// MASV | TENSV|
			// SV_01 | Vu
			// SV_02 | Hoang
			// SV_03 | Truong
			// SV_04 | Nam
			// CON TRO: TRUOC SV_01
			rs.next();
			// CON TRO: SV_01
			System.out.println("MaSV:" + rs.getString("MaSV") + ", TenSV:" + rs.getString("TenSV"));
			rs.next();
			System.out.println("MaSV:" + rs.getString("MaSV") + ", TenSV:" + rs.getString("TenSV"));
			// CON TRO: SV_02
			rs.beforeFirst();
			// CON TRO: TRUOC SV_01
			System.out.println("MaSV:" + rs.getString("MaSV") + ", TenSV:" + rs.getString("TenSV")); // LOI
			rs.next();
			rs.next();
			rs.first();
			rs.last();
			rs.absolute(3);// SV_03 | Truong
			System.out.println(rs.getRow());// Print 3
			rs.absolute(1);// SV_01 | Vu
			rs.relative(2);// SV_03 | Truong
			rs.relative(-1); // SV_02 | Hoang
			System.out.println(rs.getRow());// Print 2
			rs.previous();// SV_01 | Vu
			System.out.println(rs.getRow());// Print 1

			// UPDATE
			rs.updateString(2, "Huy");
			rs.updateRow();

			// DELETE
			rs.deleteRow();

			// INSERT
			rs.moveToInsertRow();
			rs.updateString("MaSV", "SV_05");
			rs.updateString(2, "Tuan");
			rs.insertRow();

			System.out.println("MaSV:" + rs.getString("MaSV") + ", TenSV:" + rs.getString("TenSV"));
			rs.afterLast();
			System.out.println("MaSV:" + rs.getString("MaSV") + ", TenSV:" + rs.getString("TenSV")); // LOI

			// SEARCH
			while (rs.next()) {
				String masv = rs.getString(1);
				if ("SV_01".equals(masv)) {
					rs.updateString(2, "Huy");
					rs.updateRow();
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
