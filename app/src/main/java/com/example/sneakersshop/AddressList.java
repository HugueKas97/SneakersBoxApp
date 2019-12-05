package com.example.sneakersshop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class AddressList extends ArrayAdapter<Address> {
    private Activity context;
    private List<Address> addressList;

    public AddressList(Activity context, List<Address> addressList){

        super(context, R.layout.list_layout, addressList);

        this.context = context;
        this.addressList = addressList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewAddressName);
        TextView textViewAddress = (TextView) listViewItem.findViewById(R.id.textViewAddressDetail);

        Address address = addressList.get(position);

        textViewName.setText(address.getName());
        textViewAddress.setText(address.getAddress());

        return listViewItem;
    }
}
