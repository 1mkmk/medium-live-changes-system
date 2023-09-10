package org.example.v3;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ConfigurationVertex {

    private String name;
    private UpdateConfiguration updateConfiguration;

    public ConfigurationVertex(String name, UpdateConfiguration updateConfiguration)
    {
        this.name = name;
        this.updateConfiguration = updateConfiguration;
    }

    @Override
    public String toString() {
        return name;
    }
}
