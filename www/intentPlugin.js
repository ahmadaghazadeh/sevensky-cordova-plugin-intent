var exec = require('cordova/exec');

function IntentPlugin() {

}

IntentPlugin.prototype.startActivity = function (packageName, activityName, dataUri, action, bundle) {
    exec(function (res) { }, function (err) { }, "IntentPlugin", "startActivity", [packageName, activityName, dataUri, action, bundle]);
}

module.exports = new IntentPlugin();
