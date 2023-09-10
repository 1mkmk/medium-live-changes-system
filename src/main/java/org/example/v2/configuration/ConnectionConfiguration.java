package org.example.v2.configuration;

import com.fasterxml.jackson.annotation.JsonMerge;

public class ConnectionConfiguration {

    private String host;
    private Integer port;
    private String databaseName;
    @JsonMerge
    private CredentialsConfiguration credentials;

    public ConnectionConfiguration()
    {
        System.out.println("ConnectionConfiguration.ConnectionConfiguration()");
    }

    public String getHost() {
        System.out.println("ConnectionConfiguration.getHost()");
        return host;
    }

    public void setHost(String host) {
        System.out.println("ConnectionConfiguration.setHost()");
        this.host = host;
    }

    public Integer getPort() {
        System.out.println("ConnectionConfiguration.getPort()");
        return port;
    }

    public void setPort(Integer port) {
        System.out.println("ConnectionConfiguration.setPort()");
        this.port = port;
    }

    public String getDatabaseName() {
        System.out.println("ConnectionConfiguration.getDatabaseName()");
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        System.out.println("ConnectionConfiguration.setDatabaseName()");
        this.databaseName = databaseName;
    }

    public CredentialsConfiguration getCredentials() {
        System.out.println("ConnectionConfiguration.getCredentials()");
        return credentials;
    }

    public void setCredentials(CredentialsConfiguration credentials) {
        System.out.println("ConnectionConfiguration.setCredentials()");
        this.credentials = credentials;
    }


}
