-- database: ../DataBase/RAEcuaFauna.sqlite
DROP TABLE IF EXISTS RALugar;
DROP TABLE IF EXISTS RASexo;
DROP TABLE IF EXISTS RAHormigueroVirtual;




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

CREATE TABLE RAHormigueroVirtual(
    IdHormiga           INTEGER NOT NULL
    ,TipoHormiga        VARCHAR(50) NOT NULL
    ,Ubicacion          VARCHAR(50) NOT NULL
    ,Sexo               VARCHAR(50) NOT NULL
    ,GenoAlimento       VARCHAR(50) NOT NULL
    ,IngestaNativa      VARCHAR(50) NOT NULL
    ,Estado             VARCHAR(10) NOT NULL
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica      DATETIME            
);