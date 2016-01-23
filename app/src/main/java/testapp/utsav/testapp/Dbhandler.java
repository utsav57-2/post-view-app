package testapp.utsav.testapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Utsav's Pc on 23-01-2016.
 */
public class Dbhandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "postclub";

    // Contacts table name
    private static final String TABLE_post = "posts";
    private static final String KEY_timestamp = "time_stamp";
    private static final String KEY_club = "club_name";
    private static final String KEY_post = "post";
    private static final String KEY_ename = "event_name";
    private static final String KEY_edate = "event_date";
    private static final String KEY_etime = "event_time";
    private static final String KEY_evenue = "event_venue";
    private static final String KEY_image_link = "image_link";
    private static final String KEY_club_img = "club_logo";
    public Dbhandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_post + "("
                + KEY_timestamp + " TEXT," + KEY_club + " TEXT,"
                + KEY_club_img + " TEXT" +KEY_ename+"TEXT,"+KEY_edate+"TEXT,"+KEY_etime+"TEXT,"+KEY_evenue+"TEXT,"+KEY_image_link+"TEXT,"+KEY_post+"TEXT,"+ ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_post);

        // Create tables again
        onCreate(db);
    }
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    void addContact(Posts post) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_timestamp, post.get_time_stamp()); // Contact Name
        values.put(KEY_club, post.get_club_name()); // Contact Phone
        values.put(KEY_club_img, post.get_image_club());
        values.put(KEY_ename, post.get_event_name());
        values.put(KEY_edate, post.get_event_date());
        values.put(KEY_etime, post.get_event_time());
        values.put(KEY_evenue, post.get_event_venue());
        values.put(KEY_image_link, post.get_image_link());
        values.put(KEY_post, post.get_post());
        // Inserting Row
        db.insert(TABLE_post, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    Posts getPosts(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_post, new String[] { KEY_timestamp,
                        KEY_club, KEY_club_img,KEY_ename,KEY_edate,KEY_etime,KEY_evenue,KEY_image_link,KEY_post }, KEY_club + "=?",
                new String[] { String.valueOf(id) }, null, null, null,null);
        if (cursor != null)
            cursor.moveToFirst();

        Posts post = new Posts(cursor.getString(0),
                cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
        // return contact
        return post;
    }

    // Getting All Contacts
    public List<Posts> getAllPosts() {
        List<Posts> contactList = new ArrayList<Posts>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_post;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Posts post = new Posts();
                post.set_time_stamp(cursor.getString(0));
                post.set_club_name(cursor.getString(1));
                post.set_image_club(cursor.getString(2));
                post.set_event_name(cursor.getString(3));
                post.set_event_date(cursor.getString(4));
                post.set_event_time(cursor.getString(5));
                post.set_event_venue(cursor.getString(6));
                post.set_image_link(cursor.getString(7));
                post.set_post(cursor.getString(8));

                // Adding contact to list
                contactList.add(post);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    // Updating single contact
  /* public int updateContact(Posts post) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_.., contact.get..());
        values.put(KEY_.., contact.get..());
        values....
        .....*6
        // updating row
        return db.update(TABLE_posts, values, KEY_club_name + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }*/

    // Deleting single contact
    public void deleteContact(Posts post) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_post, KEY_timestamp + " = ?",
                new String[] { String.valueOf(post.get_time_stamp()) });
        db.close();
    }


    // Getting Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_post;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }



}
