package testapp.utsav.testapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
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
    private Matrix matrix = new Matrix();
    private float scale = 1f;
    String iu;
    //private ScaleGestureDetector SGD;

    //public void getData(String x) {
      //  iu = x;
    //}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_imag);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            iu = extras.getString("iu");
        }
        img3 = (ImageView) findViewById(R.id.popimg);

        DisplayMetrics d = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(d);
        int width = d.widthPixels;

        int height = d.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .6));
        // b.setText(iu);
        Picasso.with(this).load(iu)
                .placeholder(R.drawable.ic_placeholder)   // optional
                .error(R.drawable.ic_error_fallback)
                .resize(400, 400)
                .into(img3);

        //SGD = new ScaleGestureDetector(this, new ScaleListener());
    }

   /* public boolean onTouchEvent(MotionEvent ev) {
        SGD.onTouchEvent(ev);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.

            SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();
            scale = Math.max(0.1f, Math.min(scale, 5.0f));

            matrix.setScale(scale, scale);
            img3.setImageMatrix(matrix);
            return true;
        }
    }
*/


    public void onClick(View v) {
        // TODO Auto-generated method stub

    }

}
