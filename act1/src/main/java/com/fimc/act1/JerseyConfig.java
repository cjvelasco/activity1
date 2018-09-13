package com.fimc.act1;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.stereotype.Component;

import com.fimc.act1.resource.CalculatorResource;
@Component
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		register(CalculatorResource.class);
		
		property(ServletProperties.FILTER_FORWARD_ON_404, true);
	}

}
