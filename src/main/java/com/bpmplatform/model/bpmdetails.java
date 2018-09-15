package com.bpmplatform.model;

import java.util.Date;

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
@Table(name = "bpm_details")
public class bpmdetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bpm_id")
	private int id;
	@Column(name = "bpm_name")
	@NotEmpty//(message = "*Please provide an name")
	private String bpmName;
	@Column(name = "is_delete")
	private Boolean isDetele;
	@ManyToOne
	@JoinColumn(name="createdfk")
	private User createdBy;
	@Column(name = "createdDate")
	private Date createdDate;
	@Column(name = "modification_date")
	private Date modificationDate;
    @Column(name="bpm_storage_path")
    private String bpmStoragePath;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBpmName() {
		return bpmName;
	}
	public void setBpmName(String bpmName) {
		this.bpmName = bpmName;
	}
	public Boolean getIsDetele() {
		return isDetele;
	}
	public void setIsDetele(Boolean isDetele) {
		this.isDetele = isDetele;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	public String getBpmStoragePath() {
		return bpmStoragePath;
	}
	public void setBpmStoragePath(String bpmStoragePath) {
		this.bpmStoragePath = bpmStoragePath;
	}
	
	
}
