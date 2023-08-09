package com.dongsuri.admin.domain.enumFile;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Class_Name {
    A_CLASS("A_CLASS", "A반"),
    B_CLASS("B_CLASS", "B반"),
    C_CLASS("C_CLASS", "C반");

    private final String key;
    private final String title;
}
