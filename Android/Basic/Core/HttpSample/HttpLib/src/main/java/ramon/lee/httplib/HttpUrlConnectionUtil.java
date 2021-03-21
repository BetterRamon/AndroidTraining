package ramon.lee.httplib;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc :
 * @Author : Ramon
 * @create 2021/3/21 20:04
 */
public class HttpUrlConnectionUtil {

    public static String get(String url, Map<String, String> header) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.setReadTimeout(15 * 3000);
        connection.setConnectTimeout(15 * 3000);
        addHeader(connection, header);
        int state = connection.getResponseCode();
        if (state == HttpURLConnection.HTTP_OK) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream is = connection.getInputStream();
            byte[] buffer = new byte[2048];
            int len;
            while ((len = is.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            is.close();
            out.flush();
            out.close();
            return new String(out.toByteArray());
        }
        return null;
    }

    public static String post(String url, String content, Map<String, String> header) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.setReadTimeout(15 * 3000);
        connection.setConnectTimeout(15 * 3000);
        connection.setDoOutput(true);

        addHeader(connection, header);
        int state = connection.getResponseCode();
        if (state == HttpURLConnection.HTTP_OK) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream is = connection.getInputStream();
            byte[] buffer = new byte[2048];
            int len;
            while ((len = is.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            is.close();
            out.flush();
            out.close();
            return new String(out.toByteArray());
        }
        return null;
    }

    private static void addHeader(HttpURLConnection connection, Map<String, String> header) {
        if (header == null || header.size() == 0) {
            return;
        }
        for (Map.Entry<String, String> entry: header.entrySet()) {
            connection.addRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}