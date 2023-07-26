package com.dongsuri.admin.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Categorys {
    NOTICE("Notice", "공지사항"),
    DATA_ARCHIVE("DataArchive", "자료게시판"),
    PHOTO_GALLERY("PhotoGallery", "포토갤러리");

    private final String key;
    private final String title;
}
