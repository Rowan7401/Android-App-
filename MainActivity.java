package com.example.nbastatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

private final LinkedList<String> mRecipeList = new LinkedList<>();
private final LinkedList<String> mRecipeDescriptionList = new LinkedList<>();
private RecyclerView mRecyclerView;
private RecipeAdapter mAdapter;

public class MainActivity extends AppCompatActivity {
    private EditText mBookInput;
    private TextView mTitleText;
    private TextView mAuthorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mBookInput = (EditText) findViewById(R.id.bookInput);
        mTitleText = (TextView) findViewById(R.id.titleText);
        mAuthorText = (TextView) findViewById(R.id.authorText);

        mRecipeList.add("Teriyaki Chicken");
        mRecipeDescriptionList.add("A quick and simple, protein rich dish that " +
                "will leave you satisfied and feeling good. With only 5 ingredients, it " +
                "is a crime not to make this once a week.");

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new RecipeAdapter(this, mRecipeList, mRecipeDescriptionList);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void searchBooks(View view) {
        String queryString = mBookInput.getText().toString();
        FetchBook fb = new FetchBook(mTitleText, mAuthorText);
        fb.execute(queryString);
    }
}