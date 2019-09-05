package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseEventFormData {

    private EventFormData formData;

    private EventApproval eventApproval;

}
