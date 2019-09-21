-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2019-09-20 04:56:39.259

-- tables
-- Table: alumno
CREATE TABLE alumno (
    id_alumno integer  NOT NULL,
    alumno_nombre varchar2(50)  NOT NULL,
    alumno_apelidos varchar2(50)  NOT NULL,
    alumno_direccion varchar2(1000)  NOT NULL,
    alumno_tel varchar2(10)  NOT NULL,
    alumno_nie varchar2(50)  NOT NULL,
    alumno_fecha_nac date  NOT NULL,
    alumno_genero integer  NOT NULL,
    alumno_estado integer  NOT NULL,
    CONSTRAINT alumno_nie_ UNIQUE (alumno_nie),
    CONSTRAINT alumno_pk PRIMARY KEY (id_alumno)
) ;

-- Table: alumno_responsable
CREATE TABLE alumno_responsable (
    id_alumno_responsable integer  NOT NULL,
    id_alumno integer  NOT NULL,
    id_esponsable integer  NOT NULL,
    CONSTRAINT alumno_responsable_pk PRIMARY KEY (id_alumno_responsable)
) ;

-- Table: anho
CREATE TABLE anho (
    id_anho integer  NOT NULL,
    anho varchar2(4)  NOT NULL,
    materia_id_materia integer  NOT NULL,
    CONSTRAINT anho_pk PRIMARY KEY (id_anho)
) ;

-- Table: docente
CREATE TABLE docente (
    id_docente integer  NOT NULL,
    docente_nombre varchar2(50)  NOT NULL,
    docente_apellido varchar2(50)  NOT NULL,
    docente_tel varchar2(10)  NOT NULL,
    docente_direccion varchar2(100)  NOT NULL,
    docente_doc varchar2(12)  NOT NULL,
    docente_fecha_nac date  NOT NULL,
    docente_estado integer  NOT NULL,
    docente_genero integer  NOT NULL,
    CONSTRAINT docente_doc UNIQUE (docente_doc),
    CONSTRAINT docente_pk PRIMARY KEY (id_docente)
) ;

-- Table: docente_materia
CREATE TABLE docente_materia (
    id_docente_materia integer  NOT NULL,
    id_materia integer  NOT NULL,
    id_docente integer  NOT NULL,
    CONSTRAINT docente_materia_pk PRIMARY KEY (id_docente_materia)
) ;

-- Table: grado
CREATE TABLE grado (
    id_grado integer  NOT NULL,
    grado varchar2(10)  NOT NULL,
    CONSTRAINT grado_nombre UNIQUE (grado),
    CONSTRAINT grado_pk PRIMARY KEY (id_grado)
) ;

-- Table: login
CREATE TABLE login (
    id_login integer  NOT NULL,
    login_usuario varchar2(50)  NOT NULL,
    login_clave varchar2(900)  NOT NULL,
    id_rol integer  NOT NULL,
    id_docente integer  NULL,
    CONSTRAINT login_usuario UNIQUE (login_usuario),
    CONSTRAINT login_pk PRIMARY KEY (id_login)
) ;

-- Table: materia
CREATE TABLE materia (
    id_materia integer  NOT NULL,
    materia_nombre varchar2(50)  NOT NULL,
    CONSTRAINT materia_nombre UNIQUE (materia_nombre),
    CONSTRAINT materia_pk PRIMARY KEY (id_materia)
) ;

-- Table: materia_grado
CREATE TABLE materia_grado (
    id_materia_grado integer  NOT NULL,
    id_materia integer  NOT NULL,
    id_grado integer  NOT NULL,
    CONSTRAINT materia_grado_pk PRIMARY KEY (id_materia_grado)
) ;

-- Table: nota
CREATE TABLE nota (
    id_nota integer  NOT NULL,
    id_alumno integer  NOT NULL,
    id_materia integer  NOT NULL,
    CONSTRAINT nota_pk PRIMARY KEY (id_nota)
) ;

-- Table: periodo
CREATE TABLE periodo (
    id_periodo integer  NOT NULL,
    nota1 number(5,3)  NOT NULL,
    nota2 number(5,3)  NOT NULL,
    nota3 number(5,3)  NOT NULL,
    id_nota integer  NOT NULL,
    id_login integer  NOT NULL,
    periodo integer  NOT NULL,
    CONSTRAINT periodo_pk PRIMARY KEY (id_periodo)
) ;

-- Table: responsable
CREATE TABLE responsable (
    id_responsable integer  NOT NULL,
    responsable_nombre varchar2(50)  NOT NULL,
    responsable_apellidos varchar2(50)  NOT NULL,
    responsable_direccion varchar2(100)  NOT NULL,
    responsable_dui varchar2(10)  NOT NULL,
    responsable_tel varchar2(10)  NOT NULL,
    responsable_estado integer  NOT NULL,
    responsable_genero integer  NOT NULL,
    CONSTRAINT responsable_dui UNIQUE (responsable_dui),
    CONSTRAINT responsable_pk PRIMARY KEY (id_responsable)
) ;

