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