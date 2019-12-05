package dk.sdu.student.kitcheninventory.ui.checkin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import dk.sdu.student.kitcheninventory.R;
import dk.sdu.student.kitcheninventory.model.inventory.Inventory;
import dk.sdu.student.kitcheninventory.ui.barcode.BarcodeReaderFragment;

public class CheckInFragment extends Fragment implements BarcodeReaderFragment.BarcodeReaderListener {

    private CheckInViewModel notificationsViewModel;
    private boolean ready = true;

    public static boolean isCheckIn() {
        return checkIn;
    }

    public static void setCheckIn(boolean checkIn) {
        CheckInFragment.checkIn = checkIn;
    }

    private static boolean checkIn = true;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        GetCheckInOut();

        notificationsViewModel = ViewModelProviders.of(this).get(CheckInViewModel.class);
        View root = inflater.inflate(R.layout.fragment_checkin, container, false);
        BarcodeReaderFragment readerFragment = BarcodeReaderFragment.newInstance(true, false, View.VISIBLE);
        readerFragment.setListener(this);
        FragmentManager supportFragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fm_container, readerFragment);
        fragmentTransaction.commitAllowingStateLoss();
        return root;
    }

    private void GetCheckInOut()
    {
        new AlertDialog.Builder(getContext())
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Vælg en handling")
                .setPositiveButton("Fjern produkt", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        setCheckIn(false);
                    }
                })
                .setNegativeButton("Tilføj produkt", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        setCheckIn(true);
                    }
                })
                .show();
    }

    @Override
    public void onScanned(Barcode barcode) {
        if(ready) {
            System.out.println("Commencing scan");
            ready = false;
            if(checkIn) {
                CheckInAddProduct addProduct = CheckInAddProduct.newInstance(barcode.displayValue, barcode.rawValue);
                addProduct.show(getFragmentManager(), "fragment_add_product");
                getFragmentManager().executePendingTransactions();
                addProduct.getDialog().setOnDismissListener(dialogInterface -> ready = true);
            } else {
                Inventory.getInstance().removeByBarcode(barcode.displayValue);
                Toast.makeText(this.getContext(), "Produktet blev fjernet fra beholdning", Toast.LENGTH_LONG).show();
                Thread thread = new Thread(() -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ready = true;
                });
                thread.start();
            }
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