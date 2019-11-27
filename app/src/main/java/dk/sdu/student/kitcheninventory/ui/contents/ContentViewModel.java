package dk.sdu.student.kitcheninventory.ui.contents;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ContentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Dette er beholdnings fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}