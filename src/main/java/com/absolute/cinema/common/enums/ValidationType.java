package com.absolute.cinema.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ValidationType {

    COMPLIANCE("compliance"),
    PREMIUM("premium"),
    STANDARD("standard");

    private final String name;
}
