package testapp.utsav.testapp;

/**
 * Created by Utsav's Pc on 10-01-2016.
 */
public class FeedItem {
    private String title;
    private String post;
    private String thumbnail;
private String postimage;
    public String getTitle() {
        return title;
    }
    public String getPost(){
        return post;
    }
    public void setTitle(String title) {

        this.title = title;
    }
    public void setPost(String post){

        this.post=post;
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
