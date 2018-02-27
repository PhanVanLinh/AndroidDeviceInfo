package toong.vn.androiddeviceinfo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import toong.vn.androiddeviceinfo.data.model.DeviceInfo;

public class OneItemTypeAdapter extends RecyclerView.Adapter<OneItemTypeAdapter.ViewHolder> {
    private static final String TAG = "OneItemTypeAdapter";
    private List<DeviceInfo> items = new ArrayList<>();
    private LayoutInflater mInflater;
    private ItemClickListener mItemClickListener;

    public OneItemTypeAdapter(Context context, List<DeviceInfo> items) {
        mInflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, mItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DeviceInfo item = items.get(position);
        holder.bindItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemClickListener mItemClickListener;
        private TextView textTitle;
        private TextView textDescription;
        private TextView textValue;

        private ViewHolder(View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_title);
            textDescription = itemView.findViewById(R.id.text_description);
            textValue = itemView.findViewById(R.id.text_value);
            mItemClickListener = itemClickListener;
            itemView.setOnClickListener(this);
        }

        void bindItem(DeviceInfo item) {
            textTitle.setText(item.getTitle());
            textDescription.setText(item.getDescription());
            textValue.setText(item.getValue());
        }

        @Override
        public void onClick(View view) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}