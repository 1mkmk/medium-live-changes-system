package org.example.v3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public abstract class UpdateConfiguration {

     @JsonIgnore
     private ConfigurationVertex parent;

     public void onUpdate() {
     }
}
