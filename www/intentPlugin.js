var exec = require('cordova/exec');

function IntentPlugin() {

}

IntentPlugin.prototype.startActivity = function(arrg) {
    exec(function(res){}, function(err){}, "IntentPlugin", "startActivity", arrg);
}

module.exports = new IntentPlugin();