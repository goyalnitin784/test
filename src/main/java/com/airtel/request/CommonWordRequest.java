package com.airtel.request;

import com.airtel.logging.MyLogger;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonWordRequest extends MapBasedRequest {

    static MyLogger logger = MyLogger.getLoggerObject(CommonWordRequest.class);

    List<String> filesPaths;
    List<File> fileList;
    File minimumWordFile;
    File currentProcessingFile;
    Map<String, String> currentProcessingFileMap = new HashMap<>(100000);

    boolean invalidRequest = false;

    public CommonWordRequest(HttpServletRequest httpServletRequest) {
        super(httpServletRequest);
        postProcessing();
    }

    public CommonWordRequest(String requestBody) {
        super(requestBody);
        postProcessing();
        for (String filepath : filesPaths) {
            fileList.add(new File(filepath));
        }
    }


    private void postProcessing() {
        filesPaths = new ArrayList<>();
        fileList = new ArrayList<>();
        try {
            String payLoad = this.requestBody;
            if (payLoad == null || payLoad.isEmpty()) {
                logger.error("Blank Request body came inside request");
                invalidRequest = true;
                return;
            }
            JsonArray payLoadObject = new JsonParser().parse(payLoad).getAsJsonArray();
            for (int i = 0; i < payLoadObject.size(); i++) {
                filesPaths.add(payLoadObject.get(i).getAsString());
            }
        } catch (Exception e) {
            logger.error("Exception came while parsing request with payload : " + this.requestBody, e);
            invalidRequest = true;

        }
    }

    public List<String> getFilesPaths() {
        return filesPaths;
    }

    public void setFilesPaths(List<String> filesPaths) {
        this.filesPaths = filesPaths;
    }

    public boolean isInvalidRequest() {
        return invalidRequest;
    }

    public void setInvalidRequest(boolean invalidRequest) {
        this.invalidRequest = invalidRequest;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public File getCurrentProcessingFile() {
        return currentProcessingFile;
    }

    public void setCurrentProcessingFile(File currentProcessingFile) {
        this.currentProcessingFile = currentProcessingFile;
    }

    public Map<String, String> getCurrentProcessingFileMap() {
        return currentProcessingFileMap;
    }

    public void setCurrentProcessingFileMap(Map<String, String> currentProcessingFileMap) {
        this.currentProcessingFileMap = currentProcessingFileMap;
    }

    public void putValueOnMap(String data) {
        if (data != null && !data.isEmpty()) {
            char[] chars = data.toCharArray();
            String str = "";
            for (int i = 0; i < chars.length; i++) {
                if ((chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z')) {
                    str += chars[i];
                }
            }
            currentProcessingFileMap.put(str.toLowerCase(), str);
        }
    }

    public File getMinimumWordFile() {
        return minimumWordFile;
    }

    public void setMinimumWordFile(File minimumWordFile) {
        this.minimumWordFile = minimumWordFile;
    }

    @Override
    public String toString() {
        return "CommonWordRequest{" +
                "filesPaths=" + filesPaths +
                '}';
    }
}
