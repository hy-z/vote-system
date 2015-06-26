package models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import play.api.mvc.*;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import controllers.*;


@Entity
public class User extends Model {
	@Id
    public Long id;

    @Required
    public String name;

    public Long stand_id;

    public static Finder<Long,User>find = new Finder(Long.class, User.class);

    public static JsonNode all() {

    List<User> users = find.all();

    return Json.toJson(users);
    }

    public static User create(String name,Long id) {
        User user = new User();
        user.name = name ;
        user.stand_id = id ;
        user.save();

        return user;

        }

    public static int secletnumber(int stand_id) {
    	int number = find.where().eq("stand_id",stand_id). findRowCount();
    	return number;
    }
 }



