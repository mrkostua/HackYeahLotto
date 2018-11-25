package hackyeah.hackyeahlotto;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import hackyeah.hackyeahlotto.adapters.DrawItemListAdapter;
import hackyeah.hackyeahlotto.api.mock.DrawMockService;
import hackyeah.hackyeahlotto.model.Draw;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


public class DrawActivity extends AppCompatActivity implements DrawItemListAdapter.DrawItemListAdapterOnClickHandler {

    private RecyclerView mRecyclerView;
    private TextView mErrorMessageDisplay;
    private DrawItemListAdapter mDrawsAdapter;
    private ProgressBar mLoadingIndicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draws);
        mRecyclerView = findViewById(R.id.recyclerview_draws);
        mErrorMessageDisplay = findViewById(R.id.tv_error_message_display);


        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mDrawsAdapter = new DrawItemListAdapter(this);

        mRecyclerView.setAdapter(mDrawsAdapter);
        mLoadingIndicator = findViewById(R.id.pb_loading_indicator);
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
//        mRecyclerView.addOnScrollListener(recyclerViewOnScrollListener);
        loadDrawsData();
    }

    private void loadDrawsData() {
        showDrawsDataView();
        new FetchWeatherTask().execute();
    }

    private void showDrawsDataView() {
        /* First, make sure the error is invisible */
        mErrorMessageDisplay.setVisibility(View.INVISIBLE);
        /* Then, make sure the weather data is visible */
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(Draw data) {
//        Toast.makeText(this,"Selected",Toast.LENGTH_SHORT).show();
    }



    public class FetchWeatherTask extends AsyncTask<String, Void, Draw[]> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingIndicator.setVisibility(View.VISIBLE);
        }

        @Override
        protected Draw[] doInBackground(String... params) {

            List<Draw> draws = DrawMockService.getDraws(1L);

            Collections.sort(draws, new Comparator<Draw>() {
                @Override
                public int compare(Draw o1, Draw o2) {
                    return o2.getGameStatus().compareTo(o1.getGameStatus());
                }
            });
            return draws.toArray(new Draw[0]);
        }

        @Override
        protected void onPostExecute(Draw[] data) {
            mLoadingIndicator.setVisibility(View.INVISIBLE);
            if (data != null) {
                showDrawsDataView();
                mDrawsAdapter.setData(data);
            } else {
                showErrorMessage();
            }
        }
    }

    private void showErrorMessage() {
        /* First, hide the currently visible data */
        mRecyclerView.setVisibility(View.INVISIBLE);
        /* Then, show the error */
        mErrorMessageDisplay.setVisibility(View.VISIBLE);
    }
}
