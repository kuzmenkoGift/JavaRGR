package Kuzmenko_RB_141.RGR.Model;

import java.util.List;
import java.util.Map;

public class InvatersModel {
    private String map;
    private String id;
    private List<Map<String, String>> invaters;

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Map<String, String>> getInvaters() {
        return invaters;
    }

    public void setInvaters(List<Map<String, String>> invaters) {
        this.invaters = invaters;
    }
}
