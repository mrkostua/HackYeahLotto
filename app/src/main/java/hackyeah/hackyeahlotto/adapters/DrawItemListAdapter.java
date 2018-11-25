package hackyeah.hackyeahlotto.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import hackyeah.hackyeahlotto.R;

import java.util.Collections;

public class DrawItemListAdapter extends RecyclerView.Adapter<DrawItemListAdapter.DrawItemListViewHolder> {

    private final DrawItemListAdapterOnClickHandler mClickHandler;
    private String mData;

    public interface DrawItemListAdapterOnClickHandler {
        void onClick(String data);
    }

    public DrawItemListAdapter(DrawItemListAdapterOnClickHandler clickHandler) {
        this.mClickHandler = clickHandler;
    }

    @Override
    public void onBindViewHolder(DrawItemListViewHolder holder, int position) {
        String weatherForThisDay = mData;
        holder.mBuyDateTextView.setText(weatherForThisDay);
    }

    @Override
    public int getItemCount() {
        if (null == mData) return 0;
        return Collections.singletonList(mData).size();
    }

    public void setData(String data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    public class DrawItemListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView mBuyDateTextView;
        private final TextView mDrawingDate;
        private final TextView mGameName;
        private final TextView mGameShortInfoTextView;
        private final TextView mDrawStatusTextView;


        public DrawItemListViewHolder(View itemView) {
            super(itemView);
            mBuyDateTextView = itemView.findViewById(R.id.tv_purchase_date);
            mDrawingDate = itemView.findViewById(R.id.tv_drawing_date);
            mGameName = itemView.findViewById(R.id.tv_game_name);
            mGameShortInfoTextView = itemView.findViewById(R.id.tv_game_short_info);
            mDrawStatusTextView = itemView.findViewById(R.id.tv_draw_status);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            String drawBuyDate = mData;
            mClickHandler.onClick(drawBuyDate);
        }
    }

    @Override
    public DrawItemListViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.draw_item_list;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new DrawItemListViewHolder(view);
    }
}
