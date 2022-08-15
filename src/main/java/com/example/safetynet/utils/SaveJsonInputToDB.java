package com.example.safetynet.utils;

import com.example.safetynet.model.FireStation;
import com.example.safetynet.model.MedicalRecord;
import com.example.safetynet.model.Person;
import com.example.safetynet.repository.FireStationRepository;
import com.example.safetynet.repository.MedicalRecordsRepostiory;
import com.example.safetynet.repository.PersonRepository;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@Service
public class SaveJsonInputToDB {

    private final PersonRepository personRepository;
    private final FireStationRepository fireStationRepository;
    private final MedicalRecordsRepostiory medicalRecordsRepostiory;


    @Autowired
    public SaveJsonInputToDB(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordsRepostiory medicalRecordsRepostiory) {
        this.personRepository = personRepository;
        this.fireStationRepository = fireStationRepository;
        this.medicalRecordsRepostiory = medicalRecordsRepostiory;
    }


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
                    switch (i) {
                        case 0:
                            Person person = gson.fromJson(String.valueOf(jsonArray.getJSONArray(i).getJSONObject(j)), Person.class);
                            personRepository.save(person);
                            break;
                        case 1:
                            FireStation fireStation = gson.fromJson(String.valueOf(jsonArray.getJSONArray(i).getJSONObject(j)), FireStation.class);
                            fireStationRepository.save(fireStation);
                            break;
                        case 2:
                            MedicalRecord medicalRecord = gson.fromJson(String.valueOf(jsonArray.getJSONArray(i).getJSONObject(j)), MedicalRecord.class);
                            medicalRecordsRepostiory.save(medicalRecord);
                            break;
                    }
                }
            }
        } catch (Exception e) {
        }

    }

}
