package com.tranquyet.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TopicDTO extends BasedDTO<TopicDTO>{
    private String name;
}
