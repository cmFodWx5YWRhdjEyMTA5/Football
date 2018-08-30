import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Methods {
	public void say(String aa){
		System.out.println(aa);
	}
	public void say(String aa,String ab){
		System.out.print(aa);
	}
	public String strToDate(String str,String fromPattern,String toPattern) {
		SimpleDateFormat from = new SimpleDateFormat(fromPattern);
		SimpleDateFormat to = new SimpleDateFormat(toPattern);
		
		
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
//		SimpleDateFormat sdfa = new SimpleDateFormat("dd/MM/yyyy");
//		SimpleDateFormat sdfb = new SimpleDateFormat("dd-MM-yyyy");
//		SimpleDateFormat sdfc = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy MMM dd");
//		SimpleDateFormat sdfe = new SimpleDateFormat("E, dd MMM yyyy");
		
		String mysqlTime = "";
		try {
			mysqlTime = to.format(from.parse(str));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return mysqlTime;
	}

}
