package com.primehub.primecardadmin.dto;

public class FileUploadResponseDTO {

    private String fileName;
    private String fileUrl;
    private String fileType;
    private long size;
    
    public FileUploadResponseDTO() {}
    
    public FileUploadResponseDTO(String fileName, String fileUrl, String fileType, long size) {
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.fileType = fileType;
        this.size = size;
    }
    
    // Getters and Setters
    public String getFileName() {
        return fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public String getFileUrl() {
        return fileUrl;
    }
    
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
    
    public String getFileType() {
        return fileType;
    }
    
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    
    public long getSize() {
        return size;
    }
    
    public void setSize(long size) {
        this.size = size;
    }
}