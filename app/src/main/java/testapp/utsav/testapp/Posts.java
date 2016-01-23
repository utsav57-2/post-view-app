package testapp.utsav.testapp;

/**
 * Created by Utsav's Pc on 22-01-2016.
 */
public class Posts {
    //Private
    private String _time_stamp;
    private String _club_name;
    private String _image_link;
    private String _image_club;
    private String _post;
    private String _event_name;
    private String _event_date;
    private String _event_time;
    private String _event_venue;
    public Posts() {

    }
    public Posts(String _club_name,String _event_date,String _image_link,String _event_name,String _post,String _event_time,String _event_venue,String _image_club,String _time_stamp)
    {
      this._time_stamp=_time_stamp;
        this._club_name=_club_name;
        this._image_link=_image_link;
        this._image_club=_image_club;
        this._post=_post;
        this._event_name=_event_name;
        this._event_date=_event_date;
        this._event_time=_event_time;
        this._event_venue=_event_venue;
    }
    public void set_time_stamp(String _time_stamp)
    {
        this._time_stamp=_time_stamp;
    }
    public String get_time_stamp()
    {
        return this._time_stamp;
    }
    public void set_club_name(String _club_name)
    {
        this._club_name=_club_name;
    }
    public String get_club_name()
    {
        return this._club_name;
    }
    public void set_event_name(String _event_name)
    {
        this._event_name=_event_name;
    }
    public String get_event_name()
    {
        return this._event_name;
    }
    public void set_event_date(String _event_date)
    {
        this._event_date=_event_date;
    }
    public String get_event_date()
    {
       return this._event_date;
    }
    public void set_event_time(String _event_time)
    {
        this._event_time=_event_time;
    }
    public String get_event_time()
    {
        return this._event_time;
    }
    public void set_event_venue(String _event_venue)
    {
        this._event_venue=_event_venue;
    }
    public String get_event_venue()
    {
        return this._event_venue;
    }
    public void set_post(String _post)
    {
        this._post=_post;
    }
    public String get_post()
    {
        return this._post;
    }
    public void set_image_link(String _image_link)
    {
        this._image_link=_image_link;
    }
    public String get_image_link()
    {
        return this._image_link;
    }
    public void set_image_club(String _image_club)
    {
        this._image_club=_image_club;
    }
    public String get_image_club()
    {
        return this._image_club;
    }
}

























































