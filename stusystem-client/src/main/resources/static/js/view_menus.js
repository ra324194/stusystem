// JavaScript Document

$(document).ready(function() {

	$("#quicklink").hover(function() {
		$('ul.the_menu').show();// 当鼠标放上去的时候,程序处理
		$("#quicklink .first_menu_1").addClass("current_hit");

	}, function() {
		$('ul.the_menu').hide();// 当鼠标离开的时候,程序处理
		$("#quicklink .first_menu_1").removeClass("current_hit");

	});

	$("#quicklink_2").hover(function() {
		// //$('ul.the_menu_2').show();//当鼠标放上去的时候,程序处理
		$("#quicklink_2 .first_menu").addClass("current_hit_2");

	}, function() {
		// //$('ul.the_menu_2').hide();//当鼠标离开的时候,程序处理
		$("#quicklink_2 .first_menu").removeClass("current_hit_2");

	});

	$("#quicklink_4").hover(function() {
		// //$('ul.the_menu_4').show();//当鼠标放上去的时候,程序处理
		$("#quicklink_4 .first_menu_4").addClass("current_hit_4");

	}, function() {
		// //$('ul.the_menu_4').hide();//当鼠标离开的时候,程序处理
		$("#quicklink_4 .first_menu_4").removeClass("current_hit_4");

	});

});
