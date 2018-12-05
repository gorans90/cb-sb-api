package com.carbook.models.car;

import com.carbook.enums.DefaultStatus;
import com.carbook.models.user.User;

import javax.persistence.*;
import java.io.Serializable;


/**
 * 
 * @author Goran Simic
 * CarProfile class will contain car manufacturer and car model
 * and some other specific data
 * 
 * */

@Entity(name = "carprofile")
public class CarProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1210673862109377234L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/**
	 * Engine Displacement
	 * */
	public long ccm;
	
	public long yearOfProduction;
	
	/**
	 * Power of engine in horse power unit
	 * */
	public int hp;
	
	/**
	 * Since user can have more that one cars
	 * this flag is marking the primary one
	 * and that one will be showed to the user
	 * when user logged in to the system
	 * */
	public Boolean primaryCar;
	
	@OneToOne
	public CarModel carModel;
	
	@ManyToOne
	public User user;

	@Column
	@Enumerated(EnumType.STRING)
	public DefaultStatus active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public long getCcm() {
		return ccm;
	}

	public void setCcm(long ccm) {
		this.ccm = ccm;
	}

	public long getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(long yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public Boolean getPrimaryCar() {
		return primaryCar;
	}

	public void setPrimaryCar(Boolean primaryCar) {
		this.primaryCar = primaryCar;
	}

	public CarModel getCarModel() {
		return carModel;
	}

	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DefaultStatus getActive() {
		return active;
	}

	public void setActive(DefaultStatus active) {
		this.active = active;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null || (!getClass().equals(obj.getClass()))) {
			return false;
		}

		final CarProfile other = (CarProfile) obj;
		if (other.getId() != this.getId()) {
			return false;
		} else if (!other.getPrimaryCar().equals(this.getPrimaryCar())) {
			return false;
		} else if (!other.getActive().equals(this.getActive())) {
			return false;
		} else if (other.getCcm() != this.getCcm()) {
			return false;
		} else if (other.getHp() != this.getHp()) {
			return false;
		} else if (other.getYearOfProduction() != this.getYearOfProduction()) {
			return false;
		} else if (other.getHp() != this.getHp()) {
			return false;
		} else if (!other.getCarModel().equals(this.getCarModel())) {
			return false;
		} else if (!other.getUser().equals(this.getUser())) {
			return false;
		} else {
			return true;
		}
	}
}
