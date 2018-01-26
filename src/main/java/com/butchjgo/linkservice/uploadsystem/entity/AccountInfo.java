package com.butchjgo.linkservice.uploadsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountInfo {
    private String username, password, server;

    public AccountInfo(String username, String password, String server) {
        this.username = username;
        this.password = password;
        this.server = server;
    }

    @Override
    public int hashCode() {
        return username.concat(server).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return hashCode() == obj.hashCode();
    }
}
