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