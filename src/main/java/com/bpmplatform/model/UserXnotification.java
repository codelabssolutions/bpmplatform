package com.bpmplatform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/*
@Entity
@Table(name = "user_x_notification")
public class UserXnotification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "notification_id")
	@ManyToOne(optional=true,targetEntity=NotificationDetails.class)
	@JoinColumn(name="notification_id")
	private NotificationDetails notificationDetails;
	@Column(name = "user_id")
	@ManyToOne(optional=true,targetEntity=User.class)
	@JoinColumn(name="user_id")
	private User user;
	
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
*/