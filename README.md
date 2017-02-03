# sevensky-cordova-plugin-startactivity
Cordova plugin startActivity for android devices

Install :

 # cordova plugin add sevensky-cordova-plugin-intent

Usage :


        document.getElementById("btn_device_name").addEventListener("click", deviceNmae);

        function log() {
            var obj = new Object();
            obj.name = "Ahmad";
            obj.family = "Aghazadeh";
            intentPlugin.startActivity("com.xomorod.fastbook", "PurchaseActivity", JSON.stringify(obj));
        }
