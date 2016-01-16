package testapp.utsav.testapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Utsav's Pc on 10-01-2016.
 */
public class CustomViewHolder extends RecyclerView.ViewHolder {
    protected ImageView imageView1;
    protected TextView textView;
    protected TextView textView2;
    protected ImageView imageView2;
    public CustomViewHolder(View view) {
        super(view);
        this.imageView1 = (ImageView) view.findViewById(R.id.thumbnail);
        this.textView= (TextView) view.findViewById(R.id.title);
        this.textView2= (TextView) view.findViewById(R.id.post);
        this.imageView2= (ImageView) view.findViewById(R.id.postimage);
    }
}
