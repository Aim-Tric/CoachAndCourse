function initialLogout() {
    $('#logout-btn').click(function () {
        //    TODO: 注销登录
        delCookie('CNCID');
        window.location.href = '/index.jsp';
    })
}
