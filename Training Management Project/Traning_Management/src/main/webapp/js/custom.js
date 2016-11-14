function setActiveMenuItem(arrL, crtPageL) {
	for (var j = 0; j < arrL.length; j++) {
		if (arrL[j].rel == crtPageL) {
			arrL[j].parentNode.className += " " + "active";
			break;
		}
	}
}
window.onload = function () {
	if (relTag != undefined && relTag != null && relTag != "") {
		if (document.getElementById("topmenunav") != null) {
			setActiveMenuItem(document.getElementById("topmenunav").getElementsByTagName("a"), relTag);
		}
	}
}

$(document).ready(function () {
	
	//var tabindex = 'key';
	//var dataStore = window.sessionStorage;
	try{
		var oldtabindex = sessionStorage.getItem("tabindex");
	}
	catch(e){
		var oldtabindex = 0;
	}
	//sessionStorage.setItem("tabindex", oldtabindex);
	$('.tabs-container').tabs({
		active: oldtabindex,
		activate: function(event, ui){
			var newtabindex = ui.newTab.parent().children().index(ui.newTab);
			sessionStorage.setItem("tabindex", newtabindex);
			//dataStore.setItem(tabindex,newtabindex);
			//alert(document.cookie);
		}
	});
	//alert(dataStore);

	$('.txtDatePicker').datepicker({
		dateFormat: 'yy-mm-dd',
		changeMonth: true,
		changeYear: true,
		showOn: "focus",
		yearRange: '-100:c',
		maxDate: new Date()
	});

	$('.accordion').accordion({ collapsible: true, header: "h3", heightStyle: "content" });

	$('.slider').bxSlider({
	  mode:'horizontal',
	  nextSelector: '#slider-right',
	  prevSelector: '#slider-left',
	  nextText: '',
  	  prevText: '',
	  minSlides: 5,
	  maxSlides: 5,
	  slideWidth: 160,
	  pager:false,
	  autoControls:false,
	  touchEnabled:false,
	  auto:true,
	  pause:3000,
	  moveSlides:1,
	  slideMargin:10
	 });

	 $('.news-ticker').bxSlider({
	 	mode: 'vertical',
	 	minSlides: 4,
	 	maxSlides: 4,
		controls: false,
	 	pager: false,
	 	autoControls: false,
	 	touchEnabled: false,
	 	auto: true,
	 	pause: 2500,
	 	moveSlides: 1,
	 	slideMargin: 0,
		autoHover: true
	 });
	
	$("a[rel^='prettyPhoto']").prettyPhoto({
		theme: 'light_square',
		slideshow: false,
		autoplay_slideshow: false,
		show_title: true,
		allow_resize: true,
		default_width: 600,
		default_height: 400
	});

	$('.frmMain').validationEngine({
		promptPosition: 'topLeft',
		autoHidePrompt: true,
		autoHideDelay: 3000,
		focusFirstField: false,
		addFailureCssClassToField: 'shadow_red',
		addSuccessCssClassToField: 'shadow_none'
	});



	
	
});