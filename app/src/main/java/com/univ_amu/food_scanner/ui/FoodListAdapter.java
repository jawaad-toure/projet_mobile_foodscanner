package com.univ_amu.food_scanner.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.univ_amu.food_scanner.data.Food;
import com.univ_amu.food_scanner.databinding.FoodItemBinding;

public class FoodListAdapter extends ListAdapter<Food, FoodListAdapter.ViewHolder> {

    FoodListAdapter() {
        super(diffUtilCallback);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        FoodItemBinding binding = FoodItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Food food = getItem(position);
        holder.bind(food);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        FoodItemBinding foodItemBinding;
        public Food food;

        public ViewHolder(FoodItemBinding binding) {
            super(binding.getRoot());
            binding.setViewHolder(this);
            this.foodItemBinding = binding;
        }

        void bind(Food food) {
            this.food = food;
            foodItemBinding.invalidateAll();
        }

    }

    private static final DiffUtil.ItemCallback<Food> diffUtilCallback =
            new DiffUtil.ItemCallback<Food>() {

                @Override
                public boolean areItemsTheSame(Food oldFood, Food newFood) {
                    return oldFood.code.equals(newFood.code);
                }
                @Override
                public boolean areContentsTheSame(Food oldFood, Food newFood) {
                    return this.areItemsTheSame(oldFood, newFood);
                }
            };

}