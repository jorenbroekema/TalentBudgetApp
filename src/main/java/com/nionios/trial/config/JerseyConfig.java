package com.nionios.trial.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.nionios.trial.api.PersonEndpoint;
import com.nionios.trial.api.TeamEndpoint;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(PersonEndpoint.class);
        register(TeamEndpoint.class);
    }
}
