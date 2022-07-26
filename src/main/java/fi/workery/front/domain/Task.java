package fi.workery.front.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.fasterxml.jackson.annotation.JsonFormat;

@Container(containerName="newtasks")
public class Task {
	
	@Id
	@GeneratedValue
	@PartitionKey
	private String id;
	private String taskName;
	private String location;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate date;
	private Boolean isActive;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime time;
	private int level; 
	private String skills, description; 
	private String taskerName, taskerPhone, taskerTask;
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(String taskName, String location, LocalDate date, int level, LocalTime time, String skills, String description,
			String taskerName, String taskerPhone, String taskerTask) {
		super();
		this.taskName = taskName;
		this.location = location;
		this.date = date;
		this.time = time;
		this.skills = skills;
		this.description = description;
		this.taskerName = taskerName;
		this.taskerPhone = taskerPhone;
		this.taskerTask = taskerTask;
		this.isActive = false;
		this.level = level;
	}
	
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTaskerName() {
		return taskerName;
	}
	public void setTaskerName(String taskerName) {
		this.taskerName = taskerName;
	}
	public String getTaskerPhone() {
		return taskerPhone;
	}
	public void setTaskerPhone(String taskerPhone) {
		this.taskerPhone = taskerPhone;
	}
	public String getTaskerTask() {
		return taskerTask;
	}
	public void setTaskerTask(String taskerTask) {
		this.taskerTask = taskerTask;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	

}
