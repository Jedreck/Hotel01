/**
 * 显示加载过程
 * @param id 代表该加载过程显示的位置
 */
function showProcess(id) {
    console.log("112");
    var url = "../../css/style_process.css";// 相对于html文件的位置
    dynamicLoadCss(url);
    html = "<tr>\n" +
        "<td colspan=\"4\">\n" +
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
    console.log("222");
    var head = document.getElementsByTagName('head')[0];
    var link = document.createElement('link');
    link.type='text/css';
    link.rel = 'stylesheet';
    link.href = url;
    head.appendChild(link);
}