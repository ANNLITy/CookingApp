package com.example.foodapp.services;


import java.io.File;
import java.nio.file.Path;

import java.io.File;
import java.nio.file.Path;

public interface FilesService {

    boolean saveToFile(String json, String dataFileName);

    String reedFromFile(String dataFileName);

    boolean cleanDataFile(String dataFileName);

    Path createTempFile(String suffix);

    File getDataFile(String dataFileName);
}