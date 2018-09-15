package com.bpmplatform.domainobj;

public class NotificationRequest {

	private String notifcationMessage;
	private Boolean isPublish;
	private Integer creatorId ;
	private String notifcationTitle;
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
	public Integer getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
	public String getNotifcationTitle() {
		return notifcationTitle;
	}
	public void setNotifcationTitle(String notifcationTitle) {
		this.notifcationTitle = notifcationTitle;
	}
	
	
}
