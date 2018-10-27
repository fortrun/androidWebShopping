package com.lava.music.ui.main.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lava.music.R;
import com.lava.music.ui.base.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BannerAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.banner_item,parent));
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.banner_image)
        ImageView mBanner;

        @Override
        protected void clear() {
            mBanner.setImageDrawable(null);
        }

        public ViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

        }
    }
}
