package com.bpmplatform.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "notification_detail")
public class NotificationDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "notification_id")
	private int id;
	@Column(name = "notifcation_message",columnDefinition="LONGTEXT")
	@NotEmpty//(message = "*Please provide an email")
	private String notifcationMessage;
	@Column(name = "notifcation_title")
	@NotEmpty//(message = "*Please provide an email")
	private String notifcationTitle;
	@Column(name = "is_publish")
	private Boolean isPublish;
	@ManyToOne
	@JoinColumn(name="createdfk")
	private User createdBy;
	@ManyToOne
	@JoinColumn(name="publishfk")
	private User publishBy;
	@Column(name = "createdDate")
	private Date createdDate;
	@Column(name = "publishDate")
	private Date publishDate;
	@ManyToOne(cascade = CascadeType.ALL)
	private UserXnotification userXnotification;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNotifcationMessage() {
		return notifcationMessage;
	}
	public void setNotifcationMessage(String notifcationMessage) {
		this.notifcationMessage = notifcationMessage;
	}
	public Boolean getIsPublish() {
		return isPublish;
	}
	public void setIsPublish(Boolean isPublish) {
		this.isPublish = isPublish;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public User getPublishBy() {
		return publishBy;
	}
	public void setPublishBy(User publishBy) {
		this.publishBy = publishBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getNotifcationTitle() {
		return notifcationTitle;
	}
	public void setNotifcationTitle(String notifcationTitle) {
		this.notifcationTitle = notifcationTitle;
	}
	
}
