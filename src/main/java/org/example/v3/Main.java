package org.example.v3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxGraphLayout;
import com.mxgraph.swing.mxGraphComponent;
import lombok.Getter;
import org.example.v3.configuration.Configuration;
import org.jgrapht.alg.interfaces.LowestCommonAncestorAlgorithm;
import org.jgrapht.alg.lca.NaiveLCAFinder;
import org.jgrapht.alg.lca.TarjanLCAFinder;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Main {

    private static Configuration configuration;
    private static ObjectReader objectReader;
    private static ObjectMapper objectMapper;
    private static ConfigurationVertex root;
    private static DefaultDirectedGraph<ConfigurationVertex, DefaultEdge> directedGraph;


    public static void main(String[] args) throws IOException {
        directedGraph = new DefaultDirectedGraph<>(DefaultEdge.class);
        objectMapper = new ObjectMapper();
        InputStream json = loadConfigurationFromResource("config1.json");
        configuration = objectMapper.readValue(json, Configuration.class);
        objectReader = objectMapper.readerForUpdating(configuration);
        update("config2.json");
        LowestCommonAncestorAlgorithm<ConfigurationVertex> lcaFinder = new TarjanLCAFinder<>(directedGraph, root);
        List<ConfigurationVertex> leafNodes = findLeafNodes(directedGraph);
        ConfigurationVertex vertex = findLowestCommonAncestor(lcaFinder, leafNodes);
        vertex.getUpdateConfiguration().onUpdate();
        visualizeGraph();
    }

    public static java.util.List<ConfigurationVertex> findLeafNodes(DefaultDirectedGraph<ConfigurationVertex, DefaultEdge> graph) {
        List<ConfigurationVertex> leafNodes = new ArrayList<>();

        for (ConfigurationVertex vertex : graph.vertexSet()) {
            if (graph.edgesOf(vertex).size() == 1) {
                if (!vertex.equals(root) ) { // root node
                    // Vertex has no outgoing edges, so it's a leaf node
                    leafNodes.add(vertex);
                }
            }
        }

        return leafNodes;
    }


    public static ConfigurationVertex findLowestCommonAncestor(LowestCommonAncestorAlgorithm<ConfigurationVertex> lcaFinder, List<ConfigurationVertex> leafNodes) {
        if (leafNodes.isEmpty()) {
            return null;
        }

        ConfigurationVertex lca = leafNodes.get(0);

        for (int i = 1; i < leafNodes.size(); i++) {
            lca = lcaFinder.getLCA(lca, leafNodes.get(i));
        }

        return lca;
    }

    public static void update(String fileName) throws IOException {
        InputStream json = loadConfigurationFromResource(fileName);
        objectReader.readValue(json);
    }

    private static InputStream loadConfigurationFromResource(String resourceName) {
        ClassLoader classLoader = Main.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(resourceName);
        return inputStream;
    }

    public static DefaultDirectedGraph<ConfigurationVertex, DefaultEdge> getDirectedGraph() {
        return directedGraph;
    }

    public static void setRoot(ConfigurationVertex root) {
        Main.root = root;
    }

    public static void visualizeGraph() {
        JGraphXAdapter<ConfigurationVertex, DefaultEdge> graphAdapter = new JGraphXAdapter<>(directedGraph);
        JFrame frame = new JFrame("Graph Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 600));
        mxGraphComponent graphComponent = new mxGraphComponent(graphAdapter);
        mxGraphLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());
        frame.add(graphComponent); // Add the component to the frame
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}