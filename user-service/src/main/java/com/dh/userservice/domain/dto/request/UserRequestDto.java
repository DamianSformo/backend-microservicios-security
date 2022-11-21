package com.dh.userservice.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserRequestDto {

    @Schema(example = "avatar")
    private String avatar;
}
