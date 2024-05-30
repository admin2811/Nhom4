// Generated by view binder compiler. Do not edit!
package com.englishtlu.english_learning.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.englishtlu.english_learning.R;
import com.google.android.material.imageview.ShapeableImageView;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentChangeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CircleImageView ImageProfile;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final EditText edtDob;

  @NonNull
  public final Spinner edtGender;

  @NonNull
  public final EditText edtMobile;

  @NonNull
  public final EditText edtName;

  @NonNull
  public final Spinner edtRelative;

  @NonNull
  public final EditText edtSchool;

  @NonNull
  public final ImageView imageView8;

  @NonNull
  public final ImageView imageView9;

  @NonNull
  public final ProgressBar progressBar2;

  @NonNull
  public final Button saveBtn;

  @NonNull
  public final ShapeableImageView selectPhoto;

  @NonNull
  public final TextView textView11;

  @NonNull
  public final TextView textView12;

  @NonNull
  public final TextView textView13;

  @NonNull
  public final TextView textView14;

  @NonNull
  public final TextView textView16;

  @NonNull
  public final TextView textView17;

  private FragmentChangeBinding(@NonNull ConstraintLayout rootView,
      @NonNull CircleImageView ImageProfile, @NonNull ConstraintLayout constraintLayout,
      @NonNull EditText edtDob, @NonNull Spinner edtGender, @NonNull EditText edtMobile,
      @NonNull EditText edtName, @NonNull Spinner edtRelative, @NonNull EditText edtSchool,
      @NonNull ImageView imageView8, @NonNull ImageView imageView9,
      @NonNull ProgressBar progressBar2, @NonNull Button saveBtn,
      @NonNull ShapeableImageView selectPhoto, @NonNull TextView textView11,
      @NonNull TextView textView12, @NonNull TextView textView13, @NonNull TextView textView14,
      @NonNull TextView textView16, @NonNull TextView textView17) {
    this.rootView = rootView;
    this.ImageProfile = ImageProfile;
    this.constraintLayout = constraintLayout;
    this.edtDob = edtDob;
    this.edtGender = edtGender;
    this.edtMobile = edtMobile;
    this.edtName = edtName;
    this.edtRelative = edtRelative;
    this.edtSchool = edtSchool;
    this.imageView8 = imageView8;
    this.imageView9 = imageView9;
    this.progressBar2 = progressBar2;
    this.saveBtn = saveBtn;
    this.selectPhoto = selectPhoto;
    this.textView11 = textView11;
    this.textView12 = textView12;
    this.textView13 = textView13;
    this.textView14 = textView14;
    this.textView16 = textView16;
    this.textView17 = textView17;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentChangeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentChangeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_change, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentChangeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ImageProfile;
      CircleImageView ImageProfile = ViewBindings.findChildViewById(rootView, id);
      if (ImageProfile == null) {
        break missingId;
      }

      id = R.id.constraintLayout;
      ConstraintLayout constraintLayout = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout == null) {
        break missingId;
      }

      id = R.id.edtDob;
      EditText edtDob = ViewBindings.findChildViewById(rootView, id);
      if (edtDob == null) {
        break missingId;
      }

      id = R.id.edtGender;
      Spinner edtGender = ViewBindings.findChildViewById(rootView, id);
      if (edtGender == null) {
        break missingId;
      }

      id = R.id.edtMobile;
      EditText edtMobile = ViewBindings.findChildViewById(rootView, id);
      if (edtMobile == null) {
        break missingId;
      }

      id = R.id.edtName;
      EditText edtName = ViewBindings.findChildViewById(rootView, id);
      if (edtName == null) {
        break missingId;
      }

      id = R.id.edtRelative;
      Spinner edtRelative = ViewBindings.findChildViewById(rootView, id);
      if (edtRelative == null) {
        break missingId;
      }

      id = R.id.edtSchool;
      EditText edtSchool = ViewBindings.findChildViewById(rootView, id);
      if (edtSchool == null) {
        break missingId;
      }

      id = R.id.imageView8;
      ImageView imageView8 = ViewBindings.findChildViewById(rootView, id);
      if (imageView8 == null) {
        break missingId;
      }

      id = R.id.imageView9;
      ImageView imageView9 = ViewBindings.findChildViewById(rootView, id);
      if (imageView9 == null) {
        break missingId;
      }

      id = R.id.progressBar2;
      ProgressBar progressBar2 = ViewBindings.findChildViewById(rootView, id);
      if (progressBar2 == null) {
        break missingId;
      }

      id = R.id.saveBtn;
      Button saveBtn = ViewBindings.findChildViewById(rootView, id);
      if (saveBtn == null) {
        break missingId;
      }

      id = R.id.selectPhoto;
      ShapeableImageView selectPhoto = ViewBindings.findChildViewById(rootView, id);
      if (selectPhoto == null) {
        break missingId;
      }

      id = R.id.textView11;
      TextView textView11 = ViewBindings.findChildViewById(rootView, id);
      if (textView11 == null) {
        break missingId;
      }

      id = R.id.textView12;
      TextView textView12 = ViewBindings.findChildViewById(rootView, id);
      if (textView12 == null) {
        break missingId;
      }

      id = R.id.textView13;
      TextView textView13 = ViewBindings.findChildViewById(rootView, id);
      if (textView13 == null) {
        break missingId;
      }

      id = R.id.textView14;
      TextView textView14 = ViewBindings.findChildViewById(rootView, id);
      if (textView14 == null) {
        break missingId;
      }

      id = R.id.textView16;
      TextView textView16 = ViewBindings.findChildViewById(rootView, id);
      if (textView16 == null) {
        break missingId;
      }

      id = R.id.textView17;
      TextView textView17 = ViewBindings.findChildViewById(rootView, id);
      if (textView17 == null) {
        break missingId;
      }

      return new FragmentChangeBinding((ConstraintLayout) rootView, ImageProfile, constraintLayout,
          edtDob, edtGender, edtMobile, edtName, edtRelative, edtSchool, imageView8, imageView9,
          progressBar2, saveBtn, selectPhoto, textView11, textView12, textView13, textView14,
          textView16, textView17);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
