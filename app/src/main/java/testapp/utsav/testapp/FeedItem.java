package testapp.utsav.testapp;

/**
 * Created by Utsav's Pc on 10-01-2016.
 */
public class FeedItem {
    private String title;
    private String post;
    private String thumbnail;
    private String venue;
    private String postdetail;
    private String etime;
    private String postimage;
    public String getTitle() {
        return title;
    }
    public String getPost(){
        return post;
    }
    public String getPostdetail(){
        return postdetail;
    }
    public String getVenue(){
        return venue;
    }
    public String getEtime(){
        return etime;
    }
    public void setTitle(String title) {

        this.title = title;
    }
    public void setPost(String post){

        this.post=post;
    }
    public void setPostdetail(String post){

        this.postdetail=postdetail;
    }
    public void setEtime(String post){

        this.etime=etime;
    }
    public void setVenue(String post){

        this.venue=venue;
    }
    public String getThumbnail() {

        return thumbnail;
    }
    public String getPostimg()
    {
        return postimage;
    }

    public void setThumbnail(String thumbnail) {

        this.thumbnail = thumbnail;
    }
    public void setPostimage(String postimage) {

        this.postimage = postimage;
    }
}
