package com.example.feets.feets.fragments;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BulletSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.feets.feets.R;
import com.example.feets.feets.constants.GeneralConstants;

import java.text.DecimalFormat;

public class Campaign3in30 extends Fragment{

    private ImageView mBaliBg;
    private ImageView mPhuketBg;
    private ImageView mKrabiBg;
    private TextView mRule;
    private TextView mTips;
    private TextView mCdHours;
    private TextView mCdMinutes;
    private TextView mCdSeconds;
    private TextView mCdDays;

//    BulletSpan Way
    String mTiptext;
    SpannableStringBuilder mSSBuilder;

    String mTipSentence;
    String mTipBullets;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_3in30, container, false);


        mBaliBg = (ImageView) view.findViewById(R.id.bali_indo_bg);
        mPhuketBg = (ImageView) view.findViewById(R.id.phuket_thai_bg);
        mKrabiBg = (ImageView) view.findViewById(R.id.krabi_thai_bg);
        Glide.with(this).load(R.drawable.bali)
                .into(mBaliBg);
        Glide.with(this).load(R.drawable.phuket)
                .into(mPhuketBg);
        Glide.with(this).load(R.drawable.krabi)
                .into(mKrabiBg);

        mRule = view.findViewById(R.id.rules_list);
        mRule.setText(R.string.campaign_3in30_rulehtml);
//
//        mTips = view.findViewById(R.id.tips_list);
//        mTips.setText(R.string.campaign_3in30_tipshtml);

        mTips = (TextView) view.findViewById(R.id.tips_list);

        mTipSentence = getString(R.string.campaign_3in30_tips);
        mTipBullets = getString(R.string.campaign_3in30_tipsBullets);

        // Initialize a new String variable
        mTiptext = mTipSentence +
                mTipBullets;

        // Initialize a new SpannableStringBuilder instance
        mSSBuilder = new SpannableStringBuilder(mTiptext);

        // Generate bulleted list
        showBullet("item 1");
        showBullet("item 2");
        showBullet("item 3");
        showBullet("item 4");

        // Display the spannable text to TextView
        mTips.setText(mSSBuilder);

        //Count Down
        mCdDays = (TextView) view.findViewById(R.id.cd_days);
        mCdHours = (TextView) view.findViewById(R.id.cd_hours);
        mCdMinutes = (TextView) view.findViewById(R.id.cd_minutes);
        mCdSeconds = (TextView) view.findViewById(R.id.cd_seconds);



        new CountDownTimer(1728000000, 1000){
            DecimalFormat df = new DecimalFormat("#00");
            public void onTick(long millisUntilFinished) {
                mCdDays.setText("" + df.format(millisUntilFinished / (1000*60*60*24)));
                mCdHours.setText("" + df.format(((millisUntilFinished / (1000*60*60)) % 24)));
                mCdMinutes.setText("" + df.format(((millisUntilFinished / (1000*60)) % 60)));
                mCdSeconds.setText("" + df.format((millisUntilFinished / 1000) % 60));

                //If more than 20 days (1728000000 milliseconds)
                if(millisUntilFinished > 1728000000){
//                    Log.i(GeneralConstants.TAG, "more than 20 days");
                    mCdDays.setBackgroundResource(R.drawable.green_countdown_bg);
                    mCdHours.setBackgroundResource(R.drawable.green_countdown_bg);
                    mCdMinutes.setBackgroundResource(R.drawable.green_countdown_bg);
                    mCdSeconds.setBackgroundResource(R.drawable.green_countdown_bg);
                }
                //If less than 20 days and more than 10 days (864000000 milliseconds)
                else if(millisUntilFinished < 1728000000 &&  millisUntilFinished > 864000000){
//                    Log.i(GeneralConstants.TAG, "less than 20 days and more than 10 days");
                    mCdDays.setBackgroundResource(R.drawable.orange_countdown_bg);
                    mCdHours.setBackgroundResource(R.drawable.orange_countdown_bg);
                    mCdMinutes.setBackgroundResource(R.drawable.orange_countdown_bg);
                    mCdSeconds.setBackgroundResource(R.drawable.orange_countdown_bg);
                }
                //If less than 10 days left
                else if (millisUntilFinished < 864000000) {
//                    Log.i(GeneralConstants.TAG, "less than 10 days");
                    mCdDays.setBackgroundResource(R.drawable.red_countdown_bg);
                    mCdHours.setBackgroundResource(R.drawable.red_countdown_bg);
                    mCdMinutes.setBackgroundResource(R.drawable.red_countdown_bg);
                    mCdSeconds.setBackgroundResource(R.drawable.red_countdown_bg);
                }
                else {

                }

            }

            public void onFinish() {
                mCdDays.setText("00");
                mCdHours.setText("00");
                mCdMinutes.setText("00");
                mCdSeconds.setText("00");
            }
        }.start();



        return view;
    }

    // Custom method to generate a bulleted list
    protected void showBullet(String textToBullet){
        // Initialize a new BulletSpan
        BulletSpan bulletSpan = new BulletSpan(
                20, // Gap width
                Color.rgb(32, 139, 233) // Color for Bullet
        );

        // Apply the bullet to the span
        mSSBuilder.setSpan(
                bulletSpan, // Span to add
                mTiptext.indexOf(textToBullet), // Start of the span (inclusive)
                mTiptext.indexOf(textToBullet) + 1,  // End of the span (exclusive)
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE // Do not extend the span when text add later
        );
    }


}
