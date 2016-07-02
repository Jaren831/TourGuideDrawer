package com.example.android.tourguidedrawer;

/**
 * Created by Jaren Lynch on 7/2/2016.
 */
public class Info {
    //Name of information
    private String mName;

    //Price
    private String mPrice;

    //Review, in stars.
    private String mReview;

    //Image associated with the information
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     *
     * @param name is the name of the list item.
     * @param price is the price of the list item.
     * @param review is review of the list item, in stars.
     */
    public Info(String name, String price, String review) {
        mName = name;
        mPrice = price;
        mReview = review;
    }
    /**
     *
     * @param name is the name of the list item.
     * @param price is the price of the list item.
     * @param imageResourceId is the resource id for image associated with the word.
     * @param review is review of the list item, in stars.
     */
    public Info(String name, String price, String review, int imageResourceId) {
        mName = name;
        mPrice = price;
        mImageResourceId = imageResourceId;
        mReview = review;
    }

    /**
     * Get the name of the list item.
     */
    public String getmName() {

        return mName;
    }

    /**
     * Get the price of the list item
     */
    public String getmPrice(){

        return mPrice;
    }

    /**
     * Get the id of the image
     */
    public int getImageResourceId(){

        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Get the review of the list item
     */
    public String getmReview(){
        return mReview;
    }


}
