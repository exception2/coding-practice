package com.satyendra.coding_practice.paypay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CityTemperatureStats {

    public static void main(String[] args) {
        String filePath = "city_temperatures.txt"; // Replace with your file path
        int chunkSize = 100000; // Number of lines to process per chunk

        Map<String, List<Double>> cityData = processFile(filePath, chunkSize);

        Map<String, String> cityStats = computeCityStats(cityData);

        // Print the results
        cityStats.forEach((city, stats) -> System.out.println(city + ": " + stats));
    }

    private static Map<String, List<Double>> processFile(String filePath, int chunkSize) {
        Map<String, List<Double>> aggregatedData = Collections.synchronizedMap(new HashMap<>());
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Future<Map<String, List<Double>>>> futures = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
                if (lines.size() == chunkSize) {
                    futures.add(executorService.submit(new DataProcessor(lines)));
                    lines = new ArrayList<>();
                }
            }
            // Process the remaining lines
            if (!lines.isEmpty()) {
                futures.add(executorService.submit(new DataProcessor(lines)));
            }

            // Aggregate results from all futures
            for (Future<Map<String, List<Double>>> future : futures) {
                Map<String, List<Double>> chunkResult = future.get();
                mergeData(aggregatedData, chunkResult);
            }

        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        return aggregatedData;
    }

    private static void mergeData(Map<String, List<Double>> aggregatedData, Map<String, List<Double>> chunkResult) {
        for (Map.Entry<String, List<Double>> entry : chunkResult.entrySet()) {
            aggregatedData.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).addAll(entry.getValue());
        }
    }

    private static Map<String, String> computeCityStats(Map<String, List<Double>> cityData) {
        Map<String, String> results = new HashMap<>();

        for (Map.Entry<String, List<Double>> entry : cityData.entrySet()) {
            String city = entry.getKey();
            List<Double> temps = entry.getValue();

            double minTemp = temps.stream().mapToDouble(Double::doubleValue).min().orElse(Double.NaN);
            double maxTemp = temps.stream().mapToDouble(Double::doubleValue).max().orElse(Double.NaN);
            double avgTemp = temps.stream().mapToDouble(Double::doubleValue).average().orElse(Double.NaN);

            results.put(city, String.format("%.1f/%.1f/%.1f", minTemp, maxTemp, avgTemp));
        }

        return results;
    }

    static class DataProcessor implements Callable<Map<String, List<Double>>> {
        private final List<String> lines;

        public DataProcessor(List<String> lines) {
            this.lines = lines;
        }

        @Override
        public Map<String, List<Double>> call() {
            Map<String, List<Double>> cityTemps = new HashMap<>();
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String city = parts[0].trim();
                    double temp;
                    try {
                        temp = Double.parseDouble(parts[1].trim());
                    } catch (NumberFormatException e) {
                        continue; // Skip invalid lines
                    }

                    cityTemps.computeIfAbsent(city, k -> new ArrayList<>()).add(temp);
                }
            }
            return cityTemps;
        }
    }
}