-- Table: rol
CREATE TABLE rol (
    id_rol integer  NOT NULL,
    rol_nombre varchar2(50)  NOT NULL,
    CONSTRAINT rol_nombre UNIQUE (rol_nombre),
    CONSTRAINT rol_pk PRIMARY KEY (id_rol)
) ;

-- Table: seccion
CREATE TABLE seccion (
    id_seccion integer  NOT NULL,
    nombre_seccion char(3)  NOT NULL,
    id_materia integer  NOT NULL,
    id_turno integer  NOT NULL,
    estado integer  NOT NULL,
    CONSTRAINT seccion_pk PRIMARY KEY (id_seccion)
) ;

-- Table: turno
CREATE TABLE turno (
    id_turno integer  NOT NULL,
    turno_nombre varchar2(50)  NOT NULL,
    CONSTRAINT turno_pk PRIMARY KEY (id_turno)
) ;

-- foreign keys
-- Reference: Login_Rol (table: login)
ALTER TABLE login ADD CONSTRAINT Login_Rol
    FOREIGN KEY (id_rol)
    REFERENCES rol (id_rol);

-- Reference: Nota_Alumno (table: nota)
ALTER TABLE nota ADD CONSTRAINT Nota_Alumno
    FOREIGN KEY (id_alumno)
    REFERENCES alumno (id_alumno);

-- Reference: Nota_Materia (table: nota)
ALTER TABLE nota ADD CONSTRAINT Nota_Materia
    FOREIGN KEY (id_materia)
    REFERENCES materia (id_materia);

-- Reference: Periodo_Nota (table: periodo)
ALTER TABLE periodo ADD CONSTRAINT Periodo_Nota
    FOREIGN KEY (id_nota)
    REFERENCES nota (id_nota);

-- Reference: Seccion_Materia (table: seccion)
ALTER TABLE seccion ADD CONSTRAINT Seccion_Materia
    FOREIGN KEY (id_materia)
    REFERENCES materia (id_materia);

-- Reference: Seccion_Turno (table: seccion)
ALTER TABLE seccion ADD CONSTRAINT Seccion_Turno
    FOREIGN KEY (id_turno)
    REFERENCES turno (id_turno);

-- Reference: alumno_responsable_Alumno (table: alumno_responsable)
ALTER TABLE alumno_responsable ADD CONSTRAINT alumno_responsable_Alumno
    FOREIGN KEY (id_alumno)
    REFERENCES alumno (id_alumno);

-- Reference: alumno_responsable_Responsable (table: alumno_responsable)
ALTER TABLE alumno_responsable ADD CONSTRAINT alumno_responsable_Responsable
    FOREIGN KEY (id_esponsable)
    REFERENCES responsable (id_responsable);

-- Reference: anho_materia (table: anho)
ALTER TABLE anho ADD CONSTRAINT anho_materia
    FOREIGN KEY (materia_id_materia)
    REFERENCES materia (id_materia);

-- Reference: docente_materia_docente (table: docente_materia)
ALTER TABLE docente_materia ADD CONSTRAINT docente_materia_docente
    FOREIGN KEY (id_docente)
    REFERENCES docente (id_docente);

-- Reference: docente_materia_materia (table: docente_materia)
ALTER TABLE docente_materia ADD CONSTRAINT docente_materia_materia
    FOREIGN KEY (id_materia)
    REFERENCES materia (id_materia);

-- Reference: materia_grado_grado (table: materia_grado)
ALTER TABLE materia_grado ADD CONSTRAINT materia_grado_grado
    FOREIGN KEY (id_grado)
    REFERENCES grado (id_grado);

-- Reference: materia_grado_materia (table: materia_grado)
ALTER TABLE materia_grado ADD CONSTRAINT materia_grado_materia
    FOREIGN KEY (id_materia)
    REFERENCES materia (id_materia);

-- End of file.


--Secuencias
--secuencia: Alumno
CREATE SEQUENCE tbAlumno
 MINVALUE 1
 MAXVALUE 9999999999999
 START WITH 1
 INCREMENT BY 1
 CACHE 20;

 -- secuencia: Responsable
 CREATE SEQUENCE tbResponsable
 MINVALUE 1
 MAXVALUE 9999999999999
 START WITH 1
 INCREMENT BY 1
 CACHE 20;
 -- secuencia: Alumno_Responsable
 CREATE SEQUENCE tbAlumRes
 MINVALUE 1
 MAXVALUE 9999999999999
 START WITH 1
 INCREMENT BY 1
 CACHE 20;
