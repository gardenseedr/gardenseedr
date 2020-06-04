package com.gardenseedr.gardenseedr.models.POJOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Plants implements Serializable {


    private String name;
    private String description;
    private String sunRequirements;
    private String sowingMethod;
    private int spread;
    private int rowSpacing;
    private int height;

    public Plants(String name, String description, String sunRequirements, String sowingMethod, int spread, int rowSpacing, int height) {
        this.name = name;
        this.description = description;
        this.sunRequirements = sunRequirements;
        this.sowingMethod = sowingMethod;
        this.spread = spread;
        this.rowSpacing = rowSpacing;
        this.height = height;
    }

    public Plants() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSunRequirements() {
        return sunRequirements;
    }

    public void setSunRequirements(String sunRequirements) {
        this.sunRequirements = sunRequirements;
    }

    public String getSowingMethod() {
        return sowingMethod;
    }

    public void setSowingMethod(String sowingMethod) {
        this.sowingMethod = sowingMethod;
    }

    public int getSpread() {
        return spread;
    }

    public void setSpread(int spread) {
        this.spread = spread;
    }

    public int getRowSpacing() {
        return rowSpacing;
    }

    public void setRowSpacing(int rowSpacing) {
        this.rowSpacing = rowSpacing;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @JsonProperty("attributes")
    public void setPlant(List<Map<String, Object>> plantAttributes) {
        Map<String, Object> attributes = plantAttributes.get(0);
        setName((String) attributes.get("name"));
        setDescription((String) attributes.get("description"));
        setSunRequirements((String) attributes.get("sun_requirements"));
        setSowingMethod((String) attributes.get("sowing_method"));
        setSpread((int) attributes.get("spread"));
        setSpread((int) attributes.get("row_spacing"));
        setSpread((int) attributes.get("height"));
    }

//
//    public Plants getPlants(String apiId) throws JsonProcessingException {
//        String url = "openfarm.cc/api/v1/crops/" + apiId;
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
//        ObjectMapper mapper = new ObjectMapper();
//        Plants plant = mapper.readValue(response.getBody(), Plants.class);
//        return plant;
//    }
}