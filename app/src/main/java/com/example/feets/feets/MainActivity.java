package com.example.feets.feets;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.feets.feets.adapters.MainFragmentAdapter;
import com.example.feets.feets.api.IResult;
import com.example.feets.feets.api.VolleyService;
import com.example.feets.feets.constants.ApiConstants;
import com.example.feets.feets.constants.GeneralConstants;
import com.example.feets.feets.entity.CampaignBanner;
import com.example.feets.feets.ui.FlipAnimation;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Toolbar toolbar;
    private TextView event3in30btn;
    private ImageView imgView1;
    private TextView imgView2;
    private TabLayout mtabLayout;
    private TabItem mtabChallenges;
    private TabItem mtabFeed;
    private TabItem mtabAnnouncement;
    private ViewPager mviewPager;
//    private TextView mCountDown;

    //Volley
    CampaignBanner campaignBanner;
    private String TAG = "CampaignActivity";
    IResult mResultCallback = null;
    VolleyService mVolleyService;
    private final String REQUEST_TYPE_EVENT = "GETEVENT";
    TextView tvRankingValue, tvScoreValue, tvBoosterValue, tvTimerValue;
    CountDownTimer mTimer;
    ObjectAnimator scaleDown;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    Toast.makeText(getBaseContext(), "Home!",
                            Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_highfive:
//                    mTextMessage.setText(R.string.title_highfive);
                    Toast.makeText(getBaseContext(), "Highfive!",
                            Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_ting:
//                    mTextMessage.setText(R.string.title_ting);
                    Toast.makeText(getBaseContext(), "T'ing!",
                            Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_feeters:
//                    mTextMessage.setText(R.string.title_feeters);
                    Toast.makeText(getBaseContext(), "Feeters!",
                            Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_makanbuddy:
//                    mTextMessage.setText(R.string.title_makanbuddy);
                    Toast.makeText(getBaseContext(), "Makan Buddy!",
                            Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    };

    private Toolbar.OnMenuItemClickListener mMenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId()) {
                case R.id.chatBubble:
                    Toast.makeText(getBaseContext(), "Chat Bubble!",
                            Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.notification:
                    Toast.makeText(getBaseContext(), "Notification!",
                            Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Statusbar change color
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.StartColor3in30Opacity));
        }

        // <WAFI 02-10-18 add start>
        // Volley init
        tvScoreValue = (TextView) findViewById(R.id.tv_score_value);
        tvRankingValue = (TextView) findViewById(R.id.tv_ranking_value);
        tvBoosterValue = (TextView) findViewById(R.id.tv_booster_value);
        event3in30btn = (TextView) findViewById(R.id.event3in30);
        setDefaultBannerValue();
        initVolleyCallback();
        // <WAFI 02-10-18 add end>

        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewEx bnve = (BottomNavigationViewEx) findViewById(R.id.navigation);
        bnve.enableAnimation(false);
        bnve.enableShiftingMode(false);
        bnve.enableItemShiftingMode(false);
        bnve.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(" ");
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(mMenuItemClickListener);


        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(GeneralConstants.TAG, "click");
            }
        });


        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

