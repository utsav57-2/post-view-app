package testapp.utsav.testapp;

/**
 * Created by Utsav's Pc on 10-01-2016.
 */

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
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
        protected ValueAnimator mAnimator;
        protected ImageView img3;
        protected LinearLayout ll2;
        protected CardView cv;

        protected TextView extv;
        public CustomViewHolder(View view) {
            super(view);
            this.cv=(CardView)view.findViewById(R.id.card);
            this.ll2=(LinearLayout)view.findViewById(R.id.llay);
            this.imageView = (ImageView) view.findViewById(R.id.thumbnail);
            this.textView= (TextView) view.findViewById(R.id.title);
            this.textView2= (TextView) view.findViewById(R.id.post);
           // this.textView3= (TextView) view.findViewById(R.id.postdetail);
            this.textView4= (TextView) view.findViewById(R.id.venue);
            this.img3=(ImageView)view.findViewById(R.id.popimg);
            this.textView5= (TextView) view.findViewById(R.id.etime);
            this.textView6= (TextView) view.findViewById(R.id.time);
            this.textView7= (TextView) view.findViewById(R.id.edate);
            this.extv=(TextView)view.findViewById(R.id.extv);
            this.imageView2= (ImageView) view.findViewById(R.id.postimage);
           // this.ll=(LinearLayout)view.findViewById(R.id.expand);
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
        viewHolder.extv.setOnClickListener(MyRecyclerAdapter.this);
        viewHolder.extv.setTag(viewHolder);
       // viewHolder.imageView2.setOnClickListener(MyRecyclerAdapter.this);
        //viewHolder.imageView2.setTag(viewHolder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder customViewHolder,final int i) {
       final FeedItem feedItem = feedItemList.get(i);

        Picasso.with(mContext).load(feedItem.getThumbnail())
                .into(customViewHolder.imageView2);
        //Download image using picasso library by square
      Picasso.with(mContext).load(feedItem.getThumbnail())
               .into(customViewHolder.imageView);
//.error(R.drawable.placeholder)
        //.placeholder(R.drawable.placeholder)
        //Setting text view title
        //customViewHolder.cv.setRadius(18);
        //customViewHolder.cv.setCardBackgroundColor(255255116);
        customViewHolder.textView.setText(Html.fromHtml(" "+feedItem.getTitle()));
        customViewHolder.textView2.setText(Html.fromHtml("Event Name:"+feedItem.getPost()));
        customViewHolder.textView3.setText(Html.fromHtml("<p>"+feedItem.getPostdetail())+"</p>");
        customViewHolder.textView4.setText(Html.fromHtml(" Venue: "+feedItem.getVenue()));
        customViewHolder.textView5.setText(Html.fromHtml(" Time: "+feedItem.getEtime()));
        customViewHolder.textView6.setText(Html.fromHtml(" " + feedItem.getPosttime()));
        customViewHolder.textView7.setText(Html.fromHtml(" Date: " + feedItem.getEdate()));
          customViewHolder.ll.setVisibility(View.GONE);

        /*
        //card expand code removed for now due to bugs popup window introduced
        customViewHolder.ll.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {

                    @Override
                    public boolean onPreDraw() {
                        customViewHolder.ll.getViewTreeObserver().removeOnPreDrawListener(this);
                        customViewHolder.ll.setVisibility(View.GONE);

                        final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                        final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                        customViewHolder.ll.measure(widthSpec, heightSpec);

                        customViewHolder.mAnimator = slideAnimator(customViewHolder, 0, customViewHolder.ll.getHeight());
                        return true;
                    }
                });*/


        customViewHolder.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), popup.class).putExtra("iu",feedItem.getThumbnail()));
                ImageView  test=(ImageView) v.findViewById(R.id.popimg);
                /*popup a=new popup();
                a.getData("http://www.youthedesigner.com/wp-content/uploads/2012/06/full_ps.jpg");*/


            }
        });
        customViewHolder.extv.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), popup2.class).putExtra("iu",feedItem.getPostdetail()));
                /*
                //..removed for now
                if (customViewHolder.ll.getVisibility() == View.GONE) {

                    customViewHolder.extv.setText(Html.fromHtml("Touch for Less Details"));
                    expand(customViewHolder);
                    customViewHolder.textView3.setText(Html.fromHtml(" " + feedItem.getPostdetail()));
                    //customViewHolder.ll.setVisibility(View.VISIBLE);

                } else {
                    customViewHolder.textView3.setText(Html.fromHtml(" "));
                    customViewHolder.extv.setText(Html.fromHtml("Touch for More Details"));
                    //customViewHolder.ll.setVisibility(View.GONE);
                    collapse(customViewHolder);
                }
               /* if (expandc >= 0) {
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
                }*/


            }

        });

        /*if (i == expandc) {
            customViewHolder.linearLayout.setVisibility(View.VISIBLE);
        } else {
            customViewHolder.linearLayout.setVisibility(View.GONE);
        }*/

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

   /*
    //Removed for now
   private void expand(final CustomViewHolder cvh) {
        //set Visible
        cvh.ll.setVisibility(View.VISIBLE);


        cvh.mAnimator.start();
    }
    private void collapse(final CustomViewHolder cvh) {
        int finalHeight = cvh.ll.getHeight();

        ValueAnimator mAnimator = slideAnimator(cvh,finalHeight, 0);

        mAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationEnd(Animator animator) {
                //Height=0, but it set visibility to GONE
                cvh.ll.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });
        mAnimator.start();
    }

    private ValueAnimator slideAnimator(final CustomViewHolder cvh,int start, int end){

        ValueAnimator animator = ValueAnimator.ofInt(start, end);


        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //Update Height
                int value = (Integer) valueAnimator.getAnimatedValue();

                ViewGroup.LayoutParams layoutParams = cvh.ll.getLayoutParams();
                layoutParams.height = value;
                cvh.ll.setLayoutParams(layoutParams);
            }
        });
        return animator;
    }*/
}
