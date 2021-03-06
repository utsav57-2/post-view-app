package testapp.utsav.testapp;

/**
 * Created by Utsav's Pc on 10-01-2016.
 */

import org.json.JSONException;



        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.os.Handler;
        import android.support.v4.widget.SwipeRefreshLayout;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
        import android.widget.Toast;
        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;
        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.List;



public class FeedListActivity extends AppCompatActivity {
    private static final String TAG = "Testapp";
    private List<FeedItem> feedsList;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefresh;
    private MyRecyclerAdapter adapter;
    private ProgressBar progressBar;
    private ArrayList<String> dataset;
    LinearLayoutManager llm=new LinearLayoutManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(llm);
        mSwipeRefresh=(SwipeRefreshLayout) findViewById(R.id.swipout);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        final String url = "http://vitacad-web.herokuapp.com/vitwebapp/api/v1.0/get_posts";
        new AsyncHttpTask().execute(url);
    /*    mSwipeRefresh.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);*/
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView view, int scrollState) {
            }

            @Override
            public void onScrolled(RecyclerView view, int dx,int dy) {

                mSwipeRefresh.setEnabled(llm.findFirstCompletelyVisibleItemPosition()==0);
            }
        });
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
                }
        });
        // Downloading data from below url

    }

    public class AsyncHttpTask extends AsyncTask<String, Void, Integer> {

        @Override
        protected void onPreExecute() {
            setProgressBarIndeterminateVisibility(true);
        }

        @Override
        protected Integer doInBackground(String... params) {
            Integer result = 0;
            HttpURLConnection urlConnection;

            try {
                URL url = new URL(params[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                int statusCode = urlConnection.getResponseCode();

                // 200 represents HTTP OK
                if (statusCode == 200) {
                    BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = r.readLine()) != null) {
                        response.append(line);
                    }
                    parseResult(response.toString());
                    result = 1; // Successful
                } else {

                    result = 0; //"Failed to fetch data!";
                }
            } catch (Exception e) {
                Log.d(TAG, e.getLocalizedMessage());
            }
            return result; //"Failed to fetch data!";
        }

        @Override
        protected void onPostExecute(Integer result) {
            // Download complete. Let us update UI
            progressBar.setVisibility(View.GONE);



            if (result == 1) {
                adapter = new MyRecyclerAdapter(FeedListActivity.this, feedsList);
                mRecyclerView.setAdapter(adapter);
                mSwipeRefresh.setRefreshing(false);
                /*mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
                    @Override
                public void OnRefresh(){
                        refreshContent();
                    }
                });*/
            } else {
                Toast.makeText(FeedListActivity.this, "Failed to fetch data!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void parseResult(String result) {
        try {
            JSONObject response = new JSONObject(result);
            JSONArray posts = response.optJSONArray("results");
            feedsList = new ArrayList<>();

            for (int i = (posts.length()-1); i >=0; i--) {
                JSONObject post = posts.optJSONObject(i);
                FeedItem item = new FeedItem();
                item.setTitle(post.optString("club_name"));
                item.setThumbnail(post.optString("club_logo"));
                item.setPost(post.optString("event_name"));
                item.setPostimage(post.optString("image_link"));
                item.setPostdetail(post.optString("post_body"));
                item.setVenue(post.optString("event_venue"));
                item.setEtime(post.optString("event_time"));
                item.setPosttime(post.optString("timestamp"));
                item.setEdate(post.optString("event_date"));
                feedsList.add(item);
            }
        } catch (JSONException e) {
            Toast.makeText(FeedListActivity.this, ""+e, Toast.LENGTH_SHORT).show();
        }
    }
    private void refreshContent(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                final String url = "http://vitacad-web.herokuapp.com/vitwebapp/api/v1.0/get_posts";
                new AsyncHttpTask().execute(url);
                mSwipeRefresh.setRefreshing(false);
            }},0);

        }
}