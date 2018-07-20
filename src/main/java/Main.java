import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) {
        for (String s :getUserDate()) {
            System.out.println(s);

        }

    }
    public static String getJSON(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String[] getUserDate() {
        String jsin = null;
        try {
            jsin = getJSON("https://indodax.com/api/btc_idr/depth");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        TwitchAPI twitchAPI = gson.fromJson(jsin, TwitchAPI.class);
        Oderbook oderbook = new Oderbook();
        List<Lot> lotListask = new ArrayList<Lot>();
        List<Lot> lotListbit = new ArrayList<Lot>();

        for (String[] row : twitchAPI.getBuy()) {
            Lot ask = new Lot();
            ask.setPrice(Double.valueOf(row[0]));
            ask.setQuanity(Double.parseDouble(row[1]));
            lotListask.add(ask);
        }

        oderbook.setAsk(lotListask);

        for (String[] row : twitchAPI.getSell()) {
            Lot bid = new Lot();
            bid.setPrice(Double.valueOf(row[0]));
            bid.setQuanity(Double.valueOf(row[1]));
            lotListbit.add(bid);
        }
        oderbook.setBid(lotListbit);
        HashMap<String, Oderbook> oderbooks= new HashMap<String, Oderbook>();
        oderbooks.put("indodax.com", oderbook);
        return new String[]{

                "Buy " + Arrays.deepToString(twitchAPI.getBuy()),
                "Sale " + Arrays.deepToString(twitchAPI.getSell())

        };

    }

}
