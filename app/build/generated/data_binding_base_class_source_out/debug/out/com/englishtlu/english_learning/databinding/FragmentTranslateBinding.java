// Generated by view binder compiler. Do not edit!
package com.englishtlu.english_learning.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.englishtlu.english_learning.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentTranslateBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Spinner destinationLanguageSpinner;

  @NonNull
  public final TextView destinationLanguageTv;

  @NonNull
  public final ImageView idIVCamera;

  @NonNull
  public final ImageView idIVMic;

  @NonNull
  public final ImageButton languageSwitchBtn;

  @NonNull
  public final RelativeLayout main;

  @NonNull
  public final EditText sourceLanguageEt;

  @NonNull
  public final Spinner sourceLanguageSpinner;

  @NonNull
  public final AppCompatButton translateBtn;

  private FragmentTranslateBinding(@NonNull RelativeLayout rootView,
      @NonNull Spinner destinationLanguageSpinner, @NonNull TextView destinationLanguageTv,
      @NonNull ImageView idIVCamera, @NonNull ImageView idIVMic,
      @NonNull ImageButton languageSwitchBtn, @NonNull RelativeLayout main,
      @NonNull EditText sourceLanguageEt, @NonNull Spinner sourceLanguageSpinner,
      @NonNull AppCompatButton translateBtn) {
    this.rootView = rootView;
    this.destinationLanguageSpinner = destinationLanguageSpinner;
    this.destinationLanguageTv = destinationLanguageTv;
    this.idIVCamera = idIVCamera;
    this.idIVMic = idIVMic;
    this.languageSwitchBtn = languageSwitchBtn;
    this.main = main;
    this.sourceLanguageEt = sourceLanguageEt;
    this.sourceLanguageSpinner = sourceLanguageSpinner;
    this.translateBtn = translateBtn;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentTranslateBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentTranslateBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_translate, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentTranslateBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.destinationLanguageSpinner;
      Spinner destinationLanguageSpinner = ViewBindings.findChildViewById(rootView, id);
      if (destinationLanguageSpinner == null) {
        break missingId;
      }

      id = R.id.destinationLanguageTv;
      TextView destinationLanguageTv = ViewBindings.findChildViewById(rootView, id);
      if (destinationLanguageTv == null) {
        break missingId;
      }

      id = R.id.idIVCamera;
      ImageView idIVCamera = ViewBindings.findChildViewById(rootView, id);
      if (idIVCamera == null) {
        break missingId;
      }

      id = R.id.idIVMic;
      ImageView idIVMic = ViewBindings.findChildViewById(rootView, id);
      if (idIVMic == null) {
        break missingId;
      }

      id = R.id.languageSwitchBtn;
      ImageButton languageSwitchBtn = ViewBindings.findChildViewById(rootView, id);
      if (languageSwitchBtn == null) {
        break missingId;
      }

      RelativeLayout main = (RelativeLayout) rootView;

      id = R.id.sourceLanguageEt;
      EditText sourceLanguageEt = ViewBindings.findChildViewById(rootView, id);
      if (sourceLanguageEt == null) {
        break missingId;
      }

      id = R.id.sourceLanguageSpinner;
      Spinner sourceLanguageSpinner = ViewBindings.findChildViewById(rootView, id);
      if (sourceLanguageSpinner == null) {
        break missingId;
      }

      id = R.id.translateBtn;
      AppCompatButton translateBtn = ViewBindings.findChildViewById(rootView, id);
      if (translateBtn == null) {
        break missingId;
      }

      return new FragmentTranslateBinding((RelativeLayout) rootView, destinationLanguageSpinner,
          destinationLanguageTv, idIVCamera, idIVMic, languageSwitchBtn, main, sourceLanguageEt,
          sourceLanguageSpinner, translateBtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}