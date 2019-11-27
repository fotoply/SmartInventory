package dk.sdu.student.kitcheninventory.ui.checkin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CheckInViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CheckInViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Dette er tjek in fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}