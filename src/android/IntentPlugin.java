package sevensky.cordova.plugins;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ahmad on 2/3/2017.
 */
public class IntentPlugin extends CordovaPlugin {


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("startActivity")) {
            String appName = args.getString(0);
            String activityName = args.getString(1);
            JSONObject jsonObject=new JSONObject(args.getString(2));
            Bundle bundle=new Bundle();
            for(int i = 0; i<jsonObject.names().length(); i++){
                bundle.putString(jsonObject.names().getString(i) ,
                        jsonObject.get(jsonObject.names().getString(i)).toString());
            }
            this.startActivity(appName,activityName, callbackContext,bundle);
            return true;
        }
        return false;
    }


    private void startActivity(String appName, String activityName, CallbackContext callbackContext,Bundle bundle) {
        if (appName != null && appName.length() > 0) {
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.setComponent(new ComponentName(appName, appName+"."+activityName));
            this.cordova.getActivity().startActivity(intent);
            callbackContext.success(appName+"."+activityName);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    // this function is useful to call activity from different module. This will be useful if you integrated another app within you base app using Android Library Module and wanted to call activity from that module.
    private void startActivity(String appName, String moduleName,String activityName, CallbackContext callbackContext,Bundle bundle) {
        if (appName != null && appName.length() > 0) {
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.setComponent(new ComponentName(appName, moduleName+"."+activityName));
            this.cordova.getActivity().startActivity(intent);
            callbackContext.success(moduleName+"."+activityName);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
} 