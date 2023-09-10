package org.example.v3.configuration;

import com.fasterxml.jackson.annotation.JsonMerge;
import org.example.v3.ConfigurationVertex;
import org.example.v3.Main;
import org.example.v3.UpdateConfiguration;
import org.jgrapht.graph.DefaultEdge;

public class ConnectionConfiguration extends UpdateConfiguration {

    private String host;
    private Integer port;
    private String databaseName;
    @JsonMerge
    private CredentialsConfiguration credentials;

    public ConnectionConfiguration()
    {
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        if (this.host != null && !this.host.equals(host)) {
            ConfigurationVertex configurationVertex = new ConfigurationVertex("host",this);
            Main.getDirectedGraph().addVertex(configurationVertex);
            Main.getDirectedGraph().addEdge(getParent(), configurationVertex,new DefaultEdge());
        }
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        if (this.port != null && !this.port.equals(port)) {
            ConfigurationVertex configurationVertex = new ConfigurationVertex("port", this);
            Main.getDirectedGraph().addVertex(configurationVertex);
            Main.getDirectedGraph().addEdge(getParent(), configurationVertex, new DefaultEdge());
        }
        this.port = port;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        if (this.databaseName != null && !this.databaseName.equals(databaseName)) {
            ConfigurationVertex configurationVertex = new ConfigurationVertex("databaseName",this);
            Main.getDirectedGraph().addVertex(configurationVertex);
            Main.getDirectedGraph().addEdge(getParent(), configurationVertex, new DefaultEdge());
        }
        this.databaseName = databaseName;
    }

    public CredentialsConfiguration getCredentials() {
        if (this.credentials != null)
        {
            ConfigurationVertex configurationVertex = new ConfigurationVertex("credentials", this.credentials);
            this.credentials.setParent(configurationVertex);
            Main.getDirectedGraph().addVertex(configurationVertex);
            Main.getDirectedGraph().addEdge(getParent(), configurationVertex, new DefaultEdge());
        }
        return credentials;
    }

    public void setCredentials(CredentialsConfiguration credentials) {
        this.credentials = credentials;
    }

    @Override
    public void onUpdate() {
        System.out.println("ConnectionConfiguration.onUpdate()");
    }
}
