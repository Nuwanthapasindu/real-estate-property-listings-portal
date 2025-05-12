package com.replp.model;

import java.time.LocalDateTime;

public class SystemFile {
    private String id;
    private String name;
    private String path;
    private long size;
    private String type;
    private LocalDateTime createdAt;

    public SystemFile() {
    }

    public SystemFile(String id, String name, String path, long size, String type, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.size = size;
        this.type = type;
        this.createdAt = createdAt;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "File{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", size=" + size +
                ", type='" + type + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}


