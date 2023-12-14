package com.projet.roomwordsample;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.projet.roomwordsample.data.db.WordDao;
import com.projet.roomwordsample.data.db.WordRoomDatabase;
import com.projet.roomwordsample.model.Word;

import java.util.List;

public class WordRepository {

    private final WordDao mWordDao;
    private final LiveData<List<Word>> mAllWords;

    public WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao= db.wordDao();
        mAllWords= mWordDao.getAlphabetizedwords();
    }

    public LiveData<List<Word>> getmAllWords(){
        return mAllWords;
    }

    public void insert (Word word){
        WordRoomDatabase.databaseWriteExecutor.execute(() -> mWordDao.insert(word));
    }
}
