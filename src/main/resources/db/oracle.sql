declare num   number;
begin
    select count(1) into num from User_Tables where TABLE_NAME = upper('permission') ;
    if   num=1   then
        execute immediate 'drop table permission';
    end   if;
end;
/
CREATE TABLE  permission
(
    id          NUMBER generated by default on null as IDENTITY,
    name        varchar(255) NOT NULL,
    code        varchar(50)  NOT NULL UNIQUE,
    type        varchar(255) NOT NULL,
    parentId    int       NULL   ,
    path        varchar(255) NULL,
    redirect    varchar(255) NULL    ,
    icon        varchar(255) NULL    ,
    component   varchar(255) NULL    ,
    layout      varchar(255) NULL    ,
    keepAlive    int   NULL    ,
    method      varchar(255) NULL    ,
    description varchar(255) NULL    ,
    show        int   NOT NULL   ,
    enable      int  NOT NULL  ,
    "order"       int      NULL
);
alter table permission  add constraint permission_pri primary key (id);
alter table permission  modify show DEFAULT 1 ;
alter table permission  modify enable DEFAULT 1 ;
COMMENT on COLUMN  permission.show is '是否展示在页面菜单';
INSERT INTO permission
VALUES (1, '资源管理', 'Resource_Mgt', 'MENU', 2, '/pms/resource', NULL, 'i-fe:list',
        '/src/views/pms/resource/index.vue', NULL, NULL, NULL, NULL, 1, 1, 1);
INSERT INTO permission
VALUES (2, '系统管理', 'SysMgt', 'MENU', NULL, NULL, NULL, 'i-fe:grid', NULL, NULL, NULL, NULL, NULL, 1, 1, 2);
INSERT INTO permission
VALUES (3, '角色管理', 'RoleMgt', 'MENU', 2, '/pms/role', NULL, 'i-fe:user-check', '/src/views/pms/role/index.vue',
        NULL, NULL, NULL, NULL, 1, 1, 2);
INSERT INTO permission
VALUES (4, '用户管理', 'UserMgt', 'MENU', 2, '/pms/user', NULL, 'i-fe:user', '/src/views/pms/user/index.vue', NULL, 1,
        NULL, NULL, 1, 1, 3);
INSERT INTO permission
VALUES (5, '分配用户', 'RoleUser', 'MENU', 3, '/pms/role/user/:roleId', NULL, 'i-fe:user-plus',
        '/src/views/pms/role/role-user.vue', NULL, NULL, NULL, NULL, 0, 1, 1);
INSERT INTO permission
VALUES (6, '业务示例', 'Demo', 'MENU', NULL, NULL, NULL, 'i-fe:grid', NULL, NULL, NULL, NULL, NULL, 1, 1, 1);
INSERT INTO permission
VALUES (7, '图片上传', 'ImgUpload', 'MENU', 6, '/demo/upload', NULL, 'i-fe:image', '/src/views/demo/upload/index.vue',
        NULL, 1, NULL, NULL, 1, 1, 2);
INSERT INTO permission
VALUES (8, '个人资料', 'UserProfile', 'MENU', NULL, '/profile', NULL, 'i-fe:user', '/src/views/profile/index.vue', NULL,
        NULL, NULL, NULL, 0, 1, 99);
INSERT INTO permission
VALUES (9, '基础功能', 'Base', 'MENU', NULL, '/base', NULL, 'i-fe:grid', NULL, NULL, NULL, NULL, NULL, 1, 1, 0);
INSERT INTO permission
VALUES (10, '基础组件', 'BaseComponents', 'MENU', 9, '/base/components', NULL, 'i-me:awesome',
        '/src/views/base/index.vue', NULL, NULL, NULL, NULL, 1, 1, 1);
INSERT INTO permission
VALUES (11, 'Unocss', 'Unocss', 'MENU', 9, '/base/unocss', NULL, 'i-me:awesome', '/src/views/base/unocss.vue', NULL,
        NULL, NULL, NULL, 1, 1, 2);
INSERT INTO permission
VALUES (12, 'KeepAlive', 'KeepAlive', 'MENU', 9, '/base/keep-alive', NULL, 'i-me:awesome',
        '/src/views/base/keep-alive.vue', NULL, 1, NULL, NULL, 1, 1, 3);
INSERT INTO permission
VALUES (13, '创建新用户', 'AddUser', 'BUTTON', 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1);
INSERT INTO permission
VALUES (14, '图标 Icon', 'Icon', 'MENU', 9, '/base/icon', NULL, 'i-fe:feather', '/src/views/base/unocss-icon.vue',
        NULL, NULL, NULL, NULL, 1, 1, 0);
