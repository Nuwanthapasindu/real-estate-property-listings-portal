package com.replp.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String timestamp = p.getText();
        try {
            // Convert invalid timestamp to valid one
            return convertToValidTimestamp(timestamp);
        } catch (Exception e) {
            throw new IOException("Invalid timestamp format: " + timestamp, e);
        }
    }

    private LocalDateTime convertToValidTimestamp(String timestamp) {
        // Split and redistribute overflow seconds
        String[] parts = timestamp.split(" ");
        String datePart = parts[0];
        String timePart = parts[1];

        String[] dateComponents = datePart.split("-");
        String[] timeComponents = timePart.split(":");

        int year = Integer.parseInt(dateComponents[0]);
        int month = Integer.parseInt(dateComponents[1]);
        int day = Integer.parseInt(dateComponents[2]);

        int hour = Integer.parseInt(timeComponents[0]);
        int minute = Integer.parseInt(timeComponents[1]);
        int second = Integer.parseInt(timeComponents[2]);

        if (second >= 60) {
            int additionalMinutes = second / 60;
            second %= 60;
            minute += additionalMinutes;
        }

        if (minute >= 60) {
            int additionalHours = minute / 60;
            minute %= 60;
            hour += additionalHours;
        }

        return LocalDateTime.of(year, month, day, hour, minute, second);
    }
}

