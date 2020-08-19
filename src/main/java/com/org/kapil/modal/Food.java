package com.org.kapil.modal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "foods")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Food extends BaseEntity {

	private String name;
	private String price;
	private int quantity;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;
	
	
	
}
