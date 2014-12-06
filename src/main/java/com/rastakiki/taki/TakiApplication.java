package com.rastakiki.taki;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TakiApplication extends Application<TakiConfiguration> {

    public static void main(String[] args) throws Exception {
        new TakiApplication().run(args);
    }

    @Override
    public String getName() {
        return "taki";
    }

    @Override
    public void initialize(Bootstrap<TakiConfiguration> bootstrap) {
    }

    @Override
    public void run(TakiConfiguration configuration, Environment environment) {
        final TakiResource resource = new TakiResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);
    }

}
