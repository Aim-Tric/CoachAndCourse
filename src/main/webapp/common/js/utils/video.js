var VIDEOURL = '';
var MIMECODEC = '';

function display(url, mimeCodec) {
    var video = document.querySelector('video');
    VIDEOURL = url;
    MIMECODEC = mimeCodec;
    var mediaSource = new MediaSource; // 把他理解成视频流就很好理解了
    try {
        video.srcObject = mediaSource; // 直接对srcObject复制会有加速提成
    } catch (error) {
        video.src = createObjectURL(mediaSource); // 有些浏览器不支持srcObject，就得默认的来
    }
    mediaSource.addEventListener('sourceopen', sourceOpen)

}


function sourceOpen() {
    var video = document.querySelector('video');
    console.log('sourceOpen readyState', this.readyState); // open

    var mediaSource = this;
    var sourceBuffer = mediaSource.addSourceBuffer(MIMECODEC);
    fetchVideo(VIDEOURL, function (result) {
        // updateend时候，视频信息完全拿到了（视频长度，视频格式，解码要用什么）
        sourceBuffer.addEventListener('updateend', function () {
            // mediaSource 是一个文件流，他从服务器拿到一个二进制文件，并把它转码成浏览器可读的地址
            // 既然他已经完成了读取动作，那么他就要关闭流
            mediaSource.endOfStream();

            // 这一句话，告诉了浏览器，自动播放视频
            video.play();
        });

        // 开始向服务器一直申请缓冲，
        // 在缓冲视频
        sourceBuffer.appendBuffer(result);
    });
};

function createObjectURL(data) {
    return (window.URL) ? window.URL.createObjectURL(data) : window.webkitURL.createObjectURL(data);
}

// 简单的封装了 ajax
function fetchVideo(url, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open('get', url, true);
    xhr.responseType = 'arraybuffer';
    xhr.onload = function () {
        if (xhr.readyState == 4) {
            callback(xhr.response);
        }
    }
    xhr.send();
}
