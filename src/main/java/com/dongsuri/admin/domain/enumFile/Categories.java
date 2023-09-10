package com.dongsuri.admin.domain.enumFile;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Categories {
    NOTICE("NOTICE", "공지사항"),
    DATA_ARCHIVE("DATA_ARCHIVE", "자료게시판"),
    PHOTO_GALLERY("PHOTO_GALLERY", "포토갤러리");

    private final String key;
    private final String title;
}
