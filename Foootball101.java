import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Foootball101 {
	static Methods m;
	static Connection connMysql, connSqlite;
	static PreparedStatement pst;
	static ResultSet rs;

	public static void main(String[] args) {
		m = new Methods();
		connSqlite = ConnToDb.ToSqlite();
		connMysql = connTo.ToMysql();
		m.say("Welcome To Fussball");

	}

	public static void loadMatches(){
		File mainFolder = new File("C:/Users/wilson/Desktop/10-18");
		File[] folders = mainFolder.listFiles();
		m.say("Main Folder : " + mainFolder);
		for (int a = 0; a < folders.length; a++) {
			File curFolder = folders[a];
			m.say("Folder : " + curFolder);
			File[] files = curFolder.listFiles();

			for (int i = 0; i < files.length; i++) {
				File curFile = files[i];
				m.say("File : " + curFile);
				BufferedReader br = null;
				String line = "";
				String csvSplit = ",";
				try {
					br = new BufferedReader(new FileReader(curFile));
					while ((line = br.readLine()) != null) {
						if (line.startsWith("Div")) {
						} else {
							String cols[] = line.split(csvSplit);
							for (int j = 0; j < 10; j++) {
								m.say(cols[j] + "--", "");
								// m.say(""+strToDate(cols[1]),"");
							}
							String insertSql = "INSERT INTO matches" +
									" (`div`,`match_date`,`hometeam`,`awayteam`,`fthg`,`ftag`,`ftr`,`hthg`,`htag`,`htr`)values ('" +
							cols[0] + "','"+ strToDate(cols[1]) + "','" + toa(cols[2])+ "','" + toa(cols[3]) + "'," + cols[4] + ","
							+ cols[5] + ",'" + cols[6] + "'," + cols[7]+ "," + cols[8] + ",'" + cols[9] + "')";
							m.say("");
							m.say(insertSql);
							
//							pst = connMysql.prepareStatement(insertSql);
//							pst.execute();
//							
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static String toa(String str){
		return str.replaceAll("'", "''");
	}

	public static String strToDate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		SimpleDateFormat sdfa = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfb = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdfc = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy MMM dd");
		SimpleDateFormat sdfe = new SimpleDateFormat("E, dd MMM yyyy");
		
		String mysqlTime = "";
		try {
			mysqlTime = sdfc.format(sdf.parse(str));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return mysqlTime;
	}
}
