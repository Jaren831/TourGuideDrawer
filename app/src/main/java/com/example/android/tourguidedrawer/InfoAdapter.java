package com.example.android.tourguidedrawer;

/**
 * Created by Jaren Lynch on 7/2/2016.
 */

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link InfoAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Info} objects.
 */
public class InfoAdapter extends ArrayAdapter<Info>  {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * Create a new {@link InfoAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param infos is the list of {@link Info}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of infos
     */
    public InfoAdapter(Context context, ArrayList<Info> infos, int colorResourceId) {
        super(context, 0, infos);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Info} object located at this position in the list
        Info currentInfo = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID info_text_view.
        TextView infoTextView = (TextView) listItemView.findViewById(R.id.info_text_view);
        // Get the Name of the Info object and set this text on
        // the info TextView.
        infoTextView.setText(currentInfo.getmName());

        // Find the TextView in the list_item.xml layout with the ID review_text_view.
        TextView reviewTextView = (TextView) listItemView.findViewById(R.id.review_text_view);
        // Get the default translation from the currentInfo object and set this text on
        // the default TextView.
        reviewTextView.setText(currentInfo.getmReview());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this word or not
        if (currentInfo.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentInfo.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }
        // Find the TextView in the list_item.xml layout with the ID price_text_view.
        TextView priceTextView = (TextView) listItemView.findViewById(R.id.price_text_view);
        // Get the default translation from the currentInfo object and set this text on
        // the default TextView.
        priceTextView.setText(currentInfo.getmPrice());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
