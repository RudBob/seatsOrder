document.write("<script type='text/javascript' src='util/util.js'></script>");
seat = {

    /**
     *  0代表可以使用
     * 1代表有人使用
     * 2代表已经预约
     * 3代表暂离座位
     * 4代表维修中.
     * 5代表其他.
     */
    seatStatusToStr: function (status) {
        if (status === 0) {
            return "空闲状态";
        } else if (status === 1) {
            return "正在使用";
        } else if (status === 2) {
            return "已被预约";
        } else if (status === 3) {
            return "用户暂离";
        } else if (status === 4) {
            return "维修中";
        } else if (status === 5) {
            return "其他";
        }
    },

    /**
     * 在showData 中使用
     * @param tid
     */
    deleteById: function (tid) {
        let url = "/adminSeat/removeSeat";
        let param = "tid=" + tid;
        $.ajax({
            type: "POST",//请求方式
            url: url + "?" + param,//发送请求的地址
            async: true,//请求为异步请求
            success: function (data) {//成功时调用的回调函数
                // 返回操作是否成功
                if (data.code === 100) {
                    //如果操作成功,返回发送过来的数据总条数n和包含n条信息的数组
                    alert("删除成功")
                } else {
                    showMsg(data.message);
                }
            },
            error: function () {//失败时被调用的函数
                alert("网络异常");
            }
        });
    },


    selectById: function (tid) {

    },


    /**
     * 复选框更新座位状态
     */
    updateClick: function () {

    },

    /**
     * 复选框删除位置
     */
    deleteClick: function () {

    },

    /**
     *
     */
    addSeatClick: function () {
        let url = "/adminSeat/addSeat";
        // let param = "tid=" + tid;
        $.ajax({
            type: "POST",//请求方式
            url: url,//发送请求的地址
            async: true,//请求为异步请求
            success: function (data) {//成功时调用的回调函数
                // 返回操作是否成功
                if (data.code === 100) {
                    //如果操作成功,返回发送过来的数据总条数n和包含n条信息的数组
                    alert("删除成功")
                } else {
                    showMsg(data.message);
                }
            },
            error: function () {//失败时被调用的函数
                alert("网络异常");
            }
        });
    },
}