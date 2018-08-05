package sevensky.cordova.plugins;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

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
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
      try {
        if (action.equals("startActivity")) {
            String packageName = args.getString(0);
            String activityName = args.getString(1);
            String dataUri = args.getString(2);
            String androidAction = args.getString(3);
            JSONObject jsonObject = null;

            try {
              jsonObject = new JSONObject(args.getString(4));
            } catch(JSONException e) {
                Log.w("IntentPlugin", "Unable to get json object");
            }

            Bundle bundle = new Bundle();

            if (jsonObject != null && jsonObject.names() != null) {
              for(int i = 0; i<jsonObject.names().length(); i++){
                  bundle.putString(jsonObject.names().getString(i),
                          jsonObject.get(jsonObject.names().getString(i)).toString());
              }
            }

            this.startActivity(packageName, activityName, callbackContext, dataUri, androidAction, bundle);

            return true;
        }
      } catch(JSONException e) {
          Log.w("IntentPlugin", "Unable to start activity");
      }

        return false;
    }

    private void startActivity(String packageName, String activityName, CallbackContext callbackContext, String dataUri, String action, Bundle bundle) {
        if (packageName != null && packageName.length() > 0) {
            if (activityName.startsWith(".")) {
                activityName = packageName + activityName;
            }

            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.setComponent(new ComponentName(packageName, activityName));

            if (dataUri != null) {
      		      intent.setData(Uri.parse(dataUri));
      	    }

            if (action != null) {
                intent.setAction(action);
            }

            this.cordova.getActivity().startActivity(intent);
            callbackContext.success(activityName);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
