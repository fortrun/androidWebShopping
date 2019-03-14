package com.lava.music.ui.main.home;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lava.music.R;
import com.lava.music.data.network.model.Banner;
import com.lava.music.ui.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChannelAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Banner.Channel> mData;

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
        Log.d("ChannelAdapter", "onBind:" + i);
    }

    public ChannelAdapter(List<Banner.Channel> list) {
        mData = list;
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public void setData(List<Banner.Channel> data) {
        //Log.d("ChannelAdapter", "data number:" + data.size());
        mData.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.channel_item, viewGroup, false);
        return new ChannelHolder(v);
    }


    public class ChannelHolder extends BaseViewHolder {

        @BindView(R.id.channel_pic)
        ImageView pic;

        @BindView(R.id.channel_text)
        TextView text;

        @Override
        protected void clear() {
            pic.setImageBitmap(null);
            text.setText(null);
        }

        public ChannelHolder(View item) {
            super(item);
            ButterKnife.bind(this, item);
        }

        @Override
        public void onBind(int position) {
            if (position > getItemCount() || position < 0)
                return;
            Banner.Channel item = mData.get(position);

            //Log.d("ChannelAdapter", "data info:" + item.getName());
            Log.d("ChannelAdapter", "data info:" + item.getImageUrl());
            Glide.with(pic.getContext())
                    .load(item.getImageUrl())
                    .asBitmap()
                    .fitCenter()
                    .into(pic);
            text.setText(item.getName());
        }
    }
}
