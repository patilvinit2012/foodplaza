package com.vinit.Foodplazabootweb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Indexed
@ToString
@Table(name = "TBL_FOOD")
public class FoodModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer foodId;

	@Field
	private String foodName;

	@Field
	private String foodType;

	private double foodPrice;

	private int foodQty;

	@Field
	private String foodDesc;

	@Field
	private String imagePath;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

}
