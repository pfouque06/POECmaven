package org.eclipse.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.eclipse.models.Employe;
import org.eclipse.models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args )
    {
        System.out.println( "--------------------------------------" );
        User u1 = new User(1, "Jean", "Baton", "jb@jb.com");
        System.out.println(u1);
        Gson gson = new Gson();
        String jsonString = gson.toJson(u1);
        System.out.println(jsonString);

        System.out.println();
        System.out.println( "--------------------------------------" );
        String jsonString2 = "{\"id\":1,\"firstName\":\"Jean\",\"lastName\":\"Chie\",\"email\":\"jc@jc.com\"}";
        System.out.println(jsonString2);
        Gson gson2 = new Gson();
        User u2 = gson2.fromJson(jsonString2, User.class);
        System.out.println(u2);
     
        // register DateSerializer / DateDeserializer
        GsonBuilder gsonBuilder = new GsonBuilder();
   		gsonBuilder.registerTypeAdapter(Date.class, new DateSerializer()); 
        gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
        Gson gson3 = gsonBuilder.create();
        
        System.out.println();
        System.out.println( "--------------------------------------" );
        List<String> roles = new ArrayList<String>(Arrays.asList("Role1", "Role2"));
        roles.add("Role3");
        Employe e1= new Employe(0, "Sam", "Soule", new Date("01/01/2020"), roles);
        System.out.println(e1);
        //Gson gson3 = new Gson();
        String jsonString3 = gson3.toJson(e1);
        System.out.println(jsonString3);
        
        System.out.println();
        System.out.println( "--------------------------------------" );
        String jsonString4 = "{\"id\":0,\"firstName\":\"Sam\",\"lastName\":\"Soule\",\"birthDate\":\"01/01/2020\",\"roles\":[\"Role4\",\"Role5\"]}";
        System.out.println(jsonString4);
        //Gson gson4 = new Gson();
        Employe e2 = gson3.fromJson(jsonString4, Employe.class);
        System.out.println(e2);
        String jsonString5 = "{\"id\":0,\"firstName\":\"Sam\",\"lastName\":\"Soule\",\"birthDate\":\"tttttt\",\"roles\":[\"Role4\",\"Role5\"]}";
        System.out.println(jsonString5);
        Employe e3 = gson3.fromJson(jsonString5, Employe.class);
        System.out.println(e3);
        
        System.out.println();
        System.out.println( "--------------------------------------" );
        
        
        
    }
}
