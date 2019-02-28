/**
 * =======================
 * 命名规范
 * 适用范围：后缀名为js的文件
 * 注: 变量名默认遵循以下命名规则，不在以下命名规则的范围的，都按优先度命名
 * =======================
 *
 * 分号：每逻辑行都要写
 * 优先度: 吊桥 > 山谷 > 小驼峰 > 匈牙利 > 大驼峰
 * url：用吊桥  profile-view, /update-course-detail.jsp
 * 常量：从JAVA里来的，就用全大写山谷 RESULT_OK, RESULT_CALCEL
 * 数组：存的元素的英语原型加s结尾  vertex => vertexs !> verties,  potato => potatos !> potatoes
 * 方法：小驼峰，动词加名词，定义时参数要写全名称 findArray()，showAlert()
 *
 */
var config = {
    delay_short: 2,
};
/**
 * sidebar配置列表
 * key：事件名称，value：{id：按钮的id值, url：目标页面模板, type：页面注册事件类型, submitUrl：页面注册对应的servlet}
 */
var sidebar_list = {
    'new-course': {
        id: '#new-course',
        url: '../admin/course/add-course.jsp',
        type: 'submit',
        submitUrl: '/application/servlet/course/add-course',
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


