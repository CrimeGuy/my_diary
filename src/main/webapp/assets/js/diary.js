$(document).ready(function () {
	$.ajax({
		type: "post",
		url: "../diary/diaryPageData.action",
		dataType: "json",
		success: function (data) {
			initDayData(data);
		}
	});


	$('#next-month-go').click(function () {
		var monthNo = parseInt($('#monthNo').val()) + 1;
		var yearNo = parseInt($('#yearNo').val());
		if (monthNo == 13) {
			monthNo = 1;
			yearNo = yearNo + 1;
		}
		$.ajax({
			type: "post",
			url: "../diary/diaryPageData.action?next=true&monthNo=" + monthNo + "&yearNo=" + yearNo,
			dataType: "json",
			success: function (data) {
				initDayData(data);
			}
		});

	});
	$('#pre-month-go').click(function () {
		var monthNo = parseInt($('#monthNo').val()) - 1;
		var yearNo = parseInt($('#yearNo').val());
		if (monthNo == 0) {
			monthNo = 12;
			yearNo = yearNo - 1;
		}
		$.ajax({
			type: "post",
			url: "../diary/diaryPageData.action?next=false&monthNo=" + monthNo + "&yearNo=" + yearNo,
			dataType: "json",
			success: function (data) {
				initDayData(data);
			}
		});

	});

});

function initDayData(data) {

	varscreenHeight = document.documentElement.clientHeight;

	varscreenWidth = document.documentElement.clientWidth;

	$('.diary-main').css('height', varscreenHeight - 75 + 'px');
	$('#layout-menu').css('height', varscreenHeight - 75 + 'px');
	$('.menu').css('height', varscreenHeight - 50 + 'px');
	// if(103 < varscreenHeight * 0.1){
	$('.diary-day-div-row').css('height', varscreenHeight * 0.12 + 'px');
	// }
	$('.day-blank-div').css('height', (varscreenHeight * 0.12) - 15 + 'px');
	$('.day-div').css('height', (varscreenHeight * 0.12) - 15 + 'px');

	for (var i = 1; i <= 37; i++) {
		$('#day-' + i).css('background-color', 'transparent');
		$('#day-' + i).css('border', '1px solid transparent');
		$('#day-' + i + ' .day-mid-div').text("");
		$('#day-' + i + ' .day-bom-div').text("");
	}

	var firstDayWeek = data[0].week;
	$('#monthNo').val(data[0].month);
	$('#yearNo').val(data[0].year);
	$('#diary-month-center').text(data[0].year + '年' + data[0].month + '月');
	var dayNo = "";
	for (var i = 0; i < data.length; i++) {
		dayNo = (firstDayWeek + i);
		$('#day-' + dayNo + ' .day-mid-div').text(data[i].dayNo);
		$('#day-' + dayNo + ' .day-bom-div').text(data[i].festival);
		$('#day-' + dayNo).css('background-color', '#4169E1');
		$('#day-' + dayNo).css('border', '1px solid #000');

		// 绑定点击事件
		$('#day-' + dayNo).click(function () {
			// var dayNo = $('#day-' + dayNo + ' .day-mid-div').val();
			var dayNo = $(this)[0].children[1].innerHTML;
			var festival = $(this)[0].children[2].innerHTML;
			console.log('获取的日期为------------->' + dayNo);
			console.log('获取的节日为------------->' + festival);
			$.ajax({
				type: "post",
				url: "../diary/diaryPageData.action",
				dataType: "json",
				success: function (data) {
					initDayData(data);
				}
			});
		});

	}

}