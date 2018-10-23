package com.fitnessapp.views;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.fitnessapp.R;
import com.fitnessapp.views.Fragments.EnterUserInfoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EnterUserInfoActivity extends AppCompatActivity {

    @BindView(R.id.userPhoto)
    ImageView userPhoto;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.next)
    FloatingActionButton next;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_user_info);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        collapsingToolbar.setTitle("Information");

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new EnterUserInfoFragment())
                    .commit();
        }
    }
}
