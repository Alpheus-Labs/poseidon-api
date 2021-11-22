package com.alpheus.poseidon.application.config;

import com.alpheus.poseidon.infraestructure.mqtt.IotConsumer;
import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.amazonaws.services.iot.client.sample.sampleUtil.PrivateKeyReader;
import com.amazonaws.services.iot.client.sample.sampleUtil.SampleUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.List;

@Configuration
public class MQTTAwsConfig {

    Logger log = LoggerFactory.getLogger(MQTTAwsConfig.class);
    @Autowired
    ResourceLoader resourceLoader;
    @Value("${aws.mqtt.client.endpoint}")
    private String clientEndpoint;
    @Value("${aws.mqtt.client.id}")
    private String clientId;
    @Value("${aws.mqtt.file.certificate}")
    private Resource certificateFile;
    @Value("${aws.mqtt.file.private_key}")
    private Resource privateKeyFile;
    @Value("${aws.mqtt.topic.name}")
    private String topicName;

    @Bean(name = "awsIotMqttClient")
    public AWSIotMqttClient awsIotMqttClient() throws IOException, GeneralSecurityException {
        var certificateFactory = CertificateFactory.getInstance("X.509");

        var certificateList = (List<Certificate>) certificateFactory.generateCertificates(certificateFile.getInputStream());
        var privateKey = PrivateKeyReader.getPrivateKey(privateKeyFile.getInputStream(), null);
        var keyStorePasswordPair = SampleUtil.getKeyStorePasswordPair(certificateList, privateKey);

        log.info("Certificates: {}", certificateList.size());
        log.info("Private key format: {}", privateKey.getFormat());

        return new AWSIotMqttClient(clientEndpoint, clientId, keyStorePasswordPair.keyStore, keyStorePasswordPair.keyPassword);
    }

    @Bean
    public void createAwsTopicConnection() throws AWSIotException, IOException, GeneralSecurityException {
        var client = awsIotMqttClient();
        var qos = AWSIotQos.QOS0;
        client.connect();

        var topic = new IotConsumer(topicName, qos);
        client.subscribe(topic);
    }
}
