-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2019-09-30 02:57:45.12

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
    id_seccion integer  NOT NULL,
    id_turno integer  NOT NULL,
    anho integer  NOT NULL,
    id_docente integer  NOT NULL,
    CONSTRAINT materia_grado_pk PRIMARY KEY (id_materia_grado)
) ;

-- Table: nota
CREATE TABLE nota (
    id_nota integer  NOT NULL,
    id_alumno integer  NOT NULL,
    id_materia_grado integer  NOT NULL,
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
    nombre_seccion Varchar2(10)  NOT NULL,
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

-- Reference: Periodo_Nota (table: periodo)
ALTER TABLE periodo ADD CONSTRAINT Periodo_Nota
    FOREIGN KEY (id_nota)
    REFERENCES nota (id_nota);

-- Reference: alumno_responsable_Alumno (table: alumno_responsable)
ALTER TABLE alumno_responsable ADD CONSTRAINT alumno_responsable_Alumno
    FOREIGN KEY (id_alumno)
    REFERENCES alumno (id_alumno);

-- Reference: alumno_responsable_Responsable (table: alumno_responsable)
ALTER TABLE alumno_responsable ADD CONSTRAINT alumno_responsable_Responsable
    FOREIGN KEY (id_esponsable)
    REFERENCES responsable (id_responsable);

-- Reference: materia_grado_docente (table: materia_grado)
ALTER TABLE materia_grado ADD CONSTRAINT materia_grado_docente
    FOREIGN KEY (id_docente)
    REFERENCES docente (id_docente);

-- Reference: materia_grado_grado (table: materia_grado)
ALTER TABLE materia_grado ADD CONSTRAINT materia_grado_grado
    FOREIGN KEY (id_grado)
    REFERENCES grado (id_grado);

-- Reference: materia_grado_materia (table: materia_grado)
ALTER TABLE materia_grado ADD CONSTRAINT materia_grado_materia
    FOREIGN KEY (id_materia)
    REFERENCES materia (id_materia);

-- Reference: materia_grado_seccion (table: materia_grado)
ALTER TABLE materia_grado ADD CONSTRAINT materia_grado_seccion
    FOREIGN KEY (id_seccion)
    REFERENCES seccion (id_seccion);

-- Reference: materia_grado_turno (table: materia_grado)
ALTER TABLE materia_grado ADD CONSTRAINT materia_grado_turno
    FOREIGN KEY (id_turno)
    REFERENCES turno (id_turno);

-- Reference: nota_materia_grado (table: nota)
ALTER TABLE nota ADD CONSTRAINT nota_materia_grado
    FOREIGN KEY (id_materia_grado)
    REFERENCES materia_grado (id_materia_grado);

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
 
 ---INSERT INTO MATERIA
 INSERT INTO MATERIA VALUES(1,'Lenguaje y Literatura');
 INSERT INTO MATERIA VALUES(2,'Matemática');
 INSERT INTO MATERIA VALUES(3,'Ciencia Salud y Medio Ambiente');
 INSERT INTO MATERIA VALUES(4,'Estudios Sociales y Cívica');
 INSERT INTO MATERIA VALUES(5,'Educación Física');
 INSERT INTO MATERIA VALUES(6,'Educación Artística');
 INSERT INTO MATERIA VALUES(7,'Ingles');
 INSERT INTO MATERIA VALUES(8,'Moral, Urbanidad y Cívica');
 --INSERT INTO GRADO
 INSERT INTO GRADO VALUES(1,'4');
 INSERT INTO GRADO VALUES(2,'5');
 INSERT INTO GRADO VALUES(3,'6');
 INSERT INTO GRADO VALUES(4,'7');
 INSERT INTO GRADO VALUES(5,'8');
 INSERT INTO GRADO VALUES(6,'9');
 --INSERT INTO SECCION
 INSERT INTO SECCION VALUES(1,'A',1);
 INSERT INTO SECCION VALUES(2,'B',1);
 INSERT INTO SECCION VALUES(3,'C',1);
 --INSERT INTO TURNO
 INSERT INTO TURNO VALUES(1,'Matutino');
 INSERT INTO TURNO VALUES(2,'vespertino');
 --INSERT INTO ROL
 INSERT INTO ROL VALUES(1,'Administrador');
 INSERT INTO ROL VALUES(2,'Docente');
 --INSERT INTO DOCENTE 
 INSERT INTO DOCENTE VALUES(1,'Jose Mauricio','Gonzales Renderos','7456-9525','Santa Ana','05041254-8','12/05/1992',1,1);
 INSERT INTO DOCENTE VALUES(2,'Salvador Alex','Perez Nieto','7586-9525','San Miguel','05031054-8','12/05/1992',1,1);
--INSERT INTO LOGIN
 INSERT INTO LOGIN VALUES(1,'USER1','PASS3',1,1);
 INSERT INTO LOGIN VALUES(2,'USER2','PASS4',1,2);
 --INSERT INTO ALUMNO
 INSERT INTO ALUMNO VALUES(1,'Jesus Alfredo','Roque Simeon','Santa Ana','7823-5128','126581238','12/03/2000',1,1);
 INSERT INTO ALUMNO VALUES(2,'Adrian Victor','Torres Lopez','Santa Ana','7823-5328','129581238','10/03/2000',1,1);
 --INSERT INTO RESPONSABLE
 INSERT INTO RESPONSABLE VALUES(1,'Juan Jose','Roque Mendoza','Santa Ana','06054795-5','7195-1973',1,1);
 INSERT INTO RESPONSABLE VALUES(2,'Francisco Alonso','Torres Mendoza','Santa Ana','06854795-5','7195-1973',1,1);
 --INSERT INTO ALUMNO_RESPONSABLE
 INSERT INTO ALUMNO_RESPONSABLE VALUES(1,1,1);
 INSERT INTO ALUMNO_RESPONSABLE VALUES(2,2,2);
--Procedimientos Almacenados
--Procedimiento: Registrar Alumno y Responsable
create or replace PROCEDURE registrar_alumno_representante
(aNom IN VARCHAR2, aApe IN VARCHAR2, aDirec IN VARCHAR2, aTel IN VARCHAR2, aFechNac IN VARCHAR2, aGenero IN NUMBER,
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

        INSERT INTO alumno values(tbAlumno.NEXTVAL,anom,aape,adirec,atel,tbAlumno.NEXTVAL,afechnac,agenero,1)RETURNING id_alumno INTO idAlumn;

        IF (idResp=0) THEN
            INSERT INTO responsable VALUES (tbResponsable.NEXTVAL,rnom,rape,rdirec, rdui,rtel,1,rgenero)RETURNING id_responsable INTO idResp;   
        END IF;

        INSERT INTO alumno_responsable values(tbAlumRes.NEXTVAL,idAlumn,idResp); 
END;
--Procedimiento: Registro de nota por docente
create or replace PROCEDURE registrar_nota_docente
(dId IN NUMBER, dGrado IN VARCHAR2, dMate IN VARCHAR2, dPeri IN NUMBER, dSec IN VARCHAR2,
 ANom IN VARCHAR2, aApe IN VARCHAR2, aNotaA IN NUMBER, aNotaB IN NUMBER, aNotaC IN NUMBER
,msj out VARCHAR)
IS
 idGrad number;
 idMate number; 
 idSec number;

 idAlum number;
 idNota number;
BEGIN
    BEGIN
        SELECT mg.id_grado,mg.id_materia,mg.id_seccion INTO idGrad, idMate,idSec FROM docente D                 
            INNER JOIN materia_grado MG ON d.id_docente = mg.id_docente
            INNER JOIN materia mat on mg.id_materia = mat.id_materia
            INNER JOIN grado gra on mg.id_grado= gra.id_grado
            INNER JOIN seccion SEC ON mg.id_seccion = sec.id_seccion
            WHERE d.id_docente = dId and mat.materia_nombre = dMate and gra.grado = dGrado and sec.nombre_seccion = dSec;
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
                WHERE alu.alumno_nombre=Anom AND alu.alumno_apelidos=aApe;                            
            EXCEPTION
            when others then
                idAlum:=0;
            END;

            IF (idAlum!=0) THEN
               INSERT INTO nota N values(tbNota.NEXTVAL,idAlum,idMate)RETURNING n.id_nota INTO idNota;

               INSERT INTO periodo VALUES(tbPeriodo.NEXTVAL,aNotaA,aNotaB,aNotaC, idNota, dId, dPeri) ;
               MSJ:='Notas insertas con exito';
            END IF;

        END IF;        
END;
--Procedimiento: registrar docente
create or replace PROCEDURE RegistrarDocente
(dId in NUMBER, dNom in VARCHAR2, dApe in VARCHAR2,
dTel in VARCHAR2, dDirec in VARCHAR2, dDoc in VARCHAR2,
dFNac in Date, dEst in NUMBER, dGen in NUMBER,
lId in NUMBER,dUser in VARCHAR2, dPass in VARCHAR2, dRol in VARCHAR2,
msj out VARCHAR)
is
    dui VARCHAR2(12);
    usser VARCHAR2(50);
    duiExist NUMBER;
    userExist NUMBER;
    rolExist NUMBER;
    idrol NUMBER;
    mensaje VARCHAR2(100);
BEGIN

    BEGIN
        SELECT d.docente_doc INTO dui FROM docente d WHERE d.docente_doc = dDoc; 
        duiExist:=1;
    EXCEPTION
        when others then
        duiExist:=0;
    END;

    BEGIN
        SELECT l.login_usuario INTO usser FROM login l WHERE l.login_usuario = dUser;
         userExist:=1;
    EXCEPTION
        when others then
        userExist:=0;
    END;

    BEGIN
        SELECT r.id_rol INTO idrol  FROM ROL R WHERE r.rol_nombre=dRol; 
        rolExist:=1;
    EXCEPTION
        when others then
        rolExist:=0;
    END;

    IF (duiExist=1) THEN
        mensaje:='El dui, ya esta registrado';
    ELSE
        IF (userExist=1) THEN
             mensaje:='El usuario, ya esta siendo usado.';
        ELSE

            BEGIN                
                INSERT INTO docente VALUES(dId, dNom, dApe, dTel, dDirec, dDoc, dFNac, dEst, dGen);                
                INSERT INTO login VALUES(lId,dUser,dPass,idrol,dId);                 
                mensaje:= 'Registrado!!';
            EXCEPTION
                when others then
                Rollback;
                mensaje:='Ha ocurrido un error al registrar los datos.';
            END;            
        END IF;
    END IF; 
    msj:=mensaje;
END;
--Procedimiento: Registro de nota por Admin
create or replace PROCEDURE          registrar_nota_Admin
(dNombre IN VARCHAR2, dGrado IN VARCHAR2, dMate IN VARCHAR2, dPeri IN NUMBER, dSec IN VARCHAR2,
 ANom IN VARCHAR2, aApe IN VARCHAR2, aNotaA IN NUMBER, aNotaB IN NUMBER, aNotaC IN NUMBER
,msj out VARCHAR)
IS
 idGrad number;
 idMate number; 
 idSec number;
 idDoce number;

 idAlum number;
 idNota number;
BEGIN

    BEGIN
        SELECT D.ID_DOCENTE INTO idDoce FROM DOCENTE D WHERE D.DOCENTE_NOMBRE ||' '|| D.DOCENTE_APELLIDO = dNombre;
    EXCEPTION
        when others then
        idDoce:=0;
    END;
    IF (idDoce>0) THEN
        BEGIN        
            SELECT mg.id_grado,mg.id_materia,mg.id_seccion INTO idGrad, idMate,idSec FROM docente D                 
            INNER JOIN materia_grado MG ON d.id_docente = mg.id_docente
            INNER JOIN materia mat on mg.id_materia = mat.id_materia
            INNER JOIN grado gra on mg.id_grado= gra.id_grado
            INNER JOIN seccion SEC ON mg.id_seccion = sec.id_seccion
            WHERE d.id_docente = idDoce and mat.materia_nombre = dmate and gra.grado = dgrado and sec.nombre_seccion = dsec;

        EXCEPTION
            when others then
            idGrad:=0;
            idMate:=0;
            idSec:=0;
            msj:= 'El encabezado del archivo no se encuentra registrado';

        END;
        IF (idGrad>0 AND idMate>0 AND idSec>0) THEN

            BEGIN
                SELECT alu.id_alumno INTO idAlum 
                FROM alumno ALU
                WHERE alu.alumno_nombre=anom AND alu.alumno_apelidos=aApe;                            
            EXCEPTION
            when others then
                msj:='No se ha encontrado el alumno';
                idAlum:=0;
            END;
            BEGIN
                IF (idAlum>0) THEN
                    INSERT INTO nota N values(tbNota.NEXTVAL,idAlum,idMate)RETURNING n.id_nota INTO idNota;

                    INSERT INTO periodo VALUES(tbPeriodo.NEXTVAL,aNotaA,aNotaB,aNotaC, idNota, idDoce, dPeri) ;
                    msj:='Notas insertas con exito';
                END IF;
            EXCEPTION
            when others then
                msj:='Error Al insertar el alumno';
            END;

        END IF;        
    ELSE
        msj:='No se encontro el nombre del docente de la base de datos';
    END IF;
END;

--Fin de procedimientos almacenados


---Vistas
--Vista: Reporte de notas trimestrales 
CREATE VIEW ALUMNONOTA AS
(SELECT al.id_alumno id, al.alumno_nombre || ' ' || al.alumno_apelidos as Alumno, dc.docente_nombre || dc.docente_apellido as "Docente",mt.materia_nombre,gr.grado,
sc.nombre_seccion, tr.turno_nombre, pr.nota1,pr.nota2, pr.nota3, (pr.nota1 * 0.35)+(pr.nota2*0.35) + (pr.nota3*0.3) AS "PROMEDIO", pr.periodo AS "Periodo"
FROM ALUMNO AL
INNER JOIN NOTA NT ON al.id_alumno = nt.id_alumno
INNER JOIN PERIODO PR ON nt.id_nota = pr.id_nota
INNER JOIN materia_grado MG ON nt.id_materia_grado  = MG.id_materia_grado
INNER JOIN MATERIA MT ON mg.id_materia = mt.id_materia
INNER JOIN DOCENTE DC ON mg.id_docente = dc.id_docente
INNER JOIN GRADO GR ON mg.id_grado = gr.id_grado
INNER JOIN TURNO TR ON mg.id_turno = tr.id_turno
INNER JOIN SECCION SC ON mg.id_seccion = sc.id_seccion);

--Vista: Reporte de Materias Asignadas a docente
CREATE VIEW materiasAsig AS  
SELECT  dc.docente_nombre || ' ' || dc.docente_apellido as Docente,
mt.materia_nombre, sc.nombre_seccion, gr.grado, tr.turno_nombre
FROM materia_grado mg
INNER JOIN materia mt on mt.id_materia = mg.id_materia
INNER JOIN grado gr on mg.id_grado = gr.id_grado
INNER JOIN turno tr on tr.id_turno = mg.id_turno
INNER JOIN seccion sc on sc.id_seccion = mg.id_seccion
INNER JOIN docente dc on mg.id_docente = dc.id_docente;



---Fin de Vistas









