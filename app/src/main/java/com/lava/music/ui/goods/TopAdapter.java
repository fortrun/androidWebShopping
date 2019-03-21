package com.lava.music.ui.goods;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lava.music.R;
import com.lava.music.data.network.model.GoodsGallery;
import com.lava.music.ui.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<GoodsGallery> itemList;

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
        Log.i("TopAdapter","size " + position);
    }

    public TopAdapter(List<GoodsGallery> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void setData(List<GoodsGallery> items) {
        itemList.addAll(items);
        Log.e("TopAdapter", "size " + items.size());
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.goods_top_pic, parent, false));
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.banner_image)
        ImageView mBanner;

        @Override
        protected void clear() {
            mBanner.setImageDrawable(null);
        }

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onBind(int position) {
            if (getItemCount() < position || position < 0)
                return;
            GoodsGallery item = itemList.get(position);
            String imageUrl = item.getImg_url();
            Log.e("TopAdapter", imageUrl);
            if (imageUrl != null) {
                Glide.with(mBanner.getContext())
                        .load(imageUrl)
                        .asBitmap()
                        .fitCenter()
                        .into(mBanner);
            }
        }
    }
}
