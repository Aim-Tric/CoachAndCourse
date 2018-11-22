function initialLogout() {
    $('#logout-btn').click(function () {
        //    TODO: 注销登录
        delCookie('CNC');
        delCookie('ISLOGGED');
        window.location.href = '/index.jsp';
    })
}
