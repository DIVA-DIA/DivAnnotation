/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unifr.diva.divaservicesv2;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import java.awt.Polygon;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Mathias Seuret
 */
public class PolyListResult extends Result<List<Polygon>> {

    public PolyListResult(String url) {
        super(url);
        System.out.println("PolyListResult("+url+")");
    }

    @Override
    protected List<Polygon> createResult(HttpResponse<JsonNode> response) {
        List<Polygon> res = new LinkedList<>();
        JSONArray out = response.getBody().getObject().getJSONArray("output");
        for (int o=0; o<out.length(); o++) {
            if (!out.getJSONObject(o).has("array")) {
                continue;
            }
            JSONObject item = out.getJSONObject(o).getJSONObject("array");
            JSONArray values = item.getJSONArray("values");
            Polygon poly = new Polygon(new int[values.length()], new int[values.length()], 0);
            for (int l=0; l<values.length(); l++) {
                JSONArray pt = values.getJSONArray(l);
                poly.addPoint(pt.getInt(0), pt.getInt(1));
            }
            res.add(poly);
        }
        return res;
    }
    
}
