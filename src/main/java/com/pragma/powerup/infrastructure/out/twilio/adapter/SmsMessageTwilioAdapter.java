package com.pragma.powerup.infrastructure.out.twilio.adapter;

import com.pragma.powerup.domain.model.SmsMessageModel;
import com.pragma.powerup.domain.spi.ISmsMessageTwilio;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@RequiredArgsConstructor
@Slf4j
public class SmsMessageTwilioAdapter implements ISmsMessageTwilio {

    @Value("${TWILIO_ACCOUNT_SID}")
    private String accountSid;
    @Value("${TWILIO_AUTH_TOKEN}")
    private String authToken;
    @Value("${TWILIO_FROM_PHONE_NUMBER}")
    private String fromPhoneNumber;


    @Override
    public void sendSmsMessage(SmsMessageModel smsMessageModel) {
        Twilio.init(accountSid, authToken);
        Message message = Message.creator(
                        new PhoneNumber(smsMessageModel.getNumber()),
                        new PhoneNumber(fromPhoneNumber),
                        smsMessageModel.getMessage()).
                create();

        log.info(message.getSid());
    }
}