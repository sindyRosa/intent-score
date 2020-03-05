package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {

    //VARIABEL KEY
    public  static  final  String WINNER = "winner";

    //VARIABEL
    private TextView homeTeamName;
    private TextView awayTeamName;
    private MainActivity main;
    private ImageView logoHome;
    private ImageView logoAway;
    private Integer skorHome;
    private Integer skorAway;
    private TextView poinHome;
    private TextView pointAway;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        homeTeamName = findViewById(R.id.txt_home);
        awayTeamName = findViewById(R.id.txt_away);
        logoHome = findViewById(R.id.home_logo);
        logoAway = findViewById(R.id.away_logo);
        poinHome = findViewById(R.id.score_home);
        pointAway = findViewById(R.id.score_away);
        poinHome.setText("0");
        pointAway.setText("0");
        skorHome = 0;
        skorAway =0;

        Bundle extras = getIntent().getExtras();
        Bundle bundle = getIntent().getExtras();

        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        if(bundle != null){
            String homename = getIntent().getExtras().getString("homeTeam");
            String awayname = getIntent().getExtras().getString("awayTeam");
            homeTeamName.setText(homename);
            awayTeamName.setText(awayname);
        }
        Bitmap logohome = extras.getParcelable("logohome");
        logoHome.setImageBitmap(logohome);

        Bitmap logoaway = extras.getParcelable("logoaway");
        logoAway.setImageBitmap(logoaway);

    }

    //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
    public void HandleSkorHome(View view) {
        skorHome++;
        poinHome.setText(String.valueOf(skorHome));
    }

    public void HandleSkorAway(View view) {
        skorAway++;
        pointAway.setText(String.valueOf(skorAway));
    }
    // 3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    public void HandleHasil(View view) {
        String winner;
        if(skorAway < skorHome){
            winner = homeTeamName.getText().toString();
        }else if(skorHome < skorAway){
            winner = awayTeamName.getText().toString();
        }else{
            winner ="Draw";
        }

        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra(WINNER,winner);
        startActivity(intent);

    }




}
