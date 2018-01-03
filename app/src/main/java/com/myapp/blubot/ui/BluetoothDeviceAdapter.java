package com.myapp.blubot.ui;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapp.blubot.R;

import java.util.List;

/**
 * Project : BluBot
 * Created by Rajanikant Deshmukh on 11 Aug 2015.
 */
public class BluetoothDeviceAdapter extends ArrayAdapter<BluetoothDevice> {

    public BluetoothDeviceAdapter(Context context, List<BluetoothDevice> objects) {
        super(context, R.layout.item_bluetooth_device, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        BluetoothDevice device = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_bluetooth_device, parent, false);

        TextView deviceName = convertView.findViewById(R.id.item_bluetooth_device_name);
        TextView deviceSsid = convertView.findViewById(R.id.item_bluetooth_device_ssid);
        ImageView deviceIcon = convertView.findViewById(R.id.item_bluetooth_device_icon);

        deviceName.setText(device.getName());
        deviceSsid.setText(device.getAddress());

        if (device.getBondState() == BluetoothDevice.BOND_BONDED)
            deviceIcon.setImageResource(R.drawable.ic_bluetooth_paired);
        else
            deviceIcon.setImageResource(R.drawable.ic_action_bluetooth);

        return convertView;
    }
}
