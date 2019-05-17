package com.airtel.preprocessor;

import com.airtel.request.CommonWordRequest;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
* This class will sort files based on size so that file with minimum size is loaded first.
* */
@Service
public class FileOrderModificationPreprocessor {

    public void preprocess(CommonWordRequest commonWordRequest) {
        List<File> files = commonWordRequest.getFileList();
        Collections.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return new Long(o1.length()).compareTo(o2.length());
            }
        });
        files.remove(commonWordRequest.getMinimumWordFile());
        files.add(0, commonWordRequest.getMinimumWordFile());
    }
}
