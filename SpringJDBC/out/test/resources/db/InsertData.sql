insert into USERS (id, LOGIN, PASSWORD, HASH_PASS, ROLE_TYPE) values (1, 'user1', 'user1pass', 'ghjghjgjgjh', 'User');
insert into USERS (id, LOGIN, PASSWORD, HASH_PASS, ROLE_TYPE) values (2, 'user2', 'user2pass', 'dfgdfgfdgdfg', 'User');
insert into USERS (id, LOGIN, PASSWORD, HASH_PASS, ROLE_TYPE) values (3, 'admin', 'admin1pass', 'ggdfgfdgfd', 'Admin');

insert into SESSION (id, ACTIVE, USER_ID) values (1, 0, '1');
insert into SESSION (id, ACTIVE, USER_ID) values (2, 1, '1');
insert into SESSION (id, ACTIVE, USER_ID) values (3, 0, '2');
insert into SESSION (id, ACTIVE, USER_ID) values (4, 0, '3');

insert into PROJECT (id, NAME, DESCRIPTION, STATUS, START_DATE, END_DATE, USER_ID) values (1, 'Project #1', 'The most impotent project in the world!', 'Completed', '2025-01-01', '2025-04-30', '1');
insert into PROJECT (id, NAME, DESCRIPTION, STATUS, START_DATE, END_DATE, USER_ID) values (2, 'Project #2', 'Very impotent project', 'InProgress', '2025-01-01', '2025-12-31', '1');
insert into PROJECT (id, NAME, DESCRIPTION, STATUS, START_DATE, END_DATE, USER_ID) values (3, 'Project #3', 'Is not impotent project', 'Planned', '2025-06-01', '2025-12-31', '1');

insert into TASK (id, NAME, DESCRIPTION, STATUS, START_DATE, END_DATE, PROJECT_ID) values (1, 'Task #1', 'Simple Task 1', 'Completed', '2025-01-01', '2025-01-30', '1');
insert into TASK (id, NAME, DESCRIPTION, STATUS, START_DATE, END_DATE, PROJECT_ID) values (2, 'Task #2', 'Simple Task 2', 'Completed', '2025-02-01', '2025-02-28', '1');
insert into TASK (id, NAME, DESCRIPTION, STATUS, START_DATE, END_DATE, PROJECT_ID) values (3, 'Task #3', 'Simple Task 3', 'Completed', '2025-03-01', '2025-03-30', '1');

insert into TASK (id, NAME, DESCRIPTION, STATUS, START_DATE, END_DATE, PROJECT_ID) values (4, 'Task #4', 'Simple Task 1', 'Completed', '2025-01-01', '2025-01-30', '2');
insert into TASK (id, NAME, DESCRIPTION, STATUS, START_DATE, END_DATE, PROJECT_ID) values (5, 'Task #5', 'Simple Task 2', 'InProgress', '2025-03-01', '2025-03-30', '2');
insert into TASK (id, NAME, DESCRIPTION, STATUS, START_DATE, END_DATE, PROJECT_ID) values (6, 'Task #6', 'Simple Task 3', 'Planned', '2025-04-01', '2025-04-30', '2');
insert into TASK (id, NAME, DESCRIPTION, STATUS, START_DATE, END_DATE, PROJECT_ID) values (7, 'Task #7', 'Simple Task 4', 'Planned', '2025-06-01', '2025-06-30', '2');
