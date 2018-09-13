package com.fimc.act2.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeopleResponse implements Serializable{
	private String firstName;
	private String lastName;
	private String birthDate;
}
