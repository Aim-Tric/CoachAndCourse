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

var sidebar_list = {
    'new-course': {
        id: '#new-course',
        url: '../admin/course/new-course.jsp',
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

var alert_dict = {
    'RESULT_OK': ['操作成功', 'success'],
    'RESULT_FAILED': ['操作失败', 'warning'],
    'RESULT_CANCEL': ['网络错误', 'error'],
};

