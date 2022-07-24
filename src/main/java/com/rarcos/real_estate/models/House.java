package com.rarcos.real_estate.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "houses")
@EntityListeners(AuditingEntityListener.class)
public class House {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(nullable = false)
	@NotEmpty
	private String property;
	@Column(nullable = false)
	@NotEmpty
	private String shortDescription;
	@NotEmpty
	private String phone;
	private String longDescription;
	private String photo;

	
	public House() {
	}


	public House(long id, @NotEmpty String property, @NotEmpty String shortDescription, @NotEmpty String phone,
			String longDescription, String photo) {
		super();
		this.id = id;
		this.property = property;
		this.shortDescription = shortDescription;
		this.phone = phone;
		this.longDescription = longDescription;
		this.photo = photo;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getProperty() {
		return property;
	}


	public void setProperty(String property) {
		this.property = property;
	}


	public String getShortDescription() {
		return shortDescription;
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getLongDescription() {
		return longDescription;
	}


	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, longDescription, phone, photo, property, shortDescription);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		House other = (House) obj;
		return id == other.id && Objects.equals(longDescription, other.longDescription)
				&& Objects.equals(phone, other.phone) && Objects.equals(photo, other.photo)
				&& Objects.equals(property, other.property) && Objects.equals(shortDescription, other.shortDescription);
	}


	@Override
	public String toString() {
		return "House [id=" + id + ", property=" + property + ", shortDescription=" + shortDescription + ", phone="
				+ phone + ", longDescription=" + longDescription + ", photo=" + photo + "]";
	}


	
}
