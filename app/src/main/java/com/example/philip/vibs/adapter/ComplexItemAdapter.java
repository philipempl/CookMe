package com.example.philip.vibs.adapter;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.philip.vibs.CloseUpItemDialog;
import com.example.philip.vibs.DataHolder;
import com.example.philip.vibs.InboxActivity;
import com.example.philip.vibs.R;
import com.example.philip.vibs.model.ActionItem;
import com.example.philip.vibs.model.BirthdayItem;
import com.example.philip.vibs.model.DocumentItem;
import com.example.philip.vibs.model.MultiMediaItem;
import com.example.philip.vibs.model.StoryItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComplexItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public class ActionItemViewHolder extends RecyclerView.ViewHolder {
        public TextView username, message, time, location, date;
        public ImageView profil;

        public ActionItemViewHolder(View view) {
            super(view);
            username = (TextView) view.findViewById(R.id.action_item_username);
            message = (TextView) view.findViewById(R.id.action_item_message);
            time = (TextView) view.findViewById(R.id.action_item_time);
            date = (TextView) view.findViewById(R.id.action_item_date);
            location = (TextView) view.findViewById(R.id.action_item_location_text);
            profil = (ImageView) view.findViewById(R.id.action_item_image);
        }
    }
    public class StoryItemViewHolder extends RecyclerView.ViewHolder {
        public TextView username, message, date, title;
        public ImageView profil;

        public StoryItemViewHolder(View view) {
            super(view);
            username = (TextView) view.findViewById(R.id.story_item_username);
            message = (TextView) view.findViewById(R.id.story_item_message);
            date = (TextView) view.findViewById(R.id.story_item_date);
            title = (TextView) view.findViewById(R.id.story_item_title);
            profil = (ImageView) view.findViewById(R.id.story_item_image);
        }
    }
    public class DocumentItemViewHolder extends RecyclerView.ViewHolder {
        public TextView username, documentName, date, title;

        public DocumentItemViewHolder(View view) {
            super(view);
            username = (TextView) view.findViewById(R.id.document_item_username);
            documentName = (TextView) view.findViewById(R.id.document_item_document_name);
            date = (TextView) view.findViewById(R.id.document_item_date);
            title = (TextView) view.findViewById(R.id.document_item_title);
        }
    }
    public class BirthdayItemViewHolder extends RecyclerView.ViewHolder {

        public TextView usernameDate;
        public ImageView profil;

        public BirthdayItemViewHolder(View view) {
            super(view);
            usernameDate = (TextView) view.findViewById(R.id.birthday_item_name_year);
            profil = (ImageView) view.findViewById(R.id.birthday_item_image);

        }
    }
    public class MultiMediaViewHolder extends RecyclerView.ViewHolder{

        public TextView username, date, title;
        public ImageView profil, image;

        public MultiMediaViewHolder(View view) {
            super(view);
            username = (TextView) view.findViewById(R.id.multimedia_item_username);
            title = (TextView) view.findViewById(R.id.multimedia_item_title);
            date = (TextView) view.findViewById(R.id.multimedia_item_date);
            profil = (ImageView) view.findViewById(R.id.multimedia_item_image);
            image = (ImageView) view.findViewById(R.id.multimedia_item_picture);
        }

    }
        // The items to display in your RecyclerView
    private List<Object> items;

    private final int ACTIONITEM = 0, BIRTHDAYITEM = 1, STORYITEM = 2, MULTIMEDIAITEM = 3, DOCUMENTITEM = 4;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ComplexItemAdapter() {
        this.items = DataHolder.feedObjectList;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return this.items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof BirthdayItem) {
            return BIRTHDAYITEM;
        } else if (items.get(position) instanceof ActionItem) {
            return ACTIONITEM;
        } else if (items.get(position) instanceof StoryItem) {
                return STORYITEM;
        } else if (items.get(position) instanceof MultiMediaItem) {
            return MULTIMEDIAITEM;
        } else if (items.get(position) instanceof DocumentItem) {
            return DOCUMENTITEM;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case BIRTHDAYITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.birthday_row_item, parent, false);
                return new BirthdayItemViewHolder(view);
            case ACTIONITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.action_row_item, parent, false);
                return new ActionItemViewHolder(view);
            case STORYITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_row_item, parent, false);
                return new StoryItemViewHolder(view);
            case MULTIMEDIAITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.multimedia_row_item, parent, false);
                return new MultiMediaViewHolder(view);
            case DOCUMENTITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.document_row_item, parent, false);

                return new DocumentItemViewHolder(view);
            default:
                break;
        }
        return null;
    }

    /**
     * This method internally calls onBindViewHolder(ViewHolder, int) to update the
     * RecyclerView.ViewHolder contents with the item at the given position
     * and also sets up some private fields to be used by RecyclerView.
     *
     * @param viewHolder The type of RecyclerView.ViewHolder to populate
     * @param position Item position in the viewgroup.
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        switch (viewHolder.getItemViewType()) {
            case BIRTHDAYITEM:
                BirthdayItemViewHolder bivh = (BirthdayItemViewHolder) viewHolder;
                configureViewHolderBirthdayItem(bivh, position);
                break;
            case ACTIONITEM:
                ActionItemViewHolder aivh = (ActionItemViewHolder) viewHolder;
                configureViewHolderActionItem(aivh, position);
                break;
            case STORYITEM:
                StoryItemViewHolder sivh = (StoryItemViewHolder) viewHolder;
                configureViewHolderStoryItem(sivh, position);
                break;
            case MULTIMEDIAITEM:
                MultiMediaViewHolder mivh = (MultiMediaViewHolder) viewHolder;
                configureViewHolderMultiMediaItem(mivh, position);
                break;
            case DOCUMENTITEM:
                DocumentItemViewHolder divh = (DocumentItemViewHolder) viewHolder;
                configureViewHolderDocumentItem(divh, position);
                break;
            default:
                break;
        }
    }

    private void configureViewHolderBirthdayItem(ComplexItemAdapter.BirthdayItemViewHolder bivh, int position) {
        BirthdayItem birthdayItem = (BirthdayItem) items.get(position);
        if (birthdayItem != null) {
            bivh.usernameDate.setText(birthdayItem.getPersonName()+ " (" +birthdayItem.getAge()+")");
            bivh.profil.setImageResource(birthdayItem.getImage());
        }
    }

    private void configureViewHolderActionItem(ActionItemViewHolder aivh, int position) {
        ActionItem actionItem = (ActionItem) items.get(position);
        if (actionItem != null) {
            aivh.username.setText(actionItem.getUsername());
            aivh.message.setText(actionItem.getRequestMessage());
            aivh.date.setText(new SimpleDateFormat("hh:mm").format(actionItem.getDate()));
            aivh.time.setText(new SimpleDateFormat("hh:mm").format(actionItem.getTime()));
            aivh.location.setText(actionItem.getLocation());
            aivh.profil.setImageResource(actionItem.getImage());
        }
    }
    private void configureViewHolderDocumentItem(DocumentItemViewHolder aivh, int position) {
        DocumentItem documentItem = (DocumentItem) items.get(position);
        if (documentItem != null) {
            aivh.username.setText(documentItem.getUsername());
            aivh.documentName.setText(documentItem.getDocument_name());
            aivh.title.setText(documentItem.getTitle());
            aivh.date.setText(new SimpleDateFormat("hh:mm").format(documentItem.getDate()));
        }
    }
    private void configureViewHolderStoryItem(StoryItemViewHolder sivh, int position) {
            StoryItem storyItem = (StoryItem) items.get(position);
            if (storyItem != null) {
                sivh.username.setText(storyItem.getUsername());
                if(storyItem.getMessage().length() > 100)
                {
                    sivh.message.setText(storyItem.getMessage().substring(0,200) +"...");
                }
                else
                {
                    sivh.message.setText(storyItem.getMessage());

                }
                sivh.date.setText(new SimpleDateFormat("hh:mm").format(storyItem.getDate()));
                sivh.profil.setImageResource(storyItem.getImage());
                sivh.title.setText(storyItem.getTitle());
            }
    }
    private void configureViewHolderMultiMediaItem(MultiMediaViewHolder sivh, int position) {
        MultiMediaItem multiMediaItem = (MultiMediaItem) items.get(position);
        if (multiMediaItem != null) {
            sivh.username.setText(multiMediaItem.getUsername());
            sivh.title.setText(multiMediaItem.getTitle());
            sivh.date.setText(new SimpleDateFormat("hh:mm").format(multiMediaItem.getDate()));
            sivh.profil.setImageResource(multiMediaItem.getProfil());
            sivh.image.setImageResource(multiMediaItem.getPicture());
        }
    }
}
