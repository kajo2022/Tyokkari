package fi.workery.front.domain;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName="signups")
public class Signup {
	@Id
	@GeneratedValue
	private String id;
	
	@PartitionKey
	private String taskId;
	
	private String taskName;
	
	private String firstName, lastName;
	
	private int lpk;
	
	private String phone;
	
	private String info;

	public Signup(String taskId, String taskName, String firstName, String lastName, int lpk, String phone, String info) {
		super();
		this.taskId = taskId;
		this.taskName = taskName; 
		this.firstName = firstName;
		this.lastName = lastName;
		this.lpk = lpk;
		this.phone = phone;
		this.info = info;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Signup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getLpk() {
		return lpk;
	}

	public void setLpk(int lpk) {
		this.lpk = lpk;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	
}
