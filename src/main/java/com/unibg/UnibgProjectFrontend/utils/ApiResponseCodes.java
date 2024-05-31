package com.unibg.UnibgProjectFrontend.utils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

@JsonSerialize
@Getter
public enum ApiResponseCodes{

    SUCCESS("200","Success"),
    ERROR("999","Error");

    private String code;
    private String description;

    private ApiResponseCodes(String code, String description) {
        this.code = code;
        this.description = description;
    }

}

