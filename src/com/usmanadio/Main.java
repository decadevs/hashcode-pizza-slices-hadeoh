package com.usmanadio;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        Path path = Paths.get("src/com/usmanadio/pizza.txt");
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            String[] pizzaArr = lines.get(0).split(" ");
            String[] slicesArr = lines.get(1).split(" ");
            int maximumSlices = Integer.parseInt(pizzaArr[0]);
            int sum = 0;
            ArrayList<Integer> indices = new ArrayList<>();
            int iterationLength = slicesArr.length - 1;

            for (int index = iterationLength; index >= 0; index--) {
                if (sum + Integer.parseInt(slicesArr[i]) > maximumSlices) {
                    continue;
                } else {
                    sum += Integer.parseInt(slicesArr[i]);
                    indices.add(index);
                }
            }
            Collections.reverse(indices);
            StringBuilder sb = new StringBuilder();
            indices.forEach(item -> {
                sb.append(item);
                sb.append(" ");
            });
            Path newPath = Paths.get("src/com/usmanadio/output.txt");
            OutputStream outputStream = Files.newOutputStream(newPath);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream))) {
                String noOfSlice = String.valueOf(indices.size());
                bufferedWriter.write(noOfSlice);
                bufferedWriter.write('\n');
                bufferedWriter.write(String.valueOf(sb));
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            Logger.getLogger(e.getMessage());
        }
    }
}
