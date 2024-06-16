// Generated by view binder compiler. Do not edit!
package com.englishtlu.english_learning.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.englishtlu.english_learning.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMain2Binding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RelativeLayout ConstrainLayout;

  @NonNull
  public final LinearLayout bottomBar;

  @NonNull
  public final ImageView dicImage;

  @NonNull
  public final LinearLayout dicLayout;

  @NonNull
  public final TextView dicTxt;

  @NonNull
  public final FloatingActionButton fabButton;

  @NonNull
  public final FragmentContainerView fragmentContainerView;

  @NonNull
  public final ImageView homeImage;

  @NonNull
  public final LinearLayout homeLayout;

  @NonNull
  public final TextView homeTxt;

  @NonNull
  public final ImageView profileImage;

  @NonNull
  public final LinearLayout profileLayout;

  @NonNull
  public final TextView profileTxt;

  @NonNull
  public final ImageView translateImage;

  @NonNull
  public final LinearLayout translateLayout;

  @NonNull
  public final TextView translateTxt;

  private ActivityMain2Binding(@NonNull RelativeLayout rootView,
      @NonNull RelativeLayout ConstrainLayout, @NonNull LinearLayout bottomBar,
      @NonNull ImageView dicImage, @NonNull LinearLayout dicLayout, @NonNull TextView dicTxt,
      @NonNull FloatingActionButton fabButton, @NonNull FragmentContainerView fragmentContainerView,
      @NonNull ImageView homeImage, @NonNull LinearLayout homeLayout, @NonNull TextView homeTxt,
      @NonNull ImageView profileImage, @NonNull LinearLayout profileLayout,
      @NonNull TextView profileTxt, @NonNull ImageView translateImage,
      @NonNull LinearLayout translateLayout, @NonNull TextView translateTxt) {
    this.rootView = rootView;
    this.ConstrainLayout = ConstrainLayout;
    this.bottomBar = bottomBar;
    this.dicImage = dicImage;
    this.dicLayout = dicLayout;
    this.dicTxt = dicTxt;
    this.fabButton = fabButton;
    this.fragmentContainerView = fragmentContainerView;
    this.homeImage = homeImage;
    this.homeLayout = homeLayout;
    this.homeTxt = homeTxt;
    this.profileImage = profileImage;
    this.profileLayout = profileLayout;
    this.profileTxt = profileTxt;
    this.translateImage = translateImage;
    this.translateLayout = translateLayout;
    this.translateTxt = translateTxt;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMain2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMain2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main2, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMain2Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      RelativeLayout ConstrainLayout = (RelativeLayout) rootView;

      id = R.id.bottomBar;
      LinearLayout bottomBar = ViewBindings.findChildViewById(rootView, id);
      if (bottomBar == null) {
        break missingId;
      }

      id = R.id.dicImage;
      ImageView dicImage = ViewBindings.findChildViewById(rootView, id);
      if (dicImage == null) {
        break missingId;
      }

      id = R.id.dicLayout;
      LinearLayout dicLayout = ViewBindings.findChildViewById(rootView, id);
      if (dicLayout == null) {
        break missingId;
      }

      id = R.id.dicTxt;
      TextView dicTxt = ViewBindings.findChildViewById(rootView, id);
      if (dicTxt == null) {
        break missingId;
      }

      id = R.id.fab_button;
      FloatingActionButton fabButton = ViewBindings.findChildViewById(rootView, id);
      if (fabButton == null) {
        break missingId;
      }

      id = R.id.fragmentContainerView;
      FragmentContainerView fragmentContainerView = ViewBindings.findChildViewById(rootView, id);
      if (fragmentContainerView == null) {
        break missingId;
      }

      id = R.id.homeImage;
      ImageView homeImage = ViewBindings.findChildViewById(rootView, id);
      if (homeImage == null) {
        break missingId;
      }

      id = R.id.homeLayout;
      LinearLayout homeLayout = ViewBindings.findChildViewById(rootView, id);
      if (homeLayout == null) {
        break missingId;
      }

      id = R.id.homeTxt;
      TextView homeTxt = ViewBindings.findChildViewById(rootView, id);
      if (homeTxt == null) {
        break missingId;
      }

      id = R.id.profileImage;
      ImageView profileImage = ViewBindings.findChildViewById(rootView, id);
      if (profileImage == null) {
        break missingId;
      }

      id = R.id.profileLayout;
      LinearLayout profileLayout = ViewBindings.findChildViewById(rootView, id);
      if (profileLayout == null) {
        break missingId;
      }

      id = R.id.profileTxt;
      TextView profileTxt = ViewBindings.findChildViewById(rootView, id);
      if (profileTxt == null) {
        break missingId;
      }

      id = R.id.translateImage;
      ImageView translateImage = ViewBindings.findChildViewById(rootView, id);
      if (translateImage == null) {
        break missingId;
      }

      id = R.id.translateLayout;
      LinearLayout translateLayout = ViewBindings.findChildViewById(rootView, id);
      if (translateLayout == null) {
        break missingId;
      }

      id = R.id.translateTxt;
      TextView translateTxt = ViewBindings.findChildViewById(rootView, id);
      if (translateTxt == null) {
        break missingId;
      }

      return new ActivityMain2Binding((RelativeLayout) rootView, ConstrainLayout, bottomBar,
          dicImage, dicLayout, dicTxt, fabButton, fragmentContainerView, homeImage, homeLayout,
          homeTxt, profileImage, profileLayout, profileTxt, translateImage, translateLayout,
          translateTxt);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}