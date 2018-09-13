package com.fimc.act1.resource;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class CalculatorRequest implements Serializable {
	private String operator;
	private Double num1;
	private Double num2;
	
	
}