-- secuencia: Nota
 CREATE SEQUENCE tbNota
 MINVALUE 1
 MAXVALUE 9999999999999
 START WITH 1
 INCREMENT BY 1
 CACHE 20;
 -- secuencia: Periodo
 CREATE SEQUENCE tbPeriodo
 MINVALUE 1
 MAXVALUE 9999999999999
 START WITH 1
 INCREMENT BY 1
 CACHE 20;

 --Fin de secuencias


--Procedimientos Almacenados
--Procedimiento: Registrar Alumno y Responsable
CREATE OR REPLACE PROCEDURE registrar_alumno_representante
(aNom IN VARCHAR2, aApe IN VARCHAR2, aDirec IN VARCHAR2, aTel IN VARCHAR2, aFechNac IN DATE, aGenero IN NUMBER,
 rNom IN VARCHAR2, rApe IN VARCHAR2, rDirec IN VARCHAR2, rDui IN VARCHAR2, rTel IN VARCHAR2, rGenero IN NUMBER
)
IS
 idAlumn number;
 idResp number; 
BEGIN
    BEGIN
        SELECT res.id_responsable into idResp FROM responsable res where res.responsable_dui = rdui;
    EXCEPTION
        when others then
        idResp:=0;
    END;
    
        INSERT INTO alumno values(tbAlumno.NEXTVAL,anom,aape,adirec,atel,'-',afechnac,agenero,1)RETURNING id_alumno INTO idAlumn;
        
        IF (idResp=0) THEN
            INSERT INTO responsable VALUES (tbResponsable.NEXTVAL,rnom,rape,rdirec, rdui,rtel,1,rgenero)RETURNING id_responsable INTO idResp;   
        END IF;
        
        INSERT INTO alumno_responsable values(tbAlumRes.NEXTVAL,idAlumn,idResp); 
END;

--Procedimiento: Registro de nota por docente
create or replace PROCEDURE registrar_nota_docente
(dId IN NUMBER, dGrado IN VARCHAR2, dMate IN VARCHAR2, dPeri IN NUMBER, dSec IN VARCHAR2,
 ANom IN VARCHAR2, aApe IN VARCHAR2, aNotaA IN NUMBER, aNotaB IN NUMBER, aNotaC IN NUMBER)
IS
 idGrad number;
 idMate number; 
 idSec number;
 
 idAlum number;
 idNota number;
BEGIN
    BEGIN
        SELECT gra.id_grado,mat.id_materia,sec.id_seccion INTO idGrad,idMate,idSec 
        FROM grado GRA
            INNER JOIN materia_grado MATG ON gra.id_grado = matg.id_grado
            INNER JOIN materia MAT ON matg.id_materia=mat.id_materia
            INNER JOIN seccion SEC ON mat.id_materia=sec.id_materia
            INNER JOIN docente_materia DM ON sec.id_materia=dm.id_materia
            INNER JOIN docente DOC ON dm.id_docente=doc.id_docente
        WHERE doc.id_docente=dId;
    EXCEPTION
        when others then
        idGrad:=0;
        idMate:=0;
        idSec:=0;
    END;
        IF (idGrad!=0 AND idMate!=0 AND idSec!=0) THEN
            BEGIN
                SELECT alu.id_alumno INTO idAlum 
                FROM alumno ALU
                WHERE alu.alumno_nombre=anom AND alu.alumno_apelidos=aape;                            
            EXCEPTION
            when others then
                idAlum:=0;
            END;
            
            IF (idAlum!=0) THEN
               INSERT INTO nota N values(tbNota.NEXTVAL,idAlum,idMate)RETURNING n.id_nota INTO idNota;
               
               INSERT INTO periodo VALUES(tbPeriodo.NEXTVAL,aNotaA,aNotaB,aNotaC, idNota, dId, dPeri) ;
               
            END IF;
            
        END IF;        
END;

--Fin de procedimientos almacenados












------Consultas
--select al.alumno_nombre || ' '|| al.alumno_apelidos as Nombres_Alumno,
        --grad.grado,doc.docente_nombre,sec.nombre_seccion,mt.materia_nombre,
        --p.nota1*0.35+p.nota2*0.35+p.nota3*0.30 as promedio 
--from periodo p
    --inner join nota nt on p.id_nota=nt.id_nota
    --inner join alumno al on nt.id_alumno= al.id_alumno
    --inner join materia mt on nt.id_materia=mt.id_materia
    --inner join docente_materia dc on mt.id_materia=dc.id_materia
    --inner join docente doc on dc.id_docente=doc.id_docente
    --inner join seccion sec on mt.id_materia=sec.id_materia
    --inner join materia_grado mtg on mt.id_materia=mtg.id_materia
    --inner join grado grad on mtg.id_grado=grad.id_grado