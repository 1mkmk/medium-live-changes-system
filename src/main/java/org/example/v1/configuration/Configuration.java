package org.example.v1.configuration;


import com.fasterxml.jackson.annotation.JsonMerge;

public class Configuration {


    private ConnectionConfiguration connection;

    public Configuration()
    {
        System.out.println("Configuration.Configuration()");
    }

    public void setConnection(ConnectionConfiguration connection) {
        System.out.println("Configuration.setConnection()");
        this.connection = connection;
    }

    public ConnectionConfiguration getConnection() {
        System.out.println("Configuration.getConnection()");
        return connection;
    }
}
