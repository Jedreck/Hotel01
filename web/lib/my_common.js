
var cookies_En = cookie.get("E_num");
$("h5").html("工号：" + cookies_En);

// 移除footer
$("footer").remove();

/**
 * 显示加载过程
 * @param id 代表该加载过程显示的位置
 * @param colspan 列数 方便居中
 */
function showProcess(id,colspan) {
    var url = "../../css/style_process.css";// 相对于html文件的位置
    dynamicLoadCss(url);
    html = "<tr>\n" +
        "<td colspan=\""+colspan+"\">\n" +
        "    <div class=\"spinner\">\n" +
        "    <div class=\"rect1\"></div>\n" +
        "    <div class=\"rect2\"></div>\n" +
        "    <div class=\"rect3\"></div>\n" +
        "    <div class=\"rect4\"></div>\n" +
        "    <div class=\"rect5\"></div>\n" +
        "    </div>\n" +
        "<td>\n" +
        "</tr>";
    $("#" + id).html(html);
}

/**
 * 动态加载CSS
 * @param {string} url 样式地址
 */
function dynamicLoadCss(url) {
    var head = document.getElementsByTagName('head')[0];
    var link = document.createElement('link');
    link.type='text/css';
    link.rel = 'stylesheet';
    link.href = url;
    head.appendChild(link);
}

// 显示结果
function showResult(content) {
    layer.open({
        content: content
        ,btn: ['确定']
        ,yes: function(index, layero){//删除
            layer.closeAll();
        }
        ,cancel: function(){
        }
    });
}

/**
 */
function showProcess2(obj) {
    var url = "../../css/style_process2.css";// 相对于html文件的位置
    dynamicLoadCss(url);
    obj.append("                    <div class=\"spinner\">\n" +
        "                        <div class=\"cube1\"></div>\n" +
        "                        <div class=\"cube2\"></div>\n" +
        "                    <div class='minfo'>数据加载中请稍后</div></div>");
}

/**
 * 移除加载动画
 * @param obj
 */
function removeProcess2() {
    $("div[class='spinner']").remove();
}

/**
 * 验证员工是否登录
 */
function validateEmployee() {
    console.log("验证登录");
    return true;
    // var cookies_En = cookie.get("E_num");
    // if (cookies_En == null) {
    //     console.log("非法");
    //     layui.use(['form', 'upload','layer'], function(){
    //         var layer = layui.layer;
    //         layer.alert('请登录后访问！', {
    //             skin: 'layui-layer-molv' //样式类名
    //             ,closeBtn: 0
    //         }, function(){
    //             top.location.href = "/html/common/login.html";
    //         });
    //     });
    //     return false;
    // } else return true;
}

//登出
function logout() {
        cookie.setTemp("status", 0);
        top.location.href = "/html/common/index.html"
}

//小红点
function getUnreadNum(){
    getUnreadNumFunc();
    setInterval(getUnreadNumFunc, 10000);
}
function getUnreadNumFunc() {
    var num = 0;
    $.ajax({
        url: "/GetClientUnreadNumServlet",
        data: {jsondata: cookies_phone},
        type: "post",
        success: function (flag) {
            console.log("小红点--" + flag);
            $('#red_num').html("<span class=\"badge bg-theme\">" + flag + "</span>")
        },
        error: function () {
            alert("无法获取小红点。。。");
        }
    });
    layer.closeAll('loading');
}

