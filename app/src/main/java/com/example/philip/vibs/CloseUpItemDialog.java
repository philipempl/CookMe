package com.example.philip.vibs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.philip.vibs.model.ActionItem;
import com.example.philip.vibs.model.BirthdayItem;
import com.example.philip.vibs.model.DocumentItem;
import com.example.philip.vibs.model.MultiMediaItem;
import com.example.philip.vibs.model.StoryItem;

import java.text.SimpleDateFormat;

import jp.wasabeef.blurry.Blurry;

public class CloseUpItemDialog extends Activity implements
        android.view.View.OnClickListener {
    public TextView username, date, title, time, location, message, documentTitle, documentName;
    public ImageView profil, image;
    private float x1,x2;
    static final int MIN_DISTANCE = 150;
    public int position;
    public CloseUpItemDialog() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        if (!InboxFragment.blurry) {
            Blurry.with(this).radius(25).sampling(2).onto((ViewGroup) InboxFragment.view);
            InboxFragment.blurry = true;
        }
        position = (int) (getIntent().getExtras().get("position"));
        Object object = (Object) DataHolder.feedObjectList.get(position);


        if (object instanceof MultiMediaItem) {
            resolveAsMultiMediaItem((MultiMediaItem) object);
        } else if (object instanceof ActionItem) {

            resolveActionItem((ActionItem) object);
        } else if (object instanceof StoryItem) {

            resolveStoryItem((StoryItem) object);
        } else if (object instanceof BirthdayItem) {

            resolveBirthdayItem((BirthdayItem) object);
        } else if (object instanceof DocumentItem) {

            resolveDocumentItem((DocumentItem) object);
        }

        getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    private void resolveDocumentItem(DocumentItem documentItem) {
        setContentView(R.layout.document_item_close_up);

        username = (TextView) findViewById(R.id.document_item_username);
        date = (TextView) findViewById(R.id.document_item_date);
        documentName = (TextView) findViewById(R.id.document_item_document_name);
        documentTitle = (TextView) findViewById(R.id.document_item_title);

        username.setText(documentItem.getUsername());
        documentTitle.setText(documentItem.getDocument_name());
        documentName.setText(documentItem.getTitle());
        date.setText(new SimpleDateFormat("hh:mm").format(documentItem.getDate()));
    }

    private void resolveBirthdayItem(BirthdayItem birthdayItem) {
        setContentView(R.layout.birthday_item_close_up);

        username = (TextView) findViewById(R.id.birthday_item_name_year);
        profil = (ImageView) findViewById(R.id.birthday_item_image);

        username.setText(birthdayItem.getPersonName()+ " (" +birthdayItem.getAge()+")");
        profil.setImageResource(birthdayItem.getImage());


    }

    private void resolveStoryItem(StoryItem storyItem) {
        setContentView(R.layout.story_item_close_up);

        username = (TextView) findViewById(R.id.story_item_username);
        title = (TextView) findViewById(R.id.story_item_title);
        date = (TextView) findViewById(R.id.story_item_date);
        profil = (ImageView) findViewById(R.id.story_item_image);
        message = (TextView) findViewById(R.id.story_item_message);

        username.setText(storyItem.getUsername());
        message.setText(storyItem.getMessage());
        date.setText(new SimpleDateFormat("hh:mm").format(storyItem.getDate()));
        profil.setImageResource(storyItem.getImage());
        title.setText(storyItem.getTitle());

    }

    private void resolveActionItem(ActionItem actionItem) {
        setContentView(R.layout.action_item_close_up);

        username = (TextView) findViewById(R.id.action_item_username);
        title = (TextView) findViewById(R.id.action_item_message);
        date = (TextView) findViewById(R.id.action_item_date);
        profil = (ImageView) findViewById(R.id.action_item_image);
        time = (TextView) findViewById(R.id.action_item_time);
        location = (TextView) findViewById(R.id.action_item_location_text);


        username.setText(actionItem.getUsername());
        title.setText(actionItem.getRequestMessage());
        date.setText(new SimpleDateFormat("hh:mm").format(actionItem.getDate()));
        profil.setImageResource(actionItem.getImage());
        time.setText(new SimpleDateFormat("hh:mm").format(actionItem.getTime()));
        location.setText(actionItem.getLocation());


    }

    private void resolveAsMultiMediaItem(MultiMediaItem multiMediaItem) {
        setContentView(R.layout.multimedia_item_close_up);
        username = (TextView) findViewById(R.id.multimedia_item_username);
        title = (TextView) findViewById(R.id.multimedia_item_title);
        date = (TextView) findViewById(R.id.multimedia_item_date);
        profil = (ImageView) findViewById(R.id.multimedia_item_image);
        image = (ImageView) findViewById(R.id.multimedia_item_picture);


        username.setText(multiMediaItem.getUsername());
        title.setText(multiMediaItem.getTitle());
        date.setText(new SimpleDateFormat("hh:mm").format(multiMediaItem.getDate()));
        profil.setImageResource(multiMediaItem.getProfil());
        image.setImageResource(multiMediaItem.getPicture());


    }


    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float deltaX = x2 - x1;

                if (Math.abs(deltaX) > MIN_DISTANCE)
                {
                    // Left to Right swipe action
                    if (x2 > x1)
                    {
                        if (0 < position) {
                            DataHolder.swipeRight = true;
                            DataHolder.swipeLeft = false;
                            finish();
                            Intent i = new Intent(this, CloseUpItemDialog.class);
                            i.putExtra("position", position - 1);
                            startActivity(i);
                        }
                    }

                    // Right to left swipe action
                    else {
                        if (DataHolder.feedObjectList.size() > position + 1) {
                            DataHolder.swipeRight = false;
                            DataHolder.swipeLeft = true;                            finish();
                            Intent i = new Intent(this, CloseUpItemDialog.class);
                            i.putExtra("position", position + 1);
                            startActivity(i);
                        }
                    }
                }
                else
                {
                    // consider as something else - a screen tap for example
                }
                break;
        }
        return super.onTouchEvent(event);
    }
    @Override
    public void onClick(View v) {

    }

    public void blurrImage(View view) {

    }
    @Override
    public void finish() {
        super.finish();
        if(DataHolder.swipeLeft) {
            overridePendingTransition(R.anim.right_to_middle, R.anim.middle_to_left);
            DataHolder.swipeLeft = false;
        }
        else if(DataHolder.swipeRight)
        {
            overridePendingTransition(R.anim.left_to_middle, R.anim.middle_to_right);
            DataHolder.swipeRight = false;

        }
        else
        {
            overridePendingTransition(0, R.anim.shrink_activity);
        }
    }
}
