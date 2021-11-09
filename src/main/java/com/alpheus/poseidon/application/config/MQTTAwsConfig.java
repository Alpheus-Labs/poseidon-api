package com.alpheus.poseidon.application.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQTTAwsConfig {

    @Value("${aws.mqtt.client.endpoint}")
    private String clientEndpoint;

    @Value("${aws.mqtt.client.id}")
    private String clientId;

    @Value("${aws.mqtt.file.certificate}")
    private String certificateFile;

    @Value("${aws.mqtt.file.private_key}")
    private String privateKeyFile;

}
