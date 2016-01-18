package testapp.utsav.testapp;

/**
 * Created by Utsav's Pc on 10-01-2016.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.CustomViewHolder> {
    int expandc=-1;
  String TAG="Click";
    public  class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected ImageView imageView;
        protected TextView textView;
        protected TextView textView2;
        protected TextView textView3;
        protected TextView textView4;
        protected TextView textView5;
        protected TextView textView6;
        protected ImageView imageView2;
        protected LinearLayout linearLayout;
        public CustomViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            this.imageView = (ImageView) view.findViewById(R.id.thumbnail);
            this.textView= (TextView) view.findViewById(R.id.title);
            this.textView2= (TextView) view.findViewById(R.id.post);
            this.textView3= (TextView) view.findViewById(R.id.postdetail);
            this.textView4= (TextView) view.findViewById(R.id.venue);
            this.textView5= (TextView) view.findViewById(R.id.etime);
            this.textView6= (TextView) view.findViewById(R.id.time);
            this.imageView2= (ImageView) view.findViewById(R.id.postimage);
            this.linearLayout=(LinearLayout)view.findViewById(R.id.expand);
        }
        @Override
        public void onClick(View view) {
            CustomViewHolder holder = (CustomViewHolder) view.getTag();
            //String theString = mDataset.get(holder.getPosition());

            // Check for an expanded view, collapse if you find one
           /* if (expandc >= 0) {
                int prev = expandc;
                notifyItemChanged(prev);
            }
            // Set the current position to "expanded"
            expandc = holder.getPosition();
            notifyItemChanged(expandc);
            */
            Log.d(TAG, "onClick " + getPosition());
        }
    }

    private List<FeedItem> feedItemList;
    private Context mContext;

    public MyRecyclerAdapter(Context context, List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }
    private String[] mDataset;

    public MyRecyclerAdapter(String[] dataset) {
        mDataset = dataset;
    }
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        FeedItem feedItem = feedItemList.get(i);

        //Download image using picasso library by square
      Picasso.with(mContext).load(feedItem.getPostimg())
               .into(customViewHolder.imageView2);
//.error(R.drawable.placeholder)
        //.placeholder(R.drawable.placeholder)
        //Setting text view title
        customViewHolder.textView.setText(Html.fromHtml(feedItem.getTitle()));
        customViewHolder.textView2.setText(Html.fromHtml("Event Name:"+feedItem.getPost()));
        customViewHolder.textView3.setText(Html.fromHtml(feedItem.getPostdetail()));
        customViewHolder.textView4.setText(Html.fromHtml("Venue:"+feedItem.getVenue()));
        customViewHolder.textView5.setText(Html.fromHtml("Time:"+feedItem.getEtime()));
        customViewHolder.textView6.setText(Html.fromHtml(feedItem.getPosttime()));
        /*if (i == expandc) {
            customViewHolder.linearLayout.setVisibility(View.VISIBLE);
        } else {
            customViewHolder.linearLayout.setVisibility(View.GONE);
        }*/

    }



    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

}
