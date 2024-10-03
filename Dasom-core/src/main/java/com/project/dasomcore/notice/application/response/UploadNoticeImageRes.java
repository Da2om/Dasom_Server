package com.project.dasomcore.notice.application.response;

public record UploadNoticeImageRes(String url) {
    public static UploadNoticeImageRes of(String url){
        return new UploadNoticeImageRes(url);
    }
}
