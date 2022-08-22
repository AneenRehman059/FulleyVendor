package com.zasa.fuellyvendor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;


import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {
    private List<SliderItems> sliderItems;
    private ViewPager2 viewPager2;

    SliderAdapter(List<SliderItems> sliderItems, ViewPager2 viewPager2) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_item_container, parent, false
                ));
    }


    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImage(sliderItems.get(position));

//        holder.setuponboardingLndicators(   holder.itemView,holder.linearLay);
//        holder.setCurrentonboardingindicator( 0,holder.itemView,holder.linearLay);
//
//
//        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//
//                holder.setuponboardingLndicators(   holder.itemView,holder.linearLay);
//                holder.setCurrentonboardingindicator( position,holder.itemView,holder.linearLay);
//
//                //Toast.makeText(ViewPagerActivity.this, "" + position, Toast.LENGTH_SHORT).show();
//
//
//            }
//
//
//        });

    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }



    class SliderViewHolder extends RecyclerView.ViewHolder {

TextView tv_serviceName,tv_servicePrice;
        LinearLayout linearLay;

        SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_serviceName = itemView.findViewById(R.id.tv_serviceName);
            tv_servicePrice = itemView.findViewById(R.id.tv_servicePrice);
            linearLay = itemView.findViewById(R.id.linearLay);
        }

        void setImage(SliderItems sliderItems) {
            //use glide or picasso in case you get image from internet
            tv_serviceName.setText(sliderItems.getName());
            tv_servicePrice.setText(sliderItems.getPrice());
        }
//
//        private void setuponboardingLndicators( View itemView,LinearLayout linearLay) {
//           // ImageView[] indicators = new ImageView[sliderAdapter.getItemCount()];
//            ImageView[] indicators = new ImageView[sliderItems.size()];
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
//                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            layoutParams.setMargins(8, 0, 8, 0);
//            for (int i = 0; i < indicators.length; i++) {
//                indicators[i] = new ImageView(itemView.getContext());
//                indicators[i].setImageDrawable(ContextCompat.getDrawable(itemView.getContext(),
//                        R.drawable.page_inavtive));
//                indicators[i].setLayoutParams(layoutParams);
//                linearLay.addView(indicators[i]);
//            }
//
//        }
//
//        private void setCurrentonboardingindicator( int index,View itemView,LinearLayout linearLay){
//
//
//            int childcount =linearLay.getChildCount( );
//            for (int i = 0; i< childcount ; i++) {
//
//
//                ImageView imageView = (ImageView)linearLay.getChildAt (i);
//                if (i == index)
//                    imageView.setImageDrawable(
//                            ContextCompat.getDrawable( itemView.getContext(), R.drawable.page_avtive));
//                else {
//                    imageView.setImageDrawable(
//                            ContextCompat.getDrawable(itemView.getContext(), R.drawable .page_inavtive));
//
//                }
//
//
//
//
//
//            }
//
//
//        }


    }
}