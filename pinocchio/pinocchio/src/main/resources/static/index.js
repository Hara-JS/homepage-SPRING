window.onload = () => {
	$("#pageArea").load("/pinocchio/home");
}

(() => {
	'use strict'
	const tooltipTriggerList = Array.from(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
	tooltipTriggerList.forEach(tooltipTriggerEl => {
		new bootstrap.Tooltip(tooltipTriggerEl)
	})
})()

const isMakedDocBodyKeyDownEvent = {
    eventToggle : false
}

const home = () => {
	$("#pageArea").load("home", () => {
	});
}

const yachtdice = () => {
	$("#pageArea").load("/pinocchio/yachtdice", () => {
		gameJsInit();
	});
}

const wordle = () => {
	$("#pageArea").load("/pinocchio/wordle", () => {
	  clearWordleObj();
		makeEvent();
		makeTemplate();

		if(isMakedDocBodyKeyDownEvent.eventToggle === false) {
		  makeDocumentKeydownEvent();
		  isMakedDocBodyKeyDownEvent.eventToggle = true;
		}
	});
}

const beatgame = () => {
	$("#pageArea").load("/pinocchio/beatgame", () => {
	});
}

const board = () => {
	$("#pageArea").load("/pinocchio/board", () => {
	});
}

const list = () => {
	$("#pageArea").load("/pinocchio/", () => {
	});
}

const save = () => {
	$("#pageArea").load("/pinocchio/save", () => {
	});
}

const signin = () => {
	$("#pageArea").load("/pinocchio/signin", () => {
	});
}

const signout = () => {
	$("#pageArea").load("/pinocchio/signout", () => {
	});
}

const update = () => {
	$("#pageArea").load("/pinocchio/update", () => {
	});
}