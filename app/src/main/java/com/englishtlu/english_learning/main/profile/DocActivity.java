
package com.englishtlu.english_learning.main.profile;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SearchView.OnQueryTextListener;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.englishtlu.english_learning.R;
import com.englishtlu.english_learning.main.profile.adapter.DocAdapter;
import com.englishtlu.english_learning.main.profile.model.Doc;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DocActivity extends AppCompatActivity implements DocAdapter.OnItemClickListener {
    private static final int REQUEST_CODE_PERMISSIONS = 1001;
    private static final int REQUEST_CODE_PICK_PDF = 1002;
    private  ImageView ivBack,ivAdd;
    private  RecyclerView recyclerView;
    private DocAdapter docAdapter;
    private List<Doc> docList;
    private Uri selectedPdfUri;
    private TextView tvSelectedFile,currentTextView;
    private Toolbar toolbar;
    private SearchView searchView;
    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.rvdoc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        docList = new ArrayList<>();
        docAdapter = new DocAdapter(docList, (Context) this, (DocAdapter.OnItemClickListener) this);
        recyclerView.setAdapter(docAdapter);
        fetchDocsFromFireBase();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main1,menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        assert searchView != null;
        searchView.setSearchableInfo(Objects.requireNonNull(searchManager).getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query){
                docAdapter.getFilter().filter(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText){
                docAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Quay trở lại trang profile
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        if(item.getItemId() == R.id.action_add){
            showUploadDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    private void showUploadDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_upload_pdf,null);
        builder.setView(dialogView);
        EditText etPdfName = dialogView.findViewById(R.id.etPdfName);
        Button btnSelectedFile = dialogView.findViewById(R.id.btnSelectFile);
        tvSelectedFile = dialogView.findViewById(R.id.tvSelectedFile);
        Button btnUpload = dialogView.findViewById(R.id.btnUpload);
        AlertDialog dialog = builder.create();
        btnSelectedFile.setOnClickListener(v -> {
            this.currentTextView = tvSelectedFile;
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("application/pdf");
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            startActivityForResult(Intent.createChooser(intent,"Select PDF"),REQUEST_CODE_PICK_PDF);
        });
        btnUpload.setOnClickListener(v-> {
            String pdfName = etPdfName.getText().toString().trim();
            if (pdfName.isEmpty()){
                Toast.makeText(this,"Please enter PDF name",Toast.LENGTH_SHORT).show();
                return;
            }
            if(selectedPdfUri == null){
                Toast.makeText(this, "Please select a PDF file",Toast.LENGTH_SHORT).show();
                return;
            }
            uploadFileToFireBase(selectedPdfUri,pdfName);
            dialog.dismiss();
        });
        dialog.show();
    }


    @Override
    public void onSelectFileButtonClick(int position, TextView tvSelectedFile) {
        this.currentTextView = tvSelectedFile;
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(Intent.createChooser(intent, "Select PDF"), REQUEST_CODE_PICK_PDF);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_PICK_PDF && resultCode == Activity.RESULT_OK){
            if(data != null){
                selectedPdfUri = data.getData();
                if (selectedPdfUri != null){
                        if (currentTextView != null){
                            currentTextView.setText(selectedPdfUri.getLastPathSegment());
                            docAdapter.setSelectFile(selectedPdfUri);
                        }else {
                            Log.e("DocFragment", "TextView tvSelectedFile is null");
                        }
                        if(tvSelectedFile != null){
                            tvSelectedFile.setText(selectedPdfUri.getLastPathSegment());
                        }else{
                            Log.e("DocFragment", "TextView tvSelectedFile is null");
                        }
                }
            }
        }
    }
    private void uploadFileToFireBase(Uri pdfUri, String pdfName) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            String uid = user.getUid();
            String fileName = pdfName + ".pdf";
            StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("pdfs/" + uid + "/" + fileName);
            storageReference.putFile(pdfUri)
                    .addOnSuccessListener(taskSnapshot -> storageReference.getDownloadUrl().addOnSuccessListener(uri -> {
                        String downloadUrl = uri.toString();
                        saveFileToRealtimeDatabase(fileName,downloadUrl);
                    }).addOnFailureListener(e -> {
                        Toast.makeText(this,"Failed to get download URL",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }))
                    .addOnFailureListener(e -> {
                        Toast.makeText(this,"Failed to upload file",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    });
          }
    }
    private void saveFileToRealtimeDatabase(String fileName, String downloadUrl) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            String uid = user.getUid();
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("document").child(uid).child("pdfs");
            String pdfId = databaseReference.push().getKey();
            Doc newDoc = new Doc(pdfId, fileName, downloadUrl);
            if (pdfId != null){
                databaseReference.child(pdfId).setValue(newDoc)
                        .addOnSuccessListener(aVoid -> Toast.makeText(this, "File Upload successfully",Toast.LENGTH_SHORT).show())
                        .addOnFailureListener(e -> {
                            Toast.makeText(this, "Failed to save file Url",Toast.LENGTH_SHORT).show();
                            Log.e("FirebaseDatabaseError","Error saving file Url",e);
                        });
            }
        }
    }

    private void fetchDocsFromFireBase() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            String uid = user.getUid();
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("document").child(uid).child("pdfs");
            databaseReference.addValueEventListener(new ValueEventListener() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    docList.clear();
                    for(DataSnapshot snapshot : dataSnapshot.getChildren() ){
                        Doc doc = snapshot.getValue(Doc.class);
                        docList.add(doc);
                    }
                    docAdapter.notifyDataSetChanged();
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(DocActivity.this, "Failed to fetch documents",Toast.LENGTH_SHORT).show();
                    Log.e("FirebaseDatabaseError","Error fetching documents",error.toException());
                }
            });
        }
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}