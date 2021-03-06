package basicClasses;

/**
 * basic data for yaml file
 * @author YN
 *
 */
public class AbstractData {
	
	private final static String URL = "http://192.168.1.239:8099/";
	private final static String DVWA_URL = "http://192.168.1.221/shoot/index.php";

	private String id;
	private String priority;
	private String description;

	private String username = "8labadmintrust";
	private String password = "8lab_Trust714_Test";

	public static String getDvwaUrl() {
		return DVWA_URL;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static String getUrl() {
		return URL;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString(){
		return "ID: " + getId() + ", priority: " + getPriority() + ", description: " + getDescription();
	}

}
