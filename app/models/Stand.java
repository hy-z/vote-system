package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;


import play.api.mvc.*;
import play.data.validation.Constraints.Required;

import com.avaje.ebean.Model;

import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;

import controllers.*;

@Entity
public class Stand extends Model {
    @Id
    public Long id;
    @Required
    public String standname;

    public String post;

    public static Finder<Long,Stand>find = new Finder(Long.class, Stand.class);


    public static JsonNode all() {
        List<Stand> stands = find.all();
        return Json.toJson(stands);
    }

    public static JsonNode create(Forms.StandForm addData) {
        Stand stand = new Stand();
        stand.standname = addData.standname;
        stand.post = addData.post;
        stand.save();

        return Json.toJson(stand);
    }

    public static Long checkId (String standname) {
    	Stand stand = find.where().eq("standname", standname).findUnique();
    	return stand.id;
    }
}