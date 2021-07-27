package com.may.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	String email;
	String name;
	Double marks;
	Boolean gender;
	String country;
}
