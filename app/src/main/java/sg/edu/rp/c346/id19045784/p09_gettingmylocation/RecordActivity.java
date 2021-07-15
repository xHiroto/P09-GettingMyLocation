package sg.edu.rp.c346.id19045784.p09_gettingmylocation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class RecordActivity extends AppCompatActivity {
    Button btnRefresh;
    TextView numOfLocation;
    ListView lv;
    ArrayList al;
    String folderLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        lv = findViewById(R.id.lv);
        numOfLocation = findViewById(R.id.tvLocation);
        btnRefresh = findViewById(R.id.btnRefresh);
        al = new ArrayList();

        folderLocation = getFilesDir().getAbsolutePath() + "/MyFolder";

                File targetFile = new File(folderLocation, "location.txt");

                if (targetFile.exists() == true){
                    String data = "";
                    try{
                        FileReader reader = new FileReader(targetFile);
                        BufferedReader br = new BufferedReader(reader);

                        String line = br.readLine();
                        while (line != null){
                            al.clear();
                            al.add(line + "\n");
                            line = br.readLine();

                        }
                        numOfLocation.setText(al.size());
                        br.close();
                        reader.close();

                    }
                    catch (Exception e) {
                        Toast.makeText(RecordActivity.this, "Failed to read!", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                    Log.d("Content", data);
                }
                numOfLocation.setText("Number of Location: " + al.size());
             ArrayAdapter<String> adapter = new ArrayAdapter<String>(RecordActivity.this, android.R.layout.simple_list_item_1, al);
                lv.setAdapter(adapter);




  }
}