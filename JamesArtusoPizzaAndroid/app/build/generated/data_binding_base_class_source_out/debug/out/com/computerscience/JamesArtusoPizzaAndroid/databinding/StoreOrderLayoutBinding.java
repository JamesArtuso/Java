// Generated by view binder compiler. Do not edit!
package com.computerscience.JamesArtusoPizzaAndroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.computerscience.JamesArtusoPizzaAndroid.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class StoreOrderLayoutBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button clearStoreOrderButton;

  @NonNull
  public final TextView orderInfoView;

  @NonNull
  public final RecyclerView orderRecycler;

  @NonNull
  public final Button storeOrderBackButton;

  @NonNull
  public final TextView storeTotal;

  private StoreOrderLayoutBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button clearStoreOrderButton, @NonNull TextView orderInfoView,
      @NonNull RecyclerView orderRecycler, @NonNull Button storeOrderBackButton,
      @NonNull TextView storeTotal) {
    this.rootView = rootView;
    this.clearStoreOrderButton = clearStoreOrderButton;
    this.orderInfoView = orderInfoView;
    this.orderRecycler = orderRecycler;
    this.storeOrderBackButton = storeOrderBackButton;
    this.storeTotal = storeTotal;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static StoreOrderLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static StoreOrderLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.store_order_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static StoreOrderLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.clear_store_order_button;
      Button clearStoreOrderButton = ViewBindings.findChildViewById(rootView, id);
      if (clearStoreOrderButton == null) {
        break missingId;
      }

      id = R.id.order_info_view;
      TextView orderInfoView = ViewBindings.findChildViewById(rootView, id);
      if (orderInfoView == null) {
        break missingId;
      }

      id = R.id.order_recycler;
      RecyclerView orderRecycler = ViewBindings.findChildViewById(rootView, id);
      if (orderRecycler == null) {
        break missingId;
      }

      id = R.id.store_order_back_button;
      Button storeOrderBackButton = ViewBindings.findChildViewById(rootView, id);
      if (storeOrderBackButton == null) {
        break missingId;
      }

      id = R.id.store_total;
      TextView storeTotal = ViewBindings.findChildViewById(rootView, id);
      if (storeTotal == null) {
        break missingId;
      }

      return new StoreOrderLayoutBinding((ConstraintLayout) rootView, clearStoreOrderButton,
          orderInfoView, orderRecycler, storeOrderBackButton, storeTotal);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
