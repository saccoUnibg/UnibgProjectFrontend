package com.unibg.UnibgProjectFrontend.utils;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonSerialize
public class ApiResponse {

    private String code;
    private String description;
    private String message;

    private Object object;

    public ApiResponse(){
    }

    public ApiResponse(ApiResponseCodes apiResponseCodes){
        this.code = apiResponseCodes.getCode();
        this.description = apiResponseCodes.getDescription();
    }
    public void setObject(Object object) {
        this.code = ApiResponseCodes.SUCCESS.getCode();
        this.description = ApiResponseCodes.SUCCESS.getDescription();
        this.object = object;
    }

    public void setErrorMessage(String errorMessage){
        this.code = ApiResponseCodes.ERROR.getCode();
        this.description = ApiResponseCodes.ERROR.getDescription();
        this.message = errorMessage;
    }
}
