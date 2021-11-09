package com.alpheus.poseidon.application.config;

import com.alpheus.poseidon.infraestructure.mqtt.IotConsumer;
import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.amazonaws.services.iot.client.sample.sampleUtil.SampleUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
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

    @Value("${aws.mqtt.topic.name}")
    private String topicName;

    @Bean(name = "awsIotMqttClient")
    public AWSIotMqttClient awsIotMqttClient() throws AWSIotException {
        SampleUtil.KeyStorePasswordPair keyStorePasswordPair = SampleUtil.getKeyStorePasswordPair(certificateFile, privateKeyFile);
        AWSIotMqttClient client = new AWSIotMqttClient(clientEndpoint, clientId, keyStorePasswordPair.keyStore, keyStorePasswordPair.keyPassword);

        return client;
    }

    @Bean
    public void createAwsTopicConnection() throws AWSIotException {
        var client = awsIotMqttClient();
        var qos = AWSIotQos.QOS0;
        client.connect();

        var topic = new IotConsumer(topicName, qos);
        client.subscribe(topic);
    }
}
