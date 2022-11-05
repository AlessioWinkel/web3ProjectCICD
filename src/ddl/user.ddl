CREATE SCHEMA groep301;

GRANT ALL ON SCHEMA groep301 TO local_r0877579;

CREATE SEQUENCE groep301.user_id_seq;

GRANT ALL ON SEQUENCE groep301.user_id_seq TO local_r0877579;

CREATE TABLE groep301.user
(   id integer NOT NULL DEFAULT nextval('groep301.user_id_seq'::regclass),
    email character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    first_name character varying COLLATE pg_catalog."default" NOT NULL,
    last_name character varying COLLATE pg_catalog."default" NOT NULL,
    team character varying COLLATE pg_catalog."default" NOT NULL,
    role character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

GRANT ALL ON TABLE groep301.user TO local_r0877579;

INSERT INTO groep301.user ("userid","email","password","first_name","last_name","team","role") values (1, 'alessio@gmail.com', "lalala","alessio","winkel","ALPHA","EMPLOYEE");

-- grant aan teamgenoot
GRANT ALL ON SCHEMA groep301 TO local_r0842359;
GRANT ALL ON SEQUENCE groep301.user_id_seq TO local_r0842359;
GRANT ALL ON TABLE groep301.user TO local_0842359;


-- grant aan lectoren
GRANT ALL ON SCHEMA groep301 TO local_u0015529;
GRANT ALL ON SEQUENCE groep301.user_id_seq TO local_u0015529;
GRANT ALL ON TABLE groep301.user TO local_u0015529;

GRANT ALL ON SCHEMA groep301 TO local_u0034562;
GRANT ALL ON SEQUENCE groep301.user_id_seq TO local_u0034562;
GRANT ALL ON TABLE groep301.user TO local_u0034562;