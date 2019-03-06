package com.phantom.util;

import org.springframework.util.StringUtils;

import java.util.Base64;
import java.io.*;
import java.util.zip.*;

public class ZipUtils {

    public static String getFastZipped(String str) {
        if(StringUtils.isEmpty(str)){
            return str;
        }
        byte[] compressedBytes = ZipUtils.fastCompression(str);
        byte[] encoded = Base64.getEncoder().encode(compressedBytes);
        return new String(encoded);
    }

    public static String getFastUnzipped(String compressedString) {
        if(StringUtils.isEmpty(compressedString)){
            return compressedString;
        }
        byte[] decodedBytes = Base64.getDecoder().decode(compressedString.getBytes());
        return ZipUtils.fastDecompress(decodedBytes);
    }

    public static String getZipped(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        String retStr = str;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
        GZIPOutputStream zip;
        try {
            zip = new GZIPOutputStream(out);
            IO.dump(in, zip);
            zip.close();
            retStr = new String(Base64.getEncoder().encode(out.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return retStr;
    }

    public static String getUnZipped(InputStream in) {
        String retStr = "";
        try {
            InputStream gzipStream = new GZIPInputStream(in);
            Reader decoder = new InputStreamReader(gzipStream);
            BufferedReader buffered = new BufferedReader(decoder);
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = buffered.readLine()) != null) {
                sb.append(line);
            }
            retStr = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retStr;
    }

    public static String getUnZippedBase64(String str) {
        if (str != null)
            if (str.length() > 1)
                return getUnZipped(new ByteArrayInputStream(Base64.getDecoder().decode(str)));
            else return str;
        else
            return str;
    }

    public static byte[] fastCompression(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        byte[] data = str.getBytes();
        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_SPEED);
        deflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        deflater.finish();
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer); // returns the generated code... index
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (Exception e) {

        }
        byte[] output = outputStream.toByteArray();
        return output;
    }

    public static String fastDecompress(byte[] data) {
        try {
            Inflater inflater = new Inflater();
            inflater.setInput(data);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
            byte[] buffer = new byte[1024];
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
            byte[] output = outputStream.toByteArray();
            return new String(output);
        } catch (Exception e) {
            return null;
        }
    }


    public static byte[] compressByteArray(byte[] data) throws IOException {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(
                data.length);

        deflater.finish();
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer); // returns the generated
            // code... index
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        byte[] output = outputStream.toByteArray();

        deflater.end();
        return output;
    }

    public static byte[] decompressByteArray(byte[] data) throws IOException,
            DataFormatException {
        Inflater inflater = new Inflater();
        inflater.setInput(data);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(
                data.length);
        byte[] buffer = new byte[1024];
        while (!inflater.finished()) {
            int count = inflater.inflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        byte[] output = outputStream.toByteArray();

        inflater.end();
        return output;
    }
}
