package es.mongamonga.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    private String LOG_TAG = DetailActivity.class.getSimpleName();

    private String FORECAST_SHARE_HASHTAG = "  #SunshineApp";
    private String mForecastStr;

    private ShareActionProvider sap;

    public DetailActivityFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent i = getActivity().getIntent();
        View rootview = inflater.inflate(R.layout.fragment_detail, container, false);
        Bundle bun = i.getExtras();
        TextView tx = (TextView)rootview.findViewById(R.id.textview_detail);
        mForecastStr = bun.getString("Forecast");
        tx.setText(mForecastStr);
        return rootview;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.detailfragment, menu);
        MenuItem mitem = menu.findItem(R.id.action_share);
        sap = (ShareActionProvider) MenuItemCompat.getActionProvider(mitem);
        sap.setShareIntent(createShareForecastIntent());
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Log.i(LOG_TAG, "Going to SettingActivity");
            Intent i = new Intent(getActivity(), SettingsActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    private Intent createShareForecastIntent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, mForecastStr + FORECAST_SHARE_HASHTAG);
        return shareIntent;
    }
}
