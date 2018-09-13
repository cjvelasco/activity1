package com.fimc.act1.resource;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fimc.act1.resource.CalculatorRequest;
import com.fimc.act1.resource.CalculatorResponse;

@Component
@Path("/calc")
public class CalculatorResource {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello(CalculatorRequest request) {
		CalculatorResponse calculatorResponse = new CalculatorResponse();
		if (StringUtils.isEmpty(request.getOperator()) || StringUtils.isEmpty(request.getNum1())
				|| StringUtils.isEmpty(request.getNum2())) {
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity("All fields are required.").type( MediaType.TEXT_PLAIN).build();
		} else {
			String operation = "";
			Double x = 0.0;
			if (request.getOperator().equals("+")) {
				operation = "addition";
				x = request.getNum1() + request.getNum2();
			} else if (request.getOperator().equals("-")) {
				operation = "subtraction";
				x = request.getNum1() - request.getNum2();
			} else if (request.getOperator().equals("*")) {
				operation = "multiplication";
				x = request.getNum1() * request.getNum2();
			} else if (request.getOperator().equals("/")) {
				operation = "division";
				x = request.getNum1() / request.getNum2();
			} else {
				return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(HttpServletResponse.SC_BAD_REQUEST).build();
			}
			calculatorResponse.setAction(String.format("%s", operation));
			DecimalFormat df = new DecimalFormat("#.#####");
			calculatorResponse.setResult(Double.parseDouble(df.format(x)));
			return Response.ok().entity(calculatorResponse).build();

		}

	}
}
