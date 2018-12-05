package com.carbook.models.user;

import com.carbook.enums.Gender;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Goran Simic
 * 
 * */

@Entity(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = -1318296280155480498L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(unique = true, nullable = false)
	private String username;
	
	@Column(unique = true, nullable = false)
	private String email;

	/**
 	 * password should be encrypted
 	 *
	 */
	@Column(unique = false, nullable = false)
	private String password;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private Gender gender;

	@Column(nullable = false)
	private Date dateOfBirth;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "USER_AUTHORITY",
			joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
			inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
	private List<Authority> authorities;

	/**
	 * this field is required for authentication
	 * */
	@Column
	private boolean enabled;

	public User() {
	}

	public User(Integer id, String username, String email, String password, boolean enabled, String firstName, String lastName, Gender gender, Date dateOfBirth) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) { this.id = id; }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {return password;}

	public void setPassword(String password) { this.password = password; }

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}


	@Override
	public boolean equals(Object obj) {
		if(obj == null || (!getClass().equals(obj.getClass()))){
			return false;
		}

		final User other = (User) obj;
		if(other.getId() != this.getId()){
			return false;
		}else if ( !other.getEmail().equals(this.getEmail())){
			return false;
		}else{
			return true;
		}
	}
}
