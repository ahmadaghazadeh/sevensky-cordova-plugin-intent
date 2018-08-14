# sevensky-cordova-plugin-startactivity
Cordova plugin startActivity for android devices 

Features :
+ StartActivity 
+ PutExtra string format
+ Intent action
+ Intent data URI

Install :

 # cordova plugin add sevensky-cordova-plugin-intent

Usage :


        document.getElementById("btn_device_name").addEventListener("click", purchase);

        function purchase() {
            var obj = new Object();
            obj.name = "Ahmad";
            obj.family = "Aghazadeh";
            intentPlugin.startActivity("com.xomorod.fastbook", "PurchaseActivity", null, null, JSON.stringify(obj));
        }