//        event3in30btn = (TextView) findViewById(R.id.event3in30);
        event3in30btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CampaignActivity.class);
                // TODO: 10/3/2018 Pass timer value to next activity??
                startActivity(intent);
            }
        });

        //ANIMATION PURPOSES
        imgView1 = (ImageView) findViewById(R.id.ImageView01);
        imgView2 = (TextView) findViewById(R.id.ImageView02);

        imgView1.setClickable(true);
        imgView2.setClickable(true);

        imgView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlipAnimation flipAnimation = new FlipAnimation(imgView1, imgView2, true);
                imgView2.startAnimation(flipAnimation);
            }
        });

        imgView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlipAnimation flipAnimation = new FlipAnimation(imgView2, imgView1, false);
                imgView1.startAnimation(flipAnimation);
            }
        });

        mtabLayout = (TabLayout) findViewById(R.id.tabs);
        mtabChallenges = (TabItem) findViewById(R.id.tab_challenges);
        mtabFeed = (TabItem) findViewById(R.id.tab_feed);
        mtabAnnouncement = (TabItem) findViewById(R.id.tab_announcement);
        mviewPager = (ViewPager) findViewById(R.id.tab_viewpager);


        MainFragmentAdapter mainFragmentAdapter = new MainFragmentAdapter(getSupportFragmentManager(), mtabLayout.getTabCount());
        mviewPager.setAdapter(mainFragmentAdapter);
        mviewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mtabLayout));

        mtabLayout.addOnTabSelectedListener(new
                                                    TabLayout.OnTabSelectedListener() {
                                                        @Override
                                                        public void onTabSelected(TabLayout.Tab tab) {
                                                            mviewPager.setCurrentItem(tab.getPosition());
                                                        }

                                                        @Override
                                                        public void onTabUnselected(TabLayout.Tab tab) {

                                                        }

                                                        @Override
                                                        public void onTabReselected(TabLayout.Tab tab) {

                                                        }
                                                    });

        //Count Down - Move to bottom

    }

    @Override
    protected void onResume() {
        super.onResume();
        // <WAFI 02-10-18 add start>
        mVolleyService = new VolleyService(mResultCallback, this);
        mVolleyService.getDataVolley(REQUEST_TYPE_EVENT, ApiConstants.REQ_SPECIAL_EVENTS);

        if (scaleDown != null) {
            scaleDown.start();
        }
        // <WAFI 02-10-18 add end>
    }

    @Override
    protected void onPause() {
        if (scaleDown != null) {
            scaleDown.pause();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        //Clear timer & animator if exist
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
        scaleDown = null;
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_toolbar, menu);
        return true;
    }

    // <WAFI 02-10-18 add start>
    /**
     * This method will set the rank, score and booster & time text to its default value.
     */
    private void setDefaultBannerValue() {
        tvRankingValue.setText("");
        tvScoreValue.setText("");
        tvBoosterValue.setText("");
        event3in30btn.setText("00:00:00");
    }

    private void initVolleyCallback() {
        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, JSONObject response) {
                switch (requestType) {
                    case REQUEST_TYPE_EVENT:
                        try {
                            JSONObject attributeObject = response.getJSONObject("data").getJSONObject("attributes");
                            String currentBooster = attributeObject.getString("current_boosters");
                            String ranking = attributeObject.getJSONObject("current_learner_score").getString("rank");
                            String points = attributeObject.getJSONObject("current_learner_score").getString("points");
                            String event_start = attributeObject.getString("event_start");
                            String event_end = attributeObject.getString("event_end");

                            campaignBanner = new CampaignBanner();
                            campaignBanner.setCurrent_booster(currentBooster);
                            campaignBanner.setRank(ranking);
                            campaignBanner.setPoints(points);
                            campaignBanner.setEvent_start(event_start);
                            campaignBanner.setEvent_end(event_end);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //Set data
                        tvRankingValue.setText(campaignBanner.getRank());
                        tvScoreValue.setText(campaignBanner.getPoints());
                        tvBoosterValue.setText(campaignBanner.getCurrent_booster());
                        //todo Find the time different for timer
                        final DateTimeUtils obj = new DateTimeUtils();
//                        Date start = DateTimeUtils.fromISO8601UTC(campaignBanner.getEvent_start());
                        //Get current date
                        Date date = Calendar.getInstance().getTime();
                        String currentDateStr = DateTimeUtils.toISO8601UTC(date);
                        Date current = DateTimeUtils.fromISO8601UTC(currentDateStr);
                        Date end = DateTimeUtils.fromISO8601UTC(campaignBanner.getEvent_end());

                        long diffrentTimeinMillis = obj.printDifferenceLong(current, end);
                        //Start the countdown timer, reduce 1 sec (1000 millis) periodically
                        if (mTimer == null) {
                            mTimer = new CountDownTimer(diffrentTimeinMillis, 1000) {
                                //                            DecimalFormat df = new DecimalFormat("#00");
                                public void onTick(long millisUntilFinished) {
                                    event3in30btn.setText(obj.printDifferenceInMillis(millisUntilFinished));
                                    //If less than 10 days left
                                    if (millisUntilFinished < 864000000) {
                                        //Log.i(GeneralConstants.TAG, "less than 10 days");
                                        event3in30btn.setBackgroundResource(R.drawable.red_rounded_opacity);

                                        if (scaleDown == null) {
                                            scaleDown = ObjectAnimator.ofPropertyValuesHolder(
                                                    event3in30btn,
                                                    PropertyValuesHolder.ofFloat("scaleX", 1.1f),
                                                    PropertyValuesHolder.ofFloat("scaleY", 1.1f));

                                            scaleDown.setDuration(310);
                                            scaleDown.setRepeatCount(ObjectAnimator.INFINITE);
                                            scaleDown.setRepeatMode(ObjectAnimator.REVERSE);
                                            scaleDown.start();
                                        }
                                    }
                                    else {
                                        event3in30btn.setBackgroundResource(R.drawable.black_rounded_opacity);
                                    }
                                }
                                public void onFinish() {
                                    event3in30btn.setText("00:00:00");
                                }
                            }.start();
                        }
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void notifyError(String requestType, VolleyError error) {
                //Add action if error getting data
            }
        };
    }
    // <WAFI 02-10-18 add end>

}
