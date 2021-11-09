package com.alpheus.poseidon.infraestructure.mqtt;

import com.alpheus.poseidon.application.request.SensorRequest;
import com.alpheus.poseidon.application.util.MessageUtils;
import com.amazonaws.services.iot.client.AWSIotMessage;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.amazonaws.services.iot.client.AWSIotTopic;

public class IotConsumer extends AWSIotTopic {

    public IotConsumer(String topic, AWSIotQos qos) {
        super(topic, qos);
    }

    @Override
    public void onMessage(AWSIotMessage awsIotMessage) {
        var sensorData = MessageUtils.parse(awsIotMessage, SensorRequest.class);
        System.out.println(sensorData.getMessage());
    }
}
