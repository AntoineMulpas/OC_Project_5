package com.example.safetynet.utils;

import com.example.safetynet.model.FireStation;
import com.example.safetynet.model.MedicalRecord;
import com.example.safetynet.model.Person;
import com.example.safetynet.repository.FireStationRepository;
import com.example.safetynet.repository.MedicalRecordsRepostiory;
import com.example.safetynet.repository.PersonRepository;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@Service
public class SaveJsonInputToDB {


    private final PersonRepository personRepository;
    private final FireStationRepository fireStationRepository;
    private final MedicalRecordsRepostiory medicalRecordsRepostiory;
    private static final Logger logger = LogManager.getLogger(SaveJsonInputToDB.class);



    @Autowired
    public SaveJsonInputToDB(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordsRepostiory medicalRecordsRepostiory) {
        this.personRepository = personRepository;
        this.fireStationRepository = fireStationRepository;
        this.medicalRecordsRepostiory = medicalRecordsRepostiory;
    }


    @PostConstruct
    public void gettingAndSavingDataFromJsonInputIntoDB() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/input/json_input"));

            Gson gson = new Gson();
            Map <?, ?> map = gson.fromJson(reader, Map.class);

            JSONObject object1 = new JSONObject(map);
            JSONArray namesOfJSONObject = object1.names();
            JSONArray jsonArray = object1.toJSONArray(namesOfJSONObject);
            for (int i = 0; i < jsonArray.length(); i++) {
                for (int j = 0; j < jsonArray.getJSONArray(i).length(); j++) {
                    switch (namesOfJSONObject.get(i).toString()) {
                        case "persons":
                            Person person = gson.fromJson(String.valueOf(jsonArray.getJSONArray(i).getJSONObject(j)), Person.class);
                            personRepository.save(person);
                            break;
                        case "firestations":
                            FireStation fireStation = gson.fromJson(String.valueOf(jsonArray.getJSONArray(i).getJSONObject(j)), FireStation.class);
                            fireStationRepository.save(fireStation);
                            break;
                        case "medicalrecords":
                            MedicalRecord medicalRecord = gson.fromJson(String.valueOf(jsonArray.getJSONArray(i).getJSONObject(j)), MedicalRecord.class);
                            medicalRecordsRepostiory.save(medicalRecord);
                            break;
                    }
                }
            }
            logger.info("Data from Json saved into DB with success.");
        } catch (RuntimeException | IOException e) {
            logger.error(e);
        }

    }

}
