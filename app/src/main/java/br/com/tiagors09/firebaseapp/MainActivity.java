package br.com.tiagors09.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("usuarios");
//    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
//    private TextInputEditText email, password;
    private ImageView imageView;
    private Button buttonUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        buttonUpload = findViewById(R.id.buttonUpload);

        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Salvar em memória principal
                imageView.setDrawingCacheEnabled(true);
                imageView.buildDrawingCache();

                // Recuperar bitmap da imagem
                Bitmap bitmap = imageView.getDrawingCache();

                // Converter bitmap para um formato de imagem
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(
                        Bitmap.CompressFormat.PNG,
                        75,
                        baos
                );

                // Converter para array de bytes
                byte[] dadosImagem = baos.toByteArray();

                // Define nós para o storage
                StorageReference storageReference = FirebaseStorage.getInstance().getReference();
                StorageReference imagens = storageReference.child("imagens");
//                StorageReference imagemRef = imagens.child(String.format("%s.png", UUID.randomUUID()));

                StorageReference imagemRef = imagens.child("paisagem.png");

                imagemRef.delete();
}
                // Retorna objeto que irá controlar o upload
//                UploadTask uploadTask = imagemRef.putBytes(dadosImagem);
//
//                uploadTask.addOnFailureListener(
//                        MainActivity.this,
//                        new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Toast.makeText(MainActivity.this, String.format("Falhou %s", e.getMessage()), Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                ).addOnSuccessListener(
//                        MainActivity.this,
//                        new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                            @Override
//                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                                imagemRef.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
//                                    @Override
//                                    public void onComplete(@NonNull Task<Uri> task) {
//                                        Uri url = task.getResult();
//                                    }
//                                });
//                                Toast.makeText(MainActivity.this, "Deu bom", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                );
//            }
//        });

//
//        email = findViewById(R.id.email);
//        password = findViewById(R.id.password);

//        firebaseAuth.signOut();
//
//        if (firebaseAuth.getCurrentUser() != null) {
//            Log.i("CreateUser", "Usuário logado");
//        } else {
//            Log.i("CreateUser", "Usuário não logado");
//        }

//        Usuario u = new MainActivity
//                .Usuario("Tiago", "Rodrigues", 22);
//        databaseReference.push().setValue(u);
//
//        u = new MainActivity
//                .Usuario("Roberto", "Miranda", 23);
//        databaseReference.push().setValue(u);
//
//        u = new MainActivity
//                .Usuario("José", "Silva", 23);
//        databaseReference.push().setValue(u);

//        databaseReference
//                .child("usuarios")
//                .child(u.getId().toString())
//                .setValue(u);
//
//        u = new MainActivity.Usuario("Roberto", "Rodrigues");
//
//        databaseReference
//                .child("usuarios")
//                .child(u.getId().toString())
//                .setValue(u);

//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Log.i("FIREBASE", snapshot.getValue().toString());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


//                firebaseAuth
//                .createUserWithEmailAndPassword(
//                        email.getText().toString(),
//                        password.getText().toString()
//                )
//                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(MainActivity.this, "Sucessful!", Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });


//        Query query = databaseReference
//                .orderByChild("nome")
//                .equalTo("Tiago");

//        Query query = databaseReference
//                .orderByKey()
//                .limitToFirst(2);

//        Query query = databaseReference
//                .orderByChild("idade")
//                        .startAt(40)
//                                .endAt(80);

//        Query query = databaseReference
//                .orderByChild("idade")
//                        .endAt(30);

//        Query query = databaseReference
//                .orderByChild("nome")
//                        .startAt(String.format("%s \uf8ff", "Jo"))
//                                .endAt(String.format("%s \uf8ff", "Ro"));

//        query.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Log.i("QUERY", snapshot.getValue().toString());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
        });
    }

    public void addUser(View v) {
        // Cadastro usuario
//        firebaseAuth
//                .signInWithEmailAndPassword(
//                        email.getText().toString(),
//                        password.getText().toString()
//                )
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Log.i("LOGIN", "Sucess!!");
//                        } else {
//                            Log.i("LOGIN", "Fail!!");
//                        }
//                    }
//                });
    }

    class Usuario {
        private String nome;
        private String sobrenome;
        private int idade;

        public Usuario(String nome, String sobrenome, int idade) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.idade = idade;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getSobrenome() {
            return sobrenome;
        }

        public void setSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }
    }
}