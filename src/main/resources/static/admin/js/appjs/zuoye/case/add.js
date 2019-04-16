$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {

    var tags = [];
    $("input:checkbox:checked").each(function(){
        tags.push($(this).val());
    });
    if(tags.length == 0) {
        layer.msg("至少选择1个标签",{icon:2,time:1500});
        return;
    }
    var jsonData={
        'categoryId':$("#categoryId").val(),
        'title': $("#title").val(),
        'brief':$("#brief").val(),
        'browNum':$("#browNum").val(),
        'content':editor.txt.html(),
		'type':$("#typeId").val(),
		'tags':tags
    };
    console.log(jsonData);
	$.ajax({
		cache : true,
		type : "POST",
		url : "/zuoye/case/save",
		data : jsonData,// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
            title : {
				required : true
			},
            brief : {
            	required:true
			}
		},
		messages : {
            title : {
				required : icon + "请输入标题"
			},
			brief:{
                required : icon + "请输入内容简要"
			}

		}
	})
}