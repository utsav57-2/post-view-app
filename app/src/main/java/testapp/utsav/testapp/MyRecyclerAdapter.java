package testapp.utsav.testapp;

/**
 * Created by Utsav's Pc on 10-01-2016.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.CustomViewHolder> {
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageView;
        protected TextView textView;
        protected TextView textView2;
        protected ImageView imageView2;
        public CustomViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.thumbnail);
            this.textView= (TextView) view.findViewById(R.id.title);
            this.textView2= (TextView) view.findViewById(R.id.post);
            this.imageView2= (ImageView) view.findViewById(R.id.postimage);
        }
    }

    private List<FeedItem> feedItemList;
    private Context mContext;

    public MyRecyclerAdapter(Context context, List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
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
        customViewHolder.textView2.setText(Html.fromHtml(feedItem.getPost()));
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }
}
