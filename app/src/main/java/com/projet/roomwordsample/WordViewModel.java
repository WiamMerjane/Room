package com.projet.roomwordsample;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.projet.roomwordsample.model.Word;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private final WordRepository mRepository;
    private final LiveData<List<Word>> mAllWords;

    public WordViewModel(Application application){
        super(application);
        mRepository=new WordRepository(application);
        mAllWords = mRepository.getmAllWords();
    }
    LiveData<List<Word>> getmAllWords(){ return mAllWords;}

    public void insert(Word word){mRepository.insert(word);}
}
