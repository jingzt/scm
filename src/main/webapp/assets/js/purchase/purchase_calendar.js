/**
 * 采购管理-日历统计
 */
$(function() {
	$("#purchaseCalendar").fullCalendar({
		header : {
			left : "prev,next",
			center : "title",
			right : "month"
		},
		selectable: true,
		events : "getPurchaseCalendarData.do",
		dayClick : function(date, jsEvent, view) {
			window.location="getPurchaseList.htm?dateTime="+date.Format("yyyy-MM-dd");
		}
	})
});