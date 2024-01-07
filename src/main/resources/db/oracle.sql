CREATE TABLE  HI_BD_SRV
(
    id_srv          varchar(64),
    SD_SRVTP_CD        varchar(255) NOT NULL,
    cd        varchar(50)  NOT NULL UNIQUE,
    na        varchar(255) NOT NULL,
    UNIT_SRV_MED  varchar(50) not null,

    fg_active    varchar(1)       NULL

);
alter table hi_bd_srv  add constraint hi_bd_srv_pri primary key (id_srv);

CREATE TABLE  HI_BD_SRV_SET
(
    id    NUMBER generated by default on null as IDENTITY,
    id_srv          varchar(64),
    ID_SRV_SET        varchar(64) NOT NULL,
    VAL_UNITMED  numeric(12) not null

);
alter table HI_BD_SRV_SET  add constraint HI_BD_SRV_SET_pri primary key (id);

CREATE TABLE  HI_BD_SRVPRI
(
    id  NUMBER generated by default on null as IDENTITY,
    id_srv          varchar(64),
    SD_SRVTP_CD        varchar(255) NOT NULL,
    cd        varchar(50)  NOT NULL ,
    pri       numeric(18,2) NOT NULL
);
alter table HI_BD_SRVPRI  add constraint HI_BD_SRVPRI_pri primary key (id);