CREATE DATABASE roomBooking CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE USER 'roomBooking'@'%' IDENTIFIED BY 'roomBooking';
GRANT ALL PRIVILEGES ON roomBooking.* TO 'roomBooking'@'%';
FLUSH PRIVILEGES;

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`
(
    `teacher_id`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键id',
    `teacher_name`     varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '教师名',
    `teacher_number`   varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '教工号',
    `teacher_password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
    `teacher_email`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '教师邮箱',
    `delete_flag`      tinyint                                                       NOT NULL DEFAULT '0' COMMENT '删除标识 0:未删除 1:删除',
    `create_time`      timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`      timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`teacher_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='教师表';

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `student_id`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键id',
    `student_name`   varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学生姓名',
    `student_number` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学号',
    `student_email`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '学生邮箱',
    `delete_flag`    tinyint                                                       NOT NULL DEFAULT '0' COMMENT '删除标识 0:未删除 1:删除',
    `create_time`    timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`    timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`student_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='学生表';

DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`
(
    `room_id`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键id',
    `room_number` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '房间号',
    `capacity`    INT                                                           NOT NULL COMMENT '房间容量',
    `room_state`  tinyint                                                       NOT NULL DEFAULT '0' COMMENT '房间状态 1:不可用 2:可用',
    `delete_flag` tinyint                                                       NOT NULL DEFAULT '0' COMMENT '删除标识 0:未删除 1:删除',
    `create_time` timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`room_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='房间表';

