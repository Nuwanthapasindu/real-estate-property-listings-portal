package com.replp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.replp.util.CustomLocalDateTimeDeserializer;


import java.time.LocalDateTime;

public class ObjectMapperConfig {
    private final ObjectMapper OBJECT_MAPPER;

    public ObjectMapperConfig() {
        OBJECT_MAPPER = new ObjectMapper().registerModule(new JavaTimeModule());
        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDateTime.class, new CustomLocalDateTimeDeserializer());
        OBJECT_MAPPER.registerModule(module);
    }

    public ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }


}
