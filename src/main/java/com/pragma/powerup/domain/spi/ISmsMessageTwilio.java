package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.SmsMessageModel;

import java.util.List;

public interface ISmsMessageTwilio {
    void sendSmsMessage(SmsMessageModel smsMessageModel);
}