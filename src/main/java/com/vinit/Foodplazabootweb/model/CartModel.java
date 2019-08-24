package com.vinit.Foodplazabootweb.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "TBL_CART")
public class CartModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cardId;

	@OneToOne
	private UserModel user;

	@OneToMany()
	private List<FoodModel> foods;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
}
