package sevensky.plugins;

import android.content.ComponentName;
import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Ahmad on 2/3/2017.
 */
public class IntentPlugin extends CordovaPlugin {


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("startActivity")) {
            String appName = args.getString(0);
            String activityName = args.getString(1);
            this.startActivity(appName,activityName, callbackContext);
            return true;
        }
        return false;
    }


    private void startActivity(String appName,String activityName, CallbackContext callbackContext) {
        if (appName != null && appName.length() > 0) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(appName, appName+"."+activityName));
            this.cordova.getActivity().startActivity(intent);
            callbackContext.success(appName+"."+activityName);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
