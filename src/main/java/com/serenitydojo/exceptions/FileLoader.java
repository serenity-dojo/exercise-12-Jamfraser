package com.serenitydojo.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class FileLoader {
    public String readHelloWorld() throws IOException {
        // use readString to read the file and return the string contained within
        return Files.readString(Paths.get("src/main/resources/hello.txt"));
    }

    public Boolean fileContainsText(String filename, String expectedText) {
        String path = "src/main/resources/" + filename;

        try {
            String fileContent = Files.readString(Paths.get(path));
            return fileContent.contains(expectedText);
        } catch (NoSuchFileException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    public Boolean fileHasText(String filename, String expectedText) {
        String path = "src/main/resources/" + filename;

        try {
            String fileContent = Files.readString(Paths.get(path));
            if (fileContent.contains(expectedText)) {
                return true;
            } else {
                throw new MissingWelcomeFileException("File does not contain the expected text: " + expectedText);
            }
        } catch (NoSuchFileException e) {
            throw new MissingWelcomeFileException("File not found: " + filename, e);
        } catch (IOException e) {
            throw new MissingWelcomeFileException("Error reading file: " + filename, e);
        }
    }

}
