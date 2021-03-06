/**
 * 
 */

//图片上传demo
$(function() {
       $list = $('#fileList'),
       // 优化retina, 在retina下这个值是2
       ratio = window.devicePixelRatio || 1,

       // 缩略图大小
       thumbnailWidth = 100 * ratio,
       thumbnailHeight = 100 * ratio,
       // Web Uploader实例
       
   // 初始化Web Uploader
   uploader = WebUploader.create({
       // 自动上传。
       auto: true,
       // swf文件路径
       swf:  '/assets/js/plugins/webuploader/Uploader.swf',
       // 文件接收服务端。
       server:'../common/upload.do',
       // 选择文件的按钮。可选。
       // 内部根据当前运行是创建，可能是input元素，也可能是flash.
       pick: '#filePicker',
    // 图片质量，只有type为`image/jpeg`的时候才有效。
       quality: 90,
       // 只允许选择文件，可选。
       fileNumLimit: 1,
       accept: {
           title: 'Images',
           extensions: 'gif,jpg,jpeg,bmp,png',
           mimeTypes: 'image/*'
       }
   });


// 当有文件添加进来的时候
   uploader.on( 'fileQueued', function( file ) {
	 
       var $li = $(
               '<div id="' + file.id + '" class="file-item thumbnail">' +
                   '<img>' +
               '</div>'
               ),
           $img = $li.find('img');
       // $list为容器jQuery实例
       $list.html("");
       $list.append( $li );

       // 创建缩略图
       // 如果为非图片文件，可以不用调用此方法。
       // thumbnailWidth x thumbnailHeight 为 100 x 100
       uploader.makeThumb( file, function( error, src ) {
           if ( error ) {
               $img.replaceWith('<span>不能预览</span>');
               return;
           }

           $img.attr( 'src', src );
       }, thumbnailWidth, thumbnailHeight );
       
       $("#filePicker").on('click',function(){
    	   uploader.removeFile(file);
       });
    
   });

// 文件上传过程中创建进度条实时显示。
   uploader.on( 'uploadProgress', function( file, percentage ) {
       var $li = $( '#'+file.id ),
           $percent = $li.find('.progress span');

       // 避免重复创建
       if ( !$percent.length ) {
           $percent = $('<p class="progress"><span></span></p>')
                   .appendTo( $li )
                   .find('span');
       }

       $percent.css( 'width', percentage * 100 + '%' );
   });

   // 文件上传成功，给item添加成功class, 用样式标记上传成功。
   //注意我写样式了啊response:服务端返回的数据
   uploader.on( 'uploadSuccess', function( file,response) {
       $( '#'+file.id ).addClass('upload-state-done');
       //console.info(response);
     $("input[name='logoPath']").val(response.filePathAndName);
     $("#upInfo").html("<font color='red'>"+response.msg+"</font>");
   });

   // 文件上传失败
   uploader.on( 'uploadError', function(file) {
       var $li = $( '#'+file.id ),
           $error = $li.find('div.error');
       // 避免重复创建
       if ( !$error.length ) {
           $error = $('<div class="error"></div>').appendTo( $li );
       }

       $.error('上传失败,请稍后再试.');
       
   });

   // 完成上传完了，成功或者失败，先删除进度条。
   uploader.on( 'uploadComplete', function( file ) {
       $( '#'+file.id ).find('.progress').remove();
   });
});
