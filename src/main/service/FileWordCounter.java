package main.service;

import main.model.enums.SpecialWord;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;

public class FileWordCounter {
    public static void processFile(String inputPath, String outputPath) throws IOException {

        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);

        String content = FileUtils.readFileToString(inputFile, "UTF-8");

        int totalCount = 0;

        for (SpecialWord word : SpecialWord.values()) {

            int count = StringUtils.countMatches(
                    StringUtils.upperCase(content),
                    word.name()
            );

            totalCount += count;

            String result = word.name() + ": " + count + System.lineSeparator();

            FileUtils.writeStringToFile(outputFile, result, "UTF-8", true); // append ✔
        }

        FileUtils.writeStringToFile(
                outputFile,
                "TOTAL: " + totalCount + System.lineSeparator() + "-----" + System.lineSeparator(),
                "UTF-8",
                true
        );
    }
}
