$(function () {
    initial_components();
    initTimePicker();
});

function initial_components() {
    registerEvent('login');
    registerEvent('register');
    // initialLogin();
    // initialRegister();
    initialLogout();
    initialSidebar();
}



