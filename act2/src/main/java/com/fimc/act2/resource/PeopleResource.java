package com.fimc.act2.resource;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;



@Component
@Path("/people")
public class PeopleResource {
	
	List<PeopleResponse> list=new ArrayList<PeopleResponse>();  
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello(PeopleRequest request) {
		PeopleResponse peopleResponse = new PeopleResponse();
		if (StringUtils.isEmpty(request.getFirstName()) || StringUtils.isEmpty(request.getLastName())
				|| StringUtils.isEmpty(request.getBirthDate())) {
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity("All fields are required.").type( MediaType.TEXT_PLAIN).build();
		} else {
			peopleResponse.setFirstName(String.format("%s", request.getFirstName()));
			peopleResponse.setLastName(String.format("%s", request.getLastName()));
			peopleResponse.setBirthDate(simpleDateFormat.format(request.getBirthDate()));
			list.add(peopleResponse);		}
			return Response.status(HttpServletResponse.SC_CREATED).entity(HttpServletResponse.SC_CREATED).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response all() {
		return Response.ok().entity(list).build();
	}
}
