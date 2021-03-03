package com.world.navigator.Services;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class DeliveringMessages {
    HashMap<String, String> mailbox = new HashMap<>();

    public void putMessageInMailbox(String receiver, String message){
        mailbox.put(receiver, message);
    }

    public String getMessageFromMailbox(String receiver){
        String message;
        if(mailbox.containsKey(receiver)) {
            message = mailbox.get(receiver);
            mailbox.remove(receiver);
        }
        else message = "";

        return message;
    }
}
