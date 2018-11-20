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
        console.log('fetchVideo result', result);
        console.log('fetchVideo sourceBuffer', sourceBuffer);
        sourceBuffer.addEventListener('updateend', function () {
            console.log('updateend mediaSource', mediaSource);
            mediaSource.endOfStream();

            video.play();
            console.log('updateend readyState', mediaSource.readyState); // ended
        });
        sourceBuffer.appendBuffer(result);
    });
};

function createObjectURL(data) {
    return (window.URL) ? window.URL.createObjectURL(data) : window.webkitURL.createObjectURL(data);
}

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
