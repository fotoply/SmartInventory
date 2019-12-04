package dk.sdu.student.kitcheninventory.ui.contents;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InventoryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InventoryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Dette er beholdnings fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}