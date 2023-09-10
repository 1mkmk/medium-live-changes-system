package org.example.v3.configuration;


import com.fasterxml.jackson.annotation.JsonMerge;
import org.example.v3.ConfigurationVertex;
import org.example.v3.Main;
import org.example.v3.UpdateConfiguration;
import org.jgrapht.graph.DefaultEdge;

public class Configuration extends UpdateConfiguration {


    @JsonMerge
    private ConnectionConfiguration connection;

    public Configuration()
    {
    }

    public void setConnection(ConnectionConfiguration connection) {
        this.connection = connection;
    }

    public ConnectionConfiguration getConnection() {
        if (this.connection != null)
        {
            ConfigurationVertex configurationVertex = new ConfigurationVertex("connection", this);
            this.connection.setParent(configurationVertex);
            Main.getDirectedGraph().addVertex(configurationVertex);
            Main.setRoot(configurationVertex);
        }
        return connection;
    }

    @Override
    public void onUpdate() {
        System.out.println("Configuration.onUpdate()");
    }
}
