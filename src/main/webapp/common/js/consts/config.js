/**
 * =======================
 * 命名规范
 * 适用范围：后缀名为js的文件
 * 注: 变量名默认遵循以下命名规则，不在以下命名规则的范围的，都按优先度命名
 * =======================
 *
 * 分号：每逻辑行都要写
 * 优先度: 吊桥 > 山谷 > 小驼峰 > 匈牙利 > 大驼峰
 * url：用吊桥  profile-view, /update-course.jsp
 * 常量：从JAVA里来的，就用全大写山谷 RESULT_OK, RESULT_CALCEL
 * 数组：存的元素的英语原型加s结尾  vertex => vertexs !> verties,  potato => potatos !> potatoes
 * 方法：小驼峰，动词加名词，定义时参数要写全名称 findArray()，showAlert()
 *
 */
var config = {
    delay_short: 2,
};

var sidebar_list = {
    'new-course': {
        id: '#new-course',
        url: '../admin/course/add-course.jsp',
        type: 'submit',
        submitUrl: '/application/course/add-course',
    },
    'my-course': {
        id: '#my-course',
        url: '../admin/course/my-course.jsp',
        type: 'query',
        submitUrl: '',
    },
    'update-course': {
        id: '#update-course',
        url: '../admin/course/update-course.jsp',
        type: '',
        submitUrl: '',
    },
    'moments': {
        id: '#moments',
        url: '../admin/course/moments.jsp',
        type: '',
        submitUrl: '',
    },
    'profile-view': {
        id: '#profile-view',
        url: '../admin/course/profileView.jsp',
        type: '',
        submitUrl: '',
    },
    'profile-edit': {
        id: '#profile-edit',
        url: '../admin/course/profileEdit.jsp',
        type: '',
        submitUrl: '',
    },
};

var language = {
    using: 'CH_ZN',
    'operation_success': {
        'CH_ZN': '操作成功',
        'en': 'operation success',
        'jp': '操作成功です',
    },
    'operation_failed': {
        'CH_ZN': '操作失败',
    },
    'network_disconnect': {
        'CH_ZN': '网络状态不好，请检查你的网络和防火墙设置',
    },
    'login_success': {
        'CH_ZN': ' 登陆成功！ ',
    },
    'login_failed': {
        'CH_ZN': ' 登陆失败！用户名或密码错误 ',
    },
    'account_do_not_exist': {
        'CH_ZN': ' 登陆失败！用户名不存在 ',
    },
    'sec_to_fadeout': {
        'CH_ZN': ' 秒后此对话框消失',
    },
    'username_illegal': {
        'CH_ZN': '用户名存在非法字符，请修改再试',
    },
    'email_illegal': {
        'CH_ZN': '请填写正确的邮箱地址',
    },
    'password_mismatch': {
        'CH_ZN': '两次密码不匹配，请修改再试',
    },
    'username_empty': {
        'CH_ZN': '用户名不能为空',
    },
    'email_empty': {
        'CH_ZN': '邮箱不能为空',
    },
    'nickname_empty': {
        'CH_ZN': '昵称不能为空',
    },
    'success': {
        'CH_ZN': '成功',
    },
    'warning': {
        'CH_ZN': '警告',
    },
    'info': {
        'CH_ZN': '信息',
    },
    'error': {
        'CH_ZN': '错误',
    },
    'undefined': {
        'CH_ZN': 'undefined',
    },
    'undefined': {
        'CH_ZN': 'undefined',
    },
    'undefined': {
        'CH_ZN': 'undefined',
    },
    'undefined': {
        'CH_ZN': 'undefined',
    },
    'undefined': {
        'CH_ZN': 'undefined',
    },

};



