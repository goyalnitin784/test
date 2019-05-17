package com.airtel.decorator;

import com.airtel.logging.MyLogger;
import com.airtel.request.CommonWordRequest;
import com.airtel.response.CommonWordResponse;

import java.io.File;
import java.io.RandomAccessFile;

public class FileLoadingDecorator implements BaseDecorator {

    MyLogger myLogger = MyLogger.getLoggerObject(this.getClass());

    public void process(CommonWordRequest commonWordRequest, CommonWordResponse commonWordResponse) {
        File file = commonWordRequest.getCurrentProcessingFile();
        if(file==null){
            commonWordRequest.setCurrentProcessingFile(commonWordRequest.getFileList().get(0));
            file = commonWordRequest.getCurrentProcessingFile();
        }
        long maxLength = file.length();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file.getAbsolutePath(), "r");
            int start = 0;
            byte[] bytes = null;
            if (maxLength <= 1024) {
                bytes = new byte[(int) maxLength];
                randomAccessFile.read(bytes, start, (int) maxLength);
            } else {
                bytes = new byte[1024];
                randomAccessFile.read(bytes, start, 1024);
            }

            String data = new String(bytes);
            String[] dataAfterSplit = data.split(" ");
            String lastWord = dataAfterSplit[dataAfterSplit.length - 1];
            for (int initial = 0; initial < dataAfterSplit.length - 1; initial++) {
                commonWordRequest.putValueOnMap(dataAfterSplit[initial]);
            }
            start = 1024;
            long pendingCharLength = maxLength - start;
            if (pendingCharLength < 0) {
                commonWordRequest.putValueOnMap(lastWord);
            }

            while (start < maxLength && pendingCharLength > 0) {
                int arrLength = 0;
                if (pendingCharLength < 1024) {
                    arrLength = (int) pendingCharLength;
                } else {
                    arrLength = 1024;
                }
                bytes = new byte[arrLength];
                randomAccessFile.read(bytes, 0, arrLength);
                data = new String(bytes);
                dataAfterSplit = data.split(" ");
                if (dataAfterSplit[0] == "") {
                    commonWordRequest.putValueOnMap(lastWord);
                } else {
                    dataAfterSplit[0] = lastWord + dataAfterSplit[0];
                }
                for (int initial = 0; initial < dataAfterSplit.length - 1; initial++) {
                    String word = dataAfterSplit[initial];
                    commonWordRequest.putValueOnMap(word);
                }
                lastWord = dataAfterSplit[dataAfterSplit.length - 1];
                start = start + arrLength;
                pendingCharLength = maxLength - start;
            }
        } catch (Exception e) {
            myLogger.error("Exception came while parsing request with files : " + commonWordRequest.toString(), e);
        }
    }

}
