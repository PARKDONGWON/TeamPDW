create table board_notice 
(num number primary key, 
writer varchar2(100), 
title varchar2(100), 
smallTitle varchar2(100), 
content CLOB, 
viewCount number, 
regdate DATE
);

create sequence board_notice_seq;

create tableboard_notice_comment
(num number primary key,
writer varchar2(100),
content varchar2(500),
target_id varchar2(100),
ref_group number,
comment_group number,
regdate DATE);

CREATE TABLE board_notice_comment(
num NUMBER PRIMARY KEY, --덧글의 글번호 
writer VARCHAR2(100),
content VARCHAR2(500),
target_id VARCHAR2(100), --덧글의 대상이 되는 아이디 
ref_group NUMBER, -- 덧글 그룹
comment_group NUMBER, -- 덧글 내에서의 그룹
regdate DATE
);