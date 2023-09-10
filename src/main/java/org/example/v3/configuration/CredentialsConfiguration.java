package org.example.v3.configuration;

import org.example.v3.ConfigurationVertex;
import org.example.v3.Main;
import org.example.v3.UpdateConfiguration;
import org.jgrapht.graph.DefaultEdge;

public class CredentialsConfiguration extends UpdateConfiguration {
    private String username;
    private String password;

    public CredentialsConfiguration()
    {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (this.username != null && !this.username.equals(username)) {
            ConfigurationVertex configurationVertex = new ConfigurationVertex( "username",this);
            Main.getDirectedGraph().addVertex(configurationVertex);
            Main.getDirectedGraph().addEdge(getParent(), configurationVertex, new DefaultEdge());
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (this.password != null && !this.password.equals(password)) {
            ConfigurationVertex configurationVertex = new ConfigurationVertex( "password",this);
            Main.getDirectedGraph().addVertex(configurationVertex);
            Main.getDirectedGraph().addEdge(getParent(), configurationVertex, new DefaultEdge());
        }
        this.password = password;
    }
    @Override
    public void onUpdate() {
        System.out.println("CredentailsConfiguration.onUpdate()");
    }
}

