package testapp.utsav.testapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Utsav's Pc on 20-01-2016.
 */
public class popup extends Activity implements View.OnClickListener {
    private Button b;
    private ImageView img3;
    String iu;
    public void getData(String x)
    {
        iu=x;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_imag);
        Bundle extras=getIntent().getExtras();
        if(extras!=null) {
        iu=extras.getString("iu");
        }
        img3=(ImageView)findViewById(R.id.popimg);
        DisplayMetrics d=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(d);
        int width=d.widthPixels;

                int height=d.heightPixels;
       getWindow().setLayout((int)(width*.8),(int)(height*.6));
       // b.setText(iu);
        Picasso.with(this).load(iu)
                .placeholder(R.drawable.ic_placeholder)   // optional
                .error(R.drawable.ic_error_fallback)
                .resize(400,400)
                .into(img3);

    }

    public void onClick(View v) {
        // TODO Auto-generated method stub

    }

}
