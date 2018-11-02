package com.lava.music.ui.main.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lava.music.R;
import com.lava.music.data.network.model.Banner;
import com.lava.music.ui.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BannerAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Banner.Item> itemList;

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }

    public BannerAdapter(List<Banner.Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void setData(List<Banner.Item> items) {
        itemList.addAll(items);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.banner_item, parent));
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
            if (getItemCount() < position && position < 0)
                return;
            Banner.Item item = itemList.get(position);
            String imageUrl = item.getImageUrl();
            if (imageUrl != null) {
                Glide.with(mBanner.getContext())
                        .load(imageUrl)
                        .asBitmap()
                        .centerCrop()
                        .into(mBanner);
            }
        }
    }
}
