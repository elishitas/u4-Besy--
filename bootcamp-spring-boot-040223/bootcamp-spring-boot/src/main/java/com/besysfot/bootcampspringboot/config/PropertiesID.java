package com.besysfot.bootcampspringboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
//@PropertySource("classpath:values.properties")
public class PropertiesID {

    @Value("${app.version}")
    private String version;
    @Value("${app.list-values}")
    private List<String> listaValues;
    @Value("${app.map-values}.key1")
    private String mapValueUno;
    //@Value("${app.map-values}")
    private Map<String, String> valuesMap;

    public PropertiesID() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<String> getListaValues() {
        return listaValues;
    }

    public void setListaValues(List<String> listaValues) {
        this.listaValues = listaValues;
    }

    public String getMapValueUno() {
        return mapValueUno;
    }

    public void setMapValueUno(String mapValueUno) {
        this.mapValueUno = mapValueUno;
    }

    public Map<String, String> getValuesMap() {
        return valuesMap;
    }

    public void setValuesMap(Map<String, String> valuesMap) {
        this.valuesMap = valuesMap;
    }
}
