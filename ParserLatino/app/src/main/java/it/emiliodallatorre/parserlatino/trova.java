package it.emiliodallatorre.parserlatino;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Emilio Dalla Torre on 21/07/2017.
 */
public class trova extends Activity {
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    private Context context;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String ricerca = getIntent().getStringExtra("ricerca");
        StrictMode.setThreadPolicy(policy);
        Document document = null;
        TextView art = (TextView) findViewById(R.id.result);
        try {
            document = Jsoup.connect("http://www.dizionario-latino.com/dizionario-latino-italiano.php?parola=" + ricerca).userAgent("Mozilla").get();
            String divs = document.select("#myth").text();
            art.setText(divs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
