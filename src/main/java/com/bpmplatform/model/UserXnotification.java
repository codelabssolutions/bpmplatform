package com.bpmplatform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_x_notification")
public class UserXnotification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@ManyToOne
	@JoinColumn(name="notificationDetailsfk")
	private NotificationDetails notificationDetails;
	@ManyToOne
	@JoinColumn(name="notificationfk")
	private User notificationOwner;
	@Column(name = "read_status")
	private Boolean readStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public NotificationDetails getNotificationDetails() {
		return notificationDetails;
	}
	public void setNotificationDetails(NotificationDetails notificationDetails) {
		this.notificationDetails = notificationDetails;
	}
	public User getNotificationOwner() {
		return notificationOwner;
	}
	public void setNotificationOwner(User notificationOwner) {
		this.notificationOwner = notificationOwner;
	}
	public Boolean getReadStatus() {
		return readStatus;
	}
	public void setReadStatus(Boolean readStatus) {
		this.readStatus = readStatus;
	}

}
