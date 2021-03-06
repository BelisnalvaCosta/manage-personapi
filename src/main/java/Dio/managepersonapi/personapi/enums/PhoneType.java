package Dio.Santander.managepersonapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum PhoneType {

    HOME(description: "Home");
    private description;

    MOBILE(description: "Mobile");
    COMMERCIAL(description: "Commercial");

    private final String description;
}
