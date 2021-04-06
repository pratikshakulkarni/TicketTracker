package com.tracker.app.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@NotEmpty
	@Column(name="firstName")
	private String firstName;
	
	@NotEmpty
	@Column(name="lastName")
	private String lastName;
	
	@Email
	@NotEmpty
	@Column(name="email")
	private String email;
	
	@Size(min=4)
	@Column(name="password")
	private String password;
	
	@Column(name = "active")
	private int active;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<Ticket> tickets;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USER_ROLES", joinColumns=@JoinColumn(name="user_email"),inverseJoinColumns=@JoinColumn(name="role"))
	private List<Role> roles;
	
	public User() {
		
	}

	public User(String firstName, String lastName, String email, String password, int active, List<Role> roles) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public int getId() {
		return id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}


	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", active=" + active + ", roles=" + roles + "]";
	}
	
	
	
}
