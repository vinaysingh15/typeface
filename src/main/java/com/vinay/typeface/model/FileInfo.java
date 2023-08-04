package com.vinay.typeface.model;

import java.time.LocalDateTime;

public class FileInfo {
    private String name;
    private LocalDateTime createdTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}

