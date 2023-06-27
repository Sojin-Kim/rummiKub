/**
 * 공통함수
 */

/** 
 * 세션 저장
 * type : local(로컬 스토리지), session(세션 스토리지)
 * 로컬은 새로고침하거나 창을 닫아도 삭제되지 않음. 세션은 페이지 나갈 경우 삭제됨.
 * ex) saveSession("local","login",'{"id": "soso"}') -> 로컬 스토리지에 login이라는 key값으로 {"id": "soso"} 데이터가 저장됨.
 */
function saveSession(type, key, data){
	if(type=="local"){
		localStorage.setItem(key, data); // 저장 
	}else if(type=="session"){
		sessionStorage.setItem(key, data); // 저장
	} 
}

/**
 * 세션 조회
 * ex) getSession("local","login") -> 로컬 스토리지에 login이라는 key값의 데이터가 리턴됨.
 */
function getSession(type, key){
	if(type=="local"){
		return localStorage.getItem(key); // 저장 
	}else if(type=="session"){
		return sessionStorage.getItem(key); // 저장
	}
}

/**
 * 세션 삭제
 * ex) removeSession("local","login") -> 로컬 스토리지에 login이라는 key값 삭제됨.
 */
function removeSession(type, key){
	if(type=="local"){
		localStorage.removeItem(key); // 저장 
	}else if(type=="session"){
		sessionStorage.removeItem(key); // 저장 
	} 
}
 
// null 체크 : null일 경우 true 반환
function isNull(param){
	if(param == null || param == "") {
		return true;
	}
	return false;
} 
 
// 빈값 체크 : 빈값일 경우 true 반환
function isEmpty(param){
	if(param == null || param.replace(/ /gi,"") == "") {
		return true;
	}
	return false;
}

// 각자 필요한 공통코드 추가하기
