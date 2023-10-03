package api;


import api.dataClasses.CharacterData;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.opentest4j.AssertionFailedError;

import static api.Specifications.*;
import static io.restassured.RestAssured.given;

public class ApiSteps {
    private final static String RDBASEURL = "https://rickandmortyapi.com/api";
    public static CharacterData character1 = new CharacterData();
    public static CharacterData character2 = new CharacterData();
    public static void getCharacterData(String id, CharacterData character) {
        specInstall(reqSpec(RDBASEURL), respSpec());
        Response req = given()
                .when()
                .get("/character/"+id)
                .then()
                .log().all()
                .extract()
                .response();
        character.setId(new JSONObject(req.getBody().asString()).get("id").toString());
        character.setLocation(new JSONObject(req.getBody().asString()).getJSONObject("location").get("name").toString());
        character.setName(new JSONObject(req.getBody().asString()).get("name").toString());
        character.setSpecies(new JSONObject(req.getBody().asString()).get("species").toString());
        int episode = (new JSONObject(req.getBody().asString()).getJSONArray("episode").length() - 1);
        character.setLastEp(new JSONObject(req.getBody().asString()).getJSONArray("episode").get(episode).toString().replaceAll("[^0-9]", ""));
    }
    public static void getOriginChar(String id) {
        getCharacterData(id, character1);

    }
    public static void getLastCharOfLastEp(String lEp) {
        specInstall(reqSpec(RDBASEURL), respSpec());
        Response req = given()
                .when()
                .get("/episode/"+lEp)
                .then()
                .log().all()
                .extract()
                .response();
        int tempArrId = new JSONObject(req.getBody().asString()).getJSONArray("characters").length() - 1;
        String tempCharId = new JSONObject(req.getBody().asString()).getJSONArray("characters").get(tempArrId).toString().replaceAll("[^0-9]", "");
        getCharacterData(tempCharId, character2);

    }

    public static void checkSpeciesLocation(String id) {
        getOriginChar(id);
        getLastCharOfLastEp(character1.getLastEp());
        try {
            Assertions.assertEquals(character1.getLocation(), character2.getLocation());
        } catch (AssertionFailedError e) {
            System.out.println("Локации не совпадают!\n"+
                     character1.getName() + ": " + character1.getLocation() + "\n"+
                     character2.getName() + ": " + character2.getLocation() + "\n");
        }
        try {
            Assertions.assertEquals(character1.getSpecies(), character2.getSpecies());
        } catch (AssertionFailedError e) {
            System.out.println("Расса не совпадает!\n"+
                    character1.getName() + ": " + character1.getSpecies() + "\n"+
                    character2.getName() + ": " + character2.getSpecies() + "\n");
        }
    }

}
