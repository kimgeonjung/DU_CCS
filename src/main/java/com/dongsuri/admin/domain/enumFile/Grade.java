package com.dongsuri.admin.domain.enumFile;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Grade {
    GRADE_1("GRADE_1", "1학년"),
    GRADE_2("GRADE_2", "2학년"),
    GRADE_3("GRADE_3", "3학년"),
    GRADE_4("GRADE_4", "4학년");


    private final String key;
    private final String title;
}
