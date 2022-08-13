package com.example.safetynet.utils;

import com.example.safetynet.model.Person;
import com.example.safetynet.repository.PersonRepository;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SaveJsonInputToDB {

    private final PersonRepository personRepository;

    @Autowired
    public SaveJsonInputToDB(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public void gettingAndSavingDataFromJsonInputIntoDB() throws InterruptedException, IOException {
        String url = "https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        Gson gson = new Gson();

        JSONObject object1 = new JSONObject(response.body());
        JSONArray array = object1.names();
        JSONArray persons = object1.toJSONArray(array);
        for(int i = 0; i < persons.length(); i++) {
            Person person = gson.fromJson(String.valueOf(persons.getJSONArray(0).getJSONObject(i)), Person.class);
            personRepository.save(person);
        }


    }

}
