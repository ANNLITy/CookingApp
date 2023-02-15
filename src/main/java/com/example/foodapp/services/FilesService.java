package com.example.foodapp.services;



public interface FilesService {

    boolean saveToFile(String json);

    String reedFromFile();

    boolean cleanDataFile();


}