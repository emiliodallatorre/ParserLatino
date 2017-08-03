package it.emiliodallatorre.parserlatino;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Emilio Dalla Torre on 21/07/2017.
 */
public class trova extends AppCompatActivity {
    public static void trova(String parola) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Document document = Jsoup.connect("http://www.dizionario-latino.com/dizionario-latino-italiano.php?parola=" + parola).userAgent("Mozilla").get();
            String nominativo = document.select("#myth").text();
            trova.gui.(nominativo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void gui(String risposta) {
        TextView responso = (TextView) findViewById(R.id.result);
        responso.setText(risposta);
    }
}
