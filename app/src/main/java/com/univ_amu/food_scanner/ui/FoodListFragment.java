package com.univ_amu.food_scanner.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.univ_amu.food_scanner.data.Repository;
import com.univ_amu.food_scanner.databinding.FragmentFoodListBinding;

public class FoodListFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentFoodListBinding binding = FragmentFoodListBinding.inflate(inflater, container, false);
        /* TODO :
            - créer une instance de Repository
            - créer une instance de FoodListAdapter
            - associer la liste des aliments obtenue via l'instance de Repository
              à l'adaptateur à l'aide de la méthode submitList
            - associer l'adaptateur à la RecyclerView (binding.foodList)
              à l'aide de la méthode setAdapter de RecyclerView
        */

        Repository repository = new Repository();
        FoodListAdapter foodListAdapter = new FoodListAdapter();
        foodListAdapter.submitList(repository.getFoods());
        binding.foodList.setAdapter(foodListAdapter);

        binding.foodList.addItemDecoration(
                new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        return binding.getRoot();
    }
}

