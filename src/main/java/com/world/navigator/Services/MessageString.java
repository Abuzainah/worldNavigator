package com.world.navigator.Services;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageString {
    private String value;

    public MessageString(){
        this.value = "";
    }

    public MessageString(String value){
        this.value = value;
    }
}
