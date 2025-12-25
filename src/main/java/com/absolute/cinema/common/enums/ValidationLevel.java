package com.absolute.cinema.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ValidationLevel {
    ONE(1, "1"),
    TWO(2, "2"),
    THREE(3, "3");

    private final int number;
    private final String formatedNumber;

}
