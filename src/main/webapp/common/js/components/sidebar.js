function initialSidebar() {

    var keys = [];
    for (var k in sidebar_list) {
        keys.push(k);
    }

    for (let i = 0; i < keys.length; i++) {
        var obj = sidebar_list[keys[i]];
        addClickListener(obj);
    }

}
