package com.fimc.act2;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.stereotype.Component;

import com.fimc.act2.resource.PeopleResource;
@Component
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		register(PeopleResource.class);
		property(ServletProperties.FILTER_FORWARD_ON_404, true);
	}

}