DROP TABLE IF EXISTS `room_booking`;
CREATE TABLE `room_booking`
(
    `booking_id`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键id',
    `room_id`       varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '房间id',
    `teacher_id`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '教师id',
    `course_id`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '课程id',
    `week_day`      tinyint                                                       NOT NULL DEFAULT '0' COMMENT '周几 :1,2,3,4,5,6,7',
    `course_start`  tinyint                                                       NOT NULL DEFAULT '0' COMMENT '第几节课 :1,2,3,4,5,6,7,8',
    `booking_state` tinyint                                                       NOT NULL DEFAULT '0' COMMENT '申请状态 1:待定 2:已批准 3:已拒绝 4:已取消',
    `deadline`      DATE                                                          NOT NULL COMMENT '有效截止时间',
    `delete_flag`   tinyint                                                       NOT NULL DEFAULT '0' COMMENT '删除标识 0:未删除 1:删除',
    `create_time`   timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`booking_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='房间申请表(每条记录对应)';

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`
(
    `course_id`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键id',
    `teacher_id`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '教师id',
    `course_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '课程名',
    `student_num` INT                                                           NOT NULL COMMENT '学生数',
    `delete_flag` tinyint                                                       NOT NULL DEFAULT '0' COMMENT '删除标识 0:未删除 1:删除',
    `create_time` timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`course_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='课程表';

DROP TABLE IF EXISTS `room_booking_history`;
CREATE TABLE `room_booking_history`
(
    `history_id`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键id',
    `booking_id`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '预定记录id',
    `room_id`      varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '房间id',
    `teacher_id`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '教师id',
    `course_id`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '课程id',
    `week_day`     tinyint                                                       NOT NULL DEFAULT '0' COMMENT '周几 :1,2,3,4,5,6,7',
    `course_start` tinyint                                                       NOT NULL DEFAULT '0' COMMENT '第几节课 :1,2,3,4,5,6,7,8',
    `booking_log`  varchar(100)                                                  NOT NULL DEFAULT '' COMMENT '预定描述',
    `deadline`     DATE                                                          NOT NULL COMMENT '有效截止时间',
    `process_time` timestamp                                                     NOT NULL COMMENT '处理时间',
    `delete_flag`  tinyint                                                       NOT NULL DEFAULT '0' COMMENT '删除标识 0:未删除 1:删除',
    `create_time`  timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`history_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='预定历史表';

DROP TABLE IF EXISTS `room_occupancy`;
CREATE TABLE room_occupancy
(
    `occupancy_id`    varchar(50) NOT NULL COMMENT '主键id',
    `room_id`         varchar(50) NOT NULL COMMENT '房间id',
    `week_day`        tinyint     NOT NULL DEFAULT '0' COMMENT '周几 :1,2,3,4,5,6,7',
    `course_start`    tinyint     NOT NULL DEFAULT '0' COMMENT '第几节课 :1,2,3,4,5,6,7,8',
    `occupancy_state` tinyint     NOT NULL DEFAULT '0' COMMENT '占用状态 1:空闲 2:占用',
    `capacity`        INT         NOT NULL COMMENT '房间容量',
    `booking_id`      varchar(50) COMMENT '预定id',
    `delete_flag`     tinyint     NOT NULL DEFAULT '0' COMMENT '删除标识 0:未删除 1:删除',
    `create_time`     timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`     timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (occupancy_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='房间占用状态表';

DROP TABLE IF EXISTS `student_course`;
CREATE TABLE student_course
(
    `id`          varchar(50) NOT NULL COMMENT '主键id',
    `student_id`  varchar(50) NOT NULL COMMENT '学生id',
    `course_id`   varchar(50) NOT NULL COMMENT '课程id',
    `delete_flag` tinyint     NOT NULL DEFAULT '0' COMMENT '删除标识 0:未删除 1:删除',
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='学生课程关联表';

DROP TABLE IF EXISTS `student_course`;
CREATE TABLE student_course
(
    `correlation_id`          varchar(50) NOT NULL COMMENT '主键id',
    `student_id`  varchar(50) NOT NULL COMMENT '学生id',
    `course_id`   varchar(50) NOT NULL COMMENT '课程id',
    `delete_flag` tinyint     NOT NULL DEFAULT '0' COMMENT '删除标识 0:未删除 1:删除',
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`correlation_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='学生课程关联表';
--- 测试用数据

-- 教师数据
INSERT INTO teacher (teacher_id, teacher_name, teacher_number, teacher_password, teacher_email)
VALUES ('T01', '教师A', 'TNum01', 'pwd01', 'teacherA@example.com'),
       ('T02', '教师B', 'TNum02', 'pwd02', 'teacherB@example.com');

-- 课程数据
INSERT INTO course (course_id, teacher_id, course_name, student_num)
VALUES ('C01', 'T01', '课程A', 30),
       ('C02', 'T02', '课程B', 40);


-- 假设有10个房间，每个房间容量不同
INSERT INTO room (room_id, room_number, capacity, room_state)
VALUES ('R01', '101', 35, 1),
       ('R02', '102', 40, 1),
       ('R03', '103', 45, 1),
       ('R04', '104', 50, 1),
       ('R05', '105', 55, 1),
       ('R06', '106', 60, 1),
       ('R07', '107', 65, 1),
       ('R08', '108', 70, 1),
       ('R09', '109', 75, 1),
       ('R10', '110', 80, 1);

-- 房间占用状态，为简化示例，这里只设置部分房间的占用状态
INSERT INTO room_occupancy (occupancy_id, room_id, week_day, course_start, occupancy_state, capacity)
VALUES ('O01', 'R01', 1, 2, 1, 35),
       ('O02', 'R02', 1, 1, 2, 40),
       ('O03', 'R03', 2, 2, 1, 45),
       ('O04', 'R04', 2, 2, 2, 50),
       ('O05', 'R05', 3, 3, 1, 55);

---









--- 基础数据

INSERT INTO student (student_id, student_name, student_number, student_email, delete_flag)
VALUES ('S001', '学生1', '20001', 'student1@email.com', 0),
       ('S002', '学生2', '20002', 'student2@email.com', 0),
       ('S003', '学生3', '20003', 'student3@email.com', 0),
       ('S004', '学生4', '20004', 'student4@email.com', 0),
       ('S005', '学生5', '20005', 'student5@email.com', 0),
       ('S006', '学生6', '20006', 'student6@email.com', 0),
       ('S007', '学生7', '20007', 'student7@email.com', 0),
       ('S008', '学生8', '20008', 'student8@email.com', 0),
       ('S009', '学生9', '20009', 'student9@email.com', 0),
       ('S010', '学生10', '20010', 'student10@email.com', 0);

INSERT INTO teacher (teacher_id, teacher_name, teacher_number, teacher_password, teacher_email, delete_flag)
VALUES ('T001', '教师1', '10001', 'pass123', 'teacher1@email.com', 0),
       ('T002', '教师2', '10002', 'pass123', 'teacher2@email.com', 0),
       ('T003', '教师3', '10003', 'pass123', 'teacher3@email.com', 0),
       ('T004', '教师4', '10004', 'pass123', 'teacher4@email.com', 0),
       ('T005', '教师5', '10005', 'pass123', 'teacher5@email.com', 0),
       ('T006', '教师6', '10006', 'pass123', 'teacher6@email.com', 0),
       ('T007', '教师7', '10007', 'pass123', 'teacher7@email.com', 0),
       ('T008', '教师8', '10008', 'pass123', 'teacher8@email.com', 0),
       ('T009', '教师9', '10009', 'pass123', 'teacher9@email.com', 0),
       ('T010', '教师10', '10010', 'pass123', 'teacher10@email.com', 0);

INSERT INTO room (room_id, room_number, capacity, room_state, delete_flag)
VALUES ('R001', '101', 40, 1, 0),
       ('R002', '102', 30, 1, 0),
       ('R003', '103', 35, 1, 0),
       ('R004', '104', 50, 1, 0),
       ('R005', '105', 45, 1, 0),
       ('R006', '106', 42, 1, 0),
       ('R007', '107', 38, 1, 0),
       ('R008', '108', 50, 1, 0),
       ('R009', '109', 30, 1, 0),
       ('R010', '110', 25, 1, 0);

INSERT INTO room_booking (booking_id, room_id, teacher_id, course_id, week_day, course_start, booking_state, deadline,
                          delete_flag)
VALUES ('B001', 'R001', 'T001', 'C001', 1, 1, 2, '2023-07-15', 0),
       ('B002', 'R002', 'T002', 'C002', 2, 2, 2, '2023-07-16', 0),
       ('B003', 'R003', 'T003', 'C003', 3, 3, 2, '2023-07-17', 0),
       ('B004', 'R004', 'T004', 'C004', 4, 4, 2, '2023-07-18', 0),
       ('B005', 'R005', 'T005', 'C005', 5, 5, 2, '2023-07-19', 0),
       ('B006', 'R006', 'T006', 'C006', 1, 1, 2, '2023-07-20', 0),
       ('B007', 'R007', 'T007', 'C007', 2, 2, 2, '2023-07-21', 0),
       ('B008', 'R008', 'T008', 'C008', 3, 3, 2, '2023-07-22', 0),
       ('B009', 'R009', 'T009', 'C009', 4, 4, 2, '2023-07-23', 0),
       ('B010', 'R010', 'T010', 'C010', 5, 5, 2, '2023-07-24', 0);

INSERT INTO course (course_id, teacher_id, course_name, student_num, delete_flag)
VALUES ('C001', 'T001', '课程1', 30, 0),
       ('C002', 'T002', '课程2', 35, 0),
       ('C003', 'T003', '课程3', 40, 0),
       ('C004', 'T004', '课程4', 45, 0),
       ('C005', 'T005', '课程5', 50, 0),
       ('C006', 'T006', '课程6', 55, 0),
       ('C007', 'T007', '课程7', 60, 0),
       ('C008', 'T008', '课程8', 65, 0),
       ('C009', 'T009', '课程9', 70, 0),
       ('C010', 'T010', '课程10', 75, 0);

INSERT INTO room_booking_history (history_id, booking_id, room_id, teacher_id, course_id, week_day, course_start,
                                  booking_log, deadline, process_time, delete_flag)
VALUES ('H001', 'B001', 'R001', 'T001', 'C001', 1, 1, '历史记录1', '2023-07-15', '2023-06-01 08:00:00', 0),
       ('H002', 'B002', 'R002', 'T002', 'C002', 2, 2, '历史记录2', '2023-07-16', '2023-06-02 08:00:00', 0),
       ('H003', 'B003', 'R003', 'T003', 'C003', 3, 3, '历史记录3', '2023-07-17', '2023-06-03 08:00:00', 0),
       ('H004', 'B004', 'R004', 'T004', 'C004', 4, 4, '历史记录4', '2023-07-18', '2023-06-04 08:00:00', 0),
       ('H005', 'B005', 'R005', 'T005', 'C005', 5, 5, '历史记录5', '2023-07-19', '2023-06-05 08:00:00', 0),
       ('H006', 'B006', 'R006', 'T006', 'C006', 1, 1, '历史记录6', '2023-07-20', '2023-06-06 08:00:00', 0),
       ('H007', 'B007', 'R007', 'T007', 'C007', 2, 2, '历史记录7', '2023-07-21', '2023-06-07 08:00:00', 0),
       ('H008', 'B008', 'R008', 'T008', 'C008', 3, 3, '历史记录8', '2023-07-22', '2023-06-08 08:00:00', 0),
       ('H009', 'B009', 'R009', 'T009', 'C009', 4, 4, '历史记录9', '2023-07-23', '2023-06-09 08:00:00', 0),
       ('H010', 'B010', 'R010', 'T010', 'C010', 5, 5, '历史记录10', '2023-07-24', '2023-06-10 08:00:00', 0);

INSERT INTO room_occupancy (occupancy_id, room_id, week_day, course_start, occupancy_state, capacity, booking_id,
                            delete_flag)
VALUES ('O001', 'R001', 1, 1, 2, 40, 'B001', 0),
       ('O002', 'R002', 2, 2, 2, 30, 'B002', 0),
       ('O003', 'R003', 3, 3, 2, 35, 'B003', 0),
       ('O004', 'R004', 4, 4, 2, 50, 'B004', 0),
       ('O005', 'R005', 5, 5, 2, 45, 'B005', 0),
       ('O006', 'R006', 1, 1, 2, 42, 'B006', 0),
       ('O007', 'R007', 2, 2, 2, 38, 'B007', 0),
       ('O008', 'R008', 3, 3, 2, 50, 'B008', 0),
       ('O009', 'R009', 4, 4, 2, 30, 'B009', 0),
       ('O010', 'R010', 5, 5, 2, 25, 'B010', 0);
