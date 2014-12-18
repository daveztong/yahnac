package com.malmstein.hnews.stories;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.malmstein.hnews.R;
import com.malmstein.hnews.sync.HNewsSyncAdapter;

public class TopStoriesActivity extends ActionBarActivity implements TopStoriesFragment.Listener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        setToolbar();

        HNewsSyncAdapter.initializeSyncAdapter(this);
    }

    private void setToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setAppBarColor(getDefaultAppBarColor(getResources()));
    }

    private void setAppBarColor(int color) {
        if (toolbar != null) {
            toolbar.setBackgroundColor(color);
        }
    }

    private int getDefaultAppBarColor(Resources resources) {
        return resources.getColor(R.color.orange);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onArticleSelected(Long itemId) {
        startActivity(new Intent(this, ArticleActivity.class).putExtra(ArticleFragment.ARG_STORY_ID, itemId));
    }
}