util = {
    showMsg: function (message) {
        alert(message);
    },
    appendParam: function (paramName, paramValue, params) {
        let res = "";
        if (paramValue != null && paramValue !== "") {
            if (params !== "") {
                res += "&";
            }
            res += paramName + "=" + paramValue;
        }
        return res;
    }
}
