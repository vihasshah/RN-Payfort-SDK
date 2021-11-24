
package com.reactlibrary;

import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.os.Build;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
import com.payfort.fort.android.sdk.base.FortSdk;

public class RNPayfortSdkModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  public static Callback onSuccess, onFail;

  public RNPayfortSdkModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNPayfortSdk";
  }
  

  @ReactMethod
  void getDeviceID(Promise p) {
     String deviceId;

            deviceId = FortSdk.getDeviceId(reactContext);
        
        p.resolve(deviceId);
  }

  @ReactMethod
  public void openPayfort(ReadableMap data, Callback onSuccess, Callback onFail) {
    this.onSuccess = onSuccess;
    this.onFail = onFail;

    Intent intent = new Intent(getCurrentActivity(), PayfortActivity.class);
    if(data.hasKey("is_live")) {
      intent.putExtra("is_live", data.getString("is_live"));
    }
    if(data.hasKey("access_code")) {
      intent.putExtra("access_code", data.getString("access_code"));
    }
    if(data.hasKey("merchant_identify")) {
      intent.putExtra("merchant_identify", data.getString("merchant_identify"));
    }
    if(data.hasKey("request_phrase")) {
      intent.putExtra("request_phrase", data.getString("request_phrase"));
    }
    if(data.hasKey("customer_email")) {
      intent.putExtra("customer_email", data.getString("customer_email"));
    }
    if(data.hasKey("currency")) {
      intent.putExtra("currency", data.getString("currency"));
    }
    if(data.hasKey("amount")) {
      intent.putExtra("amount", data.getString("amount"));
    }
    if(data.hasKey("merchant_reference")) {
      intent.putExtra("merchant_reference", data.getString("merchant_reference"));
    }
    if(data.hasKey("customer_name")) {
      intent.putExtra("customer_name", data.getString("customer_name"));
    }
    if(data.hasKey("customer_ip")) {
      intent.putExtra("customer_ip", data.getString("customer_ip"));
    }
    if(data.hasKey("payment_option")) {
      intent.putExtra("payment_option", data.getString("payment_option"));
    }
    if(data.hasKey("order_description")) {
      intent.putExtra("order_description", data.getString("order_description"));
    }
    if(data.hasKey("sdk_token")) {
      intent.putExtra("sdk_token", data.getString("sdk_token"));
    }
    getCurrentActivity().startActivity(intent);
  }
}