-- database: ../DataBase/RAEcuaFauna.sqlite
DROP TABLE IF EXISTS RALugar;
DROP TABLE IF EXISTS RASexo;


CREATE TABLE RALugar (
    IdLugar            integer primary key autoincrement
    ,Nombre             VARCHAR(50) NOT NULL
    ,Region             VARCHAR(50) NOT NULL
    ,Pais               VARCHAR(50) DEFAULT 'Ecuador' NOT NULL
    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica      DATETIME
);

CREATE TABLE RASexo(
    IdSexo              integer primary key autoincrement
    ,Tipo               VARCHAR(10) NOT NULL
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica      DATETIME            
);

CREATE TABLE RAHormiga(
    IdHormiga           integer primary key autoincrement
    ,TipoHormiga        VARCHAR(10) NOT NULL
    ,Provincia          VARCHAR(50) NOT NULL
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica      DATETIME            
);