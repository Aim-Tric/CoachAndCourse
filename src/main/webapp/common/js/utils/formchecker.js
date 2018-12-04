/*==================
*  formchecker.js
* ==================
*
* 模板化js框架，
* 使用模板, 就可以快速增加表单检查项，
* 使用者可以专注于写关键判断条件与提示文字
*
* 使用方法
* len ┬ 作用: 会对给定文本长度进行检查
*     └ 参数: length 目标输入框的文本长度
* cmp ┬ 作用: 对给定文本进行内容比较
*     └ 参数: ┬ value 目标输入框的文本
*			 └ value_from_file ┬ 是一个字符串,
*                              | 从'goods.txt'文件读取到的字符串数组
*                              └ 在函数执行的时候，将自动的取出每一个字符串做参数用来比较
* range ┬ 作用： 限制给定文本的内容范围
*       └ 参数： num 目标输入框的文本字符串, 需要手动转换成数字
* optional      作用： 标记目标文本框是可选填的
* msg_success   作用：填写正确提示信息，
* msg_error     作用：错误信息,
*/

// =========
// 模板
// =========
// var rules = { 	// 制定对value的规则
//      title: {
//          len: function (length) {
//              return length >= 3 && length < 50
//          },
//      },
// }
// new FormChecker(rules)  // 负责表单检查的功能性组件

// TODO: 在header加入引用，在login和register写好rules，调用和这个formchecker
class FormChecker {
    constructor(rulesMap) {
        this.rules = rulesMap
        this.response = []
        this.__registerActions()
        this.__readFromServer()
    }

    __registerActions() {
        for (var key in this.rules) { // 同步
            var selector = this.selectInput(key)
            this.registerAction(selector, key) // 不这样调用，就会发生同步异步顺序问题
        }
    }

    registerAction(selector, key) {
        var o = this;
        selector.on('blur', function () {
            var value = this.value
            var r = rules[key] // r 第一次进入此函数时是 rules 的 title，以此类推
            var result = o.checkByRule(value, r)
            var tip = o.makeTipFromRules(r, result)
            o.showTips(selector, tip)
        }).on('focus', function () {
            o.clearTips(selector)
        })
    }

    makeTipFromRules(ruleMap, result) {
        var tips = {
            true: {
                msg: ruleMap.msg_success || '填写正确',
                class: 'tip-success',
            },
            false: {
                msg: ruleMap.msg_error || '填写错误',
                class: 'tip-error',
            }
        }
        return tips[result]
    }

    checkByRule(victim, rule, victim2) {
        // len: test length of text under ruleMap
        // cmp: compare two text under ruleMap
        // range: test range of text under ruleMap
        // optional: input value can be null if true
        var len = rule.len(victim.length) || true
        var cmp = rule.cmp(victim, this.response) || true
        var range = rule.range(victim) || true
        var optional = rule.optional ? true : victim.length > 0
        return len && cmp && range && optional
    }

    cmpEach(compared, list, compFn) {
        var flag = true
        for (var i = 0, len = list.length; i < len; i += 1) {
            if (!compFn(compared, list[i])) {
                flag = false
            }
        }
        return flag
    }

    selectInput(name) {
        var queryResult = $(`input[name=${name}]`)
        return queryResult.length ? queryResult : $(`textarea[name=${name}]`)
    }

    __readFromServer() {
        var o = this
        $.ajax({
            type: "get",
            url: this.rules.url,
            dataType: "text",
            success(response) {
                if (response.statusCode == 200)
                    o.response = JSON.parse(response);
            },
            error: function () {
                alert('你的网络环境不正确，请检查你的网络和防火墙，或是你在本地计算机运行本脚本')
            }
        });
    }

    showTips(selector, tip) {
        $(selector).siblings('.tip')
            .text(tip.msg)
            .addClass(tip.class)
            .show()
    }

    clearTips(selectior) {
        $(selectior).siblings('.tip')
            .removeClass('tip-success')
            .removeClass('tip-error')
            .hide()
    }

    isJSON(str) {
        if (typeof str == 'string') {
            try {
                var obj = JSON.parse(str)
                return typeof obj == 'object' && obj
            } catch (e) {
                return false;
            }
        }
        console.warn(str, 'It is not a string!')
    }
}

/**
 * 获取表单中的数据，以键值对形式返回
 */
function form_datas(object) {
    // 如果cancel存在，则为cancel，否则为空集
    var cancel = object && object.cancel ? object.cancel : [];
    var arr = {};
    var datas = $('form').serializeArray();
    $.each(datas, function () {
        if (cancel.includes(this.name))
            return;
        arr[this.name] = this.value;
    });
    return arr;
}
