package com.org.kapil.modal;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.org.kapil.modelEnum.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseEntity{
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String phone;
	private UserStatus status;

}
