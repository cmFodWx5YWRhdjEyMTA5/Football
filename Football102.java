import java.sql.*;

public class Football102 {
	static Methods m;
	static Connection connMysql, connSqlite;
	static PreparedStatement pst;
	static ResultSet rs;

	public static void main(String[] args) {
		m = new Methods();
//		connSqlite = ConnToDb.connToSqlite();
		connMysql = connTo.ToMysql();
		m.say("Welcome To Fussball");
//		HashMap<String, String> stats = new HashMap<String, String>();
//
//		stats.put("wins", results("wins", "Arsenal", "H", "A"));
//		stats.put("draws", results("draws", "Arsenal", "D", "D"));
//		stats.put("loss", results("loss", "Arsenal", "A", "H"));
//		stats.put("homewins",
//				sideResults("homewins", "hometeam", "Arsenal", "H"));
//		stats.put("awaywins",
//				sideResults("awaywins", "awayteam", "Arsenal", "A"));
//		stats.put("homeloss",
//				sideResults("homeloss", "hometeam", "Arsenal", "A"));
//		stats.put("awayloss",
//				sideResults("awayloss", "awayteam", "Arsenal", "H"));
//		stats.put("homedraws",
//				sideResults("homedraws", "hometeam", "Arsenal", "D"));
//		stats.put("awaydraws",
//				sideResults("awaydraws", "awayteam", "Arsenal", "D"));
//
//		m.say(stats.toString());

		// m.say(sideResults("homewins","hometeam","Arsenal","H"));
		// m.say(sideResults("awaywins","awayteam","Arsenal","A"));
		// m.say(sideResults("homeloss","hometeam","Arsenal","A"));
		// m.say(sideResults("awayloss","awayteam","Arsenal","H"));
		// m.say(sideResults("homedraws","hometeam","Arsenal","D"));
		// m.say(sideResults("awaydraws","awayteam","Arsenal","D"));
		// m.say(results("wins","Arsenal","H","A"));
		// m.say(results("draws","Arsenal","D","D"));
		// m.say(results("loss","Arsenal","A","H"));

	}

	public static String sideResults(String pseudo, String whichSide,
			String whichTeam, String results) {
		String sql = "select count(*) as " + pseudo + " from matches where "
				+ whichSide + " = '" + whichTeam + "' and ftr = '" + results
				+ "';";
		String res = "";
		try {
			pst = connMysql.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				res = rs.getString(pseudo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static String results(String pseudo, String whichTeam, String hres,
			String ares) {
		String sql = "select count(*) as " + pseudo + " from matches where "
				+ "(hometeam = '" + whichTeam + "' and ftr = '" + hres
				+ "') or " + "(awayteam = '" + whichTeam + "' and ftr = '"
				+ ares + "');";
		String res = "";
		try {
			pst = connMysql.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				res = rs.getString(pseudo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}