package com.nionios.trial.config;

import javax.ws.rs.ApplicationPath;

import com.nionios.trial.api.TalentTeamEndpoint;
import com.nionios.trial.domain.TalentTeam;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;



@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(TalentTeamEndpoint.class);
    }
}