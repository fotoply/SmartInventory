package dk.sdu.student.kitcheninventory.ui.checkin;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import dk.sdu.student.kitcheninventory.R;
import dk.sdu.student.kitcheninventory.model.inventory.Product;
import dk.sdu.student.kitcheninventory.model.inventory.Inventory;
import dk.sdu.student.kitcheninventory.model.inventory.TemplateLibrary;

public class CheckInAddProduct extends DialogFragment {
    private static final String BARCODE = "barcode";
    private static final String RAW_BARCODE = "rawBarcode";

    private String barcode;
    private String rawBarcode;
    private Product createdProduct;

    public CheckInAddProduct() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param barcode    Parameter 1.
     * @param rawBarcode Parameter 2.
     * @return A new instance of fragment CheckInAddProduct.
     */
    // TODO: Rename and change types and number of parameters
    public static CheckInAddProduct newInstance(String barcode, String rawBarcode) {
        CheckInAddProduct fragment = new CheckInAddProduct();
        Bundle args = new Bundle();
        args.putString(BARCODE, barcode);
        args.putString(RAW_BARCODE, rawBarcode);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            barcode = getArguments().getString(BARCODE);
            rawBarcode = getArguments().getString(RAW_BARCODE);
        } else {
            barcode = "";
            rawBarcode = "";
        }
        createdProduct = new Product();
        if (TemplateLibrary.getByBarcode(barcode) != null) {
            createdProduct.applyTemplate(TemplateLibrary.getByBarcode(barcode));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check_in_add_product, container, false);
        ((EditText) view.findViewById(R.id.barcodeEditText)).setText(barcode);
        ((EditText) view.findViewById(R.id.barcodeEditText)).setEnabled(false);
        ((EditText) view.findViewById(R.id.nameEditText)).setText(createdProduct.getName());
        ((EditText) view.findViewById(R.id.nameEditText)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                createdProduct.setName(s.toString());
            }
        });
        ((EditText) view.findViewById(R.id.expiresEditText)).setText(createdProduct.getDaysUntilExpiration() + "");
        ((EditText) view.findViewById(R.id.expiresEditText)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    createdProduct.setExpirationInDays(Integer.valueOf(s.toString()));
                } catch (NumberFormatException e) {
                    createdProduct.setExpirationInDays(0);
                }
            }
        });
        ((EditText) view.findViewById(R.id.amountEditText)).setText(createdProduct.getAmount() + "");
        ((EditText) view.findViewById(R.id.amountEditText)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                createdProduct.setAmount(Double.valueOf(s.toString()));
                } catch (NumberFormatException e) {
                    createdProduct.setAmount(1.0);
                }
            }
        });

        Spinner categorySpinner = (Spinner) view.findViewById(R.id.locationSpinner);
        ArrayAdapter spinnerAdapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item, Inventory.getInstance().getAllCompartmentNames());
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(spinnerAdapter);
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        createdProduct.setBarcode(((EditText) view.findViewById(R.id.barcodeEditText)).getText().toString());

        ((Button) view.findViewById(R.id.addProductButton)).setOnClickListener(v -> {
            Inventory.getInstance().addProduct(createdProduct);
            dismiss();
        });
        return view;
    }




}
