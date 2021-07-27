package com.may.bean;


import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student2 {
	@NotBlank(message ="Điền mail vô ") 
	@Email(message= "Chưa điền nữa muốn ăn đấm hay gì?")
	String email;
	@NotBlank(message="Không được để trống tên")
	String fullname;
	@NotNull(message ="Điền lẹ lẹ")
	@PositiveOrZero(message="Điểm phải lớn hơn haowjc bằng 0")
	@Max(value =10, message = "Điểm lớn hơn hoặc bằn 10")
	Double marks;
	@NotNull(message ="Chọn quốc tịch") 
	@NotBlank(message = "Chọn giới tính")
	String country;
}
