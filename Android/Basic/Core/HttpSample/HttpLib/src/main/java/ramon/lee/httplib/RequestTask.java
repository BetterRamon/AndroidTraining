package ramon.lee.httplib;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * @Desc :
 * @Author : Ramon
 * @create 2021/3/21 21:18
 */
public class RequestTask extends AsyncTask<Void, Integer, Object> {
    Request request;

    public RequestTask(Request request) {
        this.request = request;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Void... voids) {
        try {
            HttpURLConnection connection =  HttpUrlConnectionUtil.execute(request);
            if (request.enableProgressUpdated) {
                return request.callback.parse(connection, new OnProgressUpdateListener() {
                    @Override
                    public void updateProgress(int curLen, int totalLen) {
                        publishProgress(curLen, totalLen);
                    }
                });
            } else {
                return request.callback.parse(connection);
            }
        } catch (Exception e) {
            return e;
        }
    }

    @Override
    protected void onPostExecute(Object o) {
        if (o instanceof Exception) {
            request.callback.onFailure((Exception) o);
        } else {
            request.callback.onSuccess(o);
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        request.callback.updateProgress(values[0], values[1]);
    }
}