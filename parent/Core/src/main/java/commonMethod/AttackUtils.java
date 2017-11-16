package commonMethod;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class AttackUtils {

	/**
	 * get attack details from radar, then get its sum 
	 * @param attackDetails
	 * @return
	 */
	public static int getAttackCount(String attackDetails){
		String details[] = attackDetails.replaceAll("\r|\n", ",").split(",");
		int sum = 0;
		for(int i=1; i<details.length; i++){
			int j = details[i].trim().lastIndexOf(":")+2;
			sum += Integer.valueOf(details[i].substring(j).trim());
		}
		return sum;
	}
	
	/**
	 * check date from log and attack date same or not
	 * @param logDate the date in log
	 * @return
	 */
	public static boolean checkLogDate(String logDate){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateNow = dateFormat.format(cal.getTime());
		if(logDate.contains(dateNow)){
			return  true;
		}
		return false;
	}
}
