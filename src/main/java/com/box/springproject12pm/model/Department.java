package com.box.springproject12pm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="department_tbl")
public class Department {

	@Id
	@GeneratedValue
private int id;
private String dpt_name;
private String dpt_hod;
private String dpt_phone;


}
