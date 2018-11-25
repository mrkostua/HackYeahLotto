package hackyeah.hackyeahlotto.adapters;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import hackyeah.hackyeahlotto.R;
import hackyeah.hackyeahlotto.model.Draw;

public class DrawItemListAdapter extends RecyclerView.Adapter<DrawItemListAdapter.DrawItemListViewHolder> {

    private final DrawItemListAdapterOnClickHandler mClickHandler;
    private Draw[] mData;

    public interface DrawItemListAdapterOnClickHandler {
        void onClick(Draw draw);
    }

    public DrawItemListAdapter(DrawItemListAdapterOnClickHandler clickHandler) {
        this.mClickHandler = clickHandler;
    }

    @Override
    public void onBindViewHolder(DrawItemListViewHolder holder, int position) {
        Draw draw = mData[position];
        Context context = holder.itemView.getContext();
        String date = DateUtils.formatDateTime(context, draw.getPurchaseDate().getTime(), DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_NUMERIC_DATE | DateUtils.FORMAT_SHOW_YEAR);
        holder.mPurchaseDateTextView.setText(context.getString(R.string.draw_purchase_date_desc, date));
        date = DateUtils.formatDateTime(context, draw.getDrawingDate().getTime(), DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_NUMERIC_DATE | DateUtils.FORMAT_SHOW_YEAR);
        holder.mDrawingDate.setText(context.getString(R.string.draw_drawing_date_desc, date));
        String drawStatus;
        int colorBackgroundId;
        int colorId;
        switch (draw.getGameStatus()) {
            case WIN:
                drawStatus = context.getString(R.string.game_win_status);
                colorId = context.getResources().getColor(android.R.color.holo_green_dark);

                break;
            case LOST:
                drawStatus = context.getString(R.string.game_lost_status);
                colorId = context.getResources().getColor(android.R.color.holo_red_dark);
                break;
            case WAITING:
                drawStatus = context.getString(R.string.game_waiting_status);
                colorId = context.getResources().getColor(android.R.color.black);
                break;
            default:
                colorId = context.getResources().getColor(android.R.color.holo_green_light);
                drawStatus = "";
        }
        holder.mDrawStatusTextView.setText(drawStatus);
        holder.mDrawStatusTextView.setTextColor(colorId);

        holder.mGameName.setText(draw.getGame().name().replace('_', ' ')); //TODO translate
        holder.mGameShortInfoTextView.setText("");
        if (draw.getBgState()) {
            holder.itemView.setBackground(context.getDrawable(R.drawable.shape_round_blue));
        } else {
            holder.itemView.setBackground(context.getDrawable(R.drawable.shape_round_gray));
        }
    }

    @Override
    public int getItemCount() {
        if (null == mData) return 0;
        return mData.length;
    }

    public void setData(Draw[] data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    public class DrawItemListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView mPurchaseDateTextView;
        private final TextView mDrawingDate;
        private final TextView mGameName;
        private final TextView mGameShortInfoTextView;
        private final TextView mDrawStatusTextView;
        private final ConstraintLayout clDrawMain;


        public DrawItemListViewHolder(View itemView) {
            super(itemView);
            mPurchaseDateTextView = itemView.findViewById(R.id.tv_purchase_date);
            mDrawingDate = itemView.findViewById(R.id.tv_drawing_date);
            mGameName = itemView.findViewById(R.id.tv_game_name);
            mGameShortInfoTextView = itemView.findViewById(R.id.tv_game_short_info);
            mDrawStatusTextView = itemView.findViewById(R.id.tv_draw_status);
            clDrawMain = itemView.findViewById(R.id.clDrawMain);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            mClickHandler.onClick(mData[adapterPosition]);
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
