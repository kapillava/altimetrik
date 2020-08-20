package com.org.kapil.modal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.org.kapil.modelEnum.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Booking extends BaseEntity{
	
	private String orderName;
    private long food_id;
    private long hotel_id;
    private long user_id;
	private int quality;
	private OrderStatus status;
	private int price;
	private String phone;
	
	
	

}
