package mitu.com.youtubeshower;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private YoutubeVideoAdapter mAdaptervideos;
    private String[] mUrl =
            {"rtsp://r17---sn-vgqsens7.googlevideo.com/Cj0LENy73wIaNAm9v7OB4j1zixMYDSANFC2VNcFXMOCoAUIASARg19fTs8OHvYBXigELeU5aZlhQTndZMzAM/7E821D04A1BAD321BD47BD4DF73B74EF2DD57FBD.AF27B199E0EF4AF369D149A1072F631AED48DB75/yt6/1/video.3gp",
            "rtsp://r10---sn-vgqsen7k.googlevideo.com/Cj0LENy73wIaNAkn7anI_zT6LxMYDSANFC3PNcFXMOCoAUIASARg19fTs8OHvYBXigELeU5aZlhQTndZMzAM/817F99110FC470F1F8E6FD55D8C9FFEA0FDB1565.8A206C0400277AF7BE28CEF2C23E3DD7F6AC5B49/yt6/1/video.3gp",
            "rtsp://r11---sn-vgqsen7y.googlevideo.com/Cj0LENy73wIaNAlF0sg5fRE3PhMYDSANFC1CNcFXMOCoAUIASARg19fTs8OHvYBXigELeU5aZlhQTndZMzAM/C8745361F0A1E037840FDB755605716D2FAF3068.C9529493BB90CB9B60D9C1A57D9C70CC9804B78B/yt6/1/video.3gp",
            "rtsp://r2---sn-vgqs7ns7.googlevideo.com/Cj0LENy73wIaNAmS692OHx8DCxMYDSANFC2sNMFXMOCoAUIASARg19fTs8OHvYBXigELeU5aZlhQTndZMzAM/4FF5C2226DA7E096EFEAD127FDD3367A773AF5E3.A689568F0EFE1AD477BAC932A2F057DCC7279DDA/yt6/1/video.3gp"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rcRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        rcRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());

        rcRecyclerView.setLayoutManager(layoutManager);
        mAdaptervideos = new YoutubeVideoAdapter(Arrays.asList(mUrl),getBaseContext());
        rcRecyclerView.setAdapter(mAdaptervideos);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}
