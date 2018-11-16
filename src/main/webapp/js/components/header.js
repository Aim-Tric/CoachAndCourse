function initialLogout() {
    $('#logout-btn').click(function (e) {
        //    TODO: 注销登录
        delCookie('USERID');
        delCookie('CNCSID');
        window.location.href = '/index.jsp';
    })
}
