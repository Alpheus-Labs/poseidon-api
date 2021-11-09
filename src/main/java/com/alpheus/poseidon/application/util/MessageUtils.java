package com.alpheus.poseidon.application.util;

import com.amazonaws.services.iot.client.AWSIotMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.nio.charset.StandardCharsets;

@UtilityClass
public class MessageUtils {
    @SneakyThrows
    public <T> T parse(AWSIotMessage awsIotMessage, Class<T> targetClass) {
        var data = new String(awsIotMessage.getPayload(), StandardCharsets.UTF_8);
        var mapper = new ObjectMapper();
        try {
            return mapper.readValue(data, targetClass);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
