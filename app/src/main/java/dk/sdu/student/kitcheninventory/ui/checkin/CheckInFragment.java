package dk.sdu.student.kitcheninventory.ui.checkin;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import dk.sdu.student.kitcheninventory.R;
import dk.sdu.student.kitcheninventory.ui.barcode.BarcodeReaderFragment;

public class CheckInFragment extends Fragment implements BarcodeReaderFragment.BarcodeReaderListener {

    private CheckInViewModel notificationsViewModel;
    private boolean ready = true;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(CheckInViewModel.class);
        View root = inflater.inflate(R.layout.fragment_checkin, container, false);
        BarcodeReaderFragment readerFragment = BarcodeReaderFragment.newInstance(true, false, View.VISIBLE);
        readerFragment.setListener(this);
        FragmentManager supportFragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fm_container, readerFragment);
        fragmentTransaction.commitAllowingStateLoss();
        return root;
    }

    @Override
    public void onScanned(Barcode barcode) {
        if(ready) {
            System.out.println("Commencing scan");
            ready = false;
            CheckInAddProduct addProduct = CheckInAddProduct.newInstance(barcode.displayValue, barcode.rawValue);
            addProduct.show(getFragmentManager(), "fragment_add_product");
            getFragmentManager().executePendingTransactions();
            addProduct.getDialog().setOnDismissListener(dialogInterface -> ready = true);
        }
    }

    @Override
    public void onScannedMultiple(List<Barcode> barcodes) {

    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    @Override
    public void onScanError(String errorMessage) {

    }

    @Override
    public void onCameraPermissionDenied() {

    }

}