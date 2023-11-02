package com.example.foodfighter;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Firestore 데이터베이스에 연결
        FirebaseFirestore db = FirebaseFirestore.getInstance();

// 데이터 삽입
        Map<String, Object> dataToInsert = new HashMap<>();
        dataToInsert.put("name", "John Doe");
        dataToInsert.put("email", "johndoe@email.com");

        db.collection("test") // "users" 컬렉션에 데이터를 삽입
                .add(dataToInsert) // 데이터 추가
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        // 데이터가 성공적으로 추가될 때 호출됩니다.
                        // documentReference.getId()를 사용하여 추가된 문서의 ID를 가져올 수 있습니다.
                    }
                });

    }
}