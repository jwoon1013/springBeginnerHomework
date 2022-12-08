# springBeginnerHomework
스프링 입문주차 숙제(22/12/06~22/12/09 제출)  
blog의 백엔드 만들어보고, 백단의 동작구조 이해하기.  

# 1. 과제 작성시 주의사항  
- Entity를 그대로 반환하지 말고 DTO 에 담아서 반환.  
- 뷰(HTML/CSS/JS) 없이 JSON만 반환하는 API로 서버 로직 이해하기.  
- Postman으로 서버가 반환하는 결과값 확인

# 2. 과제 요구사항  
1. 전체 게시글 목록 조회 API  
    - 제목, 작성자명, 작성 내용, 작성 날짜를 조회하기  
    - 작성 날짜 기준 내림차순으로 정렬하기  
2. 게시글 작성 API  
    - 제목, 작성자명, 비밀번호, 작성 내용을 저장하고  
    - 저장된 게시글을 Client 로 반환하기  
3. 선택한 게시글 조회 API  
    - 선택한 게시글의 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기   
    (검색 기능이 아닙니다. 간단한 게시글 조회만 구현해주세요.)  
4. 선택한 게시글 수정 API  
    - 수정을 요청할 때 수정할 데이터와 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후  
    - 제목, 작성자명, 작성 내용을 수정하고 수정된 게시글을 Client 로 반환하기  
5. 선택한 게시글 삭제 API  
    - 삭제를 요청할 때 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후  
    - 선택한 게시글을 삭제하고 Client 로 성공했다는 표시 반환하기  
6. API 명세서와 요구사항 기반 UseCase도 그려보기 
7. 제출할때 아래 질문에 답변도 같이 제출하기.(제출 : 깃허브 링크)  
  - 1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)   
  - 2. 어떤 상황에 어떤 방식의 request를 써야하나요?  
  - 3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?   
  - 4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)  
  - 5. API 명세서 작성 가이드라인을 검색하여 직접 작성한 API 명세서와 비교해보세요!  

# 3. API 명세서 


| 기능 | Method | URL | Request | Response |
| ---   |        --- | ---   |       --- |          --- | 
| 게시글 작성  | POST | /posts | title, author, content, password| createdAt, modifiedAt, id, ttitle, author, content, msg |  
| 전체게시글 목록조회 | GET | /posts | 없음 | createdAt, modifiedAt, id, ttitle, author, content |  
| 선택한 게시글 조회 | GET | /posts/{id} | 없음 | createdAt, modifiedAt, id, ttitle, author, content, msg |  
| 선택한 게시글 수정 | PUT | /posts/{id} | title, author, content, passwrod | createdAt, modifiedAt, id, ttitle, author, content, msg  |  
| 선택한 게시글 삭제  | DELETE | /posts/{id} | password | msg |  

#  4. Use Case
![usecase](/03.PNG)   