INSERT INTO permission
VALUES (15, 'MeModal', 'TestModal', 'MENU', 9, '/testModal', NULL, 'i-me:dialog', '/src/views/base/test-modal.vue',
        NULL, NULL, NULL, NULL, 1, 1, 5);


declare
    num   number;
begin
    select count(1) into num from User_Tables where TABLE_NAME = upper('profile') ;
    if   num=1   then
        execute immediate 'drop table profile';
    end   if;
end;
/
CREATE TABLE profile
(
    id        NUMBER generated by default on null as IDENTITY,
    gender   int      NULL     ,
    avatar   varchar(255) NOT NULL   ,
    address  varchar(255) NULL    ,
    email    varchar(255) NULL      ,
    userId   int      NOT NULL UNIQUE,
    nickName varchar(10)  NULL
);

alter table profile  add constraint profile_pri primary key (id);
alter table profile  modify avatar DEFAULT 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80' ;
INSERT INTO profile
VALUES (1, NULL, 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80', NULL,
        NULL, 1, 'Admin');

declare
    num   number;
begin
    select count(1) into num from User_Tables where TABLE_NAME = upper('role') ;
    if   num=1   then
        execute immediate 'drop table role';
    end   if;
end;
/
CREATE TABLE  role
(
    id     NUMBER generated by default on null as IDENTITY ,
    code   varchar(50) NOT NULL,
    name   varchar(50) NOT NULL,
    enable int NOT NULL
);
alter table role  add constraint role_pri primary key (id);
alter table role  add constraint unique_code_name unique   (code,name);
alter table role  modify enable DEFAULT 1 ;

INSERT INTO role
VALUES (1, 'SUPER_ADMIN', '超级管理员', 1);
INSERT INTO role
VALUES (2, 'ROLE_QA', '质检员', 1);

declare
    num   number;
begin
    select count(1) into num from User_Tables where TABLE_NAME = upper('role_permissions_permission') ;
    if   num=1   then
        execute immediate 'drop table role_permissions_permission';
    end   if;
end;
/
CREATE TABLE role_permissions_permission
(
    roleId       int NOT NULL,
    permissionId int NOT NULL
);
alter table role_permissions_permission  add constraint role_permissions_permission_pri primary key (roleId, permissionId);


INSERT INTO role_permissions_permission
VALUES (2, 1);
INSERT INTO role_permissions_permission
VALUES (2, 2);
INSERT INTO role_permissions_permission
VALUES (2, 3);
INSERT INTO role_permissions_permission
VALUES (2, 4);
INSERT INTO role_permissions_permission
VALUES (2, 5);
INSERT INTO role_permissions_permission
VALUES (2, 9);
INSERT INTO role_permissions_permission
VALUES (2, 10);
INSERT INTO role_permissions_permission
VALUES (2, 11);
INSERT INTO role_permissions_permission
VALUES (2, 12);
INSERT INTO role_permissions_permission
VALUES (2, 14);
INSERT INTO role_permissions_permission
VALUES (2, 15);


declare
    num   number;
begin
    select count(1) into num from User_Tables where TABLE_NAME = upper('user') ;
    if   num=1   then
        execute immediate 'drop table "USER"';
    end   if;
end;
/
CREATE TABLE  "USER"
(
    id         NUMBER generated by default on null as IDENTITY,
    username   varchar(50)  NOT NULL unique,
    password   varchar(255) NOT NULL,
    enable     int   NOT NULL ,
    createTime date     DEFAULT  SYSDATE,
    updateTime date    DEFAULT  SYSDATE
);

alter table "USER"  add constraint user_pri primary key (id);
alter table "USER"  modify enable DEFAULT 1 ;


INSERT INTO "USER"
VALUES (1, 'admin', '$2a$10$FsAafxTTVVGXfIkJqvaiV.1vPfq4V9HW298McPldJgO829PR52a56', 1,
        TO_DATE('2023-11-18 16:18:59', 'SYYYY-MM-DD HH24:MI:SS'),
        TO_DATE('2023-11-18 16:18:59', 'SYYYY-MM-DD HH24:MI:SS'));

declare
    num   number;
begin
    select count(1) into num from User_Tables where TABLE_NAME = upper('user_roles_role') ;
    if   num=1   then
        execute immediate 'drop table user_roles_role';
    end   if;
end;
/
CREATE TABLE user_roles_role
(
    userId int NOT NULL,
    roleId int NOT NULL
);
alter table user_roles_role  add constraint user_roles_role_pri primary key (userId, roleId);



INSERT INTO user_roles_role
VALUES (1, 1);
INSERT INTO user_roles_role
VALUES (1, 2);
