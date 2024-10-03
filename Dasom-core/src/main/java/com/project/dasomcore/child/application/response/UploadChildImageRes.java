package com.project.dasomcore.child.application.response;

public record UploadChildImageRes(String url) {
    public static UploadChildImageRes of(String url){
        return new UploadChildImageRes(url);
    }
}
