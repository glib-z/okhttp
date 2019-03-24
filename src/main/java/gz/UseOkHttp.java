package gz;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class UseOkHttp {

    public static String status;

    public static String request(String url, Boolean verbose) {

        //String result = null;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();
            //result = response.body().string();
            status = response.message();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Error";
    }

}
