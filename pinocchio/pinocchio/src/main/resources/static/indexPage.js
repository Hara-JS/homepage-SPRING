window.onload = () => {
	$("#pageArea").load("home");
}

(() => {
	'use strict'
	const tooltipTriggerList = Array.from(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
	tooltipTriggerList.forEach(tooltipTriggerEl => {
		new bootstrap.Tooltip(tooltipTriggerEl)
	})
})()

const home = () => {
	$("#pageArea").load("home", () => {
	});
}

const signin = () => {
	$("#pageArea").load("signin", () => {
	});
}

const yachtdice = () => {
	$("#pageArea").load("yachtdice", () => {
		gameJsInit();
	});
}

const wordle = () => {
	$("#pageArea").load("wordle", () => {
		makeEvent();
		makeTemplate();
	});
}

const beatgame = () => {
	$("#pageArea").load("beatgame", () => {
	});
}

const board = () => {
	$("#pageArea").load("board", () => {
	});
}