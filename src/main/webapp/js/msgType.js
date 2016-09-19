/**
 * user: yutaoxun
 * data: 2016/5/5
 */


/**
 * 查询消息类型的详细描述信息.
 */
function sub_query() {
    var value = $("#msgType").val();
    if (value.length == 0 || value == undefined || value == null) {
        return;
    }

    $.ajax({
        type: "GET",
        dataType: "json",
        url: '/message/trackRecord',
        data: "msgType=" + value,
        success: function (result) {
            var msgContent = "负责人: " + result.principal + "\n" + "系统: " + result.system + "\n" + "消息类型:　" + result.msgType + "\n" + "消息描述: " + result.description + "\n";
            $('#queryResult').css("display", "block");
            $('textarea#description').val(msgContent);
        }
    });
}
