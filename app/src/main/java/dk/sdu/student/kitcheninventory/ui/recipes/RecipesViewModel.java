package dk.sdu.student.kitcheninventory.ui.recipes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecipesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RecipesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Dette er opskrifts fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}