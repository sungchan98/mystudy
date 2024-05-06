----------------------------------------------------------------
SELECT su.created_at, s.name, s.limited_man, s.photo
FROM schools s
 JOIN school_users su ON su.school_no = su.user_no;


 -----------------
 select
c.class_no,
c.name,
u.name,
c.photo,
c.content,
c.location,
c.member,
c.repeat_set,
date_format(c.now_at, '%y%m%d'),
date_format(c.created_at, '%y%m%d'),
date_format(c.ended_at, '%y%m%d')
from classes c join
school_users s on s.school_no = c.school_no
 join
users u on u.user_no = s.user_no
where s.school_no =1 and u.user_no =2;


-----------
select
  su.school_no,
  s.school_no,
  p.school_no,
  p.title,
  p.content,
  s.name,
  s.photo
from
  schools as s join
  school_users as su join
  post as p 
on s.school_no = p.school_no
    
    
order by
    now_member_count desc

SELECT su.user_no, u.name AS user_name, s.name AS school_name, sc.name AS grade_name
FROM school_users su
INNER JOIN users u ON su.user_no = u.user_no
INNER JOIN schools s ON su.school_no = s.school_no
INNER JOIN schools sc ON su.grade_no = sc.school_no;

--- 내가 가입한 스쿨의 게시글

    SELECT
      u.user_no,
      u.name AS user_name,
      p.post_no,
      s.school_no,
      p.created_at,
      (select count(*) from likes as l where l.post_no=p.post_no) as like_count,
      (select count(*) from comments as c where c.post_no=p.post_no) as comment_count,
      s.name AS school_name,
      s.photo AS school_photo,
      p.content AS post_content,
      f.path,
      f.name,
      f.post_no
    FROM
      posts p
    INNER JOIN schools s ON s.school_no = p.school_no
    INNER JOIN users u ON p.user_no = u.user_no
    LEFT OUTER JOIN files f ON p.post_no = f.post_no
    where p.user_no=#{no}
    order by p.created_at desc;


  ---- 좋아요 많은 게시글 보기
      SELECT
      u.user_no,
      u.name AS user_name,
      p.post_no,
      s.school_no,
      p.created_at,
      (select count(*) from likes as l where l.post_no=p.post_no) as like_count,
      (select count(*) from comments as c where c.post_no=p.post_no) as comment_count,
      s.name AS school_name,
      s.photo AS school_photo,
      p.content AS post_content,
      f.path,
      f.name,
      f.post_no
    FROM
      posts p
    INNER JOIN schools s ON s.school_no = p.school_no
    INNER JOIN users u ON p.user_no = u.user_no
    LEFT OUTER JOIN files f ON p.post_no = f.post_no
   order by like_count desc;


-- 팔로잉 게시글 보기
    SELECT
      u.user_no,
      u.name AS user_name,
      p.post_no,
      s.school_no,
      p.created_at,
      (select count(*) from likes as l where l.post_no=p.post_no) as like_count,
      (select count(*) from comments as c where c.post_no=p.post_no) as comment_count,
      s.name AS school_name,
      s.photo AS school_photo,
      p.content AS post_content,
      f.path,
      f.name,
      f.post_no
    FROM
      posts p
    INNER JOIN schools s ON s.school_no = p.school_no
    INNER JOIN users u ON p.user_no = u.user_no
    INNER JOIN follows ON follows.user_no2 = p.user_no
    LEFT OUTER JOIN files f ON p.post_no = f.post_no

   order by like_count desc;


   ----
   select 
    c.class_no,
    c.school_no,
    c.name,
    c.location,
    c.content,
    c.now_at

   from 
      classes c





      ----------------------
SELECT DISTINCT
    u.user_no,
    u.name as user_name,
    u.photo,
    p.post_no,
    p.created_at,
    p.content,
    c.content as content_content,
    s.school_no,
    f.path,
    f.name as file_name
FROM
    posts p
INNER JOIN school_users su ON p.school_no = su.school_no
INNER JOIN users u ON p.user_no = u.user_no
LEFT OUTER JOIN schools s ON p.school_no = s.school_no
LEFT OUTER JOIN comments c ON p.post_no = c.post_no
LEFT OUTER JOIN files f ON p.post_no = f.post_no
WHERE
    p.school_no = 1 
ORDER BY
    p.created_at DESC;
------------------------------

    SELECT
      u.grade AS userGrade,
      su.grade_no AS schoolUserGradeNo,
      (SELECT COUNT(*) FROM school_users WHERE grade_no = 4) AS user_manager_count
    FROM
      users u
    INNER JOIN
      school_users su ON u.user_no = su.user_no
    HAVING
      user_manager_count = 1 AND u.grade = 0;

  ------------------------------------

UPDATE
  users SET grade = 4 WHERE user_no = 4;


  ---------------------------------


    SELECT
     -- u.user_no AS userNo,
     -- u.grade AS userGrade,
     -- su.grade_no AS schoolUserGradeNo,
      (SELECT COUNT(*) FROM users u INNER JOIN school_users su ON u.user_no = su.user_no WHERE su.grade_no = 4) AS user_manager_count -- 자기가 매니저인 스쿨의 개수
      (SELECT COUNT(*) FROM WHERE u.user_no = su.user_no) AS user_school_count-- 유저가 가입한 스쿨의 개수
    FROM
      users u
    INNER JOIN
      school_users su ON u.user_no = su.user_no
    ORDER BY
      u.user_no;
    HAVING
      user_manager_count = 1 AND su.grade = 1;



  ----------------------------


  SELECT DISTINCT
    u.user_no AS userNo,
  (
    SELECT COUNT(*) 
    FROM users u 
    INNER JOIN school_users su ON u.user_no = su.user_no 
    WHERE su.grade_no = 4
  ) AS user_manager_count, -- 자기가 매니저인 스쿨의 개수
  (
    SELECT COUNT(*) 
    FROM school_users 
    WHERE user_no = su.user_no
  ) AS user_school_count -- 유저가 가입한 스쿨의 개수
FROM
  users u
INNER JOIN
  school_users su ON u.user_no = su.user_no;
ORDER BY
  u.user_no;
-------------------------

   SELECT DISTINCT
     u.user_no AS userNo,
     u.grade,
  (
    SELECT COUNT(*) 
    FROM school_users su 
    WHERE su.grade_no = 4 AND su.user_no = 1
  ) AS user_manager_count,
   (
    SELECT COUNT(*)
    FROM school_users
    WHERE user_no = su.user_no
   ) AS user_school_count
  FROM
   users u
  INNER JOIN
  school_users su ON u.user_no = su.user_no
  ORDER BY
    u.user_no;

-----------------------------------

    SELECT COUNT(*) 
    FROM school_users su 
    WHERE su.grade_no = 4 AND su.user_no = 1;
-----------------------------------------

SELECT
  su.grade_no
FROM
  school_users su
WHERE 

---------------------------

SELECT
  u.user_no,
  u.grade
FROM
  users u;

-----------------------------

SELECT
  s.name
FROM
  schools s
WHERE  
  s.school_no = 1;

---------------------------------

select * from schools
where name=#{name} and

------------------------------
INSERT INTO school_users (name, user_no, password)
SELECT username, email, password
FROM users
WHERE [조건];


--------------
    update schools set
    name='샤샷',
    photo='test',
    content='test2244'
    where
    school_no=15


  DELETE FROM school_tags WHERE school_no = 12;
  DELETE FROM school_users WHERE school_no = 12;
  DELETE FROM schools WHERE school_no = 12;