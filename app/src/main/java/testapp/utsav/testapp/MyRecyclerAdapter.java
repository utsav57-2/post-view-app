package testapp.utsav.testapp;

/**
 * Created by Utsav's Pc on 10-01-2016.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.CustomViewHolder> implements View.OnClickListener{
    int expandc=-1;
  String TAG="Click";
    public  class CustomViewHolder extends RecyclerView.ViewHolder  {

        protected ImageView imageView;
        protected TextView textView;
        protected TextView textView2;
        protected TextView textView3;
        protected TextView textView4;
        protected TextView textView5;
        protected TextView textView6;
        protected TextView textView7;
        protected ImageView imageView2;
       protected  LinearLayout ll;
        protected LinearLayout linearLayout;
        protected CardView cv;
        protected Button button1;
        public CustomViewHolder(View view) {
            super(view);
            this.cv=(CardView)view.findViewById(R.id.card);
            this.ll=(LinearLayout)view.findViewById(R.id.llay);
            this.imageView = (ImageView) view.findViewById(R.id.thumbnail);
            this.textView= (TextView) view.findViewById(R.id.title);
            this.textView2= (TextView) view.findViewById(R.id.post);
            this.textView3= (TextView) view.findViewById(R.id.postdetail);
            this.textView4= (TextView) view.findViewById(R.id.venue);
            this.textView5= (TextView) view.findViewById(R.id.etime);
            this.textView6= (TextView) view.findViewById(R.id.time);
            this.textView7= (TextView) view.findViewById(R.id.edate);
            this.imageView2= (ImageView) view.findViewById(R.id.postimage);
            this.button1=(Button)view.findViewById(R.id.popclose);
            this.linearLayout=(LinearLayout)view.findViewById(R.id.expand);
        }



    }

    private List<FeedItem> feedItemList;
    private Context mContext;
    private ArrayList<String> mDataset;
    public MyRecyclerAdapter(Context context, List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        viewHolder.cv.setOnClickListener(MyRecyclerAdapter.this);
        viewHolder.cv.setTag(viewHolder);
        viewHolder.imageView2.setOnClickListener(MyRecyclerAdapter.this);
        viewHolder.imageView2.setTag(viewHolder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder customViewHolder,final int i) {
        FeedItem feedItem = feedItemList.get(i);

        //Download image using picasso library by square
      Picasso.with(mContext).load(feedItem.getPostimg())
               .into(customViewHolder.imageView2);
//.error(R.drawable.placeholder)
        //.placeholder(R.drawable.placeholder)
        //Setting text view title
        customViewHolder.textView.setText(Html.fromHtml(" "+feedItem.getTitle()));
        customViewHolder.textView2.setText(Html.fromHtml("Event Name:"+feedItem.getPost()));
        customViewHolder.textView3.setText(Html.fromHtml(" "+feedItem.getPostdetail()));
        customViewHolder.textView4.setText(Html.fromHtml(" Venue: "+feedItem.getVenue()));
        customViewHolder.textView5.setText(Html.fromHtml(" Time: "+feedItem.getEtime()));
        customViewHolder.textView6.setText(Html.fromHtml(" " + feedItem.getPosttime()));
        customViewHolder.textView7.setText(Html.fromHtml(" Date: " + feedItem.getEdate()));
       /* customViewHolder.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow a=new popupWindow();
                a;
            }
        });*/

            customViewHolder.cv.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    if (expandc >= 0) {
                        int prev = expandc;
                        notifyItemChanged(prev);
                    }
                    // Set the current position to "expanded"

                    expandc = customViewHolder.getPosition();
                    notifyItemChanged(expandc);
                    if (i == expandc) {
                        customViewHolder.linearLayout.setVisibility(View.GONE);
                    } else {
                        customViewHolder.linearLayout.setVisibility(View.VISIBLE);
                    }


                }

            });

        if (i == expandc) {
            customViewHolder.linearLayout.setVisibility(View.VISIBLE);
        } else {
            customViewHolder.linearLayout.setVisibility(View.GONE);
        }

    }
    @Override
    public void onClick(View view) {
        CustomViewHolder holder = (CustomViewHolder) view.getTag();
     //   String theString = mDataset.get(holder.getPosition());

        // Check for an expanded view, collapse if you find one
        if (expandc >= 0) {

            int prev = expandc;
            notifyItemChanged(prev);
        }
        // Set the current position to "expanded"
        expandc = holder.getPosition();
        notifyItemChanged(expandc);

       // Toast.makeText(mContext, "Clicked: "+theString, Toast.LENGTH_SHORT).show();
    }


    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

}
