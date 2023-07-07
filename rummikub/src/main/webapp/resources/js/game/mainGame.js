/**
 * 메인 게임 화면
 * 2023/06/23 ksj 추가
 */
$(document).ready(function(){
	var card = document.getElementsByClassName("card");
	
	console.log(card);

	// 게임판 만들기
	var gridStr = "";
	for(var i=0 ; i < 7 ; i++){
		gridStr += "<tr>\n";
		for(var j=0 ; j < 21 ; j++){
			gridStr += "<td></td>\n";
		}
		gridStr += "</tr>\n";
	}
	$("#mainTable").append(gridStr);
	
	// 개인 타일 판 만들기
	var pGridStr = "";
	for(var i=0 ; i < 2 ; i++){
		pGridStr += "<tr>\n";
		for(var j=0 ; j < 10 ; j++){
			pGridStr += "<td class='privateTd"+(i*10+j)+"'></td>\n";
		}
		pGridStr += "</tr>\n";
	}
	$("#privateTable1").append(pGridStr);
	$("#privateTable2").append(pGridStr);
	$("#privateTable3").append(pGridStr);
	$("#privateTable4").append(pGridStr);
	
	
	// 전체 카드팩 만들기 -> 더 괜찮은 방법 생각해보기
	var cardStr = "";
	cardStr += '<div id="blackcard">';
	for(var i=1 ; i <= 13 ; i++){
		cardStr += '<div class="blackcard card cardPack" id="card'+ (i*2-1) +'">'+i+'</div>\n';
		cardStr += '<div class="blackcard card cardPack" id="card'+ (i*2) +'">'+i+'</div>\n';
	}
	cardStr += '</div>';
	cardStr += '<div id="redcard">';
	for(var i=1 ; i <= 13 ; i++){
		cardStr += '<div class="redcard card cardPack" id="card'+ (i*2+25) +'">'+i+'</div>\n';
		cardStr += '<div class="redcard card cardPack" id="card'+ (i*2+26) +'">'+i+'</div>\n';
	}
	cardStr += '</div>';
	cardStr += '<div id="bluecard">';
	for(var i=1 ; i <= 13 ; i++){
		cardStr += '<div class="bluecard card cardPack" id="card'+ (i*2+51) +'">'+i+'</div>\n';
		cardStr += '<div class="bluecard card cardPack" id="card'+ (i*2+52) +'">'+i+'</div>\n';
	}
	cardStr += '</div>';
	cardStr += '<div id="redcard">';
	for(var i=1 ; i <= 13 ; i++){
		cardStr += '<div class="yellowcard card cardPack" id="card'+ (i*2+77) +'">'+i+'</div>\n';
		cardStr += '<div class="yellowcard card cardPack" id="card'+ (i*2+78) +'">'+i+'</div>\n';
	}
	cardStr += '</div>';
	$("#card").append(cardStr);
	
});

function start(){
	$("#startBtn").hide();
	var randomNum = Math.floor(Math.random() * 106) + 1;
	console.log(randomNum);
	
	// 14장씩 나눠주기
	for(var p = 0; p < playerCard.length ; p++){	// playerCard.length 플레이어 숫자로 변경
		while(true){	// 무한루프
			var randomNum = Math.floor(Math.random() * 106) + 1;
			var card = $("#card" + randomNum);
			console.log(card.attr('class'));
			if(card.attr('class').match("cardPack")){	// cardPack 클래스 있는지 확인
				console.log("카드팩 안에 존재");
				card.attr('class', card.attr('class').replace(' cardPack',''));
				playerCard[p][playerCard[p].length] = randomNum;
			}else{
				console.log("카드팩 안에 미존재");
			}
			if(playerCard[p].length == 14){		// 14장일 경우 멈추기
				break;
			}
		}
	}

	// 화면에서 애니메이션 추가 -> x,y 좌표로 수정하기..
	for(var p = 0; p < playerCard.length ; p++){	// 플레이어
		var tiles = $("#privateTable"+(p+1));
		console.log(tiles);
		for(var c = 0; c < playerCard[p].length ; c++){	// 가지고 있는 카드 번호
			var td = tiles.find(".privateTd"+c);
			var card = $("#card"+playerCard[p][c]);
			td.append(card);
		}
	}    
	console.log(playerCard);
}

var playerCard = [[],[],[],[]];
