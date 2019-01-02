INSERT INTO course(id,name) VALUES (100,'Java');
INSERT INTO course(id,name) VALUES (200,'OS');
INSERT INTO course(id,name) VALUES (300,'Compiler');

INSERT INTO address VALUES (100,'tehran','zamzam',1245);
INSERT INTO address VALUES (200,'tehran','azadi',5411);
INSERT INTO address VALUES (300,'semnan','azimi',1144);

INSERT INTO group_manager(manager_id,name,family)
VALUES(100,'ali','ghafari');
INSERT INTO group_manager(manager_id,name,family)
VALUES(200,'hassan','alipoor');


INSERT INTO student(student_id,name,family,student_number,address_id,manager_id)
VALUES (1000,'alireza','talashan','14523698',100,100);
INSERT INTO student(student_id,name,family,student_number,address_id,manager_id)
VALUES (1001,'sara','amini','22123654',200,100);
INSERT INTO student(student_id,name,family,student_number,address_id,manager_id)
VALUES (1002,'nima','behbod','14524410',300,200);

INSERT INTO course_student(course_id,student_id) VALUES (100,1000);
INSERT INTO course_student(course_id,student_id) VALUES (100,1001);
INSERT INTO course_student(course_id,student_id) VALUES (100,1002);
INSERT INTO course_student(course_id,student_id) VALUES (200,1002);
INSERT INTO course_student(course_id,student_id) VALUES (300,1000);
INSERT INTO course_student(course_id,student_id) VALUES (300,1001);