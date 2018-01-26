package com.butchjgo.linkservice.uploadsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RequestData {
    private String remoteUrl;
    private String localPath;
    private String finalName;
    private String account;
    private String server;
    private int status;

    @Override
    public int hashCode() {
        return remoteUrl.concat(localPath).concat(finalName).concat(account).concat(server).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return hashCode() == obj.hashCode();
    }
}
