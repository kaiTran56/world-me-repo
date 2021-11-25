package com.tranquyet.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PublicVideoDTO extends BasedDTO<PublicVideoDTO> {

    private String titleVideo;

    private String description;

    private String content;

    private String duration;

    private String linkVideo;

    private String linkImage;

}
