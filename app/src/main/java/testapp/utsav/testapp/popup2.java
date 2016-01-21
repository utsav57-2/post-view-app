package testapp.utsav.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Utsav's Pc on 21-01-2016.
 */
public class popup2 extends Activity{
    String iu;
    private TextView tvpost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popmsg);
        Bundle extras=getIntent().getExtras();
        if(extras!=null) {
            iu=extras.getString("iu");
        }

        DisplayMetrics d=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(d);
        int width=d.widthPixels;
        tvpost=(TextView)findViewById(R.id.tvpost);
         tvpost.setMovementMethod(new ScrollingMovementMethod());
        int height=d.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .6));
        tvpost.setText(iu);
    }
}

