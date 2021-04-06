package com.tracker.app.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Tickets")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@NotEmpty
	@Column(name="name")
	private String name;
	
	@NotEmpty
	@Column(name="owner")
	private String owner;
	
	@NotEmpty
	@Column(name="description")
	private String description;
	
	@NotEmpty
	@Column(name="status")
	private String status;
	
	@NotEmpty
	@Column(name="assigned")
	private String assigned;
	
	@CreationTimestamp
	private Date start_date;
	
	@UpdateTimestamp
	private Date end_date;
	
	@NotEmpty
	@ManyToOne
	@JoinColumn(name="USER_EMAIL")
	private User user;

	public Ticket(String name, String owner, String description, String status, String assigned, Date start_date,
			Date end_date) {
		super();
		this.name = name;
		this.owner = owner;
		this.description = description;
		this.status = status;
		this.assigned = assigned;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Ticket() {
		
	}
	
	public Ticket(String name, String owner, String description, String status, String assigned) {
		super();
		this.name = name;
		this.owner = owner;
		this.description = description;
		this.status = status;
		this.assigned = assigned;
	}


	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getAssigned() {
		return assigned;
	}


	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", name=" + name + ", owner=" + owner + ", description=" + description + ", status="
				+ status + ", assigned=" + assigned + "]";
	}
	
	
	
 }
