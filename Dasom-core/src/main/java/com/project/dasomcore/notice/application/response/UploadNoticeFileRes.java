package com.project.dasomcore.notice.application.response;

public record UploadNoticeFileRes(String url) {
    public static UploadNoticeFileRes of(String url){
        return new UploadNoticeFileRes(url);
    }
}
