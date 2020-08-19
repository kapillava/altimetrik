package com.org.kapil.modal;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "hotels")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Hotel extends BaseEntity{
	
	
	private String name;
	@OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Food> foods;
	@OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Rating> reviewRatings;
	private String location;

	
	
	
	
	

}
